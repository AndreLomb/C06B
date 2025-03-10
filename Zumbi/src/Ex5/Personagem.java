package Ex5;

public class Personagem {
    String nomePersonagem;
    int pontosVida;

    int tomarDano(int pontosVida){
        this.pontosVida = pontosVida - 5;
        return pontosVida;
    }

    int usarArma(Arma arma){
        arma.resistencia = arma.resistencia - 2;
        return arma.resistencia;
    }
}
