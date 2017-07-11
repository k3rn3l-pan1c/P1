/*
 * 
 * 
 * Eliminar comentarios do tipo //
 * 
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
import java.io.*;
public class ex105_v1 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		String name_in, name_out;
		
		System.out.print("Introduza o nome do ficheiro inical: ");
		do{
			name_in = kb.nextLine();
		} while(name_in.length() == 0);
		
		File fin = new File(name_in);
		
		System.out.print("Introduza o nome do ficheiro final: ");
		do{
			name_out = kb.nextLine();
		} while(name_out.length() == 0);
		
		File fout = new File(name_out);
		
		commentsOFF(fin, fout);
		
		System.out.print("Operacao terminada");

	}
	public static void commentsOFF(File fin, File fout) throws IOException{
		String line;
		Scanner sc = new Scanner(fin);
		PrintWriter pw = new PrintWriter(fout);
		while (sc.hasNextLine())
		{
			line = sc.nextLine();

			pw.println(filter(line));
		
		}
		pw.close();
		
	}
		
	public static String filter(String line){
		String temp = new String();
		for (int i = 0; i < line.length(); i++)
		{
			if (line.charAt(i) != '/') //se o caracter nao for / copiar
				temp += line.charAt(i);
			else if (line.charAt(i) == '/') //se o caracter for igual a /
					{
						if (i < line.length()-1 && line.charAt(i+1) == '/') //se o caracter nao for o ultimo e o proximo caracter for /, mudar de linha pq o resto esta comentado
							break;
						else 
						{
							temp += line.charAt(i);
						}
					}
			
		}
		return temp;
	}
}

