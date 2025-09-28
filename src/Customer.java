
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

}