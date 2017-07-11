/*
 * Num de vezes que cada elemento aparece numa sequencia
 * 
 * 
 * dif do stor... n tou a ver como ele fez -> leitura um a um e pesquisa??
 * 
 * 
 * 
 * 
 */

import java.util.Scanner;
public class ex97 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		int v[] = new int[101]; //101 pq a ultima posicao vai guardar o numero maximo de valores prenchido do array - evita-se andar com outra var atras
		int u[] = new int[101];
		
		fillArray(v);
		countNumArray(v, u);
		
		for (int i = 0; i <= u[100]; i++) 
		{
			if (u[i] != 0) //os numeros introduzidos podem nao estar seguidos e nao existirem numeros pelo meio
			{
				if (u[i] == 1)
					System.out.printf("O numero %d ocorre %d vez\n", i, u[i]);
				else 
					System.out.printf("O numero %d ocorre %d vezes\n", i, u[i]);
			}
		}	
	}
	
	public static void countNumArray(int[] array, int[] count){
		for (int i = 0; i < array[100]; i++)
		{
			count[array[i]]++; //o valor equivale a posicao para valores de 0 a 99
			//o stor nao limita, mas para resolver com valores superiores teria de se usar classes... nao nenhum big deal, mas n me parece que seja o pretendido
			
			count[100] = i; //guardar a ultima posiçao prenchida - e o maximo
		}
	}
	public static void fillArray(int[] array){
		for (int i = 0; i < 100; i++)
		{
			System.out.print("Num: ");
			array[i] = sc.nextInt();
			
			
				
			if (array[i] < 0)
			{
				array[100] = i; //dimensao do array
				break;
			}
		}
	}
}

