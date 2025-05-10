import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_Ex1 {
    public static void main(String[] args) {
        List<Double> listaDouble = new ArrayList<Double>();

        listaDouble.add(13.49);
        listaDouble.add(2.57);
        listaDouble.add(76.92);
        listaDouble.add(8.42);
        listaDouble.add(50.13);

        System.out.println("Fora de ordem:\n");

        for(double numeros : listaDouble){
            System.out.println(numeros);
        }

        Collections.sort(listaDouble, Collections.reverseOrder());

        System.out.println("\n===============\n");

        System.out.println("Em ordem. (Decrescente)");

        for(double numeros : listaDouble){
            System.out.println(numeros);
        }
    }
}
