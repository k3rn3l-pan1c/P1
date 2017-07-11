/* Numeros Primos
 *
 *  Dados: Um numero natural e um numero primo quando tem exatamente dois divisores naturais distintos: o numero um e ele mesmo
 * 
 * 1) Verificar se o num introduzido e positivo
 * 2) Verificar primalidade
 * 3) print
 */
 
import java.util.Scanner;
public class ex35 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num,cont=1;
		boolean primo=true;
		
		//1 - validar entradas
		do
		{
			System.out.print("Introduza um numero: ");
			num = sc.nextInt();
		} while (num<=0);
		
		//2 - de 2 a num-1 procurar divisores
		while ((cont!=(num-1)))
		{
			if (num==1)  //eliminação do caso particular
			{
				primo = false;
				break;
			}
			cont++;
			if ((num%cont) ==0)  // se se encontrou um divisor, o num ja nao e primo e e pode-se quebrar o ciclo
			{
				primo = false;
				break;
			}
		}
		
		//3
		if (primo == false)
			System.out.printf("O numero %d nao e um numero primo", num);
		else
			System.out.printf("O numero %d e um numero primo", num);
	}
}

