public class Hayvan {
    void sesCikar() {
        System.out.println("Hayvan sesi");
    }
}

class Kedi extends Hayvan {
    @Override
    void sesCikar() {
        System.out.println("Miyav");
    }

    void tirman() {
        System.out.println("Tırmandı");
    }
}