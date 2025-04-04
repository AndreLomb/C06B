package br.inatel.pcmania.main;

import br.inatel.pcmania.cliente.Cliente;
import br.inatel.pcmania.computador.Computador;
import br.inatel.pcmania.hardware.HardwareBasico;
import br.inatel.pcmania.memoriausb.MemoriaUSB;
import java.util.Scanner;

//matrícula = 2017
//preço promo1 = 2017
//preço promo2 = 3251
//preço promo3 = 7695

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Computador pc1 = new Computador("Apple", 2017);
        pc1.hardwares[0] = new HardwareBasico("Pentium Core i3", 2200);
        pc1.hardwares[1] = new HardwareBasico("Memória RAM", 8);
        pc1.hardwares[2] = new HardwareBasico("HD", 500);
        pc1.os.nome = "Linux Ubuntu";
        pc1.os.tipo = 32;

        MemoriaUSB musb1 = new MemoriaUSB();
        musb1.nome = "Pen-drive";
        musb1.capacidade = 16;
        pc1.addMemoriaUSB(musb1);

        Computador pc2 = new Computador("Samsung", 3251);
        pc2.hardwares[0] = new HardwareBasico("Pentium Core i5", 3370);
        pc2.hardwares[1] = new HardwareBasico("Memoria RAM", 16);
        pc2.hardwares[2] = new HardwareBasico("HD", 1000);
        pc2.os.nome = "Windows 8";
        pc2.os.tipo = 64;

        MemoriaUSB musb2 = new MemoriaUSB();
        musb2.nome = "Pen-drive";
        musb2.capacidade = 32;
        pc2.addMemoriaUSB(musb2);

        Computador pc3 = new Computador("Dell", 7695);
        pc3.hardwares[0] = new HardwareBasico("Pentium Core i7", 4500);
        pc3.hardwares[1] = new HardwareBasico("Memória RAM", 32);
        pc3.hardwares[2] = new HardwareBasico("HD", 2000);
        pc3.os.nome = "Windows 10";
        pc3.os.tipo = 64;

        MemoriaUSB musb3 = new MemoriaUSB();
        musb3.nome = "HD externo";
        musb3.capacidade = 1000;
        pc3.addMemoriaUSB(musb3);

        Cliente cliente = new Cliente();

        System.out.println("Bem-vindo à PCMania! Sinta-se à vontade para olhar nosso catálogo.");
        System.out.println("Se me permite perguntar, qual seu nome?");
        cliente.nome = input.nextLine();
        System.out.println("E seu CPF?");
        cliente.cpf = input.nextLong();


        int option;

        do{
            System.out.println("Bem vindo ao menu! Note que as memórias estão em Gb e RAM em Mhz");
            System.out.println("Eis aqui o PC1: ");
            pc1.mostraPCConfigs();
            System.out.println("Eis aqui o PC2: ");
            pc2.mostraPCConfigs();
            System.out.println("Eis aqui o PC3: ");
            pc3.mostraPCConfigs();
            System.out.println("1 - Compra PC 1");
            System.out.println("2 - Compra PC 2");
            System.out.println("3 - Compra PC 3");
            System.out.println("0 - termina suas compras");
            System.out.println("Faça sua escolha: ");

            option = input.nextInt();

            switch(option){
                case 1:
                    cliente.calculaTotalCompra(pc1);
                    System.out.println("PC 1 adicionado ao carrinho.");
                    break;
                case 2:
                    cliente.calculaTotalCompra(pc2);
                    System.out.println("PC 2 adicionado ao carrinho.");
                    break;
                case 3:
                    cliente.calculaTotalCompra(pc3);
                    System.out.println("PC 3 adicionado ao carrinho.");
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while(option != 0);

        System.out.println("Obrigado por comprar na PCMania, " + cliente.nome + "!");
        System.out.println("Seus PCs comprados foram:");
        for(Computador pc : cliente.computadores){
            if(pc != null){
                pc.mostraPCConfigs();
                System.out.println("------------");
            }
        }
        System.out.println("Total da compra: R$ " + cliente.calculaTotalCompra(null));
        System.out.println("CPF na nota: " + cliente.cpf);

        input.close();

    }
}
