/*  Figura geometrica
 * 
 * Dados:
 * Considere que os pontos sao introduzidos por ordem, seguindo o sentido horario (P1, P2, P3 e P4).
 * 
 * 1) Ler pontos
 * 2) Verificar se os o x do P1 == x do P4, x do P3 == P2, y do P1 == y do P4, y do P3 == y do P2 -> garante que a figura e um quadrado
 * 3) Imprimir
 */
 
 
import java.util.Scanner;
public class ex25 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		double x1,x2,x3,x4,y1,y2,y3,y4;
		
		//1
		System.out.print("Introduza as coordenadas do 1 ponto (x,y): ");
		x1 = sc.nextDouble();
		y1 = sc.nextDouble();
		System.out.print("Introduza as coordenadas do 2 ponto (x,y): ");
		x2 = sc.nextDouble();
		y2 = sc.nextDouble();
		System.out.print("Introduza as coordenadas do 3 ponto (x,y): ");
		x3 = sc.nextDouble();
		y3 = sc.nextDouble();
		System.out.print("Introduza as coordenadas do 4 ponto (x,y): ");
		x4 = sc.nextDouble();
		y4 = sc.nextDouble();
		
		//2
		if ((x1==x4) && (x2==x3) && (y1==y2) && (y4==y3))
			/*3*/ System.out.print("Os pontos inroduzidos formam um quadrado");
		else
			/*3*/ System.out.print("Os pontos introduzidos nao formam um quadrado");
	}
}

