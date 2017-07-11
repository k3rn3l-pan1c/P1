/* Ordenar 3 num crescente
 * 
 * 1) ler numeros
 * 2) verificar qual maior que qual
 * 3) print
 */
 
import java.util.Scanner;
public class ex28 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3, aux;
		
		//1
		System.out.print("Introduza tres numeros: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();

	   /*2
		* 1º Assumimos que num1 e o maior num, num2 o intermedio e num3 o menor
		* 
		* 2º verificamos se algum dos num e maior que num1
		* se sim, entao substitir, 
		* senao, o num1 e o maior
		* 
		* 3º verificamos se o num3 e maior que o num 1
		* se sim, entao substitir, 
		* senao, o num1 e o maior
		* 
		* 4º verifcamos se o num3 e maior que o num2
		* se sim, entao substitir, 
		* senao, o num2 e o maior	
		*/
	
		if (num2 > num1)
		{
			aux= num1;
			num1= num2;
			num2 = aux;
		}	
		if (num3 > num1)
		{
			aux = num1;
			num1 = num3;
			num3= aux;	
		}	
		if (num3 > num2)
		{
			aux = num2;
			num2 = num3;
			num3 = aux;
		}
		
		//3 - os numeros ja estao ordenados, e so escrever
		System.out.printf("Conjunto ordenado por ordem crescente: %d %d %d", num3,num2,num1);
		
		
	}
}

