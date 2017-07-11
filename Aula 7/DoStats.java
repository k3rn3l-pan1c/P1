import java.util.Scanner;

// Complete o programa
public class DoStats {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    // Cria um registo de estatisticas:
    Statistics xstat = new Statistics();
    
    // Enquanto houver um valor para ler:
    while (sc.hasNextDouble()) {
      // Lê um valor:
      double x = sc.nextDouble();
      
      // Atualiza o registo de estatisticas: GET IT!!
      updateStats(xstat, x);
    }
    
    // Escreve resultados:
    System.out.printf("min = %f\n", xstat.min);
    System.out.printf("max = %f\n", xstat.max);
    System.out.printf("numero de valores = %f\n", xstat.n);
    System.out.printf("soma dos valores = %f\n", xstat.soma);
    System.out.printf("soma dos quadrados = %f\n", xstat.soma2);
    System.out.printf("média = %f\n", mean(xstat));
    System.out.printf("variancia = %f\n", variance(xstat));
  }
	// Definir funções updateStats, mean e variance! DONE!!
	
	//funcao que atualiza as estatiscas
	public static void updateStats(Statistics xstat, double x){
		if (xstat.n == 0) //se o contador for == 0, e a primeira estatistica
			{
				//o min e o max tomam o valor dessa estatistica
				xstat.min = x; 
				xstat.max = x;
				}
		else {
			//se o contador e dif de 0, ja existem valores de estastisticas
			//comapara maximos e minimos
			if (x > xstat.max)
				xstat.max = x;
			if (x < xstat.min)
				xstat.min = x;
			}
		//independentemente da qnt de estatistcas
		xstat.soma +=x;
		xstat.soma2 += Math.pow(x,2);
		xstat.n++;
		}
		
		
	//calcula a media
	public static double mean(Statistics stats){
		return (stats.soma/stats.n);		
		}
		
	//calcula a variancia
	public static double variance(Statistics stats){
		return (((stats.soma2)/stats.n) - Math.pow(mean(stats),2));
		}
  
  
}
// Definir classe Statistics DONE!!
class Statistics{
	double min, max, n, soma, soma2;
	}
	

