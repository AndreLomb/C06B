package Ex1;

public class Main {
    public static void main(String[] args) {
        Zumbi zumbi = new Zumbi();

        zumbi.nome = "Carlos";
        //Tempo => Meses.Dias
        zumbi.tempoDecomposicao = 4.2;
        zumbi.quantidadeCerebros = 38;

        System.out.println("Qual o nome do zumbi?");
        System.out.println(zumbi.nome);
        System.out.println("Quanto tempo está tornado?");
        System.out.println(zumbi.tempoDecomposicao);
        System.out.println("Quantos cérebros consumiu?");
        System.out.println(zumbi.quantidadeCerebros);
    }
}