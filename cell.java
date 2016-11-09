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
    public cell(boolean goldImport, boolean wumpusImport, boolean makeCave, boolean pitImport) {
        gold = false;
        wumpus = false;
        pit = false;
        cave = false;
        if (goldImport == true) {
            gold = true;
        }
        if (wumpusImport == true) {
            wumpus = true;
        }
        if (makeCave == true) {
            cave = true;
        }
        if (pit == true) {
            pit = true;
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
