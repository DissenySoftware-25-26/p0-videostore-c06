
import java.util.*;

public class Customer 
{
	private final String name;
    private final List<Rental> rentals = new ArrayList<>();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add(rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";


        for (Rental each : rentals) {
            double price = getAmountFor(each);

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(price) + "\n";
        }

        // Ahora usamos el método en vez de la variable local
        result += "You owed " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points\n";

        return result;
    }

    private double getAmountFor(Rental rental) {
        return rental.getRentalPrice();
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += getAmountFor(rental);
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        for (Rental rental : rentals) {
            totalPoints += rental.calculatePoints();
            }
        return totalPoints;
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder();
        result.append("<H1>Rentals for <EM>").append(getName()).append("</EM></H1><P>\n");
        for( Rental rental : rentals) {
            result.append(rental.getMovie().getTitle()).append(": ").append(String.valueOf(getAmountFor(rental))).append("<BR>\n");
        }
        result.append("<P>You owe <EM>").append(String.valueOf(getTotalCharge())).append("</EM><P>\n");
        result.append("On this rental you earned <EM>").append(String.valueOf(getTotalFrequentRenterPoints())).append("</EM> frequent renter points<P>");
        return result.toString();
    }
}