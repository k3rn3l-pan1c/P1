/*
 * 
 * 
 * Pesquisar num no vetor
 * 
 * 
*/


import java.util.Scanner;
public class ex92_v1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		int v[] = new int[100];
		int cont= 0, num;
		
		System.out.print("Introduza o numero que pretende procurar no vetor: ");
		num = my.getIntPos();
		
		for (int i = 0; i < 100; i++)
		{
			System.out.print("Num: ");
			v[i] = sc.nextInt();
			
			if (v[i] == num)
				cont++;
				
			if (v[i] < 0)
				break;
		}
		
		System.out.printf("O numero %d aparece %d vezes no vetor", num, cont);
	}
}

