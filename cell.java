import java.util.*;
import java.text.*;
public class cell {
    boolean gold;
    boolean pit;
    boolean wumpus;
    boolean cave;
    //For this constructor have someway of import a boolean for all of these
    //If it has a gold, cave, or wumpus already make it so it won't create
    //another one
    public cell(boolean goldAlready, boolean wumpusAlready, boolean makeCave) {
        //HAVE THE BOARD CLASS CREATE RANDOM COORDINATES FOR THE WUMPUS AND gold
        Random rando = new Random();
        gold = false;
        wumpus = false;
        pit = false;
        cave = false;
        if (goldAlready == false) {
            int goldDecider = rando.nextInt(10) + 1;
            if (goldDecider == 3) {
                gold = true;
                goldAlready = true;
            }
        }
        if (wumpusAlready == false && gold == false) {
            int wumpusDecider = rando.nextInt(10) + 1;
            if (wumpusDecider == 4) {
                wumpus = true;
                wumpusAlready = true;
            }
        }
        if (gold == false && cave == false) {
            int pitDecider = rando.nextInt(10) + 1;
            if (pitDecider == 7) {
                pit = true;
            }
        }
        if (makeCave == true) {
            cave = true;
        }
    }

    public boolean checkWumpus() {
        if (wumpus == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkGold() {
        if (gold == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkPit() {
        if (pit == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkCave() {
        if (cave == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public void removeWumpus() {
        wumpus = false;
    }
}
