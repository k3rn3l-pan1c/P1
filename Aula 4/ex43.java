/* Fatorial
 * 
 * Dados:
 *  n! = 1×2×3×...×n. 
 * 
 * Condicoes: n>0 && n<10
 * 
 * 1) ler e validar entradas
 * 2) gerar intervalo
 * 3) calcular fatorial
 * 4) print fatorial
 */
 

import java.util.Scanner;
public class ex43 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int m, num=1; //num=1 pq o 1 é o elemento neutro da multiplicação
		
		//1
		do
		{
			System.out.print("Introduza um numero: ");
			m = sc.nextInt();
		} while (m<0 && m>10);
		
		
		for (int i = 1; i <=m; i++) //2 - for que gera uma lista de numero continuos.. de 1 ao num introduzido pelo user
		{
			for (int j = i; j >=1 ; j--) //3 - for que calcula o fatorial de um numero
			{
				num *= j;
			}
			System.out.printf("%2d! = %2d\n",i,num); //4
			num = 1; //inicialização da variável para ficar novamente no elemento neutro
		}
		
	}
}

