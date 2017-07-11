/* Taxa de alcoolemia
 * 
 * 
 */


import java.util.Scanner;
public class ex75 {
	public static Scanner sc = new Scanner(System.in);
	
 	public static void main (String args[]) {
		user user1 = new user(); //novoa variavel do tipo de dados user (registo) 
		user1 = Ask(); //preenche o novo registo
		
		
		print(user1.name, tas(0.8, user1.ml, user1.alcool, user1.peso, coef(user1.sex, user1.jejum))); //chama a funcao de impressao e a tas
	}
	
	
	
	
	public static user Ask(){ //funcao qe obem todos os dados necessarios e retorna um refisto user preenchido
		user user = new user();
		System.out.print("Nome: ");
		user.name = sc.nextLine();
		
		System.out.print("Sexo? (1-Masculino) (2-Feminino): ");
		user.sex = my.getIntClose(1,2);
		
		System.out.print("Peso(kg): ");
		user.peso = sc.nextDouble();
		
		System.out.print("Quantidade de bebida ingerida(mL): ");
		user.ml = sc.nextDouble();
		
		System.out.print("Teor alcoólico da bebida(%): ");
		user.alcool = sc.nextDouble();
		
		System.out.print("Consumiu a bebida em jejum? (0-nao) (1-sim): ");
		user.jejum = my.getIntClose(0,1);
		return user;
		}
	
	//funcao que retorna o coeficinete passando em argumentoso sexo da pessoa e se consumiu ou nao em jejum a bebida
	public static double coef(int sex, int jejum)
	{
		if (jejum == 0)
			return 1.1;
		else if (sex == 1)
			return 0.7;
		else return 0.6;		
		}
	
	//funcao que calcula a tas, passando a densidade, quantidade de bebida, % de alcool, peso do individuo e coeficiente
	public static double tas(double dens, double ml, double alcool, double peso, double coef){ 
		double tascalc;
		tascalc = ((dens * ml * (alcool/100))/(peso * coef));
		return tascalc;
	}
	
	public static void print(String name, double tas){ //funcao que imprime o nome do individuo e a sua TAS, passadas por argumento
		System.out.printf("A taxa de alcool do individuo %s e cerca de %f", name, tas);
		}
}
		
class user //registo dos valores para calcular a TAS
{
	String name;
	double peso, ml, alcool;
	int jejum, sex;
	}
