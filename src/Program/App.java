package Program;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data do update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(sc.next());
            if (!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else if (!checkOut.after(reservation.getCheckIn())){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }




        sc.close();
    }
}
