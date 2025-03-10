package Ex6;

public class Kart{
    String nome;
    Piloto piloto;
    Motor motor;

    public Kart(){
        motor  = new Motor();
    }

    void pular(){
        System.out.println(nome + " está pulando.");
    }

    void soltarTurbo(){
        System.out.println(nome +" esta soltando turbo");
    }

    void fazerDrift(){
        System.out.println(nome +" esta fazendo drift");
    }
}
