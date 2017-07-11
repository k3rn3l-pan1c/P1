/* Calcular a Area e Perimetro de um retangulo
 * 
 * 1) dadas as dimensoes de um retangulo, lidas do teclado, 
 * 2)calcula e escreve no monitor o perımetro e a area.
 */


import java.util.Scanner;
public class ex19
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 
		double l1,l2;
			
		//1
		System.out.print("Introduza o comprimento e a largura do retangulo: ");
		l1 = sc.nextDouble();
		l2 = sc.nextDouble();
		
		//2
		System.out.println("O perimetro do retangulo e " + (2*(l1+l2)) + " e a area e " + (l1*l2));
		}
}


