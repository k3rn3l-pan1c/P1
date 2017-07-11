/*
 * 
 * 
 * Opcao 0 reimprime o menu
 * 
 * possiblidade: as funcoes devolvem strings.. a main repete a escolha em vez da selectFuction() e imprime as! :D
 *
 * NOT WORKING!!!
 * 
 */
 
 
 
import java.util.Scanner;
public class ex93_v3 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		int array[] = new int[51];
		int option;
		String temp = ""; //a inicializacao e obrigatoria
		
		System.out.print(menu());
		
		
		do
		{
			option = getOption();
				switch (option)
				{
					case 0:
						temp = ("\n" + menu());// fazer mudanca de linha -> uma linha de intervalo
						break;
					case 1:
						array = lerArray();
						break;
					case 2:
						temp = printArray(array);
						break;
					case 3: 
						temp = maxArray(array);
						break;
					case 4: 
						temp = minArray(array);
						break;
					case 5: 
						temp = media(array);
						break;
					case 6:
						temp = paridade(array);
						break;	
					case 10:
						temp = ("\nO programa vai terminar...");
				}
		} while (option !=10);
		
		
		
		System.out.printf(temp);
		
			
	}
	public static String menu(){
		return ("Analise de uma sequencia de numeros inteiros\n0 - Imprimir menu\n1 - Ler a sequencia\n2 - Escrever a sequencia\n3 - Calcular o maximo da sequencia\n4 - Calcular o mınimo da sequencia\n5 - Calcular a media da sequencia\n6 - Detetar se e uma sequencia so constituıda por numeros pares\n10 - Terminar o programa\n");
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
		
		
	
	public static String printArray(int array[]){
		String temp = "";
		if (array[50] == 0)
			return ("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				System.out.println("Impressao do array");
				
				for (int i = 0; i < array[50]; i++)
				{
					temp += ("Indice [" + i + "]: "+ array[i] + "\n");
				}
				temp += ("\nImpressao terminada. Nova ");
				return  temp;
			}
	}
		
	public static String maxArray(int array[]){
		int max = array[0];
		if (array[50] == 0)
			return ("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 1; i < array[50]; i++)
				{
					if (array[i] > max)
						max = array[i];
				}
				return ("O valor maximo do array e " + max +" .\n\nNova ");
			}
			
		}
	
	
		
	public static String minArray(int array[]){
		int min = array[0];
		if (array[50] == 0)
			return ("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 1; i < array[50]; i++)
				{
					if (array[i] < min)
						min = array[i];
				}
				return ("O valor minimo do array e " + min + " %d.\n\nNova ");
			}
		}
		
	public static String media(int array[]){
		double  soma = 0.0;
		if (array[50] == 0)
			return ("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 0; i < array[50]; i++)
				{
					soma += array[i];
				}
				return ("A media de valores do array e " + (soma/array[50]) + " \n\nNova ");
			}
		}
		
	public static String paridade(int array[]){
		boolean par = true;
		String temp = "";
		if (array[50] == 0)
			return ("Array vazio - por favor introduza um array valido\n\n");
		else
			{
				for (int i = 0; i < array[50]; i++)
				{
					if (array[i] % 2 != 0)
					{
						par = false;
						temp = ("O array e constituido por valores pares e impares\n\nNova ");
					}
				}
				if (par) //impedir se for imapr de imprimir a frase
					temp = ("O array e constituido exclusivamente por valores pares\n\nNova ");
			}
			return temp; // tem de retornar sempre algo em teoria.. na pratica nnca chegará aqui, mas o return tem de ca estar..
	}
	}


