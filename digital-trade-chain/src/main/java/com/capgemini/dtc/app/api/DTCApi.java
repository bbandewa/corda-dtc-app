package com.capgemini.dtc.app.api;

import static java.util.Collections.singletonMap;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capgemini.dtc.app.contract.PurchaseOrderContract;
import com.capgemini.dtc.app.flow.DTCFlow;
import com.capgemini.dtc.app.model.PurchaseOrderNew;
import com.capgemini.dtc.app.state.PurchaseOrderState;

import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.crypto.Party;
import net.corda.core.messaging.CordaRPCOps;

// This API is accessible from /api/example. All paths specified below are relative to it.
@Path("dtc")
public class DTCApi {
    private final CordaRPCOps services;
    private final String myLegalName;

    public DTCApi(CordaRPCOps services) {
        this.services = services;
        this.myLegalName = services.nodeIdentity().getLegalIdentity().getName();
    }

    /**
     * Returns the party name of the node providing this end-point.
     */
    @GET
    @Path("me")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> whoami() { return singletonMap("me", myLegalName); }

    /**
     * Returns all parties registered with the [NetworkMapService]. The names can be used to look up identities by
     * using the [IdentityService].
     */
    @GET
    @Path("peers")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<String>> getPeers() {
        final String NOTARY_NAME = "Controller";
        return singletonMap(
                "peers",
                services.networkMapUpdates().getFirst()
                        .stream()
                        .map(node -> node.getLegalIdentity().getName())
                        .filter(name -> !name.equals(myLegalName) && !name.equals(NOTARY_NAME))
                        .collect(toList()));
    }

    /**
     * Displays all purchase order states that exist in the vault.
     */
    @GET
    @Path("{userId}/purchase-orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PurchaseOrderNew> getPurchaseOrders(@PathParam("userId") String userId) {

    	List<PurchaseOrderNew> returnRecords = new ArrayList<PurchaseOrderNew>();
    	
    	List<StateAndRef<ContractState>> allRecords = services.vaultAndUpdates().getFirst();
    	System.out.println("81");
    	for(int i=0; i<allRecords.size();i++){
    		
    		StateAndRef<ContractState> singleRecord = (StateAndRef<ContractState>) allRecords.get(i);
    		
    		PurchaseOrderState state = (PurchaseOrderState) singleRecord.getState().getData();
    		
    		if(state.getPurchaseOrder().getBuyer().getUserName().equalsIgnoreCase(userId) ||
    				state.getPurchaseOrder().getSeller().getUserName().equalsIgnoreCase(userId)){
    			returnRecords.add(state.getPurchaseOrder());
    		}
    	}
    	// return only one record based on kycDate which is created last
    	//PurchaseOrderNew lastPOCreation = Collections.max(returnRecords, Comparator.comparing(PurchaseOrderNew::getPoDate));
    	
    	//returnRecords.clear();
    	//returnRecords.add(lastPOCreation);
    	
        //return services.vaultAndUpdates().getFirst();
    	return returnRecords;
    }
    
    @GET
    @Path("{poNumber}/get-po-details")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PurchaseOrderNew> getPODetails(@PathParam("poNumber") String poNumber) {
    	
    	List<PurchaseOrderNew> returnRecords = new ArrayList<PurchaseOrderNew>();
    	
    	List<StateAndRef<ContractState>> allRecords = services.vaultAndUpdates().getFirst();
    	
    	for(int i=0; i<allRecords.size();i++){
    		
    		StateAndRef<ContractState> singleRecord = (StateAndRef<ContractState>) allRecords.get(i);
    		
    		PurchaseOrderState state = (PurchaseOrderState) singleRecord.getState().getData();
    		
    		if(state.getPurchaseOrder().getPurchaseOrderNum().equalsIgnoreCase(poNumber)){
    			returnRecords.add(state.getPurchaseOrder());
    		}
    	}
    	// return only one record based on kycDate which is created last
    	PurchaseOrderNew lastPOCreation = Collections.max(returnRecords, Comparator.comparing(PurchaseOrderNew::getPoDate));
    	
    	returnRecords.clear();
    	returnRecords.add(lastPOCreation);
    	System.out.println("127");
        return returnRecords;
    }

    /**
     * This should only be called from the 'buyer' node. It initiates a flow to agree a purchase order with a
     * seller. Once the flow finishes it will have written the purchase order to ledger. Both the buyer and the
     * seller will be able to see it when calling /api/example/purchase-orders on their respective nodes.
     *
     * This end-point takes a Party name parameter as part of the path. If the serving node can't find the other party
     * in its network map cache, it will return an HTTP bad request.
     *
     * The flow is invoked asynchronously. It returns a future when the flow's call() method returns.
     */
    @PUT
    @Path("{party}/create-purchase-order")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPurchaseOrder(PurchaseOrderNew purchaseOrder, @PathParam("party") String partyName) throws InterruptedException, ExecutionException {
    	System.out.println(purchaseOrder);
        final Party otherParty = services.partyFromName(partyName);
        final Party anotherParty = services.partyFromName("NodeC");

        if (otherParty == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        System.out.println("96");
        /*final PurchaseOrderState state = new PurchaseOrderState(
                purchaseOrder,
                services.nodeIdentity().getLegalIdentity(),
                otherParty,
                new PurchaseOrderContract());*/
        purchaseOrder.setPoDate(new Date());
        final PurchaseOrderState state = new PurchaseOrderState(
                purchaseOrder,
                services.nodeIdentity().getLegalIdentity(),
                otherParty, anotherParty,
                new PurchaseOrderContract());
        System.out.println("107");
        // The line below blocks and waits for the flow to return.
        final DTCFlow.DTCFlowResult result = services
                .startFlowDynamic(DTCFlow.Initiator.class, state, otherParty, anotherParty)
                .getReturnValue()
                .toBlocking()
                .first();
        System.out.println("114");
        final Response.Status status;
        if (result instanceof DTCFlow.DTCFlowResult.Success) {
            status = Response.Status.CREATED;
        } else {
            status = Response.Status.BAD_REQUEST;
        }

        return Response
                .status(status)
                .entity(result.toString())
                .build();
    }
}