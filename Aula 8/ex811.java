/* MODO PEDREIRO!!!!
 * 
 * Clube de Natação
 * 
 * not full debugged(?)
 * 
 */


import java.util.Scanner;
public class ex811 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		utente pessoa = new utente();
		
		Fill(pessoa);
		
		print(pessoa);
		
	}
	
	
	public static void print(utente pessoa){
		double ins;
		if (pessoa.inscricao == 1)
			ins = 50.00;
		else ins = 30.00;
		
		double pay = pessoa.hrs * 4 *  pessoa.mes; //inicializacao ao numero de hrs totais
		
		if (pessoa.modl == 1) //multiplicar pelo preço das hrs dependendo da categoria
			pay *=  4;
		else pay *= 6;
		
		if (pessoa.fam >= 2)
			pay -= pay*0.25; //pay = pay - pay*0.25;
		else pay -= pay * 0.1 * pessoa.fam; //se pessoa.fam == 0, nao altera o valor. se 1, 10% desconto 
		
		String s;
		if (pessoa.inscricao == 1)
			s = "Primeira Vez";
		else s = "Ja inscrito";
		
		String s2;
		if (pessoa.modl == 1)
			s2 = "Iniciacao";
		else s2 = "Aperfeicoamento";
		
		System.out.printf("\nNova Inscricao para o Clube de Natacao\nNome: %s\n%s\n%d horas de %s\n%d Familiar\n--------------------------------------------------\nItem                 Quantidade              Valor\nInscricao                     1              %5.2f\nMensalidade                   %d              %5.2f\n--------------------------------------------------\nTotal %44.2f", pessoa.nome, s, pessoa.hrs, s2, pessoa.fam, ins, pessoa.mes, pay, (ins + pay));
		
		
		
		
		
		} 
	
	public static void Fill(utente pessoa){
		System.out.print("Nome: ");
		do
		{
			pessoa.nome = kb.nextLine();
		} while (pessoa.nome.length() == 0);
		
		
		
		System.out.print("Modalidade - Iniciacao(1) ou Aperfeicoamento(2): ");
		do
		{
			 pessoa.modl = kb.nextInt();
		} while (pessoa.modl != 1 && pessoa.modl != 2);
		
		System.out.print("Numero de horas de pratica semanal, 1 a 10: ");
		do
		{
			pessoa.hrs = kb.nextInt();
		} while (pessoa.hrs < 1 && pessoa.hrs > 10);
		
		System.out.print("Numero e familiares a frequentar o clube (0 se nao tiver nenhum): ");
		do
		{
			pessoa.fam = kb.nextInt();
		} while (pessoa.fam < 0);
		
		System.out.print("Numero de meses que ira frequentar as aulas: ");
		do
		{
			pessoa.mes = kb.nextInt();
		} while (pessoa.mes < 1);
		
		System.out.print("E a sua primeira inscricao? Sim(1) ou Nao(2): ");
		do
		{
		pessoa.inscricao = kb.nextInt();
		} while (pessoa.inscricao != 1 && pessoa.inscricao != 2);
		
		
	}
}

class utente {
	String nome;
	int modl, hrs, fam, mes, inscricao;
	}
