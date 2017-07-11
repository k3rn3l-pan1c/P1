/*
 * 
 * Imprimir conteudo de ficheiro
 * 
 * 
 */
 
 
 
import java.util.Scanner;
import java.io.*;
public class ex101{
	
	public static void main (String args[]) throws IOException {
		String nome;
		File ficheiro;
		Scanner sc = new Scanner(System.in);
		
		do{
		System.out.print("Nome do ficheiro: ");
		nome = sc.nextLine();
		
		ficheiro = new File(nome);
		
		if (ficheiro.isFile() && ficheiro.canRead()) //se o ficheiro for valido e puder ser lido
			{
				Scanner readFile = new Scanner(ficheiro); //scanner que le do ficheiro
				while (readFile.hasNext())
				{
					System.out.println(readFile.nextLine());
				}
			}
		else 
			{
				
				System.out.printf("O ficheiro nao e valido\n\n");
			}
		} while (!ficheiro.isFile() && !ficheiro.canRead()); 
		
		
		
	}
}

