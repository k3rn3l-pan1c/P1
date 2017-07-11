/* Classificação a P1 e aprovação
 * 
 * Dados:
 * (TP1 10%, TP2 10%, API 30% e EP 50%). 
 * O programa devera´ no ﬁnal apresentar uma mensagem indicando se o aluno se encontra aprovado ou reprovado
 * 
 * 1) ler notas
 * 2) calcular nota final usando so pesos
 * 3) Decidir se o aluno passou ou não e apresentar ao user
 */


import java.util.Scanner;
public class ex21
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		double tp1, tp2, api, ep, nota;
		
		//1
		System.out.print("Introduza as notas que obteve nos TP: ");
		tp1 = sc.nextDouble();
		tp2 = sc.nextDouble();
		System.out.print("Introduza a nota que obteve na API: ");
		api = sc.nextDouble();
		System.out.print("Introduza a nota que obteve na EP: ");
		ep = sc.nextDouble();
		
		//2
		nota = (((tp1+tp2)/2)*0.3 + api*0.3 + ep*0.4);

		//3
		if (nota >= 9.5)	
			System.out.printf("Aprovado com %4.1f valores",  nota);
		else
			System.out.printf("Reprovado com %4.1f valores", nota);
	}
}


