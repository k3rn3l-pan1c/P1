/*
 * 
 * Gestão da pauta de uma disciplina
 * 
 * O array possui 300 indices, pos guarda os que estao preenchidos
 * 
 * NOTA: qnd e lido um 77, ou seja, nao foi ao exame ou wtv, eu coloco esse 77 a 0, visto que nao afeta pq so conta dps a melhor nota
 */
 
 
import java.util.Scanner;
import java.io.*;
public class ex134{
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) throws IOException{
		aluno alunos[] = new aluno[300];
		int op;
		int pos = 0;
		do
		{
			menu();
			op = getOP();
			switch (op)
			{
				case 1:
					pos = GetAllData(alunos);
					break;
				case 2:
					Imprimir(alunos, pos);
					break;
				case 3:
					infNotas(alunos, pos);
					break;
				case 4:
					alterarnotas(alunos, pos);
					break;
				case 5:
					histograma(alunos, pos);
					break;
				case 6:
					Save(alunos, pos);
					break;
				case 7:
					System.out.println("O programa vai terminar");
					break;
			}
			System.out.println();
		} while (op != 7);
		
	}
	
	//validar opcoes
	public static int getOP(){
		int op;
		do
		{
			System.out.print("Opcao -> ");
			op = kb.nextInt();
		} while (op < 1 || op > 7);
		
		return op;
		
		}
	
	//gravar os alunos que passaram num ficheiro
	public static void Save(aluno[] alunos, int pos) throws IOException{
		int cont = 0;
		
		//contar os alunos que tem positiva
		for (int i = 0; i < pos; i++)
		{
			if (alunos[i].ntfinal > 9.5)
				cont++;
		}
		
		aluno aprovados[] = new aluno[cont]; //criar um array so com a dimensoa dos alunos que tem positiva
		cont = 0;//reset
		
		for (int i = 0; i < pos; i++)//percorrer o array da disciplina
		{
			if (alunos[i].ntfinal > 9.5) //se o aluno tem positiva, copiar para o array dos alunos aprovados
			{
				aprovados[cont] = new aluno(); //apontar smp!
				aprovados[cont].nome = alunos[i].nome;
				aprovados[cont].mec = alunos[i].mec;
				aprovados[cont].normal = alunos[i].normal;
				aprovados[cont].recurso = alunos[i].recurso;
				aprovados[cont].ntfinal = alunos[i].ntfinal;
				cont++; //incrementar
			}
		}
		
		//ordenar bubble sort decrescente
		boolean swap;
		do
		{
			swap = false;
			for (int i = 0; i < cont - 1; i++)
			{
				if (aprovados[i].ntfinal < aprovados[i+1].ntfinal)
				{
					aluno aux = aprovados[i+1];
					aprovados[i+1] = aprovados[i];
					aprovados[i] = aprovados[i+1];
					swap = true;
				}
			}
		} while (swap);
		
		//gravar no ficheiro
		System.out.print("Nome do ficheiro: ");
		String name;
		do
		{
			name = kb.nextLine();
		} while (name.length() == 0);
		
		File  f = new File(name);
		
		PrintWriter pw = new PrintWriter(f);
		
		//imprimir no ficheiro -> mec, nota na epoca normal, nota na epoca de recurso, nota final, nome
		for (int i = 0; i < aprovados.length; i++)
		{
			pw.printf("%d %d %d %d %s\n", aprovados[i].mec, aprovados[i].normal, aprovados[i].recurso, aprovados[i].ntfinal, aprovados[i].nome);
		}
		pw.close();
		
	}
	
	//construir o histograma
	public static void histograma(aluno[] alunos, int pos){
		String[] hist = new String[21]; //array de String
		
		int max = 0; //num maximo de ocorrencias de uma nota
		
		//criar as referencias para todos os indices
		for (int i = 0; i < 21; i++)
		{
			hist[i] = new String();
		}
		
		
		for (int i = 0; i < pos; i++)
		{
			//if (hist[alunos[i].ntfinal] == null) // se o indice apontar para null, criar a referencia -> nao funciona
			//	hist[i] = new String();
			
			hist[alunos[i].ntfinal]+= '*';
			
			if ((hist[alunos[i].ntfinal].length()) > max) //num maximo de ocorrencias
				max = (hist[alunos[i].ntfinal].length());
		}
		
		//imprimir
		for (int i = max; i>=0; i--) //linhas  //decrescente, da ultimo asteriscos para o primeiro -> o 1 asteriscos e o mais abaixo
		{
			for (int j = 0; j < 21; j++) //colunas  //0 -20, notas validas
			{
				if(i < hist[j].length()) // se a string for mais pequena que o valor maximo, nao tem la nada -> nullPointerException -> assim, so imprime quando tem
				//lembrar que length = indice +1, por isso e que e <  e nao <=
					System.out.printf("%2c ", hist[j].charAt(i));
				else System.out.print("   "); 
			}
			System.out.println(); //mudar de linha qnd imprime a coluna inteira
		}
		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i < 21; i++) //imprimir as notas
		{
			System.out.printf("%2d ", i);
		}
		System.out.println();
		
	}
	
	//alterar as notas
	public static void alterarnotas(aluno[] alunos, int pos){
		System.out.print("Numero de mec: ");
		int mec = kb.nextInt();
		boolean control = false;
		for (int i = 0; i < pos; i++)
		{
			if(alunos[i].mec == mec)
			{
				System.out.printf("Aluno: %s\n", alunos[i].nome);
				System.out.print("Nota Normal: ");
				alunos[i].normal = filterNote(getGrade()); //filter note trata do caso de ser 77, get grade obtem uma nota valida
				System.out.print("Nota de recurso: ");
				alunos[i].recurso = filterNote(getGrade());
				control = true;
				if (alunos[i].normal >= alunos[i].recurso)
					alunos[i].ntfinal = alunos[i].normal;
				else if (alunos[i].recurso >= alunos[i].normal)
						alunos[i].ntfinal = alunos[i].recurso;
					else 
						alunos[i].ntfinal = 0;
			}
		}
		
		if(!control)
			System.out.println("Nao foi encontrado nenhum aluno com esse nº mec");
	}
	
	//informaçao sobre as notas
	public static void infNotas(aluno[] alunos, int pos){
		int soma = 0;
		
		for (int i = 0; i < pos; i++)
		{
			soma += alunos[i].ntfinal;
		}
		int media = (soma / pos);
		System.out.println("A media de classificações a disciplina e : " + media);
		
		int aprovados = 0, reprovados = 0;
		//inicializar ao 1 indice
		aluno best = new aluno();
		best.nome = alunos[0].nome;
		best.mec = alunos[0].mec;
		best.normal = alunos[0].normal;
		best.recurso = alunos[0].recurso;
		best.ntfinal = alunos[0].ntfinal;
		
		for (int i = 0; i < pos; i++)
		{
			if(alunos[i].ntfinal > best.ntfinal) //se existe um maior, alterar
			{
				best.nome = alunos[i].nome;
				best.mec = alunos[i].mec;
				best.normal = alunos[i].normal;
				best.recurso = alunos[i].recurso;
				best.ntfinal = alunos[i].ntfinal;		
			}
			
			//contar aprovados/reprovados
			if (alunos[i].ntfinal >= 9.5)
				aprovados++;
			else reprovados++;
		}
		
		System.out.printf("Foram aprovados %d alunos e reprovados %d alunos\n", aprovados, reprovados);
		System.out.printf("O melhor aluno e %s\nNºmec: %d\nAvaliação normal: %d\nAvaliação de Recurso: %d\nNota Final: %d\n\n", best.nome, best.mec, best.normal, best.recurso, best.ntfinal);
	} 
	
	//imprimir a pauta -> mec, nota da epoca normal, recurso, nota final
	public static void Imprimir(aluno[] alunos, int pos){
		System.out.printf("Pauta de uma disciplina\n------------------------\n");
		
		for (int i = 0; i < pos; i++)
		{
			System.out.printf("| %5d | %2d | %2d | %2d |\n", alunos[i].mec, alunos[i].normal, alunos[i].recurso, alunos[i].ntfinal);
		}
		System.out.printf("------------------------\n");
	}
	
	//contar entradas do ficheiro
	public static int counter(File f) throws IOException{
		int cont = 0;
		Scanner sc = new Scanner(f);
		
		
		while (sc.hasNextLine())
		{
			sc.nextLine();//avançar para a proxima linha
			cont++;	
		}
		
		return cont;
	}
	
	public static int GetAllData(aluno[] alunos) throws IOException{
		int pos = 0;
		File f;
		do
		{
			System.out.print("Nome do ficheiro: ");
			String name;
			do
			{
				name = kb.nextLine();
			} while (name.length() == 0);
			
			 f = new File(name);
		} while (!f.isFile() && !f.canRead());
		
		Scanner sc = new Scanner(f);
		
		while (sc.hasNextLine())
		{
			alunos[pos] = new aluno();
			alunos[pos].mec = sc.nextInt();
			do
			{
				alunos[pos].nome = sc.nextLine();
			} while (alunos[pos].nome.length() == 0);
			
			//a medida que le do ficheiro, preencher ja os dados -> poupa-se um for
			System.out.printf("Nºmec %d Aluno: %s\nNota por avaliação normal: ", alunos[pos].mec, alunos[pos].nome);
			alunos[pos].normal = filterNote(getGrade()); //filter note trata do caso de ser 77, get grade obtem uma nota valida
			System.out.print("Nota de recurso: ");
			alunos[pos].recurso = filterNote(getGrade());
			
			if (alunos[pos].normal >= alunos[pos].recurso)
				alunos[pos].ntfinal = filterNote(alunos[pos].normal);
			else if (alunos[pos].recurso >= alunos[pos].normal)
					alunos[pos].ntfinal = filterNote(alunos[pos].recurso);
				else 
					alunos[pos].ntfinal = 0;
			pos++;
		}
		
		return pos;
	}

	//obtem uma nota valida
	public static int getGrade(){
		int nota;
		do
		{
			nota = kb.nextInt();
		} while ((nota < 0 || nota > 20) && nota != 77);
		
		return nota;
	}
	
	//notas == 77 passam a 0
	public static int filterNote(int note){
		if (note == 77)
			return 0;
		else return note;
		
	}
	
	public static void menu(){
		System.out.printf("Servicos Academicos - Gestao de uma pauta:\n1 - Ler ficheiro com numeros mec. e pedir informacao de notas\n2 - Imprimir no terminal a informacao da disciplina\n3 - Calcular estatısticas das notas finais\n4 - Alterar as notas de um aluno\n5 - Imprimir um histograma de notas\n6 - Gravar num ficheiro a informacao da disciplina (ordenada)\n7- Terminar o programa\n");
		}
}

class aluno{
	String nome = new String();
	int mec, recurso, normal, ntfinal;
	
}
