/* Asteriscos 2
 * 
 * 1) ler num de linhas e num de colunas
 * 2) Imprimir os asteriscos um a um para a linha 1 e ultima, para a coluna 1 e a ultima
 * 
 */
 
 
import java.util.Scanner;
public class ex47 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int l,c;
		
		
		//1
		System.out.print("Linhas: ");
		l = sc.nextInt();
		
		System.out.print("Colunas: ");
		c = sc.nextInt();
		
		for (int i = 1; i <= l; i++) //percorre as linhas
		{
			for (int j = 1; j <= c; j++) //percorre em cada linha, cada coluna
			{
				if (((i == 1) || (i == c)) || ((j == 1) || (j == l))) //linha == 1 ou linha = fim; coluna ==1 ou coluna == fim
					//2
					System.out.print("*");
				else System.out.print(" "); //print um espaco
			}
			System.out.println(); //mudanca de linha, qnd se percorre todas as colunas de uma linha
		}
	}
}

