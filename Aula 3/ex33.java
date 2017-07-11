/*	min, max, media e n de uma lista
 * 
 * Condicao de paragem: valor igual ao primeiro que foi introduzido
 * Dados: nao conte com o valor sentinela. 
 * 
 * 1) ler numero enquanto num!=2*num1 e o num nao e o 1
 * 2) Atualizar o maximo
 * 3) Atualizar o minimo
 * 4) Calcular a soma
 * 5) Contar os num introduzidos
 * 6) Media
 * 7) print
 */
 
import java.util.Scanner;
public class ex33
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		double num, max = 0,min = 0, media, first = 0, soma = 0;
		int cont = 0;
		
		do
		{
			cont++;
			System.out.print("Introduza um numero: ");
			num = sc.nextDouble();
			
			// se o num e o primeiro, criar um maximo, min, soma. 
			// Guardar o valor -> usado na cond de paragem
			if (cont == 1) 
			{
				first = num;
				max = num;
				min = num;
				soma = num;
			}
			else
			{
				//2
				if (num>max)
					max = num;
				//3
				if (num<min)
					min = num;
				soma += num;	//4
			}
		} while (((num != first) || (cont ==1))); //1
		
		//6
		media = (soma-num) / (cont-1);
		
		//7
		System.out.println("O numero maior introduzido e " + max);
		System.out.println("O numero menor introduzido e " + min);
		System.out.println("Foram introduzidos " + (cont-1) + " numeros");
		System.out.println("A media dos numeros introduzidos e: " + media);
		}
}
