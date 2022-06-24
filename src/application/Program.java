package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner enter  = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("Welcome to System of Reservation \n");
		try {
			System.out.print("Room Number:");
			int roomNumber = enter.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy):");
			Date checkin = sdf.parse(enter.next());
			System.out.print("Check-out date (dd/mm/yyyy:");
			Date checkout = sdf.parse(enter.next());
			
			// Condição que verifica se a data de check-out é antes da data de check-in
			
			Reservation reservation = new Reservation(roomNumber,checkin,checkout);
			System.out.println("Resertvation:" + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy):");
			checkin = sdf.parse(enter.next());
			System.out.print("Check-out date (dd/mm/yyyy:");
			checkout = sdf.parse(enter.next());
			
		    //Chamada de método para a atualização das datas de reserva
			reservation.updateDates(checkin, checkout);	
			System.out.println("Reservation:" + reservation);
		}
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected Error!");
		}
	
		enter.close();
	}

}
