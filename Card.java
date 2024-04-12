
public class Card {
  private final String suit;
  private final String value;

  public Card(String suit, String value) {
    this.suit = suit;
    this.value = value; 
  }

  public String getValue() {
    try {
      return String.valueOf(Integer.parseInt(value));
  } 
  catch (NumberFormatException e) {
    switch (value) {
      case "Ace":
        return "Ace";
      case "Jack":
      case "Queen":
      case "King":
        return "10";
      default:
          return "0";
    
    }
  }
    
  }

  public String toString() {
    return value + "of" + suit; 
  }
}

