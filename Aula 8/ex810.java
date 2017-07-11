/*
 * 
 * 
 * IMC
 * 
 * 
 * 
 * 
 */
 
 
import java.util.Scanner;
public class ex810 {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static void main (String args[]) {
		individuo pessoa = new individuo();
		
		fill(pessoa);
		
		System.out.println();
		
		printData(pessoa);
	}
	
	public static void printData(individuo tmp){
		System.out.printf("|--------------------------------------|\n| Calculo do Indice de Massa Corporal  |\n|--------------------------------------|\n| Nome: %30s |\n| Sexo: %9s                      |\n| IMC : %4.1f (kg/m2)                   |\n| Comentario: %18s       |\n|--------------------------------------|", tmp.nome, tmp.sexo, calcIMC(tmp.peso, tmp.altura), matchIMC(calcIMC(tmp.peso, tmp.altura)));

		
		
		}
	
	public static String matchIMC(double IMC){
		if (IMC <= 18.5)
			return "Abaixo do peso";
		else if (IMC >= 18.6 && IMC <= 24.9)
			return "Saudavel";
		else if (IMC >= 25.0 && IMC <= 29.9)
			return "Peso m excesso";
		else if (IMC >= 30.0 && IMC <= 34.9)
			return "Obesidade Grau I";
		else if (IMC >= 35.0 && IMC <= 39.9)
			return "Obesidade Garu II";
		else //if (IMC >= 40.0) -> nao e necessario
			return "Obesidade Grau III";
		}
	
	public static double calcIMC(double peso, double altura){ //so o valor numerico
		
		 return (peso / (altura * altura));
		}
		
	//prencher elemento da classe
	public static void fill(individuo temp){
		System.out.print("Nome: ");
		temp.nome = kb.nextLine();
		temp.anos = lerInt(18, "Idade: ");
		temp.sexo = lerSexo();
		temp.peso = lerDouble(0.0, "Peso(kg): ");
		temp.altura = lerDouble(0.0, "Altura(m): ");
		}
	
	//ler int maior ou igula que o limite inferior fornecido
	public static int lerInt(int low, String ask){
		int tmp;
		do
		{
			System.out.print(ask);
			tmp = kb.nextInt();
		} while (tmp < low);
		
		return tmp;
	}
	
	//ler double maior ou igula que o limite inferior fornecido
	public static double lerDouble(double low, String ask){
		double tmp;
		do
		{
			System.out.print(ask);
			tmp = kb.nextDouble();
		} while (tmp < low);
		
		return tmp		;
	}
		
	public static String lerSexo(){
		String s = new String();
		s = kb.nextLine(); //ler a linha vazia
		
		do
		{
			System.out.print("Sexo (M/F): ");
			s = kb.nextLine();
		} while (s.charAt(0) != 'M' && s.charAt(0) != 'F' || s.length() != 1); //enquanto nao for um F o M, exclusivamente
		
		
		if (s.charAt(0) == 'M')
			return "Masculino";
		else return "Feminino"; // o else funciona devido a validacao..
		
		}
}
class individuo{
	String nome, sexo;
	int anos;
	double peso, altura;
		
	}
