/*
 * 
 * 
 * Contar palavras
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex83 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		String frase;
		System.out.print("Frase -> ");
		frase = sc.nextLine();
		
		System.out.printf("Foram introduzidas %d palavras", countWords(frase));
		
	}
	
	public static int countWords(String frase){
		int cont = 0;
		boolean white = true; //flag e true se o ultimo char != caracter branco
		
		for (int i = 0; i < frase.length(); i++)
		{
			
			if (!whitechar(frase.charAt(i)) && white) //se o caracter nao for branco e ja tiver registado um caracter branco, entao e uma nova palavra
				cont++;
			
			if (whitechar(frase.charAt(i))) // se o caracter e branco -> alerto a uma palavra
				white = true;
			else white = false; //e o caracter nao for branco, white tem de ser = false, senao conta caracteres ! brancos e nao palavras
			
		}
		return cont;
		
		
		}
		
	public static boolean whitechar(char c){ //verificar caracteres brancos
		switch (c)
		{
			case ' ':
			case '\n':
			case '\t':
				return true;
			default:
				return false;
		}
		
		}
}

