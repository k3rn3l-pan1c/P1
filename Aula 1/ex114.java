/*	Teorema de Pitágoras
 * 
 * Dado um triangulo retangulo de catetos A e B e hipotenusa C, 
 * escreva um programa que leia o valor dos catetos e determine a hipotenusa e o angulo (em graus) entre o lado A e a hipotenusa.
 * 
 * 1) Ler valor dos catetos
 * 2) Calcular a hipotenusa
 * 3) Calcular o angulo
 * 4) Apresentar resultados
 */


import java.util.Scanner;
public class ex114
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		double a,b,c,ang;
		
		//1
		System.out.print("Introduza o valor dos catetos: ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		
		//2 - formula alternativa -> c = Math.hypot(a,b)
		c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
		
		//3
		ang = Math.toDegrees(Math.acos(a/c));
		
		//4
		System.out.println("Hipotenusa: " + c);
		System.out.println("Angulo: " + ang);
	}
}


