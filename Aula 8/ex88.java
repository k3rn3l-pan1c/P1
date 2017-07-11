/*
 * 
 * Conversao de base 10 -> base X
 * 
 * 
 * 
 */
 
 
 
import java.util.Scanner;
public class ex88 {
	
	public static void main (String args[]) {
	Scanner kb = new Scanner(System.in);
	
	System.out.print("Numero: ");
	String num = kb.nextLine();	
	System.out.print("Base: ");
	int base = kb.nextInt();
	
	if (checkBase(num, base))
		System.out.printf("baseToNum(%s,%d): %d", num, base, baseToNum(num, base));
	else
		System.out.print("O numero nao pertence a base dada");
	}
	
	//verificar se o numero esta expresso corretamente na base dada
	public static boolean checkBase(String num, int base){
		for (int i = 0; i < num.length(); i++)
		{
			if ( (num.charAt(i)-'0') >= base) //’<char>’-’0’ -> converte um char para int
				return false; //se um elemento for maior que a base ou igual, o num n pertence a base
		}
		return true;
	}
	
	public static int baseToNum(String num, int base){
		int out = 0;
		
		for (int i = 0; i < num.length() ; i++) //sistema de pesos -> See ISD stuff
		{
			out += (num.charAt(i)-'0') * Math.pow(base, num.length() -1 - i); //os pesos sao de ordem inversa -> o 1 bit (right -> left) e o com potencia mais alta
		}
		
		return out;
	}
}

