/*
 * 
 * Print Vetor invertido
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex91_v1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		int dim;
		System.out.print("Dimensão: ");
		dim = sc.nextInt();
		int n[] = new int[dim];
		
		for (int i = 0; i < n.length; i++)
		{
			System.out.printf("n[%d]: ", i);
			n[i] = sc.nextInt(); 
		}
		
		System.out.println();
		
		for (int i = n.length-1 ; i >= 0 ; i--)
		{
			System.out.printf("n[%d]: ", i);
			System.out.println(n[i]);
		}
		
		
	}
}

