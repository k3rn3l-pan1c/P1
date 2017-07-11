/*
 * 
 * Histograma
 * 
 * 
 * 
 */
 
 
 
import java.util.Scanner;
public class ex94 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		System.out.print("Numero de notas que ira introduzir: ");
		int n = my.getIntPos();
		
		int v[] = new int[n];
		int hist[] = new int[21]; //de 0 a 20 inclusive
		
		LerNotas(v, hist);
		
		Histograma(hist);
		
	}
	public static void Histograma(int[] hist){
		System.out.printf("Histograma de notas\n------------------------------------------------------\n");
		for (int i = 0; i < hist.length ; i++)
		{
			System.out.printf("%2d | ", i );
			for (int j = 0; j < hist[i]; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		}
	public static void LerNotas( int[] v, int[] hist){
		
		for (int i = 0; i < v.length; i++)
		{
			System.out.print("Nota: ");
			v[i] = LerNota();
			hist[v[i]]++; //magic piece of code! 				
		}		
	}
	
	/*magic piece of code faz o seguinte:
	 * 
	 * os indices do vetor histograma vao de 0 a 20.. A possibilidade de notas inseridas tbm e de 0 a 20
	 * Como o hist[] guarda qnt vezes uma certa nota foi introduzida, 
	 * O indice 0 do vetor hist guarda qnt vezes apareceu um zero
	 * Assim se na leitura apareceu um zero, posso incrementar o indice 0 do vetor hist 
	 */
	 
	//validar as notas obtidas
	public static int LerNota(){
		int nota;
		do
		{
			nota = sc.nextInt();
		} while (nota < 0 || nota > 20);
		
		return nota;
		}
}

