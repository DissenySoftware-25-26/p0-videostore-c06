
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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        Iterator<Rental> rentals = this.rentals.iterator();

        while (rentals.hasNext()) {
            double price = 0;
            Rental each = rentals.next();

            //  aquí antes estaba el switch, ahora lo sustituimos por:
            price = getAmountFor(each);

            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(price) + "\n";
            totalAmount += price;
        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

        return result;
    }

    private double getAmountFor(Rental rental) {
        return rental.getRentalPrice();
    }


}