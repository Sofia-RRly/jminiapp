package com.jminiapp.proyectoArqFinal.VotingApp.src;

import java.util.List;
import java.util.Scanner;

import com.jminiapp.core.api.JMiniApp;
import com.jminiapp.core.api.JMiniAppConfig;

public class VotingApp extends JMiniApp{
    private VotingState votes;
    private Scanner scanner;
    private boolean running = true;

    public VotingApp(JMiniAppConfig config) {
        super(config);
    }

    @Override
    protected void initialize(){
        System.out.println("Initializing Voting App...");

        scanner = new Scanner(System.in);
        List<VotingState> data = context.getData();
        votes = (data != null && !data.isEmpty()) ? data.get(0) : new VotingState();

    }

    @Override 
    protected void run(){
        while(running){
            menu();
            handleInput();
        }
    }

    @Override
    protected void shutdown(){
        context.setData(List.of(votes));
        System.out.println("\nShutting down Voting App... \nGoodbye!");
    }

    private void menu(){
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1) Add candidate");
        System.out.println("2) Remove candidate");
        System.out.println("3) Add vote");
        System.out.println("4) Remove vote");
        System.out.println("5) View total votes and percentages");
        System.out.println("6) Reset votes");
        System.out.println("7) Exit");

        System.out.print("\nSelect option: ");
    }

    private void handleInput(){
        switch(scanner.nextLine().trim()){
            case "1": 
                votes.addCandidate();
                break;

            case "2":
                votes.removeCandidate();
                break;
    
            case "3":
                votes.addVote();
                break;
            
            case "4":
                votes.removeVote();
                break;
            
            case "5":
                System.out.println("\nTotal votes: " + votes.totalVotes() + "\n");
                votes.showCandidates();
                votes.showPercentages();
                break;

            case "6":
                votes.reset();
                break;

            case "7":
                running = false;
                break;

            default: 
                System.out.println("Invalid option. Please try again.");
        }
    }
}