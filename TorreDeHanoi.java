public class TorreDeHanoi {
    private long contadorDeMovimentos;

    // Função recursiva
    public void resolver(int n, char origem, char destino, char auxiliar) {
        if (n == 0) {
            return;
        }
        resolver(n - 1, origem, auxiliar, destino); 
        contadorDeMovimentos++; 
        resolver(n - 1, auxiliar, destino, origem); 
    } 

    public long getContadorDeMovimentos() {
        return contadorDeMovimentos; 
    }

    public void resetarContador() {
        contadorDeMovimentos = 0;
    }
}

