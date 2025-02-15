import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Dê o número de alunos matriculados em C06:");
        int numeroAlunos = entrada.nextInt();

        System.out.println("Onde as aulas serão ministradas?");
        switch (numeroAlunos) {
            case 10, 20:
                System.out.println("A sala de aula é a I-16");
                break;
            case 30:
                System.out.println("A sala de aula é I-22");
                break;
            default:
                System.out.println("Insira a quantidade de alunos adequada (10; 20 ou 30)");
        }
    entrada.close();
    }
}