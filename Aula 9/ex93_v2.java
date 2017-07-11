/*
 * 
 * Opcao 0 reimprime o menu
 * 
 * possiblidade: as funcoes devolvem strings.. a main repete a escolha em vez da selectFuction() e imprime as! :D
 */
 
 
 
import java.util.Scanner;
public class ex93_v2 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		int array[] = new int[51];
		int option;
		
		menu(""); 
		
		selectFunction(array);
		
		System.out.printf("\nO programa vai terminar...");
			
	}
	public static void menu(String aux){ //a variavel aux e usada para fazer uma linha de intervalo qnd se reimprime o menu
		System.out.printf(aux + "Analise de uma sequencia de numeros inteiros\n0 - Imprimir menu\n1 - Ler a sequencia\n2 - Escrever a sequencia\n3 - Calcular o maximo da sequencia\n4 - Calcular o mınimo da sequencia\n5 - Calcular a media da sequencia\n6 - Detetar se e uma sequencia so constituıda por numeros pares\n10 - Terminar o programa\n");
		}
	
	public static void selectFunction(int array[]){
		int option;
		do
		{
			option = getOption();
				switch (option)
				{
					case 0:
						menu("\n");
						break;
					case 1:
						array = lerArray();
						break;
					case 2:
						printArray(array);
						break;
					case 3: 
						maxArray(array);
						break;
					case 4: 
						minArray(array);
						break;
					case 5: 
						media(array);
						break;
					case 6:
						paridade(array);
						break;					
				}
		} while (option !=10);
		
		
		}
	public static int getOption(){
		boolean control;
		int option;
		do
		{
			System.out.print("Opcao -> ");
			option = sc.nextInt();
			switch (option)
			{
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 10:
					control = true;
					break;
				default:
					System.out.print("Opcao invalida. Nova ");
					control = false;
					break;
			}
			
		} while (control == false);
		
		return option;
		}
		
		
	public static int[] lerArray(){
		int temp[] = new int[51];
		
		System.out.println("Leitura do array");
		
		for (int i = 0; i < 50; i++)
		{
			System.out.printf("Indice [%d]: ", i);
			temp[i] = sc.nextInt();
			if (temp[i] == 0)
				{
					temp[50] = i;
					System.out.printf("\nleitura terminada. Nova ");
					return temp;
				}
		}
		System.out.printf("\nleitura terminada. Nova ");
		return temp;
		}
		
		
	
	public static void printArray(int array[]){
		if (array[50] == 0)
			System.out.printf("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				System.out.println("Impressao do array");
				
				for (int i = 0; i < array[50]; i++)
				{
					System.out.printf("Indice [%d]: %d\n", i, array[i]);
				}
				System.out.printf("\nImpressao terminada. Nova ");
			}
	}
		
	public static void maxArray(int array[]){
		int max = array[0];
		if (array[50] == 0)
			System.out.printf("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 1; i < array[50]; i++)
				{
					if (array[i] > max)
						max = array[i];
				}
				System.out.printf("O valor maximo do array e %d.\n\nNova ",  max);
			}
			
		}
	
	
		
	public static void minArray(int array[]){
		int min = array[0];
		if (array[50] == 0)
			System.out.printf("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 1; i < array[50]; i++)
				{
					if (array[i] < min)
						min = array[i];
				}
				System.out.printf("O valor minimo do array e %d.\n\nNova ",  min);
			}
		}
		
	public static void media(int array[]){
		double  soma = 0.0;
		if (array[50] == 0)
			System.out.printf("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 0; i < array[50]; i++)
				{
					soma += array[i];
				}
				System.out.printf("A media de valores do array e %.2f.\n\nNova ", (soma/array[50]));
			}
		}
		
	public static void paridade(int array[]){
		boolean par = true;
		if (array[50] == 0)
			System.out.printf("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 0; i < array[50]; i++)
				{
					if (array[i] % 2 != 0)
					{
						System.out.printf("O array e constituido por valores pares e impares\n\nNova ");
						par = false;
						break;
					}
				}
				if (par)
					System.out.printf("O array e constituido exclusivamente por valores pares\n\nNova ");
			}
	}
	}


