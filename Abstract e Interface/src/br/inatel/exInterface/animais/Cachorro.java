package br.inatel.exInterface.animais;

import br.inatel.exInterface.reino.Mamifero;

public class Cachorro extends Mamifero {
    public Cachorro(String nome, double vida){
        super(nome, vida);
    }

    @Override
    public void emitirSom(){
        System.out.println("Cachorro latindo!");
    }
}
