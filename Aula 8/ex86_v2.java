/*
 * Eliminar R das strings
 * Trocar L por U
 * 
 * Outra possibilidade: passar caracter a caracter para uma string
 * Manipular os caracteres na string individualmente
 * 
 * 
 **/





import java.util.Scanner;
public class ex86_v2 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		System.out.print("Introduza uma frase: ");
		String str = kb.nextLine();
		System.out.printf("Na terra do Alberto Alexandre, a frase seria:\n%s", dialeto(str));
	}
	
	public static String dialeto(String str){
		String tmp = new String();
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == 'l') // as ' sao para char
				tmp += "u"; // a " torna numa string
			else if (str.charAt(i) == 'r') {}//instrucao vazia
			
			else tmp += str.charAt(i);
		}
		return  tmp;
		}
}
