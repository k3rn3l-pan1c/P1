/* 
 * 
 * Distancia entre pontos
 * 
 * 
 */


import java.util.Scanner;
public class ex72{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		Ponto2D point = new Ponto2D(); //ponto generico
		Ponto2D zero = new Ponto2D();  //ponto zero(origem)
		Ponto2D max = new Ponto2D();  //registo que guarda o valor do ponto mais distante a origem
		int cont = 0; //
		double soma, maxdis; //
		
		
		point = lerPonto(); //atribui ao valor do ponto generico um registo preenchido devolvido atraves da funcao lerPonto
		soma = dis(point, zero); //atribui a soma o valor da distancia do ponto generico a origem
		maxdis = soma; // a distancia maxima inicial e soma, ou seja, a distancia de zero a origem
		max = point; // o ponto mais distante inicial e o ponto inicial
		
		//enquanto a coordenada x do ponto for != 0  e a coordenada y do ponto !=0
		while (point.x != zero.x || point.y != zero.y){
			point = lerPonto(); //ler um novo ponto
			cont++; //contar mais um ponto
			soma += dis(zero, point); //somar a distancia desse ponto a origem (chamando a funcao dis para obter a distancia)
			if (maxdis < dis(zero, point)) //se a distancia do ponto atual for maior do que a distancia do ponto guardado na memoria
				{
					maxdis = dis(zero,point); //atribuir essa nova distancia
					max = point; //atribuir o novo ponto maximo
				}
				
		} 
		System.out.printf("\nA soma das distancias dos %d pontos a origem e %4.1f\nO ponto mais afastado da origem foi ", cont, soma); //imprimir soma das distancias dos n pontos
		writePoint(max); //chama a funcao void que imprime um ponto passado por argumento
		
		
		
	}
	
	public static Ponto2D lerPonto(){
		Ponto2D point = new Ponto2D();
		System.out.println("Introduza um ponto");
		System.out.print("Coordenada X= ");
		point.x = sc.nextDouble();
		System.out.print("Coordenada Y= ");
		point.y = sc.nextDouble();
		return point;
		}
	
	//funcao void que escreve dois pontos - podia devolver uma string tbm!
	public static void writePoint(Ponto2D aux){
		System.out.printf("(%3.1f ; %3.1f)", aux.x, aux.y);
	}
	
	//funcao que devolve a distancia enter dois pontos, passando dois registos de pontos preenchidos
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
