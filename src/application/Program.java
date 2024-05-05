package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scan.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = pattern.parse(scan.next());
        System.out.print("Check-out date  (dd/mm/yyyy): ");
        Date checkOut = pattern.parse(scan.next());

        Date now = new Date();

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = pattern.parse(scan.next());
            System.out.print("Check-out date  (dd/mm/yyyy): ");
            checkOut = pattern.parse(scan.next());

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
        scan.close();
    }
}
