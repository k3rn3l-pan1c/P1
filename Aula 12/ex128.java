/*
 * 
 * 
 * Gerir uma biblioteca
 * 
 * NOTE: livros[i].data[x]-> x == 2, ano ; x == 1, meses; x == 0, dias
 */
 
 
 
import java.util.Scanner;
public class ex128 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		printMenu();
		livro livros[] = new livro[200];
		int pos = 0;
		int op;
		do
		{
			op = options();
			switch (op)
			{
				case 0:
					System.out.println();
					printMenu();
					break;
				case 1:
					pos = add(livros, pos);
					break;
				case 2: 
					remove(livros, pos);
					break;
				case 3:
					pos = Clear(livros, pos);
					break;
				case 4:
					UnrepetCotas(livros, pos);
					break;
				case 5: 
					ChangeStat(livros, pos);
					break;
				case 6:
					requesitados(livros, pos);
					break;
				case 7:
					OrdCota(livros, pos);
					break;
				case 8:
					OrdAta(livros, pos);
					break;
				case 9:
					System.out.println("O programa vai terminar!");
					break;					
			}
			
		} while (op != 9);
		
	} 
	
	//ordenar livros por data de aquisição -> Fusoa do bubble sort com o Selection Sort
	public static void OrdAta(livro[] livros, int pos){
		if (pos == 0)
			System.out.println("A base de dados encontra-se vazia");
		else
		{
			boolean swap;
			do
			{
				//NOTE: livros[i].data[x]-> x == 2, ano ; x == 1, meses, x == 0, dias
				
				swap = false;
				for (int i = 0; i < pos -1; i++)
				{
					if(livros[i].data[0] != 0) //pode ter sido apagado
					{
						if (livros[i].data[2] > livros[i+1].data[2]) //ordenar por anos 
						{
							livro aux = livros[i];
							livros[i] = livros[i+1];
							livros[i+1] = aux;
							swap = true;
						}
						
						if ((livros[i].data[2] == livros[i+1].data[2]) && (livros[i].data[1] > livros[i+1].data[1])) //se os anos forem iguais, ordenar por meses
						{
							livro aux = livros[i];
							livros[i] = livros[i+1];
							livros[i+1] = aux;
							swap = true;
						}
						
						if ((livros[i].data[2] == livros[i+1].data[2]) && (livros[i].data[1] == livros[i+1].data[1]) && (livros[i].data[0] > livros[i+1].data[0])) //se os anos e mese forem iguais, ordenar dias
						{
							livro aux = livros[i];
							livros[i] = livros[i+1];
							livros[i+1] = aux;
							swap = true;
						}
					}
				}
			} while (swap); //enquanto forem efetuadas trocas
			
			for (int i = 0; i < pos; i++)
			{
				if(livros[i].data[0] != 0) //pode ter sido apagado
					System.out.printf("Cota: %s\nAutor: %s\nTitulo: %s\nData: %02d-%02d-%02d\n\n", livros[i].cota, livros[i].autor, livros[i].titulo, livros[i].data[0], livros[i].data[1], livros[i].data[2]);
			}
			
		}
	}
	
	//ordenar por cota
	public static void OrdCota(livro[] livros, int pos){
		if (pos == 0)
			System.out.println("A base de dados encontra-se vazia");
		else
		{
			boolean swap;
			do
			{
				swap = false;
				for (int i = 0; i < pos -1; i++)
				{
					if(livros[i].data[0] != 0) //pode ter sido apagado
						if (livros[i].cota.compareTo(livros[i+1].cota) > 0) //se o caracter for "maior" no alfabeto que o caracter da proxima String
						{
							livro aux = livros[i];
							livros[i] = livros[i+1];
							livros[i+1] = aux;
							swap = true;
						}
				}
			} while (swap);
			
			for (int i = 0; i < pos; i++)
			{
				if(livros[i].data[0] != 0) //pode ter sido apagado
					System.out.printf("Cota: %s\nAutor: %s\nTitulo: %s\nData: %02d-%02d-%02d\n\n", livros[i].cota, livros[i].autor, livros[i].titulo, livros[i].data[0], livros[i].data[1], livros[i].data[2]);
			}
			
		}
	}
	
	//listar livros requesitados
	public static void requesitados(livro[] livros, int pos){
		if (pos == 0)
			System.out.println("A base de dados encontra-se vazia");
		else
		{
			boolean any = false;
			System.out.println("Livros requesitados");
			for (int i = 0; i < pos; i++)
			{
				if(livros[i].data[0] != 0) //pode ter sido apagado
					if (livros[i].estado == 'R')
					{
						System.out.printf("Cota: %s\nAutor: %s\nTitulo: %s\nData: %02d-%02d-%02d\n\n", livros[i].cota, livros[i].autor, livros[i].titulo, livros[i].data[0], livros[i].data[1], livros[i].data[2]);
						any = true;
					}
			}
			if (!any)
				System.out.printf("Nao existe nenhum livro requesitado\n\n");
		}
	}
	
	//mudar o estado do livro
	public static void ChangeStat(livro[] livros, int pos){
		if (pos == 0)
			System.out.println("A base de dados encontra-se vazia");
		else
		{
			boolean found = false;
			String cota = ValS(20, true, "Cota: "); //validar as strings da classe
			for (int i = 0; i < pos; i++)
			{
				if(livros[i].data[0] != 0) //pode ter sido apagado
					if (cota.compareTo(livros[i].cota) == 0)
					{
						livros[i].estado = GetStat("Novo Estado - (R)equesitado, (L)ivre, (C)ondicionado: ");
						found = true;
						break; //so um livro cm a mesma cota -> devia validar cotas antes! user do it
					}
			}
			if (!found)
				System.out.println("Nao existe nenhum livro com essa cota");			
		}
		
		
		
	}
	
	//mudar as cotas repetidas
	public static void UnrepetCotas(livro[] livros, int pos){
		if (pos == 0)
			System.out.println("A base de dados encontra-se vazia");
		else
		{
			boolean repet, ok = true;
			do
			{
				repet = false;
				for (int i = 0; i < pos -1; i++)
				{
					for (int j = i +1; j < pos; j++)
					{
						if(livros[i].data[0] != 0) //pode ter sido apagado
							if (livros[i].cota.compareTo(livros[j].cota) == 0) //duas cotas iguais
							{
								System.out.printf("\nEncontrados dois livros com cotas repetivas:\n%s (Cota: %s) e %s (Cota: %s)\n", livros[i].titulo, livros[i].cota, livros[j].titulo, livros[j].cota);
								livros[j].cota = ValS(20, true, ("Nova Cota de " + livros[i].titulo + ": ")); //substituir o [j]. Se i++ != j, entao j pode ser verificado again, caso a nova cota ja exista tbm
								repet = true;
								ok = false;
							}
					}
				}
			} while (repet);
			
			if(ok)
				System.out.println("As cotas estavam todas corretas");
			else
				System.out.println("Todas as cotas repetidas foram corrigidas");
		}
	}
	
	
	public static int Clear(livro[] livros, int pos){
		for (int i = 0; i < pos; i++)
		{
			livros[i] = new livro();
		}
		
		System.out.printf("\nA base de dados foi apagada\n");
		
		return 0;
	}
	
	public static void remove(livro[] livros, int pos){
		if (pos == 0)
			System.out.println("Nao existem livros para remover");
		else
		{
			boolean found = false;
			String cota;
			do
			{
				System.out.print("Cota: ");
				cota =  kb.nextLine();
			} while (cota.length() == 0);
			
			
			for (int i = 0; i < pos; i++)
			{
				if(livros[i].data[0] != 0) //pode ter sido apagado
					if (livros[i].cota.compareTo(cota) == 0)
					{
						livros[i] = new livro();
						found = true;
						break;					
					}
			}
			
			if (!found)
				System.out.print("Nao existe nenhum livro com essa cota");
			else
				System.out.println("O livro foi removido da base de dados");
		}
	}
		
	public static int add(livro[] livros, int pos){
		System.out.println("Novo livro");
		
		livros[pos] = new livro();
		
		livros[pos].cota = ValS(20, true, "Cota: ");
		
		livros[pos].autor = ValS(40, false, "Autor: ");
		
		livros[pos].titulo = ValS(60, false, "Titulo: ");

		System.out.print("Data de aquisicao (dd mm aa): ");
		livros[pos].data[0] = kb.nextInt();
		livros[pos].data[1] = kb.nextInt();
		livros[pos].data[2] = kb.nextInt();
		
		livros[pos].estado = GetStat("Estado Atual - (R)equesitado, (L)ivre, (C)ondicionado: ");
		
		return ++pos;
		}
		
	public static int options(){
		int op;
		do
		{
			System.out.print("Opcao -> ");
			op = kb.nextInt();
		} while (op < 0 || op > 9);
		
		return op;
	}
	
	//Validar Strings
	public static String ValS(int len, boolean Alfanumeric, String ask){
		String tmp;
		boolean fine = true;
		do
		{
			System.out.print(ask);
			do
			{
				tmp= kb.nextLine();
			} while (tmp.length() == 0 || tmp.length() > len); //obter uma string dentro da length valida
			
			for (int i = 0; i < tmp.length(); i++)
			{
				char c = tmp.charAt(i);
				if (Alfanumeric) //se sao permitidos caracteres alfanumericos
					if( !(Character.isDigit(c) || Character.isLetter(c) || c != ' ')) // se o caracter nao for letra nem digito ou espaco-> É simbolo 
						{
							fine = false;
							break;
						}
				
				
				else
					if( !(Character.isLetter(c) || c != ' ')) // se o caracter nao for letra ou espaco-> É simbolo ou num
						{
							fine = false;
							break;
						}
			}
		} while (!fine);
		
		
		return tmp;
	}
	
	//LEr estado -> read char com condiçoes mais especificas -> o char tem de ser Maisculo e so pode ser R L C
	public static char GetStat(String s){
		String prompt = new String();
		char c;
		do
		{
			System.out.print(s);
			do
			{
				prompt = kb.nextLine();
			} while (prompt.length() != 1);
			c = Character.toUpperCase(prompt.charAt(0));//upper case, caso o user tenha introduzido uma minuscula
		} while (c != 'R' && c != 'L' && c != 'C');
		
		return c;
	}

	public static void printMenu(){
		System.out.printf("Gestao de uma biblioteca\n0 - Imprimir o menu\n1 - Introduzir livro\n2 - Remover um livro\n3 - Apagar a base da dados\n4 - Verificacao de cotas repetidas\n5 - Alterar o estado de um livro\n6 - Listar os livros requisitados\n7 - Listar os livros ordenados pela cota\n8 - Listar os livros ordenados pela data\n9 - Terminar o programa\n");
		}
}

class livro{
	String cota, autor, titulo;
	int data[] = new int[3]; //array de int que guarda a data
	//NOTE: livros[i].data[x]-> x == 2, ano ; x == 1, meses, x == 0, dias
	char estado;
	}

