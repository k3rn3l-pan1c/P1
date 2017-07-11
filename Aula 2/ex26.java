/*	Par ou Impar
 * 
 * 1) ler numeros
 * 2) Verificar se o resto da dfivisao por 2 == 0. se sim, par, senao, impar
 */


import java.util.Scanner;
public class ex26
{
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num;
		//1
		System.out.print("Introduza um numero: ");
		num = sc.nextInt();
		
		//2
		if (num % 2 == 0)	System.out.print("O numero introduzido e par");
		else System.out.print("O numero introduzido e impar");
	}
}

