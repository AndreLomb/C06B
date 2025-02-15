import java.util.Random;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numeroAleatorio, numeroProcurado;

        Random random = new Random();
        numeroAleatorio = random.nextInt(10) + 1;

        System.out.println("Bem vindo à roleta!");
        do{
            System.out.println("De 1 ao 10, qual número escolhi?");
            numeroProcurado = entrada.nextInt();
            if(numeroAleatorio > numeroProcurado)
                System.out.println("O meu é maior! Tente de novo!");
            else if(numeroAleatorio < numeroProcurado)
                System.out.println("O meu é menor! Tente de novo!");
        }while(numeroAleatorio != numeroProcurado);

        System.out.println("Eureka! Você venceu!");

        entrada.close();
    }
}
