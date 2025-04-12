package brownies;

public class BrownieCafe extends Brownie {

    public BrownieCafe (String nome, double preco, String sabor){
        super(nome, preco, sabor);
    }

    public void addCafe(){
        System.out.println(super.nome + " adicionando mais cafe");
    }

    @Override
    public void addCarrinhoCompras(){
        System.out.println("Este não é muito pedido, mas aqui está um de Café!");
    }
}
