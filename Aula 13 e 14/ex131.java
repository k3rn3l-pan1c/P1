/*
 * 
 * Estação Metereologica
 * 
 * 
 * 
 */
 

import java.util.Scanner;
import java.io.*;
public class ex131 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		data stats[] = new data[31];
		int dim = 0;
		menu();
		
		select(stats, dim);
	}
	
	//adicionar um elemento ao array
	public static int add(data[] stats, int dim){
		
		stats[dim] = new data();
		do
		{
			System.out.printf("Temperatura[%d]: ", dim);
			stats[dim].t = kb.nextInt();
		} while (stats[dim].t < -10 || stats[dim].t > 40);
		
		do
		{
			System.out.printf("Humidade[%d]: ", dim);
			stats[dim].h = kb.nextInt();
		} while (stats[dim].h < 0 || stats[dim].h > 100);
		
		System.out.println("Adicao de dados terminada");
		
	return ++dim; //incrementar e dps devolver.. ATENÇAO!!! diferente de dim++!
	//++dim incremenat dim e dps usa esse valor (neste caso devolve)
	//dim++ usa o valor e dps incrementa (neste caso devolve logo, nunca incrementando
		
	}
	
	//min e maximo
	public static void extremes(data[] stats, int dim){
		data min = new data(); //minimo da temp e da humidade
		data max = new data(); //maximo da temp e da humidade
		
		//inicializaçao ao primeiro valor do array
		min.t = stats[0].t;
		max.t = stats[0].t;
		min.h = stats[0].h;
		max.h = stats[0].h;
		
		//o for começa portanto no 2 elemento
		for (int i = 0; i < dim; i++)
		{
			if (stats[i].t > max.t)
				max.t = stats[i].t;
				
			if (stats[i].t < min.t)
				min.t = stats[i].t;
				
			if (stats[i].h > max.h)
				max.h = stats[i].h;
				
			if (stats[i].h < min.h)
				min.h= stats[i].h;
		}
		
		System.out.printf("O valor minimo de temperatura e %d e o valor maximo %d\nO valor minimo de humidade e %d e o valor maximo %d\n", min.t, max.t, min.h, max.h);
		
	}
	
	//media de temp e de humidade
	public static void media(data[] stats, int dim){
		int somaT = 0, somaH = 0;
		
		for (int i = 0; i < dim; i++)
		{
			somaT += stats[i].t;
			somaH += stats[i].h;
		}
		
		System.out.println("A media da temperatura e : " + (somaT / dim));
		System.out.println("A media da humidade e : " + (somaH / dim));
	}
	
	//selecionar opçoes
	public static void select(data[] stats, int dim) throws IOException{
		int op;
		
		do
		{
			System.out.print("Opcao -> ");
			op = kb.nextInt();
		switch (op)
		{
			case 0:
				System.out.println();
				menu();
				break;
			case 1:
				dim = readFile(stats);
				break;
			case 2:
				dim = add(stats, dim);
				break;
			case 3:
				print(stats, dim);
				break;
			case 4:
				ordenarT(stats, dim);
				break;
			case 5:
				ordenarH(stats, dim);
				break;
			case 6:
				media(stats, dim);
				break;
			case 7:
				extremes(stats, dim);
				break;
			case 8:
				histograma(stats, dim);
				break;
			case 9:
				System.out.print("O programa vai terminar");
				break;	
			default:
				System.out.printf("\nOpcao invalida. Nova ");
				break;
			}
			System.out.println();
		} while (op != 9);
		
	}
	
	//histogramas
	public static void histograma(data[] array, int dim){
		System.out.printf("Histograma da temperatura\n-----------------------\n");
		
		for (int i = -10; i <= 40; i++)//linhas
		{
			System.out.printf("%3d | ", i );
			for (int j = 0; j < dim; j++) //colunas
			{
				if (i == array[j].t)
					System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.printf("\n\n");
		
		System.out.printf("Histograma da humidade\n-----------------------\n");
		
		for (int i = 0; i <= 100; i++) //linhas
		{
			System.out.printf("%3d | ", i );
			for (int j = 0; j < dim; j++) //colunas
			{
				if (i == array[j].t)
					System.out.print("*");
			}
			System.out.println();
		}
		}
		
	public static void ordenarH(data[] array, int dim){
		data aux[] = new data[dim];
		
		//copiar o array
		for (int i = 0; i < dim; i++)
		{
			aux[i] = new data();
			aux[i].t = array[i].t;
			aux[i].h = array[i].h;
		}
		
		//ordenar por humidade
		for (int i = 0; i < dim -1; i++)
		{
			for (int j = i + 1; j < dim ; j++)
			{
				if (aux[i].h > aux[j].h)
				{
					data tmp;
					tmp = aux[i];
					aux[i] = aux[j];
					aux[j] = tmp;
				}
			}
		}
		
		System.out.print("Temperatura - Humidade\n");
		for (int i = 0; i < dim; i++)
			{
				System.out.printf("%6d      - %4d\n", aux[i].t, aux[i].h);
			}
	}
	
	public static void ordenarT(data[] array, int dim){
		data aux[] = new data[dim];
		
		//copiar o array
		for (int i = 0; i < dim; i++)
		{
			aux[i] = new data();
			aux[i].t = array[i].t;
			aux[i].h = array[i].h;
		}
		
		//ordenar por temperatura
		for (int i = 0; i < dim -1; i++)
		{
			for (int j = i + 1; j < dim ; j++)
			{
				if (aux[i].t > aux[j].t)
				{
					data tmp;
					tmp = aux[i];
					aux[i] = aux[j];
					aux[j] = tmp;
				}
			}
		}
		
		System.out.print("Temperatura - Humidade\n");
		for (int i = 0; i < dim; i++)
			{
				System.out.printf("%6d      - %4d\n", aux[i].t, aux[i].h);
			}
	}
		
	//imprimir
	public static void print(data[] array, int dim){
		System.out.print("Temperatura - Humidade\n");
		for (int i = 0; i < dim; i++)
			{
				System.out.printf("%6d      - %4d\n", array[i].t, array[i].h);
			}
		}
	
	//ler Ficheiro	
	public static int readFile(data[] array) throws IOException{
		String name = new String();
		File f;
		int i = 0;
		
		do
		{
			System.out.print("Nome do ficheiro: ");
			do {
				name = kb.nextLine();
			} while (name.length() == 0);
		
			 f = new File(name);
		} while (!(f.isFile() || f.canRead())); //repetir enquanto nao: existir o ficheiro ou puder ler o ficheiro
		
		Scanner sc = new Scanner(f);
		
		while (sc.hasNextDouble())
			{
				array[i] = new data();
				array[i].t = sc.nextInt();
				array[i].h = sc.nextInt();
				i++;
			}
		
		System.out.printf("A leitura do ficheiro foi concluida\n");
		return i;
		}
	
	public static void menu(){
		String s[] = {"Estacao meteorologica: ", "1 - Ler ficheiro de dados",  "2 - Acrescentar medida ", "3 - Listar valores de temperatura e humidade",  "4 - Listar medidas ordenadas por valor de temperatura",  "5 - Listar medidas ordenadas por valor de humidade",  "6 - Calcular valores medios de temperatura e humidade",  "7 - Calcular valores maximos e mınimos de temperatura e humidade",  "8 - Calcular histograma das temperaturas e humidade",  "9 - Terminar o programa"};
		for (int i = 0; i < s.length; i++)
		{
			System.out.println(s[i]);
		}
		
		
		
		
		}
}

class data{
	int t, h;
	
	}
