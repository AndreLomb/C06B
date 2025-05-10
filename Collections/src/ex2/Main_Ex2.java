package ex2;

import ex2.arma.Arma;
import ex2.arma.armas.Chakram;
import ex2.arma.armas.Lança;

import java.util.ArrayList;
import java.util.List;

public class Main_Ex2 {
    public static void main(String[] args) {
        List<Arma> listaArmas = new ArrayList<Arma>();

        Arma chakram = new Chakram("Ib Veda", 8);
        Arma lance = new Lança("Alabarda", 6);

        listaArmas.add(chakram);
        listaArmas.add(lance);

        listaArmas.sort(null);

        for(Arma n : listaArmas){
            System.out.println(n.getNome() + " : " + n.getQualidade());
        }
    }
}
