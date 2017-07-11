/*
 * 126 + gerir 10 turmas
 * 
 * Comments no 126
 * 
 * not debugged. In theory is working
 * 
 * 
 */





import java.util.Scanner;
public class ex127 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		aluno alunos[][] = new aluno[10][20];
		int opcao, turma = 0;
		int pos[] = new int[10];
		do
		{
			
			Menu();
			opcao = opcoes();
			if (opcao != 7)
				turma = selectT(); // ler a turma 
				//dps passar somente o vetor da turma em questão
			switch (opcao)
			{
				case 1:
					System.out.printf("\nTurma %d\n", turma);
					pos[turma] = InfTurma(alunos[turma]);
					break;
				case 2:
					System.out.printf("\nInformacao da turma %d\n", turma);
					MostrarInf(alunos[turma], pos[turma]);
					break;
				case 3:
					System.out.printf("\nTurma %d\n", turma);
					pos[turma] = Alterar(alunos[turma], pos[turma]);
					break;
				case 4:
					System.out.printf("\nTurma %d\n", turma);
					Ordmec(alunos[turma], pos[turma]);
					break;
				case 5:
					System.out.printf("\nTurma %d\n", turma);
					OrdNota(alunos[turma], pos[turma]);
					break;
				case 6:
					Media(alunos[turma], pos[turma], turma);
					break;
				case 7:
					Melhor(alunos[turma], pos[turma], turma);
					break;	
				case 0:
					System.out.println("O programa vai terminar");
					break;
			}
			
			System.out.println();
			
		} while (opcao != 0);
		
	}
	//ler turma
	public static int selectT(){
		int turma;
		
		do
		{
			System.out.print("Turma? ");
			turma = kb.nextInt();
		} while (turma < 0 || turma > 9);
		
		return turma;
		}
	
	public static void Melhor(aluno[] alunos, int pos, int turma){
		if (pos == 0)
			System.out.println("A turma encontra-se vazia");
		else
		{
			aluno best = alunos[0];
			for (int i = 1; i < pos; i++)
			{
				if (alunos[i].ntfinal > best.ntfinal)
				{
					best = alunos[i];
				}
				
			}
			
			System.out.printf("O melhor aluno da turma %d e: %s\nNº mec: %d\nNotas:\nMiniteste 1: %d\nAvaliacao Pratica Intercalar: %d\nMiniteste 2: %d\nExame Final: %d\nNota Final: %5.2f\n\n", turma, best.nome, best.mec, best.notas[0], best.notas[1], best.notas[2], best.notas[3], best.ntfinal);
		}
	}
		
	public static void Media(aluno[] alunos, int pos, int turma){
		if (pos == 0)
			System.out.println("A turma encontra-se vazia");
		else
		{
			double soma = 0.0;
			for (int i = 0; i < pos; i++)
			{
				soma += alunos[i].ntfinal;
			}
			
			System.out.printf("\nA media das notas finais da turma %d e: %.2f\n\n", turma, (soma / pos));
		}
	}
		
	public static void OrdNota(aluno[] alunos, int pos){
		if (pos == 0)
			System.out.println("A turma encontra-se vazia");
		else
		{
			aluno tmp[] = new aluno[pos];
		
			for (int i = 0; i < pos; i++)
			{
				tmp[i] = new aluno();
				
				tmp[i].mec = alunos[i].mec;
				tmp[i].nome = alunos[i].nome;
				tmp[i].notas[0] = alunos[i].notas[0];
				tmp[i].notas[1] = alunos[i].notas[1];
				tmp[i].notas[2] = alunos[i].notas[2];
				tmp[i].notas[3] = alunos[i].notas[3];
				tmp[i].ntfinal = alunos[i].ntfinal;
			}
			
			boolean swap;
			do
			{
				swap = false;
				for (int i = 0; i < tmp.length - 1; i++)
				{
					if(tmp[i].ntfinal > tmp[i+1].ntfinal)
					{
						aluno aux = tmp[i];
						tmp[i] = tmp[i+1];
						tmp[i+1] = tmp[i];
						swap = true;					
					}
				}
			} while (swap);
			
			for (int i = 0; i < pos; i++)
			{
				System.out.printf("\nNº mec: %d\nNome: %s\nNotas:\nMiniteste 1: %d\nAvaliacao Pratica Intercalar: %d\nMiniteste 2: %d\nExame Final: %d\nNota Final: %5.2f\n\n", tmp[i].mec, tmp[i].nome, tmp[i].notas[0], tmp[i].notas[1], tmp[i].notas[2], tmp[i].notas[3], tmp[i].ntfinal);	
			}
		}
	}
	
	public static void Ordmec(aluno[] alunos, int pos){
		if (pos == 0)
			System.out.println("A turma encontra-se vazia");
		else
		{
			aluno tmp[] = new aluno[pos];
		
			for (int i = 0; i < pos; i++)
			{
				tmp[i] = new aluno();
				
				tmp[i].mec = alunos[i].mec;
				tmp[i].nome = alunos[i].nome;
				tmp[i].notas[0] = alunos[i].notas[0];
				tmp[i].notas[1] = alunos[i].notas[1];
				tmp[i].notas[2] = alunos[i].notas[2];
				tmp[i].notas[3] = alunos[i].notas[3];
				tmp[i].ntfinal = alunos[i].ntfinal;
			}
			
			boolean swap;
			do
			{
				swap = false;
				for (int i = 0; i < tmp.length - 1; i++)
				{
					if(tmp[i].mec > tmp[i+1].mec)
					{
						aluno aux = tmp[i];
						tmp[i] = tmp[i+1];
						tmp[i+1] = tmp[i];
						swap = true;					
					}
				}
			} while (swap);
			
			for (int i = 0; i < pos; i++)
			{
				System.out.printf("\nNº mec: %d\nNome: %s\nNotas:\nMiniteste 1: %d\nAvaliacao Pratica Intercalar: %d\nMiniteste 2: %d\nExame Final: %d\nNota Final: %5.2f\n\n", tmp[i].mec, tmp[i].nome, tmp[i].notas[0], tmp[i].notas[1], tmp[i].notas[2], tmp[i].notas[3], tmp[i].ntfinal);	
			}
		}
	}
		
	public static int Alterar(aluno[] alunos, int pos){
		if (pos == 0)
			System.out.println("A turma encontra-se vazia");
		else
		{
			int mec;
			boolean found = false;
			
			System.out.print("Nº mec do aluno: ");
			do
			{
				mec = kb.nextInt();
			} while (mec <= 0);
			
			
			
			
			for (int i = 0; i < pos; i++)
			{
				if (mec == alunos[i].mec)
				{
					System.out.printf("Aluno(a) %s", alunos[i].nome);
					
					
					System.out.print("Nota Miniteste 1: ");
					alunos[i].notas[0] = kb.nextInt();
					
					System.out.print("Nota Avaliacao Pratica Intercalar: ");
					alunos[i].notas[1] = kb.nextInt();
					
					System.out.print("Nota Miniteste 2: ");
					alunos[i].notas[2] = kb.nextInt();
					
					System.out.print("Nota Exame Final: ");
					alunos[i].notas[3] = kb.nextInt();
					
					alunos[i].ntfinal = (0.1 * alunos[i].notas[0] + 0.3 * alunos[i].notas[1] + 0.1 * alunos[i].notas[2] + 0.5 * alunos[i].notas[3]);
					found = true;
					
					System.out.printf("As notas do aluno %s foram atualizadas", alunos[i].nome);
				}
			}
			
			if (!found)
			{
				System.out.print("O aluno nao foi encontrado ");
				
				if (pos == alunos.length -1)
					System.out.printf("e a turma ja se encontra cheia");
				else
				{
					alunos[pos] = new aluno();
					
					alunos[pos].mec = mec;
									
					System.out.print("Nome: ");
					do
					{
						alunos[pos].nome = kb.nextLine();
					} while (alunos[pos].nome.length() == 0);
					
					System.out.print("Nota Miniteste 1: ");
					alunos[pos].notas[0] = kb.nextInt();
					
					System.out.print("Nota Avaliacao Pratica Intercalar: ");
					alunos[pos].notas[1] = kb.nextInt();
					
					System.out.print("Nota Miniteste 2: ");
					alunos[pos].notas[2] = kb.nextInt();
					
					System.out.print("Nota Exame Final: ");
					alunos[pos].notas[3] = kb.nextInt();
					
					alunos[pos].ntfinal = (0.1 * alunos[pos].notas[0] + 0.3 * alunos[pos].notas[1] + 0.1 * alunos[pos].notas[2] + 0.5 * alunos[pos].notas[3]);
					
					System.out.printf("O aluno %s foi inserido na turma", alunos[pos].nome);
					
					return ++pos;
				}
			
			}
		}
		return pos;
	}
		
	public static void MostrarInf(aluno[] alunos, int pos){
		if (pos == 0)
			System.out.println("A turma encontra-se vazia");
		else
		{
			int mec;
			boolean found = false;
			
			System.out.print("Nº mec do aluno: ");
			mec = kb.nextInt();
			
			
			for (int i = 0; i < pos; i++)
			{
				if (mec == alunos[i].mec)
				{
					System.out.printf("\nNº mec: %d\nNome: %s\nNotas:\nMiniteste 1: %d\nAvaliacao Pratica Intercalar: %d\nMiniteste 2: %d\nExame Final: %d\nNota Final: %5.2f\n\n", alunos[i].mec, alunos[i].nome, alunos[i].notas[0], alunos[i].notas[1], alunos[i].notas[2], alunos[i].notas[3], alunos[i].ntfinal);	
					found = true;
				}
			}
			
			if (!found)
				System.out.printf("O aluno nao foi encontrado\n\n");
		}
	}
		
	public static int InfTurma(aluno[] alunos){
		int i;
		for (i = 0; i < alunos.length; i++)
		{
			alunos[i] = new aluno();
			System.out.printf("Aluno Nº%d\n", i+1);
			System.out.print("Nº mec: ");
			alunos[i].mec = kb.nextInt();
			
			if (alunos[i].mec == 0)
				return i;
				
			System.out.print("Nome: ");
			do
			{
				alunos[i].nome = kb.nextLine();
			} while (alunos[i].nome.length() == 0);
			
			System.out.print("Nota Miniteste 1: ");
			alunos[i].notas[0] = kb.nextInt();
			
			System.out.print("Nota Avaliacao Pratica Intercalar: ");
			alunos[i].notas[1] = kb.nextInt();
			
			System.out.print("Nota Miniteste 2: ");
			alunos[i].notas[2] = kb.nextInt();
			
			System.out.print("Nota Exame Final: ");
			alunos[i].notas[3] = kb.nextInt();
			
			alunos[i].ntfinal = (0.1 * alunos[i].notas[0] + 0.3 * alunos[i].notas[1] + 0.1 * alunos[i].notas[2] + 0.5 * alunos[i].notas[3]);
			System.out.println();
		}
		
		return i;
	}
	
	public static int opcoes(){
		boolean val = true;
		int opcao;
		do
		{
			System.out.print("Opcao? ");
			opcao = kb.nextInt();
			if  (opcao < 0 || opcao > 7)
				val = false;
		} while (!val);
		
		return opcao;
	}
	
	public static void Menu(){
		System.out.printf("Gestao de turmas:\n1 - Inserir informacao da turma\n2 - Mostrar informacao de um aluno\n3 - Alterar informacao de um aluno\n4 - Listar os alunos ordenados por no mec.\n5 - Listar os alunos ordenados por nota final\n6 - Media das notas finais\n7 - Melhor aluno\n0 - Terminar o programa\n");
		}
		
}
class aluno{
	int mec;
	String nome;
	int[] notas = new int[4];
	double ntfinal;
	}

