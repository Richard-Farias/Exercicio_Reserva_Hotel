package model.exceptions;

public class DomainException extends Exception{
	private static final long serialVersionUID = 1L;
	//Criação de um construtor recebendoum patâmetro String
	// Permite instanciar a exceção personalizada passando uma messagem que vai ficar armazenada na exceção
	public DomainException (String message) {
		// Repassa message para o construtor da super classe
		super(message);
	}
	 
	
	

}
