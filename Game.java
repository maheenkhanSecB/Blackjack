import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private List<Player> players;
    private Dealer dealer;
    private Deck deck;
    private Scanner scanner;

    public Game() {
        players = new ArrayList<>();
        dealer = new Dealer();
        deck = new Deck();
        scanner = new Scanner(System.in); 
    }

    public boolean isDeckEmpty() {
      return deck.isEmpty();
  }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        deck.shuffle();
        dealInitialHands();

        boolean keepPlaying = true;
        while (keepPlaying && !deck.isEmpty()) {
            for (Player player : players) {
                player.playTurn(deck);
            }

            dealer.playTurn(deck);
            determineWinner();
            printFinalScore();
            keepPlaying = askForAnotherRound();
        }
        System.out.println("End of Game");
        scanner.close();
    }
       
    private void dealInitialHands() {
        // Deal two cards to each player and the dealer
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCard(deck.dealCard());
            }
            dealer.addCard(deck.dealCard());
        }

        // Display initial hands
        for (Player player : players) {
            player.displayHand();
        }
        dealer.displayFirst();
    }

    private void determineWinner() {
        int dealerHandValue = dealer.calculateHandValue();

        if (dealerHandValue > 21) {
            for (Player player : players) {
                if (!player.busted()) {
                    System.out.println(player.getName() + " wins! Dealer busted.");
                }
            }
            return;
        }

        for (Player player : players) {
            int playerHandValue = player.calculateHandValue();

            if (player.busted()) {
                System.out.println(player.getName() + " busted. Dealer wins.");

                } else if (playerHandValue > dealerHandValue) {
                    System.out.println(player.getName() + " wins! Player's hand value: " + playerHandValue + ", Dealer's hand value: " + dealerHandValue);
                } else if (playerHandValue < dealerHandValue) {
                 System.out.println("Dealer wins! Player's hand value: " + playerHandValue +
                               ", Dealer's hand value: " + dealerHandValue);
                } else {
                    System.out.println("It's a tie! Player's hand value: " + playerHandValue +
                               ", Dealer's hand value: " + dealerHandValue);
                }
            }
    }

    private boolean askForAnotherRound() {
        System.out.println("Play another round? Enter 'yes' or 'no' :");
        String input = scanner.nextLine().trim().toLowerCase();
        return "yes" .equals(input);
    }

    public void playRound() {
    }

    public void printFinalScore() {
        System.out.println("Final scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.calculateHandValue());
        }
        System.out.println(dealer.getName() + ": " + dealer.calculateHandValue());
    }
}
