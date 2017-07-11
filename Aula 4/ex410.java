/* Numeros Perfeitos
 * 
 * Dados: Um numero natural e um numero perfeito quando e igual a soma de todos os seus divisores proprios
 * 
 * 1) ler num e validar
 * 2) percorrer intervalo ate igualar o num
 * 3) se o num for divisil por o i (resto == 0), somatorio desse i com a soma anterior 
 * 4) verificar se o num e perfeito e print
 */
 
 
import java.util.Scanner;
public class ex410 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int num, soma = 0;
		
		//1
		do
		{
			System.out.print("Numero: ");
			num = sc.nextInt();
		} while (num <= 0);
		
		//2
		for (int i = 1; i < num ; i++)
		{
			//43
			if ((num % i) == 0)
				soma += i;
		}
		
		//4
		if (soma == num)
			System.out.printf("O numero %d e perfeito", num);
		else System.out.printf("O numero %d nao e um numero perfeito", num);
	}
}

