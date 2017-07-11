/*
 * 
 * Totoloto
 * 
 * array de 50 booleanos
 * 
 */
 
 
import java.util.Scanner;
public class ex115 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		boolean n[] = new boolean[50];
		
		lerChave(n);
		mostraChave(n);
	}
	public static void mostraChave(boolean[] n){
		System.out.printf("\n\tAposta do totoloto\n");
		int cont = 1;
		for (int i = 1; i <= 7 ; i++) //linhas
		{
			for (int j= 1; j <= 7; j++) //colunas
			{
				
				if (n[cont]) //se for verdade, ou seja, foi introduzido um numero que pertence ao indice
						System.out.print("  X");
				else System.out.printf("%3d", cont);
				cont++; 
			}
		System.out.println();	
		}
		
	}
			
	public static void lerChave(boolean[] n){
		int cont = 0, num;
		do{
			do
			{
			System.out.printf("Elemento %d da chave: ", cont + 1);
			num = kb.nextInt();	
			} while ((num < 0 && num > 49) || n[num] == true); //se o numero for invalido ou se o valor ja existir (ou seja, o seu indice for true) pedir outra vez 
			
			n[num] = true; //se o numero for valido, agr ja existe, logo o seu indice e true
			cont++;
		} while (cont != 6); 	//enquanto nao forem lidos 6 numeros
	}
	
	

}
