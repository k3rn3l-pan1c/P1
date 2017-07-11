/*	Conversao Dolares Americanos -> Euros
 * 
 * 1) pedir a quantia em dolares e a taxa de conversao. 
 * 2) calcular e escreve no monitor a respetiva conversao para euros com o seguinte formato:
 *		##.# dolares equivalem a ##.# euros
 */ 


import java.util.Scanner;
public class ex111
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 
		double money,rate;
		
		//1	
		System.out.print("Introduza uma quantia em dolares: ");
		money= sc.nextDouble();
		System.out.print("Introduza a taxa de cambio atual de dolares para escudos: ");
		rate= sc.nextDouble();
		
		//2
		System.out.print("A quantia em dolares introduzida corresponde a " + (money*rate) + " escudos");
		}
}



