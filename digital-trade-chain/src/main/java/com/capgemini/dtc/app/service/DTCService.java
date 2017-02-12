package com.capgemini.dtc.app.service;

import com.capgemini.dtc.app.flow.DTCFlow;
import kotlin.jvm.JvmClassMappingKt;
import net.corda.core.node.PluginServiceHub;

/**
 * This service registers a flow factory we wish to use when a initiating party attempts to communicate with us
 * using a particular flow. Registration is done against a marker class (in this case [ExampleFlow.Initiator]
 * which is sent in the session handshake by the other party. If this marker class has been registered then the
 * corresponding factory will be used to create the flow which will communicate with the other side. If there is no
 * mapping then the session attempt is rejected.
 *
 * In short, this bit of code is required for the seller in this Example scenario to repond to the buyer using the
 * [ExampleFlow.Acceptor] flow.
 */
public class DTCService {
    public DTCService(PluginServiceHub services) {
        services.registerFlowInitiator(
                JvmClassMappingKt.getKotlinClass(DTCFlow.Initiator.class),
                DTCFlow.Acceptor::new
        );
    }
}