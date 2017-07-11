/*
 * 
 * Totoloto
 * 
 * Tipo de dados Long -> usar Shifts
 * 
 * Incompleto
 * 
 */
 
 
import java.util.Scanner;
public class ex116 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		long n = lerChave();
		mostraChave(n);
	}
	public static void mostraChave(long n){
		System.out.printf("\n\tAposta do totoloto\n");
		int cont = 1;
		for (int i = 1; i <= 7 ; i++) //linhas
		{
			for (int j= 1; j <= 7; j++) //colunas
			{
				/*
				if (cont == ??? )      //tem de se usar shifts!!! another time maybe :P
						System.out.print("  X");
				else System.out.printf("%3d", cont);
				*/
				cont++; 
			}
		System.out.println();	
		}
		
	}
			
	public static long lerChave(){
		long n = 0L;
		int cont = 0, num;
		do{
			do
			{
			System.out.printf("Elemento %d da chave: ", cont);
			num = kb.nextInt();	
			} while (num < 0 && num > 49);
			
			n += num * Math.pow(10, cont*2); //ordem dos numeros inversas.. o ultimo num e o mais significativo
			cont++;
		} while (cont != 6); 
		return n;	
	}
	
	

}
