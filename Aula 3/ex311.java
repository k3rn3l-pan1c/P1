/* Seqencia de numeros impares
 * 
 * Dados: 
 * dado um numero indeterminado de numeros inteiros positivos introduzidos pelo teclado, 
 * veriﬁque se os numeros lidos constituem uma sequencia exclusivamente constituıda por numeros ımpares. 
 * 
 * Condicao de paragem: num = 0
 * 
 * 1) ler num (ciclo repetitivo)
 * 2) verificar se existe um caso em que num e impar e bloquear a alteracao de valor da variavel booleana
 * 3) print

 */


import java.util.Scanner;
public class ex311 {
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		boolean impar = true;
		
		//1
		do
		{
			System.out.print("Numero: ");
			num = sc.nextInt();
			
			//2 - qnd o num e par e nao e zero(pois zero e o numero de fim de ciclo) entra dentro do if e imapr == false
			// a cond imapr == true pretende apenas poupar atribuicoes, pois basta apenas encontrar um par para a sequecia ja nao ser toda de nums impares
			if (((num % 2 == 0) && (impar == true)) && (num != 0)) // tbm pode ser resolvido com um cont - qnd encontra um par, cont muda de valor e nunca mais a condição e true
				impar = false;
		} while (num != 0);
		
		//3
		if (impar == true) System.out.println("Os numeros introduzidos sao todos impares");
		else System.out.print("Os numeros introduzidos nao são todos impares");
	}
}

