/*	Conversao segundos em hh:mm:ss
 * 
 * 1) Ler tempo em segundos
 * 2) Converter
 * 3) escrever  o tempo com o formato hh:mm:ss. 
 */ 


import java.util.Scanner;
public class ex112
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		int seg,min,hr;
		//1
		System.out.print("Segundos: ");
		seg= sc.nextInt();
		
		//2
		hr= (seg / 3600); //cada 3600 seg = 1h
		
		seg -= hr*3600; //remover os segundos que foram convertidos em horas
		//seg = seg - hr*3600
		
		min = seg / 60; //cada 60 seg = min
		
		seg -= (min*60); //remover os segundos que foram convertidos em minutos
		
		//3
		System.out.printf("Tempo: %2d : %2d : %2d", hr, min, seg);  
	
		}
}




