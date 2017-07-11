/* Fatorial
 * 
 * 
 */


import java.util.Scanner;
public class ex54 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		num = Functions.GetIntRange(1,10); //funcao que devolve um valor entre [1,10]
		
		
		for (int i = num; i >=1 ; i--) //for que percorre o intervalo
		{
			System.out.printf("%d! = %d\n", i, Functions.fact(i)); //imprime o resultado direto da funcao que calcula o fatorial de um numero
		}
		
	}
}

