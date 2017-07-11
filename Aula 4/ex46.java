/* Asteriscos 1
 * 
 * 1) ler num de linhas e num de colunas
 * 2) Imprimir os asteriscos um a um com um for para as colunas e outro para as linhas
 * 
 */
 

import java.util.Scanner;
public class ex46 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int l,c;
		
		
		//1
		System.out.print("Linhas: ");
		l = sc.nextInt();
		System.out.print("Colunas: ");
		c = sc.nextInt();
		
		
		for (int i = 1; i <= l; i++) //percorre as linhas
		{
			for (int j = 1; j <= c; j++) //percorre em cada linha, cada coluna
			{
				/*2*/ System.out.print("*");
			}
			System.out.println(); // muda de linha sempre que ja foram escrita todas as colunas para a linha
		}
		
	}
}

