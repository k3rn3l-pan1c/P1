/*
 * 
 * Media
 * Desvio Padrao
 * Valores > Media
 * 
 */
 
 
import java.util.Scanner;
public class ex95 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		double values[] = readArray();
		
		System.out.printf("A media dos valores e: %5.2f\n", media(values));
		System.out.printf("O desvio padrao dos valores e: %5.2f\n", desvioP(values));
		
		printMM(values);
		
	} 
	
	public static void printMM(double[] array){
		double media = media(array);
	
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] > media)
				System.out.printf("O valor %5.2f e maior que a media\n", array[i]);
		}
	}
	
	//desvio padrao = soma de (valor - media)² a dividir pelo numero de elementos
	public static double desvioP(double[] array){
		double soma = 0.0; //soma do desvio padrao
		double media = media(array); //obter a media
		int i;
		
		for (i = 0; i < array.length; i++)
		{
			soma += Math.pow(array[i] - media, 2); //obter a soma de (valor - media)²
		}

		return Math.sqrt(soma / (i -1)); // i tem o numero de iterações(numeros)
		
	}
	
	public static double media(double[] array){
		double soma = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			soma += array[i];
		}
		
		return (soma / array.length);
		}
	
	public static double[] readArray(){
		int size = my.getIntL(0, "Dimensao do array: "); //funcao na my.java
		double num[] = new double[size];
		
		for (int i = 0; i < size; i++)
		{
			System.out.printf("num[%d]: ", i);
			num[i] = kb.nextDouble();
		}
			
		return num;
	}
}

