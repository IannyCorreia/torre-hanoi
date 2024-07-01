import java.time.Duration; 
import java.time.Instant; //usado para medir um ponto especifico na linha do tempo
public class Main {
    public static void main(String[] args) {
        int[] instancias = {1, 10, 20, 30, 40, 41}; 
        TorreDeHanoi torre = new TorreDeHanoi(); 
        final int LIMITE_PARA_CALCULO_REAL = 30; 

        for (int n : instancias) { 
            System.out.println("Número de discos: " + n); 
            torre.resetarContador();

            if (n <= LIMITE_PARA_CALCULO_REAL) { 
                Instant inicio = Instant.now(); 
                torre.resolver(n, 'A', 'C', 'B'); 
                Instant fim = Instant.now(); 

                Duration tempoDecorrido = Duration.between(inicio, fim); 
                long horas = tempoDecorrido.toHours();
                long minutos = tempoDecorrido.toMinutes() % 60;
                long segundos = tempoDecorrido.getSeconds() % 60;
                long milissegundos = tempoDecorrido.toMillis() % 1000;

                System.out.printf("Total de movimentos: %d\n", torre.getContadorDeMovimentos()); 
                System.out.printf("Tempo decorrido: %02d:%02d:%02d:%03d\n", horas, minutos, segundos, milissegundos);
            } else {
                long movimentos = (long) Math.pow(2, n) - 1;
                System.out.printf("Total de movimentos (teórico): %d\n", movimentos);
                System.out.println("Tempo decorrido (teórico): Estimativa impossível de calcular com precisão para este número de discos, pois há um crescimento exponencial.");
            }
        }
    }
}
