/*
 * 
 * Capitalizar inicio de palavras
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex87 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		System.out.print("Introduza uma string: ");
		String str = kb.nextLine();
		
		String temp = new String();
		boolean start = true; //se a frase começar logo por letra deve capitalizar
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == ' ')
				start = true; //nova palavra, fica a espera de uma letra
			if (Character.isLetter(str.charAt(i)) && start == true)
				{
					temp += Character.toUpperCase(str.charAt(i));
					start = false; //nao capitaliza as proximas letras
				}
			else temp += str.charAt(i); //adiciona as letras nao capitalizadas
		}
		
		System.out.print(temp);
	}
}

