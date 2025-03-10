public class Zumbi {

    String nome;
    String genero;
    boolean careca;
    int forca;
    double vida;
    boolean transferOK = false;

    void correr(){
        System.out.println(nome + " está correndo!");
    }

    void seAlimentar(){
        System.out.println(nome + " está se alimentando.");
        vida++;
    }

    double mostraVida(){
        return this.vida;
    }

    void transfereVida(Zumbi zumbiAlvo, double quantidade) {
        /*
        * if(quantidade <= 0 | quantidade > vida){
            System.out.println("Transferência inválida");
            return;
        }
        * */
        if (quantidade >= 0) {
            System.out.println("Transferência de vida = " + (transferOK = true));
            vida -= quantidade;
            zumbiAlvo.vida += quantidade;
            System.out.println(nome + " transferiu " + quantidade + " de vida para " + zumbiAlvo.nome);
        }
        else {
            System.out.println(transferOK);
        }
    }
}
