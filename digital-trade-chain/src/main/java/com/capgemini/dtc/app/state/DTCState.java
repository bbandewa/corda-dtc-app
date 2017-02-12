package com.capgemini.dtc.app.state;

import com.capgemini.dtc.app.contract.DTCContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.crypto.CompositeKey;

import java.util.Collections;
import java.util.List;

/**
 * Define your state object here.
 */
public class DTCState implements ContractState {
    private final DTCContract contract;

    public DTCState(DTCContract contract) { this.contract = contract; }

    @Override public DTCContract getContract() { return contract; }

    /** The public keys of the involved parties. */
    @Override public List<CompositeKey> getParticipants() { return Collections.emptyList(); }
}