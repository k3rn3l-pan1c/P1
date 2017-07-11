/* Numeros impares do intervalo
 * 
 * Condicoes: A e B positivos. Validacao dos valores de entrada.
 * 
 * 1) Obter limite inferior e limte superior
 * 2) percorrer o intervalo e imprimir os valores que sao impares
 */
 

import java.util.Scanner;
public class ex48 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int low, up, cont = 0;
		
		//1
		do
		{
			System.out.print("Limite Inferior= ");
			low = sc.nextInt();
		} while (low < 0); //limite inferior tem de ser positvo, logo maior que 0
		
		do
		{
			System.out.print("Limite Superior= ");
			up = sc.nextInt();
		} while (up <= low); // se o limite superior for maior que o limte inferior e obrigatoriamente maior do que 0
		
		System.out.printf("Numeros impares pertencentes ao intervalo [%d, %d]:\n", low,up);
		
		//2
		for (int i = low; i <= up; i++)
		{
			if ((i % 2) == 1)
				System.out.println(i);
		}
		
	}
}

