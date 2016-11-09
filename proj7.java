import java.util.*;
import java.text.*;
public class proj7 {
    public static void main(String[] args) {
        view v = new view();
        board b = new board();
        int game = 0;
        boolean hasGold = false;
        boolean killedWumpus = false;
        do {
            boolean isThereGold = b.goldAround();
            if (isThereGold == true) {
                v.printGold();
            }
            boolean isTherePit = b.pitAround();
            if (isTherePit == true) {
                v.printPit();
            }
            boolean isThereWumpus = b.wumpusAround();
            if (isThereWumpus == true) {
                v.printWumpus();
            }
            char move = v.printFirstMove();
            char direction = v.printSecondMove();
            //So I have the move that is wanted and the direction that is wanted
            //I need to send it to get checked based on what each one of them are.
            if (move == "m" || move == "M") {
                boolean validMove = b.move(direction);
                if (validMove == false) {
                    v.printNonValidMove();
                }
            }
            if (move == "s" || move == "S") {
                boolean isThereArrow = b.checkForArrow();
                if (isThereArrow == true) {
                    boolean validShot = b.shootArrow(direction);
                    if (validShot == true) {
                        v.printDeadWumpus();
                        killedWumpus = true;
                    }
                }
                else {
                    v.printNoArrow();
                }
            }
            if (move == "c" || move == "C") {
                boolean atCave = b.atCave();
                if (atCave == true) {
                    b.climbOut();
                    v.printClimbOut(killedWumpus, hasGold);
                    game = 1;
                }
                else {
                    v.printNotAtCave();
                }
            }
            if (move == "g" || move == "G") {
                boolean atGold = b.atGold();
                if (atGold == true) {
                    b.getGold();
                    v.printGetGold();
                }
                else {
                    v.printNotAtGold();
                }
            }
        }
        while (game = 0);
    }
}
