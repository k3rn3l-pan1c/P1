/*
 * 
 * 
 * Validar matriculas portuguesas
 * 
 * 
 * 
 */



import java.util.Scanner;
public class ex84 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		String str, pattern;
		
		System.out.print("Introduza o padrao da placa: (AA-00-00, 00-00-AA, 00-AA-00): ");
		pattern = sc.nextLine();
		System.out.print("Introduza a sua placa: ");
		str = sc.nextLine();
		if (matchpattern(str, pattern))
			System.out.print("A placa introduzida e valida");
		else
			System.out.print("A placa introduzida nao e valida");
			
			
	}
	public static boolean matchpattern(String str, String pattern){
		
		//verificar se o modelo de matricula e um modelo valido pt
		//senao a matricula seria sempre valida, desde que o padrao dado respeita-se a forma de escrita de um padrao (A 0 -)
		if (!pattval(pattern)) 
			return false;
		
		//procurar o contra-exemplo
		for (int i = 0; i < 8 ; i++)
		{
			switch (pattern.charAt(i)) //filtrar por caracter do padrao
		{
			case 'A': //se o o caracter no padrao for A, na matricula tem de ser maiscula
				if (!Character.isUpperCase(str.charAt(i)))
				return false;
				break;
			case '-': //os - tem de coincidir no padrao e na matricula
				if (str.charAt(i) != '-')
				return false;
				break;
			case '0': //se o o caracter no padrao for 0, na matricula tem de ser digito
				if (!Character.isDigit(str.charAt(i)))
				return false;
				break;
		}
		}
		
		return true; //se nao existir contra-exemplo, a matricula e valida
	}
	
	public static boolean pattval(String pattern){
		switch (pattern)
		{
			case "AA-00-00":
			case "00-00-AA":
			case "00-AA-00":
				return true;
			default:
				return false;
		}
		}
}

