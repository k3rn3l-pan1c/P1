/* Maior de tres numeros
 * 
 * 1) ler numeros
 * 2) verificar condicoes
 * 3) print
 */


import java.util.Scanner;
public class ex27 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		
		//1
		System.out.print("Introduza tres numeros: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		
		/* 2 - variavel num1 guardara smp o num maior
			   if num1 > num2  ou  if num1> num3
		       n e preciso pq assim o num1 e o maior 
		 */
		
		 if (num2>num1)     
		 //se o num2 > num1, o num1(maior) passa a ser o num2
				num1 = num2;  
		if (num3> num1)
		// se o num3 e maior que o num1(o maior), entao ele e o maior de todos
				num1 = num3; 
		
		//2	
		System.out.print("O maior numero e: " + num1);
	}
}

