/* P1 e fixe!
 * 
 *
 */


import java.util.Scanner;
public class ex41_v2 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("Introduza um numero: ");
		num= sc.nextInt();
		
		for (int i = 1; i <= num ; i++) // for(int i = 0; i < num; i++);
		{
			System.out.println("P1 e fixe!");
		}
		
	}
}


