/* Equação Resolvente
 * 
 * 1) Ler coeficientes
 * 2) Verificar se a equação e possivel e determinada em R
 * 3) se nao = imprimir
 * 4) se sim, calcular zeros e imprimir

 */


import java.util.Scanner;
public class ex211 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double a,b,c;
		
		//1
		System.out.print("Introduza os coeficinetes a, b e c: ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		//2
		if ((Math.pow(b,2) - 4*a*c)<0)
			/*3*/ System.out.print("As raizes da equação nao sao reais");
			
		//4
		else
			{
				System.out.printf("Raiz 1: %6.3f\n", ((-b+Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a)));
					System.out.printf("Raiz 1: %6.3f\n", ((-b-Math.sqrt(Math.pow(b,2) - 4*a*c))/(2*a)));
			}
		}
}

