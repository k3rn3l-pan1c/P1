/* Max, min Lista positiva do while
 * 
 * Dados: determine e escreva no monitor o menor e o maior dos numeros lidos. 
 * 
 * Condicao de paragem:  numero e o dobro do numero anterior
 * 
 * 1) Validar entradas
 * 2) Ler numeros ate cond == true
 * 3) Atualizar max
 * 4) Atualizar min
 * 5) print
 */
 
 
 import java.util.Scanner;
public class ex310_v1 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int num, ant, max, min;
		
		//ler numero fora do ciclo para ser o 1 anterior
		System.out.print("Numero: ");
		num = sc.nextInt();
		min = num;
		max = num;
		
		
		do
		{
			ant = num; //guarda num anterior
			
			do
			{
				System.out.print("Numero: ");
				num = sc.nextInt();
			} while (num<=0); //1
			
			
			/*3*/ if (num > max) max = num;
			/*4*/ if (num < min) min = num;
			
		} while (num!=(2*ant)); //2
		
		//5
		System.out.printf("O maior numero lido e %d e o menor numero lido e %d\n", max,min);
		System.out.printf("O ultimo numero lido foi %d e o numero anterior a esse, que é a sua metade, e %d\n", num, ant);
	}
}

