package brownies;

public class Comprador {
    protected String nome;
    protected double saldo;

    public Comprador(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }

    public void efetuarCompra(Brownie brownie){
        if(saldo > brownie.preco) {
            System.out.println(nome + " comprou um brownie de " + brownie.nome);
            saldo -= brownie.preco;
            System.out.println(nome + " agora tem " + saldo + " reais.");
        }
    }
}
