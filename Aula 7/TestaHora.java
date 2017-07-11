import java.util.Scanner;

public class TestaHora {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    Hora inicio;  // tem de definir o novo tipo Hora!
    Hora fim;
    
    inicio = new Hora(); //criar novo tipo de dados, hora
    
    //inicializar
    inicio.hr = 9;
    inicio.min = 23;
    inicio.seg = 5;
    
    
    System.out.print("Começou às ");
    printHora(inicio);  // crie esta função! DONE!!
    
    System.out.println(".");
    
    System.out.println("Quando termina?");
    fim = lerHora();  // crie esta função! DONE!!
    
    //imprimir o resultado
    System.out.print("Início: ");
    printHora(inicio);
    System.out.print(" Fim: ");
    printHora(fim);
  }
  // funcao que imprime a hora
  public static void printHora(Hora aux){
	
	  System.out.printf("%02d:%02d:%02d", aux.hr, aux.min, aux.seg);
	  }
	
	//funcao que preenche o registo hora
	public static Hora lerHora(){;
		Hora fim = new Hora();
		System.out.print("Hora: ");
		fim.hr = my.getIntClose(0,23); //funcao que devolve um valor pertencente ao intervalo [0,23]
		System.out.print("Min: ");
		fim.min = my.getIntClose(0,59); //funcao que devolve um valor pertencente ao intervalo [0,59]
		System.out.print("Seg: ");
		fim.seg = my.getIntClose(0,59); //funcao que devolve um valor pertencente ao intervalo [0,59]
		return fim; //retornar um registo de horas preenchido
}
} 
//class das horas
class Hora
	{
	int hr, min, seg;	
	}
	
/**
EXEMPLO do pretendido:
$ java TestaHora
Começou às 09:23:05.
Quando termina?
horas? 11
minutos? 72
minutos? 7
segundos? 2
Início: 09:23:05 Fim: 11:07:02.
**/
