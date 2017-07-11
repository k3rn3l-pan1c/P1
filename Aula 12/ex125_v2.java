/*
 * Agenda de Contactos
 * 
 * valida os emails
 * 
 * 
 */
 
import java.util.Scanner;
import java.io.*;
public class ex125_v2 {
	
	public static Scanner kb = new Scanner(System.in);
	
	
	public static void main (String args[]) {
		pessoa contactos[] = new pessoa[100];
		menu();
		opcoes(contactos);
	}
	
	//apagar uma agenda inteira -> fazer cada indice apontar para uma nova class
	public static int Apagar(pessoa[] contactos, int pos){
		for (int i = 0; i < pos; i++)
		{
			contactos[i] = new pessoa();
		}
		System.out.printf("A agenda foi apagada\n\n");
		return 0;
		
	}
	
	//verificar se um email e valido
	public static String emailV(String email, String nome){ //emails do tipo example._1@x12x.yy
		int cont; //posiçao
		boolean check; //true se o email e valido
		char c; //caracter na posiçao cont
		
		do
		{
			
			check = true;
			cont = 0; //posiçao
			
			do
			{	
				c = email.charAt(cont); //obter o caracter na posiçao que queremos
				
				if (Character.isUpperCase(c)) //os emails nao podem ter maisculas
				{
					check = false;
					break;
				}
				
				if (c != '@')  // se nao e @
					if (!(Character.isDigit(c) || Character.isLetter(c))) //Se nao e digito nem letra -> e um simbolo ou caracter branco
						if (!(c == '.' || c == '_')) // e se e diferente dos dois unicos sinais valido
						{
							check = false;
							break;
						}
				if (cont == email.length() - 1) //se chegar ao fim do email sem encontrar um arroba
				{
					check = false;
					break;
				}
				
				cont++;
			} while (c != '@'); //le ate ao arroba
			
			if (check) //se ainda for um email valido ate agr -> se for invalido nao se deve verificar mais nada
				do
				{	
					c = email.charAt(cont);
					
					if (Character.isUpperCase(c)) //os emails nao podem ter maisculas
					{
						check = false;
						break;
					}
					
					if (!(Character.isDigit(c) || Character.isLetter(c))) //Se nao e digito nem letra -> e um simbolo ou caracter branco
						if (c != '.') // se nao e ponto
						{
							check = false;
							break;
						}
					
					if (cont == email.length() - 1) //se chegar ao fim do email sem encontrar um ponto
					{
						check = false;
						break;
					}
				
					cont++;
				} while ( c != '.'); //ler ate ao ponto
				
			if (check)
				do
				{
					 c = email.charAt(cont);
					if (!(Character.isLowerCase(c))) //depois do ponto so sao aceites letras minusculas
					{
						check = false;
						break;
					}
					
					cont++;
				} while (cont != email.length());
			
			if(!check) //se o email e invalido -> corrigir -> ler email
			{
				System.out.printf("\nNome do contacto: %s\n", nome);
				System.out.print("Novo email: ");
				email = kb.nextLine(); //um email nao tem espaços
			}
			
		} while (!check);
		
		return email; //devolver o email validado
		}	
	
	//validar emails da lista
	public static void Validar(pessoa[] contactos, int pos){
		if (pos == 0)
			System.out.println("A lista de contactos encontra-se vazia");
		else
		{
			for (int i = 0; i < pos; i++)
				contactos[i].email = emailV(contactos[i].email, contactos[i].nome);
			
			System.out.printf("\nOs emails foram validados com sucesso\n");
		 }
		
		}
		
	//Ordenar por nome com Selection Sort
	public static void Ordenar(pessoa[] contactos, int pos){
		if (pos == 0)
			System.out.println("A lista de contactos encontra-se vazia");
		else
		{
			String[] nomes = new String[pos];
			for (int i = 0; i < pos ; i++)
			{
				nomes[i] = contactos[i].nome;
			}
			
			for (int i = 0; i < pos -1; i++)
			{
				for (int j = i +1; j < pos; j++)
				{
					if (nomes[i].compareTo(nomes[j]) > 0) //se o caracter i do nome j for "maior" no alfabeto, trocar
						{
								String aux;
								aux = nomes[i];
								nomes[i] = nomes[j];
								nomes[j] = aux;
						}
				}	
			}
			
			System.out.println("Nomes ordenados por ordem alfabetica");
			for (int i = 0; i < pos; i++)
			{
				System.out.println(nomes[i]);
			}
			
		}
	}
	
