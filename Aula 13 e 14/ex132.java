/*
 * Gestao de prova automovel com 10 participantes
 * 
 *  sugestao: qnd removem um piloto, podem confirmar se é o ultimo da lista //if (i == pos - 1) e simplesmente decrementam o pos...
 * no primeiro tbm...
 * 
 * codigo em comment na vallpatt é o output das cenas que ajuda a confirmar como verifica so os 3 padraos validos para cada matricula que exista
 * 
 */



import java.util.Scanner;
public class ex132 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
	piloto pilotos[] = new piloto[11]; //começa no 1... a 0 nunca e preenchida -> nao notei neste detail a escrever o prog, so a comentar, por isso aumento um valor ao array e fica tudo fine!
	
	menu();
	int op, pos = 0;
	do
	{
		System.out.print("Opcao -> ");
		op = kb.nextInt();
		switch (op)
		{
			case 0:
				menu();
				break;
			case 1:
				pos = inserir(pilotos);
				break;
			case 2:
				OrdViatura(pilotos, pos);
				break;
			case 3:
				AlterarPiloto(pilotos, pos);
				break;
			case 4:
				RemoverPiloto(pilotos, pos);
				break;
			case 5:
				OrdNome(pilotos, pos);
				break;
			case 6:
				RemoverPilotos(pilotos, pos);
				break;
			case 7:
				ValidarMatriculas(pilotos, pos);
				break;
			case 8:
				System.out.println("O programa vai terminar");
				break;
			default:
				System.out.printf("\nNova ");
		}
		
		
	} while (op != 8);
		
	}
	
	public static void ValidarMatriculas(piloto[] array, int pos){
		if (pos == 0)
			System.out.println("Nao existem pilotos na base de dados");
		else
		{
			for (int i = 1; i < pos; i++)
			{
				if (array[i].num != 0)
					if (!matchpattern(array[i].matricula))
					{
						System.out.printf("A matricula do piloto %d, de nome %s nao e valida\nPor favor introduza uma matricula da forma (AA-00-00), (00-00-AA), (00-AA-00)\nNova matricula: ", array[i].num, array[i].nome);
						do
						{
							array[i].matricula = kb.nextLine();
						} while (!matchpattern(array[i].matricula)); //passar a matricula como argumento para uma funcoa que valida essa matricula
					}
			}
		
			System.out.println("As matriculas sao todas validas");
		}
	}
	
	public static boolean matchpattern(String str){ 
		String patt[] = {"AA-00-00", "00-00-AA", "00-AA-00"};
		
		if (str.length() != 8)
			return false;
			
		boolean match;
		
		for (int j = 0; j < 3; j++) //testar um padrao de cada vez
		{
			
			//System.out.printf("j: %d\n", j);
			
			int cont = 0;
			for (int i = 0; i < 8 ; i++) //percorre caracter a caracter a matricula introduzida
			{
				match = false; //reset
			
				if (cont == 8) //contador -> qnd 8 caracteres forem validos, a matricula e valida
					return true;
					
			/*	
			 * LOG - Imprime a Verificação passo a passo
				System.out.printf("i: %d\n", i);
				System.out.printf("str(%d): %d\n", i, str.charAt(i));
				System.out.printf("patt(%d): %d\n", i, patt.charAt(i));
				System.out.printf("cont: %d\n", cont);
				
				System.out.println((Character.isUpperCase(str.charAt(i))));
				System.out.println(patt[j].charAt(i) == 'A');
				System.out.println(str.charAt(i) == '-');
				System.out.println(str.charAt(i) == '-');
				System.out.println(Character.isDigit(str.charAt(i)));
				System.out.println(patt[j].charAt(i) == '0');
			*/
			
				if (Character.isUpperCase(str.charAt(i))) //Se o caracter na matricula e maiscula
					{
						if(patt[j].charAt(i) == 'A') //se o padrao atual e valido -> a maiscula na matricula corresponde a A num dos padroes
							{
									match = true; //encontrou correspondencia
									cont ++;
									if (cont == 8) //contador -> qnd 8 caracteres forem validos, a matricula e valida
										return true;
									continue; //proximo char
							}
						}
				else if (str.charAt(i) == '-') //se na matricula o caracter é -
					{
						if(patt[j].charAt(i) == '-') //se o padrao atual e valido -> a -  na matricula corresponde um - no padrao
							{
									match = true; //encontrou correspondencia
									cont ++;
									if (cont == 8) //contador -> qnd 8 caracteres forem validos, a matricula e valida
										return true;
									continue; //proximo char
							}
					}
				else if (Character.isDigit(str.charAt(i))) //se na matricula o caracter e digito
					{
						if(patt[j].charAt(i) == '0') //se o padrao atual e valido -> a um digito na matricula tem de corresponder um 0 num dos padroes
							{
									match = true; //encontrou correspondencia
									cont ++;
									if (cont == 8) //contador -> qnd 8 caracteres forem validos, a matricula e valida
										return true;
									continue; //proximo char
							}
					}
				else 
					return false; //se a matricula nao tem nem Maisculas, nem Digitos nem -, chega a este else... A matricula e invalida, pois o caracter atual e invalido! 
					
					
				if (match) 
					cont++;
					
				else //se o caracter for valido -> ou e maiscula, digito ou -, mas nao corresponder com um padrao, e porque a matricula ou e invalida, ou esta escrita noutro padrao
					break; //sair do ciclo que percorre os caracteres da matricula, mudar de padrao (incrementar o primeiro ciclo)
					
				
				
			}
		}
		
		return false; //se chegar aqui, a matricula esta escrita so com Maisculas, digitos e -, mas nao corresponde a nenhum padrao válido portugues
	}
			
	//Remover Indices -> IndexOf
	public static void RemoverPilotos(piloto[] array, int pos){
		if (pos == 0)
			System.out.println("Nao existem pilotos na base de dados");
		else
		{
			System.out.print("Nome do Piloto: ");
			String nome;
			do
			{
				nome = kb.nextLine();
			} while (nome.length() == 0);
			
			boolean match = false;

			for (int i = 1; i < pos; i++)
			{
				if (array[i].num != 0) //entrada nao null
					if (array[i].nome.indexOf(nome) >= 0) //se encontrou a substring na string
						{
							match = true;
							System.out.printf("Numero do piloto: %d \nNome do piloto: %s\nRemover? 1 - Sim / 0 -Nao: ", array[i].num, array[i].nome);
							int answer;
							do
							{
								answer = kb.nextInt();
							} while (answer != 0 && answer != 1);
							
							if(answer == 1)
								{
									array[i] = new piloto();
									System.out.printf("Piloto Removido\n\n");
								}
							else
								System.out.println("Piloto nao removido");
								
							
						}
			}
			
			if (!match)
				System.out.println("Nao foi encontrado nenhum piloto com nome correspondente");
		}
	}
	
	//ordenar alfabeticamente por bubble sort
	public static void OrdNome(piloto[] array, int pos){
		if (pos == 0)
			System.out.println("Nao existem pilotos na base de dados");
		else
		{
			boolean swap;
			do
			{
				swap = false;
				for (int i = 1; i < pos - 1; i++)
				{
					if (array[i].num != 0 && array[i+1].num != 0) //entrada nao null
						if (array[i].nome.compareTo(array[i+1].nome) > 0)
							{
								piloto aux = array[i];
								array[i] = array[i+1];
								array[i+1] = aux;
								swap = true;
							}
				}
				
			} while (swap);	
			
			for (int i = 1; i < pos; i++)
			{
				if (array[i].num != 0) //entrada nao null
					System.out.printf("Piloto %d:\nNome: %s\nMatricula: %s\n", array[i].num, array[i].nome, array[i].matricula);
			}
		}			
	}	
	
	//remover indice
	public static void RemoverPiloto(piloto[] array, int pos){
		if (pos == 0)
			System.out.println("Nao existem pilotos na base de dados");
		else
		{
			System.out.print("Numero do Piloto: ");
			int num = kb.nextInt();
			
			boolean match = false;
			
			for (int i = 1; i < pos; i++)
			{
				if (array[i].num != 0) //entrada nao null
					if (array[i].num == num)
						{
						array[i] = new piloto();
						match = true;
						}
			}
			
			if (!match)
				System.out.println("Nao foi encontrado um veiculo com numero de piloto correspondente");
			else
				System.out.println("Piloto removido");
		}
	}
	
	//Alterar inf de um piloto
	public static void AlterarPiloto(piloto[] array, int pos){
		if (pos == 0)
			System.out.println("Nao existem pilotos na base de dados");
		else
		{
			System.out.print("Numero do Piloto: ");
			int num = kb.nextInt();
			
			boolean match = false;
			
			for (int i = 1; i < pos; i++)
			{
				if (array[i].num != 0) //entrada nao null
					if (array[i].num == num)// se encontrar correspondencia
						{
							System.out.print("Novo Nome: ");
							do
							{
								array[i].nome = kb.nextLine();
							} while (array[i].nome.length() == 0);
							
							
							System.out.print("Nova Matricula: ");
							array[i].matricula = kb.nextLine();
							match = true;
						}
			}
			
			if (!match)
				System.out.println("Nao foi encontrado um veiculo com numero de piloto correspondente");
		}
	}
	
	//ordenar de forma decrescente por num de viatura
	public static void OrdViatura(piloto[] array, int pos){
		if (pos == 0)
			System.out.println("Nao existem pilotos na base de dados");
		else
		{
			boolean swap;
			do
			{
				swap = false;
				for (int i = 1; i < pos - 1; i++)
				{
					if (array[i].num != 0) //entrada nao null
						if (array[i].num < array[i+1].num)
							{
								piloto aux = array[i]; 
								array[i] = array[i+1];
								array[i+1] = aux;
								swap = true;
							}
				}
				
			} while (swap);	
			
			for (int i = 1; i < pos; i++)
			{
				if (array[i].num != 0) //entrada nao null
					System.out.printf("Piloto %d:\nNome: %s\nMatricula: %s\n", array[i].num, array[i].nome, array[i].matricula);
			}
		}
	}
	
	public static int inserir(piloto[] array){
		for (int i = 1; i < 10; i++)
		{
			array[i] = new piloto(); //APONTAR SEMPRE PARA A CLASS!! senao obtem-se NullPointerException!
			
			System.out.print("Nome: ");
			
			if (i == 1)
			{
				String garbage = kb.nextLine(); //a primeira leitura e sempre vazia
			}	
				
			array[i].nome = kb.nextLine();
			
			if(array[i].nome.length() == 0) //condiçao de paragem -> length do nome ser 0
				return i;
				
			System.out.print("Matricula: ");
			array[i].matricula = kb.nextLine();
			
			array[i].num = i;
			
			
		}
		return 11; //se chegar ao fim, o array tem a dimensao maxima (ler comentario na declaraçao)
		//como o array tem 11 elementos, logo 0 - 10, e todos os outros ciclos sao <, retorno 11 e os ciclos começaram sempre de 1 ate 10... ou seja, os 10 elementos inicias do programa
	}

	public static void menu() {
		System.out.printf("Gestao de uma prova automovel:\n0 - Menu\n1 - Inserir informacao dos pilotos\n2 - Listar pilotos ordenados pelo numero da viatura\n3 - Alterar informacao de um piloto\n4 - Remover piloto com base no numero da viatura\n5 - Listar pilotos ordenados pelo nome\n6 - Remover piloto(s) com base no nome\n7 - Validar matriculas\n8 - Terminar o programa\n");
	}
}
class piloto {
	int num;
	String nome, matricula;
	
	}

