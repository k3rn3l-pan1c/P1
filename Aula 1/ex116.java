/* Despesa media de um turista
 * 
 * Dados:
 * despesa media diaria que um turista despendeu numa viagem de quatro dias a Portugal, sabendo que cada dia gastou mais 20% do que no dia anterior.
 *
 * 1) Ler despesa no 1 dia
 * 2) Calcular despesa dos dias seguintes
 * 3) Calcular despesa total
 * 4) Imprimir
 */


import java.util.Scanner;
public class ex116
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		double despesa1, despesa2, despesa3, despesa4,total;
		//1
		System.out.print("Introduza a despesa que obteve no 1 dia: ");
		despesa1 = sc.nextDouble(); 
		
		//2      
		despesa2 = despesa1 + despesa1*0.2;     //do 
		despesa3 = despesa2 + despesa2*0.2;     //despesa += despesa*0.2; cont++;
		despesa4 = despesa3 + despesa3*0.2;     //while (cont != 3)
		
		//3
		total = despesa1 + despesa2 + despesa3 + despesa4;
		
		//4
		System.out.print("Despesa total: " + total);
		
	}
}



