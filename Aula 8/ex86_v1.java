/*
 * 
 * Eliminar R das strings
 * Trocar L por U
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex86_v1 {
	
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
			switch (str.charAt(i))
			{
				case 'l':  //trocar
					tmp += "u";
					break;
				case 'r': //do nothing
					break;
				default: //concatenar tudo o resto
					tmp += str.charAt(i);
					break;
			}
		}
		return  tmp;
		}
}

