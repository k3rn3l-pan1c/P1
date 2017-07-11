/* Dia posterior e anterior
 * 
 * 1) ler dia, mes, ano
 * 2) Dia maximo do mes introduzido? 
 * 3) Ano bissexto??
 * Dia lido =
 * 3) ultimo dia do ano??  dia seguinte = dia 1, mes 1, ano++
 * 4) 1 dia do ano?? dia anterior = dia 31, mes 12, ano--
 * 5) ultimo dia do mes?? dia seguinte = dia 1, mes++
 * 6) 1 dia do mes?? dia anterior = dia maximo do mes anterior, mes--
 * 7) nenhuma das anteriores?? dia seguinte = dia++, mes, ano; dia anterior = dia--, mes, ano
 */
 
import java.util.Scanner;
public class ex210
{
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		int ano, mes,dia, mesmax=0, mesout, diaout, anoout;
		
		//1
		System.out.print("Introduza o dia - mes - ano: ");
		dia = sc.nextInt();
		mes = sc.nextInt();
		ano = sc.nextInt();
		
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
				mesmax = 31;
				break;
			case 2:
					if (((ano%4 == 0) && (ano %100 != 0)) || (ano%400 == 0)) //3
						mesmax = 29;
					else 
						mesmax = 28;
					break;
			case 4:
			case 6:
			case 9:
			case 11:
				mesmax = 30;
				break;
						
		}
		
		
		if ((mes==12) && (dia+1)>31) //3
				{
					System.out.printf("O dia seguinte e 1 - 1 - %d\n", (ano+1));
					System.out.printf("O dia anterior e %d - %d - %d\n", (dia-1), mes, ano);
				}
				
		else if ((mes ==1) && (dia-1)<1) //4
				{
					System.out.printf("O dia seguinte e %d - %d - %d\n", (dia+1), mes, ano);
					System.out.printf("O dia anterior e 31 - 12 - %d\n", (ano-1));
				}
				
		else if ((dia +1)>mesmax) //5
			{
				System.out.printf("O dia seguinte e 1 - %d - %d \n" , (mes+1) , ano);
				System.out.printf("O dia anterior e %d %d %d \n", (dia -1), mes, ano);
			}
		else if ((dia -1)<1) //6
			{
				switch (mes-1)
				{
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						mesmax = 31;
						break;
					case 2:
						if (((ano%4 == 0) && (ano %100 != 0)) || (ano%400 == 0)) //3
							mesmax = 29;
						else 
							mesmax = 28;
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						mesmax = 30;
						break;
				}
				System.out.printf("O dia seguinte e %d - %d - %d\n", (dia+1), mes, ano);
				System.out.printf("O dia anterior e %d - %d - %d\n", mesmax, (mes-1), ano);
			}
			
			else //7
			{
				System.out.printf("O dia seguinte e %d - %d - %d\n", (dia+1), mes, ano);
				System.out.printf("O dia anterior e %d - %d - %d\n", (dia-1), mes, ano);
			}	
}
}
