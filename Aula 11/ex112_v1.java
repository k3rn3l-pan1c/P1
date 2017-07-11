/*
 * 
 * Totoloto
 * 
 * 
 * 
 */
 
 
 
import java.util.Scanner;
public class ex112_v1 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		int n[] = new int[7];
		
		n = lerChave();
		mostraChave(n);
		
		
		
	}
	public static void mostraChave(int[] n){
		System.out.printf("\n\tAposta do totoloto\n");
		int cont = 1;
		for (int i = 1; i <= 7 ; i++) //linhas
		{
			for (int j= 1; j <= 7; j++) //colunas
			{
				
				if (pertenceChave(n, 7, cont)) //7 pq na funcao o for vai ate <7, logo i max = 6
						System.out.print("  X");
				else System.out.printf("%3d", cont);
				cont++; 
			}
		System.out.println();	
		}
		
	}
		
		
	public static int[] lerChave(){
		int n[] = new int[7];
		int cont = 1, num;
		do{
			System.out.printf("Elemento %d da chave: ", cont);
			do
			{
			num = kb.nextInt();	
			} while (num < 0 && num > 49); //validar os elementos
			
			if (!pertenceChave(n, cont, num)) //verificar se ja existem
			{
				n[cont] = num;
				cont++;
			}
		} while (cont != 7); //ele conta no fim... qnd tem 6 elementos o cont e 7
		
		return n;		
	}
	
	
		public static boolean pertenceChave(int[] n, int edge, int num ) {
			for (int i = 1; i < edge; i++)
			{
				if ((num == n[i])) 
						return true; //o numero que se pretende adicionar ja existe
			}
			return false; // se nao encontrar o num e pq ele nao existe
			}
}

