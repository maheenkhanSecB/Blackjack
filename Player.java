import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    

    public void addCard(Card card) {
      hand.add(card);
  }
   
  public List<Card> getHand() {
    return hand;
}
    public int calculateHandValue() {
      int sum = 0;
      int numberOfAces = 0;

      for (Card card : hand) {
        String value = card.getValue();
        if (value.equals("Ace")) {
          numberOfAces++;
          sum += 11; 
        } else if (value.equals("Jack") || value.equals("Queen") || value.equals("King")) {
          sum += 10;
        } else {
          sum += Integer.parseInt(value);
        }

      }

       while (sum > 21 && numberOfAces > 0) {
        sum -= 10;
        numberOfAces--;
    }
    return sum;
}

    public void displayHand() {
      System.out.println(name + "'s Hand:");
      for (Card card : hand) {
        System.out.println(card);
      }
    }

    public boolean busted() {
      return calculateHandValue() > 21;
    }

    public String getName() {
      return name;
  }
}
