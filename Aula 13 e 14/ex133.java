/*
 * 
 * 
 * Gestao do concurso microrato
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
import java.io.*;
public class ex133 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		int pos = 0, op;
		robot robos[] = new robot[10]; //inicializei a um valor max
		do
		{
			PrintMenu(); //repetir a impressao do menu a cada iteração
			op = getOP(); //obter uma opcao valida
			switch (op)
			{
				case 1:
					pos = addRobot(robos, pos);
					break;
				case 2:
					printInf(robos, pos);
					break;
				case 3:
					WinnerMedia(robos, pos);
					break;
				case 4:
					MediaElem(robos, pos);
					break;
				case 5:
					OrdenarNomes(robos, pos);
					break;
				case 6:
					AlterarRobo(robos, pos);
					break;
				case 7:
					RemoverRobots(robos, pos);
					break;
				case 8:
					SaveFile(robos, pos);
					break;
				case 9:
					System.out.println("O programa vai terminar");
					break;
			}
			System.out.println();
		} while (op != 9);
		
	}
	
	//obter a opcao
	public static int getOP(){
		int op;
		do
		{
			System.out.print("Opcao -> ");
			op = kb.nextInt();
		} while (op < 1 || op > 9);
		
		return op;
	}
	
	//guardar ficheiro
	public static void SaveFile(robot[] robos, int pos) throws IOException{
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			System.out.print("Nome do ficheiro a gravar: ");
			String name;
			do
			{
				name = kb.nextLine();
			} while (name.length() == 0);
			
			File f = new File(name);
			PrintWriter pw = new PrintWriter(f);
			
			for (int i = 0; i < pos; i++)
			{
				if(robos[i].time != 0) //se nao for null
					pw.printf("%d %d %s\n", robos[i].elem, robos[i].time, robos[i].nome); //ordem de gravação-> nº de elementos, tempo, nome
			}
			
			pw.close(); //forçar escrita
		}
	}
	
	//remover indice por tempo
	public static void RemoverRobots(robot[] robos, int pos){
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			System.out.print("Tempo maximo para desclassificar robots: ");
			int time;
			do
			{
				time = kb.nextInt();
			} while (time <= 0);
			
			
			for (int i = 0; i < pos; i++)
			{
				if(robos[i].time != 0) //se nao for null
					if(robos[i].time >= time)
						robos[i] = new robot();
			}
		}
	}
	
	//alterar inf de um robo
	public static void AlterarRobo(robot[] robos, int pos){
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			System.out.print("Nome: ");
			String nome;
			
			do
			{
				nome = kb.nextLine();
			} while (nome.length() == 0);
			
			boolean exist = false;
			
			for (int i = 0; i < pos; i++)
			{
				if(robos[i].time != 0)
					if(robos[i].nome.compareTo(nome) == 0)
						{
							exist = true;
							System.out.print("Novo ");
							addRobot(robos, i); //chamar a funcao de adicionar, passando a posiçao que queremos alterar
							System.out.println("Os dados do robot foram alterados");
							break;
						}
			}
			
			if(!exist)
				System.out.print("Nao existe nenhum robot com esse nome");
		}	
	}
	
	//ordenar nomes de forma crescente
	public static void OrdenarNomes(robot[] robos, int pos){
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			String nomes[] = new String[pos];
		
			for (int i = 0; i < pos; i++)
			{
				
				if(robos[i].time != 0)
				{
					nomes[i] = new String();
					for (int j = 0; j < robos[i].nome.length(); j++)
					{
						nomes[i] += Character.toUpperCase(robos[i].nome.charAt(j));//concatemar caracter a caracter, passando para maiscula
					}
				}
					
			}
			
			//ordenar por bubble sort
			boolean swap;
			do
			{
				swap = false;
				for (int i = 0; i < pos-1; i++)
				{
					if(nomes[i].compareTo(nomes[i+1]) >= 0)
						{
							String aux = nomes[i+1];
							nomes[i+1] = nomes[i];
							nomes[i] = aux;
							swap = true;
						
						}
				}
			} while (!swap);
			
			//imprimir
			for (int i = 0; i < pos; i++)
			{
				if(robos[i].time != 0) //null
					System.out.println(nomes[i]);
			}
		}
	}
	
	//media de elementos
	public static void MediaElem(robot[] robos, int pos){
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			int soma  = 0;
			
			for (int i = 0; i < pos; i++)
			{
				if (robos[i].elem != 0)
					soma += robos[i].elem;
			}
			
			System.out.printf("A media de elementos por equipa e %d\n", (soma/pos));
		}
	}
	
	//
	public static void WinnerMedia(robot[] robos, int pos){
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			int soma = 0; //nao se pode inicializar a um indice pq o valor desse indice pode ter sido apagado
			robot winner = new robot();
			boolean first = true; //controlar qnd for a primeira execução
			
			for (int i = 0; i < pos; i++)
			{
				if (robos[i].time != 0)
					{
						
						soma += robos[i].time;
						if (first) //se for a primeira execução, copiar 
						{
							first = false; //nunca mais copiar, verificar
							winner.time = robos[i].time;
							winner.nome = robos[i].nome;
							winner.elem = robos[i].elem;
						}
						else if (robos[i].time < winner.time) //winner.time e por default 0. Ou seja, na primeira vez que esta linha de codigo e executada, e smp verdadeira
							{
								//copiar, nao apontar
								winner.nome = new String();
								winner.time = robos[i].time;
								winner.nome = robos[i].nome;
								winner.elem = robos[i].elem;
							}
					}
			}
			
			System.out.printf("A media de tempo de prova e %d segundos e o robo vencedor e %s, com %d segundos\n", (soma/pos) , winner.nome, winner.time);	
		}
	}
	
	//imprimir inf sobre os robots
	public static void printInf(robot[] robos, int pos){
		if (pos == 0)
			System.out.println("Nao existem dados");
		else
		{
			for (int i = 0; i < pos; i++)
			{
				if (robos[i].time != 0)
				{
					int h, m, s;
					h = robos[i].time / 3600; //3600s -> 1 hr
					m = (robos[i].time - 3600* h) / 60; //subtrair aos segundos aqueles que ja foram convertidos em horas. 60 seg -> 1 min
					s = robos[i].time % 60; //o que nao e possivel dividir por 60 (resto), nao pode ser hrs, nem min, ja que 3600/60 = 60
					
					System.out.printf("A equipa de %d elementos, com o robot %s, realizou a prova em %02d:%02d:%02d\n", robos[i].elem, robos[i].nome, h, m, s);
				}
			}
		}
	}
		
	public static int addRobot(robot[] robos, int pos){
		robos[pos] = new robot(); //criar apontador
		
		System.out.print("Nome do Robot: ");
		do
		{
			robos[pos].nome = kb.nextLine();
		} while (robos[pos].nome.length() == 0);
		
		System.out.print("Tempo de prova: ");
		do
		{
			robos[pos].time = kb.nextInt();
		} while (robos[pos].time <= 0);
		
		System.out.print("Nº de elementos da equipa: ");
		do
		{
			robos[pos].elem = kb.nextInt();
		} while (robos[pos].elem <= 0);
		
		
		return ++pos; //incrementar e dps devolver
		
	}
	
	//imprimir o menu
	public static void PrintMenu(){
		System.out.printf("Micro-Rato 2013 - Gestao da prova:\n1 - Adicionar informacao relativa a um robo\n2 - Imprimir informacao dos robos em prova\n3 - Vencedor da prova e tempos medios de prova\n4 - Media do numero de elementos por equipa\n5 - Mostrar o nome dos robos em maiusculas\n6 - Alterar informacao de um robo\n7 - Remover robos da competicao\n8 - Gravar informacao da prova num ficheiro\n9 - Terminar o programa\n");
		}
}
class robot{
	String nome;
	int time, elem;	
	}
