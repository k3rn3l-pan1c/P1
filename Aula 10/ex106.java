/*
 * 
 * Copiar ficheiro de texto atraves do terminal
 * 
 * ficheiro de origem arg[0]
 * ficheiro copiado arg[1]
 * 
 * NOT WORKING -> bug... leitura do ficheiro nao termina
 * ou ciclo infinito ou crash
 */
 
 
import java.util.Scanner;
import java.io.*;
public class ex106 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		File INfile = new File(args[0]);
		File OUTfile = new File(args[1]);
		
		if (INfile.isFile())
			if (INfile.canRead())
				if (OUTfile.isFile())
					System.out.println("O ficheiro a ser criado ja existe");
				else
				{
					Scanner sc = new Scanner(INfile);
					PrintWriter pw = new PrintWriter(OUTfile);

					while (sc.hasNextLine()); //enquanto existirem mais linhas
					{
						String line = sc.nextLine();
						pw.println(line);
					}
					
					sc.close();
					pw.close();
					System.out.println("Terminou a copia do ficheiro");
				}
			else
				System.out.println("Nao possui permissoes para ler o ficheiro de origem");
		else
			System.out.println("O ficheiro para leitura não é válido");
	}
}


