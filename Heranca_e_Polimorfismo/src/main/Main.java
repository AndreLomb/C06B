package main;

import brownies.*;

public class Main{
    public static void main(String[] args) {
        BrownieCafe bwCafe = new BrownieCafe("Bcafe", 5, "Cafe");
        BrownieDoceLeite bwLeite = new BrownieDoceLeite("Bleite", 8, "Doce de Leite");
        BrownieChoco bwChoco = new BrownieChoco("Bchoco", 10, "Café");

        bwCafe.addCarrinhoCompras();
        bwLeite.addCarrinhoCompras();
        bwChoco.addCarrinhoCompras();

        Comprador cliente = new Comprador("Chris", 50);
        cliente.efetuarCompra(bwChoco);

        bwCafe.calculaCompra();
        bwLeite.calculaCompra();
        bwChoco.calculaCompra();
    }
}