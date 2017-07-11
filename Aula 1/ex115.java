/*	Nota final a P1
 * 
 * Dados:
 * 	Considere os pesos seguintes: (TP1 15%, TP2 15%, API 30% e EP 40%).
 * 
 * 1) Ler notas
 * 2) Calcular nota final usando os pesos relativos
 * 3) Imprimir
 */


import java.util.Scanner;
public class ex115
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		double tp1, tp2, api, ep;
		//1
		System.out.print("Introduza as notas que obteve nos TP: ");
		tp1 = sc.nextDouble();
		tp2 = sc.nextDouble();
		System.out.print("Introduza a nota que obteve na API: ");
		api = sc.nextDouble();
		System.out.print("Introduza a nota que obteve na EP: ");
		ep = sc.nextDouble();
		
		//2, 3
		System.out.println("Nota final: " + (((tp1+tp2)/2)*0.3 + api*0.3 + ep*0.4));
	}
}


