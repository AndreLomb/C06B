package brownies;

public class BrownieDoceLeite extends Brownie{
    public BrownieDoceLeite(String nome, double preco, String sabor){
        super(nome, preco, sabor);
    }

    public void addDoceLeite(){
        System.out.println(super.nome + " adicionando mais doce de leite");
    }

    @Override
    public void addCarrinhoCompras(){
        System.out.println("Este é de Doce de leite.");
    }
}
