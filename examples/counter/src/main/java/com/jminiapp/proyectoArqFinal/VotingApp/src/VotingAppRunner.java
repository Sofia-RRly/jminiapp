package com.jminiapp.proyectoArqFinal.VotingApp.src;

import com.jminiapp.core.engine.JMiniAppRunner;

public class VotingAppRunner {    
    public static void main(String[] args) {
        JMiniAppRunner
            .forApp(VotingApp.class)
            .withState(VotingState.class)
            .withAdapters(new VotingJSONAdapter())
            .named("Voting App")
            .run(args);        
    }

}