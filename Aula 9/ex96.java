/*
 * Letras do alfabeto que aparecem na frase
 * 
 * dont like teacher way... much easier this way
 * teacher way -> array de booleanos.. cada indice corresponde a uma letra
 * 
 */


import java.util.Scanner;
public class ex96 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		String text = lerF();
		String out = new String();
		
		System.out.printf("As letras do alfabeto que existem na frase sao: %s", match(text, out));
		
		
	}

		
	public static String match(String input, String output){
		boolean control = false; //false -> nao existe por default
		for (int i = 0; i < input.length(); i++)
		{
				control = false; //reset
				for (int j = 0; j < output.length(); j++)
				{
					if (input.charAt(i) == output.charAt(j))
					{
						control = true;
						break; //nao e preciso procurar mais, n interessa se existe 1, 2 ou 100 vezes, so interessa se existe
					}
				}
				if (control == false)
					output += input.charAt(i); //se chegar ao fim do ciclo e o caracter nao existir, concatena-o
		}
		
		return output;
		
	}
	
	public static String lerF(){
		String text;
		
		System.out.print("Frase: ");
		do
		{
			text = kb.nextLine();
		} while (text.length() == 0);
		
		return text;
	}
}

