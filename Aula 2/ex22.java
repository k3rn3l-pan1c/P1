/*  Maior, Igual ou Menor
 * 
 * 1)ler numeros
 * 2) verificar a condição
 * 3) imprimir essa condição
 */


import java.util.Scanner;
public class ex22
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		double num1, num2;
		
		//1
		System.out.print("Introduza dois numeros: ");
		num1 = sc.nextDouble();
		num2 = sc.nextDouble();
		
		//2, 3
		if (num1>num2)
			System.out.println("O maior numero e " + num1);
		else if (num2>num1)
			System.out.println("O maior numero e " + num2);
		else System.out.println("Os numeros são iguais");
	
	}
}

