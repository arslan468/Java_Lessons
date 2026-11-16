public class Ogrenci {
    private final String ogrenciNo;
    private int yas;
    private final int[] notlar;

    // Ana yapıcı
    public Ogrenci(String ogrenciNo, int yas, int not1, int not2) {
        if (yas < 17 || yas > 70) {
            throw new IllegalArgumentException("Geçersiz yaş.");
        }

        this.ogrenciNo = ogrenciNo;
        this.yas = yas;
        this.notlar = new int[]{not1, not2};
    }

    // Yaş verilmezse ana yapıcıya 18 gönder
    public Ogrenci(String ogrenciNo, int not1, int not2) {
        this(ogrenciNo, 18, not1, not2);
    }

    // Kopya yapıcı
    public Ogrenci(Ogrenci kaynak) {
        this.ogrenciNo = kaynak.ogrenciNo;
        this.yas = kaynak.yas;
        this.notlar = kaynak.notlar.clone();
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yeniYas) {
        if (yeniYas < 17 || yeniYas > 70) {
            System.out.println("Yaş 17 ile 70 arasında olmalı.");
            return;
        }

        this.yas = yeniYas;
    }

    public void ilkNotuGuncelle(int yeniNot) {
        if (yeniNot < 0 || yeniNot > 100) {
            return;
        }

        notlar[0] = yeniNot;
    }

    public double getNotOrtalamasi() {
        return (notlar[0] + notlar[1]) / 2.0;
    }


}