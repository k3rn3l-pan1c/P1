/* Celsius - Fahrenheit and vice-versa
 * 
 * Dados:
 *  valor de temperatura (real) e um numero (0 - Celsius, 1 - Fahrenheit),  
 * calcula e escreve no terminal a respetiva conversao com o formato seguinte. 
 * 		##.## oCelsius ´e equivalente a ##.## oFahrenheit
 * A formula de conversao e F = 1.8∗C + 32. 
 * 
 * 1) ler temperatura
 * 2) ler escala
 * 3) selecionar a op a realizar
 * 4) print

 */
 

import java.util.Scanner;
public class ex29 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double temp;
		int a;
	
		//1
		System.out.print("Temperatura: ");
		temp = sc.nextDouble();
		
		//2
		System.out.print("Escolha a unidadde da temperatura (0-Celsius/ 1-Fahrenheit): ");
		a = sc.nextInt();
		
		//3, 4
		switch (a)
		{
			case 0:
				System.out.printf("A temperatura em Fahrenheit e %5.2f" , (1.8*temp+32));
				break;
			case 1:
				System.out.printf("A temperatura em Celsius e %5.2f" , ((temp-32)/1.8));
				break;
			default:
				System.out.print("Introduziu uma unidade incorreta");
				break;
				
		}
		
	}
}

