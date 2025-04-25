package br.inatel.exInterface.reino;

public abstract class Mamifero {
    protected String nome;
    protected double vida;

    public Mamifero(String nome, double vida){
        this.nome = nome;
        this.vida = vida;
    }

    public abstract void emitirSom();

    public void mostrainfo(){
        System.out.println(" Este animal se chama:" + nome + " e tem " + vida + " de vida.");
    }
}
