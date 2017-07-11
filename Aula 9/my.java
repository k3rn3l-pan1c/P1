/*
 * 
 * Funcoes by Pedro Martins
 * 
 */



import java.util.Scanner;
public class my {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
	}
	
	//ler num int
	public static int getIntPos(){
		int num;
		do
			{
				num = sc.nextInt();
			} while (num <= 0);
		return num;
		}
		
		
	//ler num int 
	public static int getIntL(int low, String question){
		int num;
		
		do
		{
			System.out.print(question);
			num = sc.nextInt();
		} while (num < low);
		
		return num;
	}
	
	//ler num int num intervalo aberto
	public static int getIntOpen(int min, int max){
			int num;
			do
			{
				num = sc.nextInt();
			} while ((num <= min) || (num >= max));
			
		return num;
	}
	
	//ler num int num intervalo fechado
	public static int getIntClose(int min, int max){
			int num;
			do
			{
				num = sc.nextInt();
			} while ((num < min) || (num > max));
			
		return num;
	}
	
	//ler num double 
	public static double getIntL(double low, String question){
		double num;
		
		do
		{
			System.out.print(question);
			num = sc.nextInt();
		} while (num < low);
		
		return num;
	}
	//ler num double num intervalo aberto
	public static double getDoubleOpen(double min, double max){
			double num;
			do
			{
				num = sc.nextDouble();
			} while ((num <= min) || (num >= max));
			
		return num;
	}
	
	//ler num double num intervalo fechado
	public static double getDoubleClose(double min, double max){
			double num;
			do
			{
				num = sc.nextDouble();
			} while ((num < min) || (num > max));
			
		return num;
	}
	
}

