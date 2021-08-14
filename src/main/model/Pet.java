package model;

import java.util.ArrayList;
import java.util.List;

// The Pet for Dendrii
public class Pet {
    private int health;
    private List<String> needs;

    public Pet() {
        health = 100;
        needs = new ArrayList<>();
        chooseNeeds();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int n) {
        health = n;
    }

    public List<String> getNeeds() {
        return needs;
    }

    public void addNeed(String s) {
        needs.add(s);
    }

    // Don't know the best way to remove, so programmed remove by index for now
    public void removeNeed(int n) {
        needs.remove(n);
    }

    // At end of day, subtract # of unfinished tasks from health, see if pet faints, redo tasks for new day
    public void dayEnd() {
        int tasksUnfinished = needs.size();
        health -= tasksUnfinished;
        needs = new ArrayList<>();

        if (health < 1) {
            faintedPet();
        }

        chooseNeeds();
    }

    private void faintedPet(){
        // Blank for now because I'm not sure of consequences
    }

    private void chooseNeeds(){
        // Hardcoded for now
        needs.add("Play Poke-A-Dot");
        needs.add("Add a journal entry");
        needs.add("Read a summarized article");
    }
}