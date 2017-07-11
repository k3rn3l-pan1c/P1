/* dia do mes do ano
 * 
 * 
 * 
 * 
 */




import java.util.Scanner;
public class ex53 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int mes, ano;
		
		//obter um ano valido(positivo)
		do
		{
			System.out.print("Introduza o ano: ");
			 ano = sc.nextInt();
		} while (ano < 0);
		
		//obter um mes valido (entre o 0 e 12)
		do
		{
			System.out.print("Introduza o mes: ");
		 mes = sc.nextInt();
		} while ((mes<1) || (mes >12));
		
		//print os dados, diretamente do retorno das funcoes
		System.out.printf("O mes %d do ano %d tem %d dias", mes, ano, (diames(mes, ano)));
	}
	
	//funcao booleana que indica se um ano e bissexto ou nao
	public static boolean bissexto(int ano) {
		if (((ano%4 == 0) && (ano %100 != 0)) || (ano%400 == 0))
			return true;
		else return false;
	}
	
	//funcao que retorna o dia do mes passando o mes e o ano em argumento
	public static int diames (int mes, int ano){
		int aux=0;
		switch (mes)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
				
			case 2:
					if (bissexto(ano) == true)
						return 29;
					else 
					return 28;
					
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			default :
				return 0;
			}
	}		
}

