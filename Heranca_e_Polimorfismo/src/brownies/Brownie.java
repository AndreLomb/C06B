package brownies;

public class Brownie {
    protected String nome;
    protected double preco;
    protected String sabor;

    public Brownie(String nome, double preco, String sabor){
        this.nome = nome;
        this.preco = preco;
        this.sabor = sabor;
    }

    public void addCarrinhoCompras(){
        System.out.println("Adicionando um : " + nome);
    }

    public void calculaCompra(){
        System.out.println("Total de " + nome + ": " + preco);
    }
}
