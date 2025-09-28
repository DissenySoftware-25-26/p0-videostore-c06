
public class Rental {
    private Movie movie;
    private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

    public Movie getMovie () {
        return movie;
    }

    public int getDaysRented () {
        return daysRented;
    }

    public double getRentalPrice() {
        // determines the amount for each line
        return movie.getCharge(daysRented);
    }

    public int calculatePoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}