/**
 * Function - Define several functions, and test them.
 * 
 * Nesta classe deve definir novas funções e testá-las na função main.
 * 
 * 
 **/
import java.util.Scanner;
public class Functions {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		// Testar função sqr:
		System.out.printf("sqr(%f) = %f\n", 10.1, sqr(10.1));
		System.out.printf("sqr(%f) = %f\n", -2.0, sqr(-2.0));
	
		//teste da funcao f
		System.out.printf("f(%d) = %f\n", 5, f(5));
		
		
		//teste da funcao max real e int
		System.out.printf("max(%f, %f) = %f\n", 5.2, 10.2, max(5.2,10.2));
		System.out.printf("max(%d, %d) = %d\n", 5, 10, max(5,10));
		
		//teste da funcao poly3
		System.out.printf("poly3(%d,%d,%d,%d,%d) = %f\n", 5,6,7,8,9, poly3(5,6,7,8,9));
		
		//teste da funcao do fatorial
		System.out.printf("fact(%d) = %d", 4, fact(4));
		

		// Testar as restantes funções desenvolvidas
		//System.out.printf("max(%f,%f) = %f\n", 3.1, 5.2, max(3.1, 5.2));
		//System.out.printf("max(%d,%d) = %d\n", 3, 2, max(3, 2));
		//int ano = getIntPos("Ano? ");
		//System.out.printf("ano = %d\n", ano);
	
	}
	
	/**
	 * sqr - calcula o quadrado de um número (real).
	 * (A classe Math tem uma função para a raiz quadrada, sqrt,
	 * mas falta-lhe uma para o quadrado: sqr colmata essa lacuna!)
	 **/
	 
	public static double sqr(double x) {
		double y;	// variavel para resultado
		y = x*x;	// calculo do resultado a partir dos dados
		return y;	// devolver o resultado
	}
	
	//funcao f definida no guiao 5
	public static double f(int n){
		return (1/(1+sqr(n)));
		}
		
	//funcao que devolve o maximo de dois num
	public static double max (double num1, double num2){
		//supondo que a var num1 guarda smp o valor do maior num
		if (num1 < num2) //se num2 > num1
			num1 = num2; //troca os valores
		return num1;    //retorna smp num1, pois esta var e que guarda smp o valor maior
	}
	
	// diferenca entre dois num inteiros
	public static int max (int num1, int num2){
		return (num1-num2);
	}
	
	//resultado de uma funcao polinomial de 3 grau
	public static double poly3(double a, double b, double c, double d, double x) {
		double aux;
		aux = (a*Math.pow(x,3) + b*sqr(x) + c*c + d);
		return aux;		
		}
	
	
	//fatorial de um num
	public static int fact(int num){
			for (int j = num-1; j >=1 ; j--)
			{
				num *= j;
			}
			return num;
		}
		
	//retorna um valor inteiro dentro dos limites de um intervalo fechado passado por argumento
	public static int GetIntRange(int low, int up) // intervalo a validar é fechado
	{
		int num;
		
		do
		{
			System.out.print("Valor: ");
			num = sc.nextInt();
		} while ((num<low) || (num > up));
		return num;
		
		}
		
	
	//retorna um valor inteiro dentro dos limites de um intervalo aberto passado por argumento
	public static int GetIntORange(int low, int up) //intervalo a validar é aberto
	{
		int num;
		
		do
		{
			System.out.print("Valor: ");
			num = sc.nextInt();
		} while ((num<=low) || (num >= up));
		return num;
		
		}
		
	//retorna um valor real > 0
	public static double GetDouble()
		{
		double num;
		do
		{
			System.out.print("Valor: ");
			num = sc.nextDouble();
		} while (num<0);
		return num;
		
		}
		
	//retorna um valor inteiro > 0
	public static int GetPositive()
	{
		int num;
		do
		{
			System.out.print("Valor: ");
			num = sc.nextInt();
		} while (num<0);
		return num;
		
		}
	
	
	//imprime a tabela da tabuada de um numero int passado por argumento
	public static void tabuada(int n)
	{
		System.out.printf("-------------------\n|  Tabuada dos %2d |\n-------------------\n", n);
		
		for (int i = 1; i <=10 ; i++)
		{
			System.out.printf("| %2d x %2d  |  %3d |\n",n, i, (n*i));
		}
		
		System.out.println("-------------------");
	}
	
	
	
	//maximo divisor comum de dois nums passados por argumento
	public static void euclides ( int num1, int num2){
		int aux;
		if (num2>num1)
		{
			aux = num1;
			num1 = num2;
			num2 = aux;
		}
			
		do
		{
			num1-=num2;
		} while ((num1!=num2) && (num1>num2));
		
		if (num1==num2)
		
			System.out.print("o maior divisor comun e: " + num1);
		else System.out.print("Nao existe divisor comun");
	}
	
	
	//imprime no terminal se um numero int passado por argumento e ou nao primo
	public static void isprime( int num){
		boolean primo=true;
		int cont = 1;
		while ((cont!=(num-1)))
		{
			if (num==1)  //eliminação do caso particular
			{
				primo = false;
				break;
			}
			cont++;
			if ((num%cont) ==0)  // se se encontrou um divisor, o num ja nao e primo e e pode-se quebrar o ciclo
			{
				primo = false;
				break;
			}
		}
		if (primo == false)
			System.out.printf("O numero %d nao e um numero primo", num);
		else
			System.out.printf("O numero %d e um numero primo", num);
	}
}
