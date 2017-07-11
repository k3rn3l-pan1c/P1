/* Bilhete de comboio
 * 
 * Dados:
 * Idade Inferior a 6 -> Isento de pagamento 
 * Entre 6 e 12 -> Bilhete de crianca 
 * Entre 13 e 65 -> Bilhete normal 
 * Mais de 65 -> Bilhete de 3a idade
 * 
 * 1) Ler idade
 * 2) Decidir e imprimir
 */
 

import java.util.Scanner;
public class ex23
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		int age;
		
		//1
		System.out.print("Introduz a sua idade: ");
		age = sc.nextInt();
		
		//2
		if (age < 6)
			System.out.print("Isento de pagamento");
		else if (age <= 12)
			System.out.print("Bilhete de criança");
		else if (age <65)
			System.out.print("Bilhete normal");
		else if (age>65)
			System.out.print("Bilhete de 3º idade");
		
	}
}
