class KanBasinci {
    public static final int EN_DUSUK = 40;
    public static final int EN_YUKSEK = 250;

    private int buyuk;
    private int kucuk;

    public KanBasinci(int yeniBuyuk, int yeniKucuk) {
        this.buyuk = 120;
        this.kucuk = 80;
        ayarla(yeniBuyuk, yeniKucuk);
    }

    private boolean araliktaMi(int deger) {
        return deger >= EN_DUSUK && deger <= EN_YUKSEK;
    }

    public boolean ayarla(int yeniBuyuk, int yeniKucuk) {
        if (!araliktaMi(yeniBuyuk) || !araliktaMi(yeniKucuk)) {
            System.out.println("  RED: degerler " + EN_DUSUK + ".." + EN_YUKSEK + " araliginda olmalidir.");
            return false;
        }
        else if (yeniBuyuk <= yeniKucuk) {
            System.out.println("!!!buyuk tansiyon kucukten buyuk olmalidir (" + yeniBuyuk + " <= " + yeniKucuk);
            return false;
        }
        this.buyuk = yeniBuyuk;
        this.kucuk = yeniKucuk;
        return true;
    }

    public int getBuyuk() {
        return buyuk;
    }

    public int getKucuk() {
        return kucuk;
    }

    public int getNabizBasinci() {
        return (buyuk - kucuk);
    }

    public String degerlendir() {
        if (buyuk < 120 && kucuk < 80) {
            return "NORMAL";
        } else if (buyuk < 130 && kucuk < 80) {
            return "YUKSEK-NORMAL";
        } else if (buyuk < 140 || kucuk < 90) {
            return "EVRE-1";
        } else {
            return "EVRE-2";
        }
    }

    @Override
    public String toString() {
        return buyuk + "/" + kucuk + " mmHg (" + degerlendir() + ")";
    }
}

public class Gorev2_KanBasinciDemo {
    public static void main(String[] args) {


        KanBasinci kb = new KanBasinci(220, 58);
        System.out.println("Olcum 1 : " + kb);
        System.out.println("Nabiz basinci: " + kb.getNabizBasinci());
        System.out.println();

        System.out.println("===Dengesiz istekler====");
        kb.ayarla(90, 130);
        kb.ayarla(300, 80);
        kb.ayarla(120, 120);
        System.out.println("Degismedi: " + kb);
        System.out.println();

        System.out.println("--- Gecerli olcumler ---");
        kb.ayarla(158, 58);
        System.out.println("Olcum 2 : " + kb);
        kb.ayarla(100, 66);
        System.out.println("Olcum 3 : " + kb);
        System.out.println("Nabiz basinci: " + kb.getNabizBasinci());
    }
}
