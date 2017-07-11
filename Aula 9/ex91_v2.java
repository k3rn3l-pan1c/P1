/*
 * 
 * Print Vetor invertido
 * 
 * with functions
 */
 
 
import java.util.Scanner;
public class ex91_v2 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		int dim;
		System.out.print("Dimensão: ");
		dim = sc.nextInt();
		int n[] = new int[dim];
		lerArray(n);
		System.out.println();
		printArray(n);
		
		
	}
	
	public static void lerArray(int temp[]){
		
		for (int i = 0; i < temp.length; i++)
		{
			System.out.printf("temp[%d]: ", i);
			temp[i] = sc.nextInt(); 
		}
	}
	public static void printArray(int n[]){
		
		for (int i = n.length-1 ; i >= 0 ; i--)
		{
			System.out.printf("n[%d]: ", i);
			System.out.println(n[i]);
		}
		}
		
		
}
