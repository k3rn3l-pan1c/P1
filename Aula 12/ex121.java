/*
 * 
 * Multiplicação de Matries
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex121 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		int m1[][];
		int m2[][];
		
		
		m1 = getMatrix();

		m2 = getMatrix();
		
		System.out.println("m1.length: " + m1.length);
		System.out.println("m1[0].length: " + m1[0].length);
		System.out.println("m2.length: " + m2.length);
		System.out.println("m2[0].length: " + m2[0].length);
		
		if (CheckMatrix(m1,m2)) //se for possivel o produto
			{
				PrintMatrix(ProdMatrix(m1,m2));
			} 
		else
			{
				System.out.print("O Produto destas matrizes nao e possivel");
			}	
	}
	
	public static void PrintMatrix(int[][] m){
		for (int i = 0; i < m.length; i++)
		{
			for (int j = 0; j < m[0].length ; j++)
			{
				System.out.printf("%2d", m[i][j]);
			}
			System.out.println();
			
		}
		
		
		}
		
		
	public static int[][] ProdMatrix(int[][] m1, int[][] m2){
		// as linhas da matriz que guarda o produto sao as linhas de m1 e as colunas sao as colunas de m2
		int temp[][] = new int[m1.length][m2[0].length];
		
		
		//1 for seleciona a linha da 1 matriz
		for (int i = 0; i < m1.length; i++)
		{
			//2 for seleciona a linha da 2 matriz
			for (int j = 0; j < m2[0].length; j++)
			{
				//3 for percorre os elementos das linhas
				//as matrizes são iguais, por isso as colunas da 1 são iguais as linhas da segunda = k
				int aux = 0;
				for (int k = 0; k < m1[0].length ; k++)
				{
					aux+=m1[i][k] * m2[k][j]; //calculo de um unico indice -> linha de uma matriz por outra coluna
				}
				temp[i][j] = aux; //devolve o valor da multiplicacao a entrada especifica da matriz multiplicacao
			}
			
		}

		return temp;
		
	}
		
	//verificar se as matrizes tem dimensoes compativeis. Remind = nº de colunas de A tem de ser igual ao num de linhas de B
	public static boolean CheckMatrix(int[][] m1, int[][] m2){
		if (m1[0].length == m2.length)
			return true;
		else return false;
		}
	
	//ler a matriz
	public static int[][] getMatrix(){
		System.out.print("Nº de linhas da matriz: ");
		int l = kb.nextInt();
		System.out.print("Nº de colunas da matriz: ");
		int c = kb.nextInt();
		
		int temp[][] = new int[l][c];
		for (int i = 0; i < l ; i++)
		{
			for (int j = 0; j < c ; j++)
			{
				System.out.printf("[%d][%d]: ", i, j);
				temp[i][j] = kb.nextInt(); 
			}
			
		}
		
		return temp;
		}
}

