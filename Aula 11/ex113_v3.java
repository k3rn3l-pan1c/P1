/*
 * PH Station
 * 
 * obriga a ler um ficheiro logo no inicio
 * nao permite a alteracao de dados, a nao ser que se termine o programa ---  bug
 * 
 * 
 * 
 */






import java.util.Scanner;
import java.io.*;
public class ex113_v3 {
	
	public static Scanner kb = new Scanner(System.in);
		
	public static void main (String args[]) throws IOException{
		
		
		double[] PH = readFile(); //tem que se obrigar a ler um ficheiro, senao os arrays nunca sao inicializados... 
		System.out.printf("\n");
		printMenu();
		int option;
		do
		{
			System.out.printf("Opcao-> ");
			option = choice(PH);
		} while (option != 7);
		
	}
	public static void BubbleSort(double[] array){
		double tmp[] = new double[array.length];
		
		
		for (int i = 0; i < array.length; i++)
		{
			tmp[i] = array[i]; //copiar os valores para ordenar... o enunciado diz pra escrever os valores ordenados e nao para ordenar os valores... 
			//Assim, nao se altera o vetor inicial mas sim cria-se um temp com os valores ordenados
			//Neste problema nao faria dif, mas num vetor de classes ao ordenar um dos parametros teria de se ordenar tbm os outros (para nao desassociar os dados)
			//Se o enunciado fosse igual (so pedisse para apresentar qualquer cena ordenada), estariamos a ordenar os dados em funcao de qualquer coisa (mesmo que so imprissemos o pretendido) e nao a apresentar uma lista dessa qualquer coisa ordenada 
		}
		
		
		int changes = 0;
		do
		{
			changes = 0; //reset
			for (int i = 0; i < tmp.length -1; i++)
			{
				if (tmp[i] > tmp[i+1])
				{
					changes++;
					double aux;
					aux = tmp[i+1];
					tmp[i+1] = tmp[i];
					tmp[i] = aux;
				}
			}
			
		} while (changes != 0);
		
		for (int i = 0; i < tmp.length; i++)
		{
			System.out.printf("PH[%d]: %f\n", i, tmp[i]);
		}
		
	}
	
	
	public static int UPmedia(double[] array){
		double media = mediaPH(array);
		int cont = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] > media)
				cont++;
		}
		
		return cont;
	}
		
		
		
	public static void PHstats(double[] array){
		int H = 0;
		int OH = 0;
		for (int i = 0; i < array.length; i++)
		{
			if( array[i] < 7.0) //acida
				H ++;               //n e preciso verificar... so existem valores validos
			else if (array[i] > 7.0) //basica
					OH++;
		}
		
		System.out.printf("Existem %d valores de PH acidos e %d valores de PH basicos\n", H, OH);
	}
		
		
	public static double mediaPH(double[] array){
		double soma = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			soma += array[i];
		}
		
		return (soma / array.length);
	}
		
		
	public static void print(double[] array){
		for (int i = 0; i < array.length; i++)
		{
			System.out.printf("entrada %d: %f\n", i, array[i]);
		}
	}
		
		
	public static double[] readFile() throws IOException{
		String nome;
		File fich;
		do
		{
			System.out.print("Nome do ficheiro: ");
			do
			{
				nome = kb.nextLine();				
			} while (nome.length() == 0);
			fich = new File(nome);
		} while (!fich.isFile() && !fich.canRead());
		
		double entrys[] = new double[countFileVEntrys(fich)];
		int cont = 0;
		Scanner sc = new Scanner(fich);
		
		while (sc.hasNextDouble())
		{
			double next = sc.nextDouble();
			if (next >= 0 && next <= 14)
			{
				entrys[cont] = next;
				cont++;			
			}
		}
		
		return entrys;
	}
	
	public static int countFileVEntrys(File f) throws IOException{
		Scanner sc = new Scanner(f);
		int cont = 0;
		
		while (sc.hasNextDouble())
		{
			double next = sc.nextDouble();
			if (next >= 0.0 && next <= 14.0)
				cont++;
		}
		sc.close();
		return cont;		
	}
	
	public static int choice(double[] PH) throws IOException{
		int option = kb.nextInt();
		
		do
		{
			switch (option)
			{
				case 0:
					System.out.println();
					printMenu();
					break;
				case 1:
					PH = readFile();
					break;
				case 2:
					print(PH);
					break;
				case 3:
					System.out.println("A media de valores de PH e: " + mediaPH(PH));
					break;
				case 4:
					PHstats(PH);
					break;	
				case 5:
					System.out.println("Existem " + UPmedia(PH) + " valores superiores a media");
					break;
				case 6:
					BubbleSort(PH);
					break;
				case 7:
					System.out.println("O programa vai terminar...");
					break;
				default:
					System.out.print("ERRO! Opcao invalida. ");
					break;	
			}
		} while (option < 0 || option > 7); //repetir enquanto a escolha for inválida
		
		return option;
	}
	
	public static void printMenu(){
		System.out.printf("Analisador de pH\n" 
		+ "1 - Ler valores de pH de um ficheiro\n"
		+ "2 - Escrever valores de pH no terminal\n"
		+ "3 - Calcular o pH medio das amostras\n"
		+ "4 - Calcular o numero de amostras acidas e basicas\n"
		+ "5 - Calcular o numero de amostras de pH superior a media\n"
		+ "6 - Escrever valores de pH no terminal ordenados de modo crescente\n" 
		+ "7 - Terminar o programa\n");
	}
}

