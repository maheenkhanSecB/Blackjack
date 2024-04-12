import java.util.Scanner;

public class Main {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    Game game = new Game();
    System.out.println("Welcome to Black");

    boolean keepPlaying = true;
    while (keepPlaying && !game.isDeckEmpty()) {
      game.playRound(); 

      System.out.println("Would you like to play? Enter 'yes' or 'no': ");
        String input = scanner.nextLine().trim().toLowerCase();
         if ("no".equals(input)) {
          keepPlaying = false;
            } 
          

            
    }

    game.printFinalScore();
    System.out.println("End of Game");
    scanner.close();
  }
}

