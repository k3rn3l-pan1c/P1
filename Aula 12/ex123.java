/*
 * Inverter ordem das frases e os seus caracteres
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex123 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		String frases[] = new String[10];
		int dim = 0;
		
		//ler as frases
		for (int i = 0; i < 10; i++)
		{
			frases[i] = sc.nextLine();
			if (frases[i].compareTo("fim") == 0) //ate obter fim
			{
				dim = i;
				break;				
			}
		}
		
		System.out.printf("\n\n");
		change(frases, dim);
		
		System.out.printf("\n\n");
		
		matriz(frases, dim); //metodo mais eficiente
		
	} 
	//um vetor de strings e um array de caracteres -> imprimir caracter por caracter de forma decrescente
	public static void matriz(String[] names, int dim){
		for (int i = dim -1; i >= 0 ; i--) //frase
		{
			for (int j = names[i].length() -1; j >= 0 ; j--)//caracter
			{
				System.out.print(names[i].charAt(j));
			}
			System.out.println();
		}
	}
	
	
	//metodo menos eficiente
	public static void change(String[] names, int dim){ 
		String tmp[] = new String[dim];//novo vetor
		
		//inverter os caracteres de uma frase de um vetor
		for (int i = 0; i < dim; i++)
		{
			tmp[i] = new String();
			for (int j = names[i].length() -1; j >= 0 ; j--)
			{
				tmp[i] += names[i].charAt(j);
			}
			
		}
		
		//imprimir as frase por ordem inversa a inserida
		for (int i = tmp.length - 1; i >= 0 ; i--)
		{
			System.out.println(tmp[i]);
		}
		
		
	}
}

