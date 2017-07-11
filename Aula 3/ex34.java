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
 * 3) comparar com o num gerado e informar o user ate condicao de paragem = true
 * 4) qnd a condicao de paragem se verificar, dizer qntas tentativas foram feitas
 */
 
 
import java.util.Scanner;
public class ex34
{
	
	public static void main (String args[]) 
	{
		Scanner sc = new Scanner(System.in); 	
		int cont=0, attempt;
		
		//1
		int secret = (int)(100.0*Math.random()+1); //gerar um numero random
		
		do
		{
			cont++; //3
			
			//2
			System.out.printf("Tente adivinhar um numero aleatorio entre 1 e 100 \nIntroduza uma tentativa: ");
			attempt = sc.nextInt();
			
			//3
			if (attempt > secret)
					System.out.printf("Introduziu um numero muito alto \n\n");
			else 
				if (attempt < secret)
					System.out.printf("Introduziu um numero demasiado baixo \n\n");
				else
					System.out.printf("Introduziu o numero correto! \n\n");
			
			
		} while (attempt != secret); //4
		
		System.out.printf("\nRealizou " + cont + " tentaivas");
		}
}


