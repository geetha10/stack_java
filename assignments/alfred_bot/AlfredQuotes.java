import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello ".concat(name);
    }

    public String guestGreeting(String firstName, String lastName){
        return "Hello ".concat(firstName).concat(" ").concat(lastName);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return date.toString();
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return "What Do you want me to do? "+conversation;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

