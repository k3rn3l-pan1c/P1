/*
 * 
 * Acrónimos
 * 
 */
 
 
import java.util.Scanner;
public class ex82 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		String frase;
		System.out.print("Introduza uma frase: ");
		frase = sc.nextLine();
		
		System.out.printf("Acronimo(%s) -> %s", frase, acronimo(frase));
		
	}
	
	public static String acronimo(String frase){
		String aux = "";
		
		for (int i = 0; i < frase.length(); i++)
		{
			if (Character.isUpperCase(frase.charAt(i))) //se o caracter for maiscula adiciona a string do acronimo
				aux += frase.charAt(i);
		}
		return aux;
		}
}

