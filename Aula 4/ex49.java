/* Soma n pares do intervalo 
 * 
 * 1) ler o numero de valores do intervalo e validar
 * 2) percorrer o inetrvalo 
 * 3) imprimir os n pares
 * 4) calcular a sua soma
 * 5) contar os numeros pares
 */


import java.util.Scanner;
public class ex49 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num, soma = 0, i = 0,cont = 0;
		
		//1
		do
		{
				System.out.print("Numero: ");
				num = sc.nextInt();
		} while ((num<0) && (num <=1000));
		
		System.out.printf("\nOs primeiros %d pares sao:\n" , num);
		
		//2
		do
		{
			i++;
			if ((i % 2) == 0)
				{
					System.out.println(i); //3
					soma += i; //4
					cont++; //5
				}
		} while (cont != num); //qnd forem obtidos tantos num pares como os do intervalo, get out!

		System.out.printf("\nA soma de todos os numeros pares do intervalo e " + soma);
	}
}

