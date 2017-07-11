/* Jogo Alto-Baixo
 * 
 * O jogo AltoBaixo consiste em tentar adivinhar um numero (inteiro) entre 1 e 100. 
 * O programa escolhe um numero aleatoriamente. 
 * Depois, o utilizador insere uma tentativa e o programa indica se e demasiado alta, ou demasiado baixa. 
 * Isto e repetido ate o utilizador acertar no numero. O jogo acaba indicando quantas tentativas foram feitas. 
 * 
 * Dados: int secret = (int)(100.0*Math.random()) + 1;
 * 
 * Condicao de paragem: num = num aleatorio
 * 
 * 1) gerar num aleatorio
 * 2) Ler num do user
 * 3) Contar tentativa
 * 4) comparar com o num gerado e informar o user ate condicao de paragem = true
 * 5) qnd a condicao de paragem se verificar, dizer qntas tentativas foram feitas
 * 6) perguntar ao usar se quer executar o programa de novo
 */
 
 
import java.util.Scanner;
public class ex312 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in); 	
		int cont=0, attempt;
		
		int secret = (int)(100.0*Math.random()+1); //1 - gerar um numero random
		boolean n;
		do {
		
		do
		{
			cont++; //3
			
			//2
			System.out.printf("Tente adivinhar um numero aleatorio entre 1 e 100 \nIntroduza uma tentativa: ");
			attempt = sc.nextInt();
			
			//4
			if (attempt > secret)
					System.out.printf("Introduziu um numero muito alto \n\n");
			else 
				if (attempt < secret)
					System.out.printf("Introduziu um numero demasiado baixo \n\n");
				else
					System.out.printf("Introduziu o numero correto! \n\n");
			
			
		} while (attempt != secret);
		
		//5
		System.out.printf("\nRealizou " + cont + " tentativas\n");
		
		//6
		System.out.println("Pretende jogar mais?");
		String resp = sc.next();
		n = (resp.equals("n")); // n é true or false?? boolean n(nome da var) guarda essa inf
		
		cont = 0; // reinicia a variavel para não contar com as tentativas ja efetuadas
		System.out.println(); // da um espaço
		}while (n != true); //enquanto n não for true, ou seja, não se pretende terminar o jogo, este continua
		
		System.out.print("O programa vai terminar!");
	}
}

