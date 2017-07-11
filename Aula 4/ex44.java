/* Serie de Leibnitz
 * 
 * Condiçoes: resultado com 15 casas decimais e comparado com o valor de π/4.
 * 
 * 1) Ler numero 
 * 2) gerar os n termos da serie de leibnitz
 * 2) decidir que operacao aplicar aos termos e calcular 
 * 3) print
 */
 

import java.util.Scanner;
public class ex44 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n,cont=0;
		double output = 0;
		
		//1
		System.out.print("N= ");
		n = sc.nextInt();
		
		//2
		for (int i = 1; i <=n ; i+=2)
		{
			cont++;
		/*
		 * para o resultado da divisao ser real, 
		 * um dos numeros tem de ser obrigatoriamenate real
		 * ou entao, temos de mudar a seu tipo de dados momentariamnete para double
		 *  Ex.: (1/(double)i)
		 */
		 
			//3
			if (cont%2 == 0)
				output -= (1.0/i); 
			else 
				output += (1.0/i);
		}
		
		//4
		System.out.printf("A soma dos primeiros %d termos a serie de Leibnitz e %17.15f\n",n, output);
		System.out.printf("Comparando o %d termo da sequencia de Leibnitz com π/4 podemos obtemos o termo %2d da serie de Leibnitz e aproximadamente %f partes de π/4", n, n, (output/(Math.PI/4)));
	}
}

