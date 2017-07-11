/*
 * 
 * Conversao de base 10 -> base X
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex85 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		System.out.print("Numero: ");
		int num = kb.nextInt();
		System.out.print("Base de conversao: ");
		int base = kb.nextInt();
		
		System.out.printf("numToBase(%d,%d) = %s", num, base, numToBase(num, base));
		
	}
	
	public static String numToBase(int num, int base){

		String aux;
		aux = new String();  //inicializacao como string vazia
		
		aux += (num % base); //primeiro digito da divisao
		
		while (num >= base)
		{
			num /= base; //sucessivas divisoes do num a dividir pela base (quociente passa a dividendo)
			
			aux = aux + (num % base); //concatenar o resto de cada divisao a string
		}
		
		return invertS(aux); //inverter a string na base
	}
	
	public static String invertS(String s){
		String tmp = new String();
		for (int i = s.length() -1 ; i >= 0 ; i--) //inverter a string -> a ordem do digitos na base e contraria e medida que sao adicinados a string
		{
			tmp = tmp + s.charAt(i);
		}
		
		return tmp;
		
		
	}
}

