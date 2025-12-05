package com.jminiapp.proyectoArqFinal.VotingApp.src;

import com.jminiapp.core.adapters.JSONAdapter;

public class VotingJSONAdapter implements JSONAdapter<VotingState>{
    @Override
    public Class<VotingState> getstateClass() {
        return VotingState.class;
    }
}
