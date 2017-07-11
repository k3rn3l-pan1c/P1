/*
 * 
 * 
 * Read Char
 * 
 * 
 */
 
 
 
import java.util.Scanner;
public class ex89 {
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		char c;
		
		
		//first way - prov not the best
		do
		{
			System.out.print("Caracter: ");
			String prompt = kb.nextLine();
			c = readChar1(prompt);
		} while (c == ' ');
		
		System.out.printf("readChar with prompt1: %c\n\n", c);
		
		//second way - not good
		System.out.print("Caracter: ");
		c = readChar2(kb.nextLine());
		System.out.printf("readChar with prompt2: %c\n\n", c);
		
		//makes more sense - more eficient to read from kb
		c = readChar3();
		System.out.printf("readChar without prompt: %c\n\n", c);
		
		//provavelmente o que o stor quer...
		//dar uma string de um caracter a funcao... devolver o char
		//dont need to validate, a string tem a cabeça so 1 caracter
		String prompt = "s"; 
		c = readChar4(prompt);
		System.out.printf("readChar convert only: %c\n\n", c);
	}
	
	
	
	public static char readChar1(String prompt){
		char c = ' ';
		
		if (prompt.length() == 1)
			 c = prompt.charAt(0);
		
		return c;
	}
	
	
	public static char readChar2(String prompt){
		if (prompt.length() != 1)
			do
			{
				System.out.print("Caracter: ");
				prompt = kb.nextLine();
			} while (prompt.length() != 1);
		
		char c = prompt.charAt(0);
		
		return c;
	}
		
		
	public static char readChar3(){
		String prompt = new String();
		
		do
		{
			System.out.print("Caracter: ");
			prompt = kb.nextLine();
		} while (prompt.length() != 1);
		
		char c = prompt.charAt(0);

		return c;
		}
		
	public static char readChar4(String prompt){
		char c = prompt.charAt(0); //conversao pura string -> char
		
		return c;
	}
}

