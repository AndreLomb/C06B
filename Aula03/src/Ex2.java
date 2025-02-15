import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Dê o valor do lanche 1:");
        int lanche1 = Scanner.nextInt();
        System.out.println("Dê o valor do lanche 2:");
        int lanche2 = Scanner.nextInt();
        System.out.println("Dê o valor do lanche 3:");
        int lanche3 = Scanner.nextInt();

        int somaLanches = lanche1 + lanche2 + lanche3;
        System.out.println("A soma de lanches é: " + somaLanches);

        int mediaLanches = somaLanches / 3;
        System.out.println("A média de lanches é:" + (float)mediaLanches);

        Scanner.close();
    }
}
