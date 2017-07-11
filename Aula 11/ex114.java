/*
 * 
 * Ler lista de alunos (ficheiro .tab)
 * Pesquisar por nº mec e obter nome
 * 
 * 
 * 
 */
 
 
 
import java.util.Scanner;
import java.io.*;

public class ex114 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException {
		
		File f = new File("alunos.tab");
		
		int len = countEntrys(f);
		int num[] = new int[len];
		String nomes[] = new String[len];
		
		readTab(num, nomes, f);
		
		System.out.print("Numero a procurar: ");
		int x;
		do
		{
			 x = kb.nextInt();
		} while (x <= 0); // numeros negativos ou 0 sao invalidos... os outros simplesmente podem ou nao existir na lista
		
		System.out.println(search(num, nomes, x));
	
	}
	
	public static String search(int[] num, String[] nomes, int x){
		for (int i = 0; i < num.length; i++)
		{
			if (num[i] == x)
				return ("O numero " + x + " existe na lista e o aluno(a) correspondente e " + nomes[i]);
			
		}
		
		return ("O numero " + x + " nao existe na lista");
	}
	
	
	
	public static int countEntrys(File f) throws IOException{
		Scanner sc = new Scanner(f);
		int cont = 0;
		while (sc.hasNextLine())
		{
			String garbage = sc.nextLine(); //se nao chamar nenhum nextLine() ele nunca muda de linha... consequencia: basta ter uma linha que sera sempre verdade -> ciclo infinito
			cont++;
		}
		
		return cont;
		
		}
		
	
	public static void readTab(int[] num, String nome[], File f) throws IOException
	{
		Scanner sc = new Scanner(f);
		
		for (int i = 0; i < num.length; i++)
		{
				num[i] = sc.nextInt(); //a primeira entrada e um num
				nome[i] = sc.nextLine(); //a segunda entrada e uma string
		}
		
		
		
		
		
	}
}

