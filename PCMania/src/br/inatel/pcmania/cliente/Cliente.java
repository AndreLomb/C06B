package br.inatel.pcmania.cliente;

import br.inatel.pcmania.computador.Computador;

public class Cliente {
    public String nome;
    public long cpf;
    public Computador [] computadores = new Computador[3];
    private int count = 0;

    public float calculaTotalCompra(Computador computador){
        if(count < computadores.length){
            computadores[count] = computador;
            count++;
        }
        float totalCompra = 0;
        for (int i = 0; i < count; i++) {
            if(computadores[i] != null)
                totalCompra += computadores[i].preco;
        }
        return totalCompra;
    }
}
