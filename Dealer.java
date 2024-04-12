import java.util.List;

public class Dealer extends Player {
    public Dealer() {
        super("Dealer");
    }

 
@Override
    public void playTurn(Deck deck) {
        while (calculateHandValue() < 17) {
            addCard(deck.dealCard());
        }
    }

    @Override
    public void displayFirst() {
        System.err.println("Dealer's Hand:");
        List<Card> hand = getHand();
        if (!hand.isEmpty()) {
            for (Card card : hand) {
                System.err.println(card);
            } 
        } else {
            System.err.println("No cards dealt yet");
        }
    }
}

