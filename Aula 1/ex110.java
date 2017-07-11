/*	Conversao Celsius -> Fahrenheit
 * 
 * 1) ler do teclado uma temperatura em Celsius, 
 * 2) calcula e escreve no monitor a respetiva conversao para Fahrenheit com o seguinte formato:
 * 		##.## Celsius e equivalente a ##.## Fahrenheit
 * 
 * A formula de conversao e F = 1.8∗C + 32. 
 */


import java.util.Scanner;
public class ex110
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		double C;
		
		//1
		System.out.print("Introduza a temperatura em graus Celsius: ");
		C = sc.nextDouble();
		
		//2
		System.out.printf("A temperatura corresponde a %5.2f graus Fahrenheit", (1.8*C+32));
		}
}



