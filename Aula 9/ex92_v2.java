/*
 * 
 * 
 * Pesquisar num no vetor sem vetor
 * 
 * 
*/


import java.util.Scanner;
public class ex92_v2 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		int x;
		int cont= 0, num;
		
		System.out.print("Introduza o numero que pretende procurar no vetor: ");
		num = my.getIntPos();
		
		for (int i = 0; i < 100; i++)
		{
			System.out.print("Num: ");
			x = sc.nextInt();
			
			if (x == num)
				cont++;
				
			if (x < 0)
				break;
		}
		
		System.out.printf("O numero %d aparece %d vezes no vetor", num, cont);
	}
}
