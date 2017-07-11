/*	Numero de dias do mes
 * 
 * Dados:
 * Um ano e bissexto de 4 em 4 anos, com excecao dos ﬁns de seculo, que so sao bissextos de 4 em 4 seculos.
 * 
 * 1) Ler ano, mes
 * 2) obter numero de dias para o mes do ano
 * 3) verificar se o nao e bissexto
 * 4) Escrever
 */


import java.util.Scanner;
public class ex24
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		int ano, mes,dia;
		//1
		System.out.print("Introduza o ano: ");
		ano = sc.nextInt();
		System.out.print("Introduza o mes: ");
		mes = sc.nextInt();
		
		//2
		switch (mes)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				//4
				System.out.print("O mes " + mes + " do ano " + ano + " tem 31 dias");
				break;
			case 2:
					//3, 4
					if (((ano%4 == 0) && (ano %100 != 0)) || (ano%400 == 0))
						System.out.print("O mes 2 do ano " + ano + " tem 29 dias");
					else 
					System.out.print("O mes 2 do ano " + ano + " tem 28 dias");
					break;
			case 4:
			case 6:
			case 9:
			case 11:
				//4
				System.out.print("O mes " + mes + " do ano " + ano + " tem 30 dias");
				break;
			default:
				//4
				System.out.println("Introduziu um valor inválido");
				break;
				
		}
		
		
	}
}
