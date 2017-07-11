/* Produto de numeros reais
 * 
 * Condiçao de paragem: num = 0
 * 
 * 1) Ler num ate num = 0
 * 2) Calcular produto
 * 2) print
 */
 

import java.util.Scanner;
public class ex32
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); //criar scanner
		double num,prod=1;
		int n;
		
		
		do
		{
			System.out.print("Introduza um numero: ");
			num= sc.nextDouble();
			if (num==0) //impede o ultimo produto de ser efetuado, assim o resultado n e 0
				break;
			/*2*/ prod *= num;
		} while (num!=0); //1
		System.out.print("O produto dos numeros introduzidos e: " + prod);
	}
		
}


