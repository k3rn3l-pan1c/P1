/*
 * Amplitude Termica
 * 
 */
 
 
import java.util.Scanner;
public class ex76 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		Temp day = new Temp(); //nova variavel do registo Temp
		Ampmax max = new Ampmax(); //nova variavel do tipo de dados Ampmax
		
		//for que percorre o intervalo dos 5 dias
		for (int i = 1; i <= 5 ; i++)
		{
			System.out.println("Temperaturas referentes ao dia: " + i);
			day = GetTemp(); //preencher o registo, chamando a funcao GetTemp
			System.out.println(); //quebra de linha
			
			if (i == 1) //inicializacao dos valores
				{
				max.amp = day.amp;
				max.dia = 1;
				}
			else if (day.amp > max.amp) //atualizacao dos valores, caso se justifique
				{
				max.amp = day.amp;
				max.dia = i;
			}
		}
		
		System.out.printf("A amplitude maxima registada foi %d e ocorreu ao %d dia", max.amp, max.dia);
	}
	
	public static Temp GetTemp(){
		// funcao qe obtem a temperatura maxima, minima, calcula a amplitude termica e devolve um registo Temp preenchido
		Temp day = new Temp();
		do
		{
			do
			{
				System.out.print("Temperatura minima: ");
				day.tMin = sc.nextInt();
			} while (day.tMin < -20 || day.tMin > 50); //temp tem pertencer a [-20,50]
			
			do
			{
				System.out.print("Temperatura maxima: ");
				day.tMax = sc.nextInt();
			} while (day.tMax < -20 || day.tMax > 50); //temp tem pertencer a [-20,50]
			
		} while (day.tMin > day.tMax); // temp min < temp max
		
		day.amp = day.tMax - day.tMin;
		return day;
		}
	
}
class Temp //registo qe guarda a temperatura maxima, minima e a amplitude correspondente a um dia
{
	int tMax, tMin, amp;
}

class Ampmax //registo qe guarda o valor da amplitude maxima e o dia em que ocorreu
{
	int amp, dia;
	}
