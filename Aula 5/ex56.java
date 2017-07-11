/* Tabuada
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex56 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num;
		num = Functions.GetIntORange(0, 100);// chama a funcao que devolve um valor dentro do intervalo ]0,100[
		Functions.tabuada(num); // chama a funcao que imprime no terminal a tabuada de um num
	}
}

