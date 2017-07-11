/* Tabela de solucoes de equacoes polinomias de 3 grau e 2
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex58 {
	
	public static void main (String args[]) {
		double num1, num2;
		
		num1 = Functions.GetDouble(); // chama a funcao que obtem um vaor real positivo
		do
		{
			num2 = Functions.GetDouble(); // chama a funcao que obtem um vaor real positivo
		} while (num2 <= num1); //garante que num2 > num1 
		
		System.out.printf("------------------------------------\n|   x   | 5x2+10x+3 | 7x3+3x2+5x+2 |\n------------------------------------\n");
		
		for (int i = (int)num1; i <= (int)num2; i++) //gerar valores da incognita pertencente ao valor do intervalo introduzido
		{
			System.out.printf("| %5.1f | %9.2f | %12.4f |\n", (double)i, Functions.poly3(0,5,10,3,i), Functions.poly3(7,3,5,2,i)); //imprimir a tabela, usando os valores de retorna da funcao poly3
		}
		System.out.printf("------------------------------------");
		
		
	}
}

