/*
 * ex103 + pesquisa e ordenação
 * 
 * 
 * pls note: array[50] guarda o num de indices do vetor preenchidos
 * 
 */
 
import java.util.Scanner;
import java.io.*;
public class ex111 {
		
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException {
		int array[] = new int[51];
		int option;
		
		menu(""); //chamar a funcao que escreve o menu com nenhuma linha de intervalo
		
		selectFunction(array); //hiper function!
		
		System.out.printf("\nO programa vai terminar...");
			
	} 
	
	
	
	public static void fullSearch(int[] array){
		boolean control = false;
		System.out.print("Introduza o numero que pretende pesquisar no vetor: ");
		int num = sc.nextInt();
		for (int i = 0; i < array[50]; i++)
		{
			if(array[i] == num)
			{
				System.out.printf("O numero %d existe no vetor.", num);
				control = true;
				break;
			}
		}
		if (!control)
			System.out.printf("O numero %d nao existe no vetor.", num);
		System.out.printf("\nNova ");
	}
		
		
	//ordenação por Selection Sort
	public static void sequencialSortUP(int[] array) {
		for (int i = 0; i < array[50]; i++)
		{
			for (int j = 0; j < array[50] ; j++)
			{
				if (array[i] < array[j])
				{
					int temp;
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.printf("\nOrdenacao do vetor concluida. Nova ");
		
	}
	
	//Ordenação por Bubble Sort
	public static void bubbleSortDown(int[] array) {
		int changes = 0;
		do
		{
			changes = 0;
			for (int i = 0; i < array[50] ; i++)
			{
				if (array[i] < array[i+1])
				{
					int temp;
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					changes++;
				}
			}
		} while (changes != 0);
		System.out.printf("\nOrdenacao do vetor concluida. Nova ");
		
		
		
		}
	
		
		
	
	public static void save(int[] array) throws IOException{
		int op = 1;
		if (array[50] == 0)
			{
			System.out.printf("O array encontra-se vazio.\nPretende mesmo assim proceder com a gravacao? (1 - S / 0 - N): ");
			do
			{
				op = sc.nextInt();
			} while (op != 1 && op != 0);
			}
		if (op == 1)
			{
				String name;
				System.out.print("Introduza o nome do ficheiro onde pretende gravar: ");
				do
				{
					name = sc.nextLine();
				} while (name.length() == 0);
						
				File f = new File(name);
				PrintWriter pw = new PrintWriter(f);
				
				
				for (int i = 0; i < array[50]; i++)
				{
					pw.println( array[i]);
				}
				pw.close();
				System.out.printf("\nEscrita no ficheiro %s terminada. Nova ", name);
			}
		
		else System.out.printf("\nNova ");
	}
	
	
	public static int[] add(int[] temp){
		int i;
		for ( i = temp[50]; i < temp.length ; i++)
		{
			System.out.printf("[%d]: ", i);
			temp[i] = sc.nextInt();
			if (temp[i] == 0)
				{
					temp[50] = i;
					System.out.printf("\nNova ", i);
					return temp;
				}
			}
		System.out.printf("\nNova ");
		return temp;
		}
	
	public static int[] lerFile() throws IOException{
		int temp[] = new int[51];
		String name = "";
		int i = 0;
		System.out.print("Introduza o nome do ficheiro: ");
		do {
			name = sc.nextLine();
		} while (name.length() == 0);

		File f = new File(name);
		if( f.isFile() ){
			if( f.canRead() ){
		Scanner readFile = new Scanner(f);
		
		while(readFile.hasNextInt())
		{
			temp[i] = readFile.nextInt();
			i++;

		}
		readFile.close();
		System.out.printf("\nleitura do ficheiro %s terminada. Nova ", name);
		} else System.out.println("Nao tem permissão para ler o ficheiro.");
			
			} else	System.out.println("O ficheiro nao e valido.");
	
		temp[50] = i;
		return temp;
		
		
	}
		
	
	
	public static void menu(String aux){ //a variavel aux e usada para fazer uma linha de intervalo qnd se reimprime o menu
		System.out.printf(aux + "Analise de uma sequencia de numeros inteiros\n0 - Imprimir menu\n1 - Ler a sequencia via teclado\n2 - Escrever a sequencia\n3 - Calcular o maximo da sequencia\n4 - Calcular o mınimo da sequencia\n5 - Calcular a media da sequencia\n6 - Detetar se e uma sequencia so constituıda por numeros pares\n7 - Ler uma sequencia de numeros de um ficheiro\n8 - Adicionar numeros a sequencia\n9 - Gravar a sequencia num ficheiro\n10 - Ordenar a sequencia por ordem crescente utilizando ordenacao sequencial\n11 - Ordenar a sequencia por ordem decrescente utilizando ordenacao por flutuacao\n12 - Pesquisa de valor na sequencia\n13 - Terminar o programa\n");
		}
	
	public static void selectFunction(int array[]) throws IOException{
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
					case 7:
						array = lerFile();
						break;
					case 8:
						add(array);
						break;
					case 9:
						save(array);
						break;
					case 10:
						sequencialSortUP(array);
						break;
					case 11:
						bubbleSortDown(array);
						break;
					case 12:
						fullSearch(array);
						break;
				}
		} while (option !=13);
		
		
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
				case 7:
				case 8:
				case 9:
				case 10:
				case 11:
				case 12:
				case 13:
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




