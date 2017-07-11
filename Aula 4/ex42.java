/* Tabuada
 * 
 * Condicoes: n>0 && n<100
 * 
 * 1) ler e validar dados de leitura
 * 2) Imprimir partes cabecalho da tabela
 * 3) gerar os valores e imprimir
 * 4) imprimir fim
 */




import java.util.Scanner;
public class ex42 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		//1
		do
		{
			System.out.print("Introduza um numero: ");
			num = sc.nextInt();
		} while (num<0 || num>100);
		
		//2
		System.out.printf("-------------------\n|  Tabuada dos %2d |\n-------------------\n", num);
		
		//3
		for (int i = 1; i <=10 ; i++)
		{
			System.out.printf("| %2d x %2d  |  %3d |\n",num, i, (num*i));
		}
		
		//4
		System.out.println("-------------------");
	}
}

