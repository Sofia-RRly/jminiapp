# Voting App — Tutorial

This guide explains step-by-step how to run and extend the Voting App built with **JMiniApp**.

---

## Project Structure
java/com/jminiapp/proyectoArqfinal/VotingApp

  -src
	
  -README.md

--- 

## How to run: 

Navigate to the examples directory

```bash
cd examples/voting-app
javac VotingApp.java
java VotingApp

```
----

## Usage Menu

Once started, the program display a menu similar to:

#### Voting system

1) Add candidate
2) Remove candidate
3) Add vote
4) Remove vote
5) Total votes
6) Percentages & Graph
7) Reset
8) Exit

## Notes

- Since IDs never change, removing a candidate does not affect the numbering of the others.
- Reset clears vote counts and reset the candidates list to default (3 candidates)
- Percentages are only shown when total votes > 0.