	//Mostrar dados
	public static void Mostrar(pessoa[] contactos, int pos){
		if (pos == 0)
			System.out.println("A lista de contactos encontra-se vazia");
		else
		{
			for (int i = 0; i < pos; i++)
				if (contactos[i].nome.compareTo("") == 0)
					System.out.printf("n%dº Contacto\nContacto apagado\n\n");
				else
					System.out.printf("\n%dº Contacto\nNome: %s\nMorada: %s\nNº Telefone: %d\nemail: %s\n", i+1, contactos[i].nome, contactos[i].morada, contactos[i].ntel, contactos[i].email);
		}
	}
	
	//Eliminar contacto por num tel
	public static void Eliminar(pessoa[] contactos, int pos){
		if (pos == 0)
			System.out.println("A lista de contactos encontra-se vazia");
		else
		{
			System.out.print("Numero de contacto: ");
			int num = kb.nextInt();
			boolean control = false;
			
			for (int i = 0; i < pos; i++)
			{
				if (contactos[i].ntel == num)
				{
					contactos[i].nome = "";
					contactos[i].morada = "";
					contactos[i].ntel = 0;
					contactos[i].email = "";
					System.out.println("Contacto eliminado");
					control = true;
				}
			}
			if (!control)
				System.out.println("Nao existe nenhum contacto com esse numero de telefone");
		}
	}
	
	//Full Search
	public static void Pesquisar(pessoa[] contactos, int pos){
		if (pos == 0)
			System.out.println("A lista de contactos encontra-se vazia");
		else
		{
			String nome;
			do
			{
				System.out.print("Nome do contacto: ");
				nome = kb.nextLine();
			} while (nome.length() == 0);
			
			boolean control = false;
			int i;
			for ( i = 0; i < pos; i++)
			{
				if (contactos[i].nome.indexOf(nome) >= 0) //se existir a subtring nome em contactos[i].nome, indexOf retorna o valor do indice, logo e maior que 0. Se nao existir retorna -1
				{
				System.out.printf("Contacto encontrado\nNome: %s\nMorada: %s\nNº Telefone: %d\nemail: %s\n\n", contactos[i].nome, contactos[i].morada, contactos[i].ntel, contactos[i].email);
					control = true;
					break;
				}
			}
			if(!control)
				System.out.println("O contacto nao existe na lista");
		}		
	}
		
	//Inserir uma pessoa
	public static int Insert(pessoa[] contactos, int pos){
		contactos[pos] = new pessoa();
		
		System.out.print("Nome: ");
		contactos[pos].nome = kb.nextLine();
		
		System.out.print("Morada: ");
		contactos[pos].morada = kb.nextLine();
		
		System.out.print("Nº de telefone: ");
		contactos[pos].ntel = kb.nextInt();
		
		System.out.print("email: ");
		do
		{
			contactos[pos].email = kb.nextLine();
		} while (contactos[pos].email.length() == 0);
		
		
		
		return ++pos; //incrementar pos e dps fazer o retorno
	}
		
		
	public static void opcoes(pessoa[] contactos){
		char opcao;
		int pos = 0;
		do
		{
			opcao = readChar();
			switch (opcao)
			{
				case 'I':
					pos = Insert(contactos, pos);
					break;
				case 'P':
					Pesquisar(contactos, pos);
					break;
				case 'E':
					Eliminar(contactos, pos);
					break;
				case 'M':
					Mostrar(contactos, pos);
					break;
				case 'O':
					Ordenar(contactos, pos);
					break;
				case 'V':
					Validar(contactos, pos);
					break;
				case 'A':
					pos = Apagar(contactos, pos);
					break;
				case 'T':
					System.out.println("O programa vai terminar");
					break;
				default:
					
			}
		} while (opcao != 'T');
	}
		
		
	public static void menu(){
		System.out.printf("Gestao de uma agenda:\n" 
		+ "I - Inserir um contacto\n"
		+ "P - Pesquisar contacto por nome\n" 
		+ "E - Eliminar um contacto\n" 
		+ "M - Mostrar os contactos\n" 
		+ "O - mostrar contactos Ordenados pelo nome\n"
		+ "V - Validar endere¸cos de email\n"
		+ "A - Apagar a agenda\n"
		+ "T - Terminar o programa\n");
		
		
		
	}
	
	//ler um caracter
	public static char readChar(){
		String prompt = new String();
		
		do
		{
			System.out.print("Opcao-> ");
			prompt = kb.nextLine();
		} while (prompt.length() != 1); //ler ate obter somente um caracter na String
		
		char c = Character.toUpperCase(prompt.charAt(0)); //fazer o UpperCase do caracter do indice 0 da string lida

		return c;
		}
}
class pessoa {
	String nome, morada, email;
	int ntel;
	}
