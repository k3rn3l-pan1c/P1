/*
 * 
 * 
 * Eliminar comentarios do tipo // e /**/
 /* 
 * 
 * 
 * 
 */
 
 
 
import java.util.Scanner;
import java.io.*;
public class ex105_v2 {
	
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
		String line, temp;
		boolean control = false; //comentario multilinha
		Scanner sc = new Scanner(fin);
		PrintWriter pw = new PrintWriter(fout);
		while (sc.hasNextLine())
		{
			line = sc.nextLine();

			temp = new String();
			for (int i = 0; i < line.length(); i++)
			{
				if (control == false) //se nao estamos dentro de um comentario multilinha
				{
					if (line.charAt(i) != '/') //se o caracter nao for / copiar
						temp += line.charAt(i);
					else if (line.charAt(i) == '/') //se o caracter for igual a /
							{
								if (i < line.length()-1 && line.charAt(i+1) == '/') //se passou a haver um comentario de uma linha inteira
									break;
								else if (i < line.length()-1 && line.charAt(i+1) == '*') //se passou a haver comentario multilinha
									{
										control = true; //comentario multilinha ON
										break; 
									}
									else 
									{
										temp += line.charAt(i); //nao a comentario -> copiar caracter
									}
							}
				}
				else //se estamos num comentario multilinha
					if (i > 0 && line.charAt(i-1) == '*' && line.charAt(i) == '/') //se o comentario multilinha vai acabar
						control = false;
						
			 }
			 pw.println(temp);   
			}
			
			pw.close();
		}
		
		
	}

