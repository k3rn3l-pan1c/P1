/*
 *  Maximo Divisor Comum
 *  
 */
 
 
import java.util.Scanner;
public class ex57 {
	
	public static void main (String args[]) {
		int num1,num2;
		num1 = Functions.GetPositive(); //funcao que devolve um valor int positivo
		num2 = Functions.GetPositive(); //funcao que devolve um valor int positivo
		Functions.euclides(num1, num2); //funcao que imprime o mdc de m numero ou entao informa que nao existe
		
		
		
	}
}

