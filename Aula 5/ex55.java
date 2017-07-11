/* Asteriscos
 * 
 * 
 */

import java.util.Scanner;
public class ex55 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int c,l;
		
		//obter um num positivo para as linhas
		do
		{
			System.out.print("Linhas: ");
			l = sc.nextInt();
		} while (l<0);
		
		//obter um num positivo para as colunas
		do
		{
			System.out.print("Colunas: ");
			c = sc.nextInt();
		} while (c<0);
		
		//gerar todos os valores possiveis ara uma matriz lxc
		for (int i = 1; i <=l ; i++)
		{
			for (int j = 1; j <= c; j++)
				{
					if (((i==1) || (i==l)) || ((j==1) || (j==c))) //imprimir asteriscos so qnd a linha ou e a 1 ou a ultima e idem para as colunas
					System.out.print("*");
					else System.out.print(" ");
				}
				System.out.println();	//mudanca de linha smp que se percorre todas as colunas de um linha
				
					
			}
			
		}
		
	}


