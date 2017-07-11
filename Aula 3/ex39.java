/* Conta numeros intervalos
 * 
 * Dados: (contar)
 *  numeros positivos
 *  numeros negativos; 
 *  numeros cujo valor se situa no intervalo [100...1000]
 *  numeros cujo valor se situa no intervalo [−1000...−100] 
 * 
 * condicao de paragem: num = 0
 * 1) Ler num ate num = 0
 * 2) contar smp que o num esteja dentro dos intervalos
 * 3) print
 * 
 */
 
import java.util.Scanner;
public class ex39 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int pos = 0, neg = 0, intpos = 0, intneg = 0;
		double num;
		do
		{
			//1
			System.out.print("Numero = ");
			num = sc.nextDouble();
		
			//2
			if (num>0)
				{
					pos++;
					if ((num <= 1000) && (num >= 100))
						intpos++;
				}
			if (num<0)
				{
					neg++;
					if ((num <= -100) && (num >= -1000))
						intneg++;
				}
		} while (num!=0);
		
		//3
		System.out.println("Foram introduzidos " + pos + " numeros positivos e " + neg + " numeros negativos");
		System.out.println("Foram introduzidos " + intpos + " pertencentes ao intervalo [100,1000]");
		System.out.println("Foram introduzidos " + intneg + " pertencentes ao intervalo [-1000, -100]");
 		
		
	}
}

