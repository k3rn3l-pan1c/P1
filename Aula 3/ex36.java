/* MDC - Algoritmo de Euclides
 * 
 * Dados:  Este algoritmo consiste em subtrair sucessivamente o menor numero ao maior ate que os dois numeros se tornem iguais
 * 
 * 1) ler 2 nums
 * 2) verificar qual o maior
 * 3) Subtrair sucessivamente os nums ate serem iguais ou ate um delse ser menor que o outro
 * 4) iguais -> encontrou-se o maximo divisor comum
 * 5) um ser menor que o outro -> n existe mdc
 */
 
import java.util.Scanner;
public class ex36 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, aux;
		
		//1
		System.out.print("Introduza dois numeros: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		//2
		if (num2>num1)
		{
			aux = num1;
			num1 = num2;
			num2 = aux;
		}
		
		//3
		do
		{
			num1-=num2;
		} while ((num1!=num2) && (num1>num2));
		
		//4
		if (num1==num2)
			System.out.print("o maior divisor comun e: " + num1);
			
		//5
		else System.out.print("Nao existe divisor comun");
	}
}

