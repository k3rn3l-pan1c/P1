/* Contador de numeros int
 * 
 * Condiçao de paragem: num -
 * 
 * 1) Ler num ate num < 0
 * 2) print
 */
 

import java.util.Scanner;
public class ex31 
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		int num, cont=0;
		
		//1
		do
		{
			System.out.print("Introduza um numero: ");
			num = sc.nextInt();
			cont++; //cont = cont+1; cont += 1;
		} while (num>=0);
		
		//2
		System.out.print("Foram introduzidos " + (cont-1) + " numeros");
		
	}
}

