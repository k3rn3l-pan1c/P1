/* Total Liquido de uma fatura
 * 
 * Dados:
 *  o valor dos produtos, o desconto oferecido e a taxa de IVA fornecidos pelo utilizador.
 * 
 * 1) Ler vars de entrada
 * 2) Calcular o total liquido
 * 3) apresentar
 */


import java.util.Scanner;
public class ex117
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		double prod,desc,iva;
		
		//1
		System.out.print("Introduza o valor do(s) produto(s): ");
		prod = sc.nextDouble();
		System.out.print("Introduza a % do IVA aplicado: ");
		iva = sc.nextDouble();
		System.out.print("Introduza a % dos descontos aplicados: ");
		desc = sc.nextDouble();
		
		//2, 3
		System.out.printf("O total liquido da fatura e: %5.2f" , (prod-(prod*iva/100)-(prod*desc/100)));
		
		
	}
}


