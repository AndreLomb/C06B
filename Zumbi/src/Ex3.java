public class Ex3 {
    public static void main(String[] args) {
        Zumbi z1 = new Zumbi();
        Zumbi z2 = new Zumbi();

        z1.vida = 100;
        z2.vida = 150;

        z1 = z2;

        z1.transfereVida(z2, 20);
        z2.transfereVida(z1, 30);

        System.out.println(z1.vida);
        System.out.println(z2.vida);
    }
}
