import java.util.Scanner;
import java.io.*;

public class teste {
	
	public static void main (String args[]) throws IOException{
		int array[] = new int[51];
		Scanner kb = new Scanner(System.in);
		String name = "";
		int pos = 0, temp;
		System.out.print("Introduza o nome do ficheiro: ");
		do {
	name = kb.nextLine();
	} while (name.length() == 0);

		File f = new File(name);
		Scanner sc = new Scanner(f);
		
		while(sc.hasNextInt())
		{
			array[pos] = sc.nextInt();
			pos++;	
		}
		sc.close();
		
		for (int i = 0; i < 50; i++)
		{
			System.out.print(array[i]);
		}
		
	}
}

