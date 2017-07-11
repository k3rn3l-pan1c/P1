/* Calendario do mes
 * 
 * STILL WORKING ON IT
 * 
 * 
 */




import java.util.Scanner;
public class ex412_v1 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int ano, mes, dia, diames = 0, cont = 0;
		String aux="";
		boolean bissexto, aux2 = true;
		//leitura dos dados e validação
		do
		{
			System.out.print("Mes: ");
			mes = sc.nextInt();
		} while ((mes < 0) && (mes > 12));
		
		do
		{
			System.out.print("Ano: ");
			ano = sc.nextInt();
		} while (ano < 0);
		
		do
		{
			System.out.printf("Dia da semana a que começa o mes: (1 = Domingo, 2 = Segunda, 3 = Terca, 4 = Quarta, 5 = Quinta, 6 = Sexta, 7 = Sabado)\nDia: ");
			dia = sc.nextInt();
		} while ((dia < 1) && (dia > 7));
		
		
		switch (mes)  //obter texto do mes formatado
		{
			case 1:
				aux = ("    January ");
				break;
			case 2:
				aux = ("   February ");
				break;
			case 3:
				aux = ("       Mars ");
				break;
			case 4:
				aux = ("      April ");
				break;
			case 5:
				aux = ("        May ");
				break;
			case 6:
				aux = ("       June ");
				break;
			case 7:
				aux = ("       July ");
				break;
			case 8:
				aux = ("     August ");
				break;
			case 9:
				aux = ("  September ");
				break;
			case 10:
				aux = ("    October ");
				break;
			case 11:
				aux = ("   November ");
				break;
			case 12:
				aux = ("   December ");
				break;				
		} 


		if (((ano%4 == 0) && (ano %100 != 0)) || (ano%400 == 0))
			bissexto = true;
		else bissexto = false;
		switch (mes)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				diames =  31;
				
			case 2:
				{
					if (bissexto == true)
						diames = 29;
					else 
					diames = 28;
					break;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				diames = 30;
			}
			
			
		System.out.printf("----------------------\n|" + aux +"%4d    |\n---------------------- \n|Su Mo Tu We Th Fr Sa|\n----------------------\n|",  ano);
		int i= 1;
		for ( i = 1 ; i <= diames; i++)
			{
				if (i == 1)
					for (int j = 1; j < dia ; j++)
					{
						System.out.print("**");
						if (j != dia -1)
							System.out.print("_");
						aux2= true;
					}
				if (((i + dia - (dia % 2))% 7) == 0)
				System.out.printf("|\n|");
				
				
			
			if ((aux2 != true) || ((i % 7) != 0))
				System.out.print(".");
			System.out.printf("%2d", i);
			
			
			dia = 0;
		}
			
		}
		
	}


