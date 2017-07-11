/*
 * Agenda de Contactos
 * 
 * Nao valida os emails a 100% -> bom metodo de validacao na v2
 * 
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
import java.io.*;
public class ex125_v1 {
	
	public static Scanner kb = new Scanner(System.in);
	
	
	public static void main (String args[]) {
		pessoa contactos[] = new pessoa[100];
		menu();
		opcoes(contactos);
	}
	
	
	public static int Apagar(pessoa[] contactos, int pos){
		for (int i = 0; i < pos; i++)
		{
			contactos[i] = new pessoa();
		}
		System.out.printf("A agenda foi apagada\n\n");
		return 0;
		
	}
	public static String emailV(){
		String email;
		boolean ok = true; //supoe-se que o email e valido
		do
		{
			ok = true;
			System.out.print("Email: ");
			email = kb.nextLine();
			int a = 0;
			for (int k = 0; k < email.length(); k++)
			{
				
				char c = email.charAt(k);
				if (c == '@') a++;
				if (a > 1 && (((!Character.isDigit(c) && !Character.isLetter(c)) && !(c == '.' || c == '_')) || !Character.isLowerCase(c)))
				{	
					ok = false;
					break;	
				}
			} 
			if (a == 0)
				ok =  true;
		} while (!ok);
		
		
		return email;
		}	
	 
	public static void Validar(pessoa[] contactos, int pos){
		if (pos == 0)
			System.out.println("A lista de contactos encontra-se vazia");
		else
		{
			int a = 0;
			for (int i = 0; i < pos; i++)
			{
				a = 0; //encontrar o @
				for (int j = 0; j < contactos[i].email.length(); j++)
				{
					char c = contactos[i].email.charAt(j);
					System.out.println((!Character.isDigit(c) && !Character.isLetter(c)));
					System.out.println(!(c == '.' || c == '_'));
					System.out.println((!Character.isDigit(c) && !Character.isLetter(c)) && (!(c == '.' || c == '_')));
					System.out.println(!Character.isLowerCase(c));
					System.out.println(((!Character.isDigit(c) && !Character.isLetter(c)) && !(c == '.' || c == '_')) || !Character.isLowerCase(c));
					System.out.println(a == 2);
					System.out.println(a == 2  && (((!Character.isDigit(c) && !Character.isLetter(c)) && !(c == '.' || c == '_')) || !Character.isLowerCase(c))) ;
					System.out.println(a == 2  || ((!Character.isDigit(c) && !Character.isLetter(c)) && !(c == '.' || c == '_')) || !Character.isLowerCase(c)) ;
					if (c == '@')
						a++;
						System.out.println(a);
					if (a > 1  && (((!Character.isDigit(c) && !Character.isLetter(c)) && !(c == '.' || c == '_')) || !Character.isLowerCase(c)))
					{
						System.out.println(a);
						
						emailV();
						break;
					}	
				}
			}
			if (a == 0)
				emailV();
			System.out.println("Os emails foram validados com sucesso");
		 }
		
		}
		
		
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
					if (nomes[i].compareTo(nomes[j]) > 0)
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
				if (contactos[i].nome.indexOf(nome) >= 0)
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
		
		
		
		return ++pos;
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
	public static char readChar(){
		String prompt = new String();
		
		do
		{
			System.out.print("Opcao-> ");
			prompt = kb.nextLine();
		} while (prompt.length() != 1);
		
		char c = Character.toUpperCase(prompt.charAt(0));

		return c;
		}
}
class pessoa {
	String nome, morada, email;
	int ntel;
	}
