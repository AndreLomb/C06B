package brownies;

public class BrownieChoco extends Brownie {
    public BrownieChoco(String nome, double preco, String sabor){
        super(nome, preco, sabor);
    }

    @Override
    public void addCarrinhoCompras(){
        System.out.println("Aqui está um brownie de chocolate.");
    };
    public void addChoco(){
        System.out.println(super.nome + " Adicionando mais choco");
    }
}
