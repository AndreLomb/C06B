package br.inatel.pcmania.computador;

import br.inatel.pcmania.hardware.HardwareBasico;
import br.inatel.pcmania.memoriausb.MemoriaUSB;
import br.inatel.pcmania.sistemaoperacional.SistemaOperacional;

public class Computador {
    public String marca;
    public float preco;
    public MemoriaUSB musb;
    public HardwareBasico [] hardwares = new HardwareBasico[3];
    public SistemaOperacional os = new SistemaOperacional();

    public Computador(String marcaComputador, float precoComputador){
        this.marca = marcaComputador;
        this.preco = precoComputador;
    }

    public void mostraPCConfigs(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Preço: R$ " + this.preco);
        for(int i = 0; i < hardwares.length; i++){
            System.out.println(hardwares[i].nome + "-" + hardwares[i].capacidade);
        }
        System.out.println("OS nativo: " + os.nome + " Qte bits: x" + os.tipo + " -bits");

        if(musb != null){
            if(musb.capacidade >= 1000){
                System.out.println("Memória externa(HD): " + musb.nome + " de " + musb.capacidade + " TB");
            } else {
                System.out.println("Memória externa(UsB): " + musb.nome + " de " + musb.capacidade + " GB");
            }
        } else {
            System.out.println("Sem memória externa conectada.");
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb){
        this.musb = musb;
    }
}
