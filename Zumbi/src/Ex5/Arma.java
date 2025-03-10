package Ex5;


public class Arma {
    String nome;
    int poder;
    int resistencia;
    String descricao;

    void mostraInfoArma(String nome, int poder, int resistencia, String descricao){
        this.nome = nome;
        this.poder = poder;
        this.resistencia = resistencia;
        this.descricao = descricao;

        System.out.println("Nome da arma: " + this.nome);
        System.out.println("Poder da arma: " + this.poder);
        System.out.println("Resistência: " + this.resistencia);
        System.out.println("Descrição: " + this.descricao);
    }
}
