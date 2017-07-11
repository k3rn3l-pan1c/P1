/* Multiplicação Russa
 * 
 * Dados: O algoritmo funciona da seguinte forma: para multiplicar X por Y , divide-se X sucessivamente por dois 
 * ate se obter o quociente 1 e ao mesmo tempo multiplica-se Y por 2. 
 * Adicionam-se ao resultado os valores de Y sempre que X e ımpar. 
 * 
 * 1) Ler dois numeros int
 * 2) Se x e impar, guardar o  valor de y para adicionar no fim 
 * 3) x/2 e y*2 ate que x=1
 * 4) adicionar y e print
 */
 
import java.util.Scanner;
public class ex37 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int x,y,aux=0;
		
		//1
		System.out.print("Introduza dois numeros: ");
		x= sc.nextInt();
		y= sc.nextInt();
		
		//2
		if (x % 2 != 0)
			aux = y;
			
		//3
		do
		{
			x/=2;
			y*=2;
		} while (x!=1);
		
		//4
		System.out.print("Resultado: "+ (y+aux));
		
	}
}

