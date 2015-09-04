import java.util.*;

public class DotComBust {
  private GameHelper helper;
  private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
  private int numOfGuesses = 0;
  
  public void setUpGame() {
    DotCom one = new DotCom();
    DotCom two = new DotCom();
    DotCom three = new DotCom();
    
    one.setName("Pets.com");
    two.setName("Yahoo.com");
    three.setName("AOL.com");
    
    dotComList.add(one);
    dotComList.add(two);
    dotComList.add(three);
    
    System.out.println("Your goal is to sink three dot coms in the fewest number of guesses.");
    
    for (DotCom dotComToSet : dotComList) {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }
  
  private void startPlaying() {
    while (!dotComList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }
  
  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";
    
    for (DotCom dotComToTest : dotComList) {
      result = dotComToTest.checkYourself(userGuess);
      if (result.equals("hit")) {
        break;
      }
      else if (result.equals("kill")) {
        dotComList.remove(dotComToTest);
        break;
      }
    }
    System.out.println(result);
  }
  
  private void finishGame() {
    System.out.println("All Dot Coms are dead! Your stock is now worthless.");
    
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    }
    else {
      System.out.println("It took you " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options.");
    }
  }
  
  public static void main(String[] args) {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }
}