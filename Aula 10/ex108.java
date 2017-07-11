/*
 * 
 * 8.6 + leitura de ficheiro
 * 
 * Trocar L por U
 * Eliminar os R
 * de um ficheiro de texto
 * 
 */
 
 
 
import java.util.Scanner;
import java.io.*;
public class ex108 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		String name;
		File text;
		do
		{
			System.out.print("Nome do ficheiro de texto: ");
			do
			{
				 name = kb.nextLine();
			} while (name.length() == 0);
			 text = new File(name);
		} while (!text.isFile() || !text.canRead());
		
		Scanner sc = new Scanner(text);
		while (sc.hasNextLine())
		{
			System.out.println(dialeto(sc.nextLine()));
		}
		
	}
	
	
	public static String dialeto(String str){
		String tmp = new String();
		for (int i = 0; i < str.length(); i++)
		{
			switch (str.charAt(i))
			{
				case 'l':
					tmp += "u";
					break;
				case 'L':
					tmp += "U";
					break;
				case 'r':
					break;
				default:
					tmp += str.charAt(i);
					break;
			}
		}
		return  tmp;
		}
}

