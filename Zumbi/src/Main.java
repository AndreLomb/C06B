public class Main {
    public static void main(String[] args) {
        //criar instancias de uma classe
        Zumbi zumbi1 = new Zumbi();
        Zumbi zumbi2 = new Zumbi();

        zumbi1.nome = "Chris";
        zumbi2.nome = "Laura";

        /*
        * zumbi1.nome = "Chris";
        * zumbi1.nome = "Laura";
        *
        * a atribuição mais recente sobrescreve a informação na instância;
        *
        * */

        zumbi1.careca = false;
        zumbi2.careca = true;

        zumbi1.vida = 100;
        zumbi2.vida = 200;

        zumbi1.seAlimentar();
        zumbi2.correr();

        zumbi1.transfereVida(zumbi2, 20);

        System.out.println(zumbi1.vida);
        System.out.println(zumbi2.vida);
    }
}
