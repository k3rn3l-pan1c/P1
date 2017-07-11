/* Tabuleiro de xadrez
 * 
 * 1) gerar o tabuleiro com 2 fors( linhas e colunas)
 * 
 */
 
 
import java.util.Scanner;
public class ex411 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		char letra;
		
		//1
		for ( int i = 8; i >= 1; i--) // o i decresce ao longo da coluna, por isso i--
		{
			
			 for (int j = 1; j <= 8; j++) // as letras crescem ao longo da linha, por isso j++ (que se soma ao char para incrementa-lo) 
			 {
				 letra = ((char)('a' + j -1)); // incrementar as letras
				 System.out.printf("%c%d ", letra , i ); //print formatado, respeitando o pedido
			 }
			 System.out.println(); //mdanca de linha qnd percorremos todas as colunas de uma linha
		}
		
	}
}

