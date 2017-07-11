/*
 * 
 * Capitalizar inicio de frases (dps de .)
 * Decapitalizar todo o resto
 * 
 * 
 * 
 * 
 */






import java.util.Scanner;
import java.io.*;
public class ex107 {
	
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
			System.out.println(Capitalizar(sc.nextLine()));
		}
		
	
		
		
		
		
		
		
		
		
	}
	public static String Capitalizar(String str){
		
		String temp = new String();
		boolean start = false; //se a frase começar logo por maiscula deve descapitalizar
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == '.')
				start = true; //ponto final, fica a espera de uma letra
			if (Character.isLetter(str.charAt(i)) && start == true)
				{
					temp += Character.toUpperCase(str.charAt(i));
					start = false; //nao capitaliza as proximas letras ate aparecer um novo ponto final
				}
			else if (Character.isLetter(str.charAt(i)) && start == false) //se é uma letra mas nao esta antecedida de ponto final
					temp += Character.toLowerCase(str.charAt(i));
			else temp += str.charAt(i); //adiciona numeros, simbolos, etc...
		}
		
		return temp;
		
		}
}

