package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = scan.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIn = pattern.parse(scan.next());
            System.out.print("Check-out date  (dd/mm/yyyy): ");
            Date checkOut = pattern.parse(scan.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = pattern.parse(scan.next());
            System.out.print("Check-out date  (dd/mm/yyyy): ");
            checkOut = pattern.parse(scan.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException error){
            System.out.println("Invalid date format");
        }
        catch (DomainException error) {
            System.out.println("Error in reservation: " + error.getMessage());
        }
        catch (RuntimeException error) {
            System.out.println("Unexpected error");
        }

        scan.close();
    }
}
