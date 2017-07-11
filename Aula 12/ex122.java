/*
 * 7.2 com o uso de arrays
 * 
 * Guardar ate 10 pontos e ordenar por distancias
 * 
 * 
 */


import java.util.Scanner;
public class ex122{
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		Ponto2D points[] = new Ponto2D[10];
		Ponto2D max = new Ponto2D();  //Ponto maximo
		Ponto2D zero = new Ponto2D();  //ponto zero(origem)
		//Ponto2D max = new Ponto2D();  //registo que guarda o valor do ponto mais distante a origem
		int cont = 0; //
		double soma, maxdis; //
		
		
		lerPonto(cont, points); //atribui ao valor do ponto generico um registo preenchido devolvido atraves da funcao lerPonto
		soma = dis(points[0], zero); //atribui a soma o valor da distancia do ponto generico a origem
		maxdis = soma; // a distancia maxima inicial e soma, ou seja, a distancia de zero a origem
		max = points[0]; // o ponto mais distante inicial e o ponto inicial
		
		//enquanto a coordenada x do ponto for != 0  e a coordenada y do ponto !=0
		while ((points[cont].x != zero.x || points[cont].y != zero.y) && cont != 9){
			cont++; //contar mais um ponto
			lerPonto(cont, points); //ler um novo ponto
			
			soma += dis(zero, points[cont]); //somar a distancia desse ponto a origem (chamando a funcao dis para obter a distancia)
			if (maxdis < dis(zero, points[cont])) //se a distancia do ponto atual for maior do que a distancia do novo ponto do vetor
				{
					maxdis = dis(zero,points[cont]); //atribuir essa nova distancia
					max = points[cont]; //atribuir o novo ponto maximo
				}
				
		} 
		System.out.printf("\nA soma das distancias dos %d pontos a origem e %4.1f\nO ponto mais afastado da origem foi ", cont, soma); //imprimir soma das distancias dos n pontos
		writePoint(max); //chama a funcao void que imprime um ponto passado por argumento
		
		BubbleSort(zero, points, cont);//imprimir os valores ordenados no fim
		
	}
	
	//ordenar por Bubble Sort
	public static void BubbleSort(Ponto2D zero, Ponto2D[] points, int cont){ //sort by distance to (0,0)
		int swap = 0;
		
		do
		{
			for (int i = 0; i < cont -1; i++)
			{
				swap = 0;
				if (dis(zero, points[i]) > dis(zero, points[i+1]))//ordenar por distancia a origem
				{
					Ponto2D aux = points[i];
					points[i] = points[i+1];
					points[i+1] = aux;
					swap++;
				}
				
			}
			
		} while (swap != 0);
		
		System.out.println("Pontos ordenados por ordem crescente a origem:");
		for (int i = 0; i < cont; i++)
		{
			System.out.printf("%d: (%5.2f ; %5.2f)\n", i+1, points[i].x, points[i].y);
		}
		
		
		
		
	
	}
	
	public static void lerPonto(int cont, Ponto2D[] points){
		points[cont] = new Ponto2D();
		System.out.println("Introduza um ponto");
		System.out.print("Coordenada X= ");
		points[cont].x = kb.nextDouble();
		System.out.print("Coordenada Y= ");
		points[cont].y = kb.nextDouble();
		}
	
	//funcao void que escreve dois pontos - podia devolver uma string tbm!
	public static void writePoint(Ponto2D aux){
		System.out.printf("(%5.2f ; %5.2f)\n", aux.x, aux.y);
	}
	
	//funcao que devolve a distancia entre dois pontos, passando dois registos de pontos preenchidos
	public static double dis(Ponto2D pt1, Ponto2D pt2){
		double aux;
		aux = (Math.sqrt(Math.pow(pt2.x-pt1.x,2) + Math.pow(pt2.y - pt1.y,2)));
		return aux;
	} 
}
//registo que guarda as coordenadas dos pontos
class Ponto2D{
	double x, y;
	}

