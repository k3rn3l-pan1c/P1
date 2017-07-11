/*
 * 
 * Print Vetor invertido
 * 
 * with functions
 */
 
 
import java.util.Scanner;
public class ex91_v3 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		int n[];
		int dim;
		System.out.print("Dimensão: ");
		dim = sc.nextInt();
		
		n = lerArray(dim);
		System.out.println();
		printArray(n);
		
		
	}
	
	public static int[] lerArray(int dim){
		int temp[] = new int[dim];
		
		for (int i = 0; i < dim; i++)
		{
			System.out.printf("num[%d]: ", i);
			temp[i] = sc.nextInt(); 
		}
		
		return temp;
	}
	
	public static void printArray(int n[]){
		
		for (int i = n.length-1 ; i >= 0 ; i--)
		{
			System.out.printf("n[%d]: ", i);
			System.out.println(n[i]);
		}
		}
		
		
}
