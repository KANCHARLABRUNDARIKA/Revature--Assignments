import java.util.*;

// Custom Exceptions
class InvalidCustomerNameException extends Exception {
    public InvalidCustomerNameException(String message) {
        super(message);
    }
}

class InvalidMovieException extends Exception {
    public InvalidMovieException(String message) {
        super(message);
    }
}

class InvalidTicketCountException extends Exception {
    public InvalidTicketCountException(String message) {
        super(message);
    }
}

class InsufficientSeatsException extends Exception {
    public InsufficientSeatsException(String message) {
        super(message);
    }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

class CancellationNotAllowedException extends Exception {
    public CancellationNotAllowedException(String message) {
        super(message);
    }
}


class TicketBooking {
    String customerName;
    String movieName;
    int ticketCount;
    int availableSeats = 5;
    double pricePerTicket = 200;
    boolean isCancelled = false;

    void booking(String customerName, String movieName, int ticketCount, double payment)
            throws InvalidCustomerNameException, InvalidMovieException,
            InvalidTicketCountException, InsufficientSeatsException,
            PaymentFailedException {

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new InvalidCustomerNameException("Customer name cannot be empty");
        }

        if (!(movieName.equals("Leo") || movieName.equals("Jailer") || movieName.equals("Vikram"))) {
            throw new InvalidMovieException("Invalid movie");
        }

        if (ticketCount <= 0) {
            throw new InvalidTicketCountException("Ticket count must be greater than 0");
        }

        if (ticketCount > availableSeats) {
            throw new InsufficientSeatsException("Not enough seats available");
        }

        double total = ticketCount * pricePerTicket;

        if (payment < total) {
            throw new PaymentFailedException("Insufficient payment");
        }


        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketCount = ticketCount;
        availableSeats -= ticketCount;

        System.out.println("Total left " + (payment-total));
        System.out.println("Booking Successful!");
        System.out.println("Remaining Seats: " + availableSeats);
    }

    void cancelBooking() throws CancellationNotAllowedException {
        if (isCancelled) {
            throw new CancellationNotAllowedException("Already cancelled");
        }

        isCancelled = true;
        availableSeats += ticketCount;

        System.out.println("Booking Cancelled");
    }
}


public class b3ExceptionHandling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketBooking ticketbooking = new TicketBooking();

        try {
            System.out.print("Enter Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Enter Movie Name (Leo/Jailer/Vikram): ");
            String movieName = sc.nextLine();

            System.out.print("Enter Ticket Count: ");
            int ticketCount = sc.nextInt();

            System.out.print("Enter Payment: ");
            double payment = sc.nextDouble();

            ticketbooking.booking(customerName, movieName, ticketCount, payment);

            System.out.print("Cancel booking? (yes/no): ");
            sc.nextLine();
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                ticketbooking.cancelBooking();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you");
        }

        sc.close();
    }
}