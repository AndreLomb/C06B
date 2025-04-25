package br.inatel.exInterface.main;

import br.inatel.exInterface.animais.Boi;
import br.inatel.exInterface.animais.Cachorro;
import br.inatel.exInterface.animais.Lontra;
import br.inatel.exInterface.reino.Mamifero;

public class Main{
    public static void main(String[] args) {
        Mamifero animal1 = new Lontra("Carlos", 100);
        Mamifero animal2 = new Boi("Betty", 500);
        Mamifero animal3 = new Cachorro("Yeller", 350);

        animal1.mostrainfo();
        animal2.mostrainfo();
        animal3.mostrainfo();

        animal1.emitirSom();
        animal2.emitirSom();
        animal3.emitirSom();
    }
}