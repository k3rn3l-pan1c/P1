/*
 * 
 * Inf sobre caracteres de frases
 * Maisculos
 * Minusculos
 * Numericos 
 * 
 */
 
 
import java.util.Scanner;
public class ex81_v1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main (String args[]) {
		String in;
		int up = 0, low = 0, num = 0;
		
		System.out.printf("Analise de uma frase\n\nFrase de entrada -> ");
		in = sc.nextLine();
		
		for (int i = 0; i < in.length(); i++)
		{
			if (Character.isUpperCase(in.charAt(i)))
				up++;
			else if (Character.isLowerCase(in.charAt(i)))
				low++;
			else if (Character.isDigit(in.charAt(i)))
				num++;
		}
		
		System.out.printf("Numero de caracteres minusculos -> %2d\n" , low);
		System.out.printf("Numero de caracteres maisculos -> %2d\n" , up);
		System.out.printf("Numero de caracteres numericos -> %2d\n" , num);
	}
}

