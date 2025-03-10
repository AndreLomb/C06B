package Ex6;

public class Main {
    public static void main(String[] args) {
        Kart kart1 = new Kart();
        Kart kart2 = new Kart();

        kart1.nome = "kart1";
        kart2.nome = "kart2";

        kart1.motor.cilindradas = "150";
        kart1.motor.velocidadeMaxima = 120.3f;

        kart2.motor.cilindradas = "100";
        kart2.motor.velocidadeMaxima = 100f;

        Piloto piloto1 = new Piloto();
        Piloto piloto2 = new Piloto();

        piloto1.nome = "Mario";
        piloto2.nome = "Bowser";

        kart1.piloto = piloto1;
        kart2.piloto = piloto2;

        kart1.fazerDrift();
        kart1.motor.mostraInfo();

        kart2.soltarTurbo();
        kart2.motor.mostraInfo();
    }
}
