import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Dê a NPA: ");
        int notaParcial = entrada.nextInt();

        if(notaParcial >= 60)
            System.out.println("O aluno está aprovado");
        else if(notaParcial < 60) {
            System.out.println("Está reprovado!");
            System.out.println("Dê a NP3: ");
            int notaRecuperada = entrada.nextInt();
            int media = notaRecuperada + notaParcial;
            if(media >= 50)
                System.out.println("Aprovado!");
            else
                System.out.println("Nos vemos próximo semestre.");
        }

        entrada.close();
    }
}
