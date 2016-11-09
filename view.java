import java.util.*;
import java.text.*;
public class view {
  private Scanner s;

  public view () {
    s = new Scanner(System.in);
  }
  public char printFirstMove() {
      System.out.println("Enter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
      char playerFirstMove = char.parseChar(s.nextLine());
      return playerFirstMove;
      //It returns the char and sends it to the MM to send to board
  }
  public char printSecondMove() {
      System.out.println("Enter (u)p, (d)own, (l)eft, or (r)ight: ");
      char playerSecondMove = char.parseChar(s.nextLine());
      return playerSecondMove;
  }
  public void printNonValidMove() {
      System.out.println("Invalid move!");
  }
  public void printPit() {
      System.out.println("There is a breeze.");
  }
  public void printWumpus() {
      System.out.println("You smell a stench.");
  }
  public void printGold() {
      System.out.println("There is a glimmer.");
  }
  public void printFallingPit() {
      System.out.println("You have fallen into a pit! You lose.");
  }
  public void printEaten() {
      System.out.println("You have been eaten by a Wumpus! You lose.");
  }
  public void printNoArrow() {
      System.out.println("You have no more arrows!");
  }
  public void printDeadWumpus() {
      System.out.println("You hear a scream");
  }
  public void printClimbOut(boolean hasGold, boolean killedWumpus) {
      //add params or whatever to make this whatever it needs to be for the final
      //print statemente
      if (hasGold == true && killedWumpus == true) {
          System.out.println("You have killed the Wumpus and taken the gold. You win!");
      }
      if (hasGold == false && killedWumpus == false) {
          System.out.println("You have not killed the Wumpus and have not taken the gold. You lose!");
      }
      if (hasGold == true && killedWumpus == false) {
          System.out.println("You have not killed the Wumpus but have taken the gold. You lose!");
      }
      if (hasGold == false && killedWumpus == true) {
          System.out.println("You have killed the Wumpus but have not taken the gold. You lose!");
      }
  }
  public void printNotAtCave() {
      System.out.println("You are not at the cave!");
  }
  public void printGetGold() {
      System.out.println("You grabbed the gold!");
  }
  public void printNotAtGold() {
      System.out.println("You are not at the gold!");
  }
  //I have to make methods to return Glitter and shit like that but I'll do it
  //after I get further into the project.
}
