/* 
 * Operacoes com numeros complexos
 * 
 */



import java.util.Scanner;
public class ex74 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		Complexo a = new Complexo();  //complexo de entrada a
		Complexo b = new Complexo();  //complexo de entrada b
		Complexo out = new Complexo();  //complexo de saida
		String op; //string que guarda a operacao a efetuar
		
		do{
		System.out.print("Operaçao: ");
		op= sc.next();
		a = lerComplexo();
		b = lerComplexo();
		
		//chamar a funcao correspondente para a operacao introduzida e atribuir o valor da operacao ao Complexo out
		switch (op)
		{
			case "+": 
				out = add(a,b);
				
			case "-":
				out = sub(a,b);

			case "*":
				out = x(a,b);
				
			case "/":
				out = div(a,b);
				
				//caso a operacao seja valida, imprimir o complexo a, b e o resultado da sua operacao
				PrintComplexo(a);
				System.out.printf(" %s ", op);
				PrintComplexo(b);
				System.out.print(" = ");
				PrintComplexo(out);
				System.out.println();
				break;
			case "=":
				break;
			default:
				System.out.println("Operacao não permitida!");
				break;
		}
		} while(!op.equals("=")); //nao dava de outra maneira, damn it!! usar materia aula 8 :s
		
		System.out.print("O programa vai terminar...");
		
	}
	public static Complexo lerComplexo() //funcao que obtem pede ao utilizador um numero complexo e retorna um registo totalmente preenchdo
	{
		Complexo aux = new Complexo();
		System.out.println("Introduza um Numero Complexo");
		System.out.print("Parte Real: ");
		aux.r = sc.nextDouble();
		System.out.print("Parte Imaginária: ");
		aux.i = sc.nextDouble();
		return aux;
		}
		
	public static void PrintComplexo(Complexo out) //funcao que imprime um numero complexo na forma +-#.# +- #.#i
	{
		if (out.r < 0)
		System.out.printf("- %3.1f ", out.r);
		else System.out.printf(" %3.1f ", out.r);
		
		if (out.i < 0)
			System.out.printf("- %3.1fi ", out.i);
		else System.out.printf("+ %3.1fi ", out.i);
		}
		
	public static Complexo add(Complexo a, Complexo b) { //funcao que calcula a soma de dois numeros complexos
		Complexo aux = new Complexo();
		aux.r = a.r + b.r;
		aux.i = a.i + b.i;
		return aux;
		}
	
	public static Complexo sub(Complexo a, Complexo b) { //funcao que calcula a subtracao de dois numeros complexos
		Complexo aux = new Complexo();
		aux.r = a.r - b.r;
		aux.i = a.i - b.i;
		return aux;
		}
		
	public static Complexo x(Complexo a, Complexo b) { //funcao que calcula a multiplicacao de dois numeros complexos
		Complexo aux = new Complexo();
		aux.r = (a.r * b.r) - (a.i * b.i);
		aux.i = (a.i * b.r) + (a.r * b.i);
		return aux;
		}
	
	public static Complexo div(Complexo a, Complexo b) { //funcao que calcula a divisao de dois numeros complexos
		Complexo aux = new Complexo();
		aux.r = ((a.r * b.r) + (a.i * b.i))/((Math.pow(b.r,2) + Math.pow(b.i,2)));
		aux.i = ((a.i * b.r) - (a.r * b.i))/((Math.pow(b.r,2) + Math.pow(b.i,2)));
		return aux;
		}
}
class Complexo{ //registo de numeros complexos
	double r, i;
	}
/*
Deﬁna um registo (class Complexo) para representar um nu´mero complexo como um par de valores reais (r, i). 
* • Escreva uma fun¸ca˜o para ler um valor complexo. 
* • Escreva uma func¸˜ao que imprima um nu´mero complexo com o seguinte formato: #.#+/-#.#i (em que +/- depende do sinal da parte imagina´ria).
* • Escreva uma fun¸ca˜o para cada uma das opera¸co˜es seguintes: 
* – Adi¸ca˜o: a + bi + c + di = (a + c) + (b + d)i 
* - Subtra¸ca˜o: a + bi−c + di = (a−c) + (b−d)i – 
* Multiplica¸ca˜o: (a + bi)∗(c + di) = (ac−bd) + (bc + ad)i 
* – Divisa˜o: (a + bi)/(c + di) = ((ac + bd)/(c2 + d2)) + ((bc−ad)/(c2 + d2))i •
*  Escreva um programa (fun¸ca˜o main) que pe¸ca ao utilizador uma opera¸ca˜o (+ , - , * , / ) e dois operandos complexos, e apresente o resultado respetivo. 
* Deve repetir isso enquanto a opera¸c˜ao for diferente de ’=’.
* */
