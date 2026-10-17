public class Gorev2_SensorDemo {
    public static void main(String[] args) {
        Sensor s = new Sensor("TRB-01", "C");

        System.out.println("Baslangic : " + s.toString());

        System.out.println("\n--- Gecerli olcumler ---");
        System.out.println("olc(21.5)  -> " + s.olc(21.5));
        System.out.println("olc(-12.0) -> " + s.olc(-12.0));
        System.out.println("Durum: " + s.toString());

        System.out.println("\n--- Aralik disi olcumler ---");
        System.out.println("olc(999.0) -> " + s.olc(999.0));
        System.out.println("olc(-80.0) -> " + s.olc(-80.0));
    }
}