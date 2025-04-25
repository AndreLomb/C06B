package br.inatel.exInterface.animais;

import br.inatel.exInterface.Aquatico;
import br.inatel.exInterface.reino.Mamifero;

public class Lontra extends Mamifero implements Aquatico {
    public Lontra (String nome, double vida){
        super(nome, vida);
    }

    @Override
    public void emitirSom(){
        System.out.println("Lontra chiando!");
    }

    @Override
    public void nadar(){
        System.out.println("Lontra nadando");
    }
}
