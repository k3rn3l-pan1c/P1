/*
 * 9.4 + leitura de um file
 * 
 * Histograma com leitura de file
 * 
 * 
 */
 
import java.util.Scanner;
import java.io.*;
public class ex104 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		String name;
		
		int hist[] = new int[21]; //de 0 a 20 inclusive
		
		System.out.print("Introduza o nome do ficheiro: ");
		do{
			name = sc.nextLine();
		} while(name.length() == 0);
		
		System.out.println();
		
		File f = new File(name);
		int n = FileEntrysCount(f); //contar entradas
		
		int v[] = new int[n];
		LerNotasF(v, hist, f);
		Histograma(hist);
		
	}
	
	//contar entradas
	public static int FileEntrysCount(File f) throws IOException{
		Scanner readFile = new Scanner(f);
		int n = 0;
		while (readFile.hasNextInt())
		{
			int nota = readFile.nextInt(); //ler
			if (nota >= 0 && nota <= 20)
				n++;
		}
		readFile.close();
		return n;
		
		
		}
	
	//Construir o histograma
	public static void Histograma(int[] hist){
		System.out.printf("Histograma de notas\n------------------------------------------------------\n");
		for (int i = 0; i < hist.length ; i++)
		{
			System.out.printf("%2d | ", i );
			for (int j = 0; j < hist[i]; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void LerNotasF(int[] v, int[] hist, File f) throws IOException{
		Scanner readFile = new Scanner(f);
		for (int i = 0; i < v.length; i++)
		{
			int nota = readFile.nextInt(); //ler
			if (nota >= 0 && nota <= 20) //se for valida atribuir
			{
				v[i] = nota; 
				hist[v[i]]++; //magic piece of code! 
			 }				
		}
		readFile.close();		
	}
	
	/*magic piece of code faz o seguinte:
	 * 
	 * os indices do vetor histograma vao de 0 a 20.. A possibilidade de notas inseridas tbm e de 0 a 20
	 * Como o hist[] guarda qnt vezes uma certa nota foi introduzida, 
	 * O indice 0 do vetor hist guarda qnt vezes apareceu um zero
	 * Assim se na leitura apareceu um zero, posso incrementar o indice 0 do vetor hist 
	 */
	 
}
