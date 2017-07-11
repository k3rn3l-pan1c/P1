/* Ternos ordenados que sao solucao do Teorema de Pitagoras
 * 
 * Sugestoes:  pode evitar solucoes repetidas se garantir que a < b.
 * 
 * 1) gerar todas as combinacoes de a e b para a e b < 100
 * 2) garantir que b < a para evitar solucoes repetidas
 * 3) verifcar se a2 + b2 = c2 (teorema de pitagoras)
 * 4) print qnd encontrar uma solucao

 */
 
 import java.util.Scanner;
public class ex45 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		//1 - os tres for, um para cada coeficiente (a,b,c)
		for (int a = 0; a < 100; a++)
		{
			for (int b = 0; b < a /*2*/ ; b++)
			{
				for (int c = 0; c < 100; c++)
				{
					//3
					if (((a*a) + (b*b)) == (c*c))
						/*4*/ System.out.printf("(%d %d %d)\n", a,b,c);
				}
				
			}
			
		}
		
		
	}
}

