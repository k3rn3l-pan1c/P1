/* Media Calculator
 * 
 * Condicao de paragem: nota < 0
 * 
 * 1) ler notas ate cond = true
 * 2) contar qnts notas forma introduzidas
 * 3) Somar as notas para usar na media
 * 4) se n = 0, print ERRO!
 * 5) se n > 0, calcular media e print
 * 
 */
 
import java.util.Scanner;
public class ex38 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int cont = 0, soma = 0, num;
		
		//1
		do
		{
			System.out.print("Introduza a sua nota: ");
			num = sc.nextInt();
			
			
			if (num < 0) //proteger o contador e a soma das notas do elemento de paragem
				break;
			
			cont+= 1; //2
			soma += num; //3
		
			
			
		} while (num>0);

			//4
			if (cont == 0)
				System.out.print("Introduziu uma lista vazia");
				
			//5
			else		
				System.out.printf("A media dos nos numeros introduzidos e %f e a soma e %d", ((double)soma/cont), soma);
	}
}

