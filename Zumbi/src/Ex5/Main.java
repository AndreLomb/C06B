package Ex5;

public class Main {
    public static void main(String[] args) {
        Arma arma = new Arma();
        Personagem personagem = new Personagem();

        personagem.nomePersonagem = "Chris";
        System.out.println("O seu nome é: " + personagem.nomePersonagem);

        arma.mostraInfoArma("AK-47", 40, 60, "Uma metralhadora confiável de longo alcance.");

        System.out.println("Quanto de vida seu personagem tem? vida = " + personagem.tomarDano(100));
        System.out.println("Os novos pontos de vida do personagem são: " + personagem.pontosVida);

        System.out.println("Os pontos de resistência da arma são: " + personagem.usarArma(arma));
    }
}
