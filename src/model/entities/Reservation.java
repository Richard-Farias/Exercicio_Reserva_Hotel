package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {
	
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reservation(int roomNumber, Date checkin, Date checkout) throws DomainException{
		if(!checkout.after(checkin )) {
			throw new DomainException("Check-out date must be after Check-in date."); 								
		 }
		
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	//Método para calcular a diferença entre as duas datas
	public long duration() {
		// getTime()-calcula a diferença das datas em mílissegundos
		long diff = checkOut.getTime() - checkIn.getTime(); 
		// TimeUnit é um Enumeration que vai converter a variável "diff" de millisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	
		
	}
	
	public void updateDates(Date checkin ,Date checkout) throws DomainException{
		Date now = new Date();	
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for updates must be future."); 
		 }
		if(!checkout.after(checkin )) {
			throw new DomainException("Check-out date must be after Check-in date."); 								
		 }
		
		this.checkIn = checkin;
		this.checkOut = checkout;
		
	}
	
	//Método para a saída de dados
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("Room " 
					+ roomNumber
					+ ",Chech-In: " + sdf.format(checkIn) 
					+ ",Check-Out:" + sdf.format(checkOut) 
					+ "," + duration()	
					+ " Nights");
		
		return msg.toString();
	}
	
	// Getters and Setters
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}


	public Date getChekcout() {
		return checkOut;
	}

	
}
