/* 	Distancia entre dois pontos
 * 
 * Dados:
 *  - coordenadas cartesianas em centımetros, A:(x1, y1) e B:(x2, y2), das 2 localidades
 *  - escala 1:100 (cm:Km)
 * 
 * 1) Ler as coordenadas das 2 localidades 
 * 2) Ler a escala do mapa
 * 3) Calcular a distancia, em linha reta, existente entre elas. 
 * 4) Escrever a distancia, em linha reta, existente entre elas.
 */


import java.util.Scanner;
public class ex113
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		int x1, x2 ,y1, y2;
		double escala, dis;
		//1
		System.out.print("Introduza o valor as coordenadas do 1 ponto (x1,y1): ");
		x1= sc.nextInt();
		y1= sc.nextInt();
		System.out.print("Introduza o valor as coordenadas do 2 ponto (x2,y2): ");
		x2= sc.nextInt();
		y2= sc.nextInt();
		
		//2
		System.out.print("Introduza a escala: ");
		escala = sc.nextDouble();
		
		//3 - formula da distancia entre dois pontos de um plano
		dis = (Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2))*escala);
		
		//4
		System.out.println("A distancia me linha reta entre os dois pontos e :" + dis + " km");
		}
}

