package com.capgemini.dtc.app.plugin;

import com.esotericsoftware.kryo.Kryo;
import com.capgemini.dtc.app.api.DTCApi;
import com.capgemini.dtc.app.contract.PurchaseOrderContract;
import com.capgemini.dtc.app.state.PurchaseOrderState;
import com.capgemini.dtc.app.flow.DTCFlow;
import com.capgemini.dtc.app.model.PurchaseOrder;
import com.capgemini.dtc.app.service.DTCService;
import net.corda.core.crypto.Party;
import net.corda.core.flows.IllegalFlowLogicException;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.node.CordaPluginRegistry;
import net.corda.core.node.PluginServiceHub;

import java.util.*;
import java.util.function.Function;

public class DTCPlugin extends CordaPluginRegistry {	
	
    /**
     * A list of classes that expose web APIs.
     */
    private final List<Function<CordaRPCOps, ?>> webApis = Collections.singletonList(DTCApi::new);

    /**
     * A list of flows required for this CorDapp. Any flow which is invoked from from the web API needs to be
     * registered as an entry into this map. The map takes the form:
     *
     * Name of the flow to be invoked -> Set of the parameter types passed into the flow.
     *
     * E.g. In the case of this CorDapp:
     *
     * "ExampleFlow.Initiator" -> Set(PurchaseOrderState, Party)
     *
     * This map also acts as a white list. If a flow is invoked via the API and not registered correctly
     * here, then the flow state machine will _not_ invoke the flow. Instead, an exception will be raised.
     */
    private final Map<String, Set<String>> requiredFlows = Collections.singletonMap(
            DTCFlow.Initiator.class.getName(),
            new HashSet<>(Arrays.asList(
                    PurchaseOrderState.class.getName(),
                    Party.class.getName()
            )));

    /**
     * A list of long lived services to be hosted within the node. Typically you would use these to register flow
     * factories that would be used when an initiating party attempts to communicate with our node using a particular
     * flow. See the [ExampleService.Service] class for an implementation.
     */
    private final List<Function<PluginServiceHub, ?>> servicePlugins = Collections.singletonList(DTCService::new);

    /**
     * A list of directories in the resources directory that will be served by Jetty under /web.
     */
    private final Map<String, String> staticServeDirs = Collections.singletonMap(
            // This will serve the exampleWeb directory in resources to /web/example
            "kyc", getClass().getClassLoader().getResource("kycWeb").toExternalForm()
    );

    @Override public List<Function<CordaRPCOps, ?>> getWebApis() { return webApis; }
    @Override public Map<String, Set<String>> getRequiredFlows() { return requiredFlows; }
    @Override public List<Function<PluginServiceHub, ?>> getServicePlugins() { return servicePlugins; }
    @Override public Map<String, String> getStaticServeDirs() { return staticServeDirs; }

    /**
     * Register required types with Kryo (our serialisation framework).
     */
    @Override public boolean registerRPCKryoTypes(Kryo kryo) {
        kryo.register(PurchaseOrderState.class);
        kryo.register(PurchaseOrderContract.class);
        kryo.register(PurchaseOrder.class);
        kryo.register(PurchaseOrder.Address.class);
        kryo.register(Date.class);
        kryo.register(PurchaseOrder.Item.class);
        kryo.register(DTCFlow.DTCFlowResult.Success.class);
        kryo.register(DTCFlow.DTCFlowResult.Failure.class);
        kryo.register(IllegalArgumentException.class);
        kryo.register(IllegalFlowLogicException.class);
        return true;
    }
}