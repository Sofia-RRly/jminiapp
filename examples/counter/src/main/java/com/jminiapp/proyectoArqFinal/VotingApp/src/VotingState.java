package com.jminiapp.proyectoArqFinal.VotingApp.src;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class VotingState {
    private Map<Integer, Integer> candidates = new HashMap<>();
    private int nextId = 1;

    public VotingState(){
        candidates.put(nextId++, 0); 
        candidates.put(nextId++, 0); 
        candidates.put(nextId++, 0); 
    }

    public void addCandidate(){
        candidates.put(nextId, 0);
        System.out.println("Candidate " + (nextId) + " added.");
        nextId++;
    }

    public void removeCandidate(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter candidate ID to remove:");
        int id = Integer.parseInt(in.nextLine());

        if(candidates.containsKey(id)){
            candidates.remove(id);
            System.out.println("Candidate " + id + " removed.");
        } else {
            System.out.println("Candidate "+ id + " not found.");
        }
    }

    public void addVote(){
        int id = requestCandidateId("vote for");
        if (id!= -1) {
            candidates.put(id, candidates.get(id) + 1);
            System.out.println("Vote added to Candidate " + id);
        }
    }

    public void removeVote(){
        int id = requestCandidateId("remove vote from");
        if (id != -1) {
            if(candidates.get(id) > 0){
                candidates.put(id, candidates.get(id) - 1);
                System.out.println("Vote removed from Candidate " + id);
            } else System.out.println("No votes to remove for Candidate " + id);
        }
    }

    private int requestCandidateId(String action){
        Scanner sc = new Scanner(System.in);
        showCandidates();
        System.out.println("Enter candidate ID to " + action + ":");
        int id = Integer.parseInt(sc.nextLine());

        return candidates.containsKey(id) ? id : -1;
    }


    public int totalVotes(){
        return candidates.values().stream().mapToInt(v -> v).sum();
    }

    public void showCandidates(){
        candidates.forEach((id, v) -> 
            System.out.println("Candidate " + id + ": " + v + " votes"));
    }

    public void showPercentages(){
        int total = totalVotes();
        if (total == 0) {
            System.out.println("\nNo votes to display percentages.");
            return;
        }

        System.out.println("\n-- Vote Percentages: --");
        for(var entry : candidates.entrySet()){
            int id = entry.getKey();
            int votes = entry.getValue();
            double percent = (votes * 100.0) / total;
            System.out.printf("\nCandidate %d |  %.2f%% (%d)\n", id, percent, votes);
        }
    }

    public void reset(){
        candidates.clear();
        nextId = 1;
        candidates.put(nextId++, 0);
        candidates.put(nextId++, 0);
        candidates.put(nextId++, 0);
        System.out.println("All votes have been reset. Default candidates restored.");
    }
}