public class Sensor {
    /*İLK HALİ
    public String kod; // herkes degistirebilir

    public String birim;

    public double deger; // hicbir aralik denetimi yok

    public int olcumSayisi; // disaridan istenen degere ayarlanabilir

    public Sensor(String kod, String birim)
    {
        this.kod = kod;
        this.birim = birim;
    }
    */

    private final String kod, birim;
    private double deger;
    private int olcumSayisi, redSayisi;
    public static final double En_Dusuk = -50.00;
    public static final double En_Yuksek = 150.00;

    public String getKod()
    {
        return kod;
    }
    public String getBirim()
    {
        return  birim;
    }
    public double getDeger()
    {
        return deger;
    }
    public int getOlcumSayisi()
    {
        return olcumSayisi;
    }
    public int getRedSayisi()
    {
        return redSayisi;
    }



    public Sensor(String kod, String birim) {
        this.kod = kod;
        this.birim = birim;
        this.deger = 0.0;
        this.olcumSayisi = 0;
        this.redSayisi = 0;
    }

    @Override
    public String toString()
    {
        return kod + " = " + deger + " " + birim + " (kabul = " + olcumSayisi + " , red = " + redSayisi + " )";
    }



    public boolean olc(double deger)
    {
        if (deger < En_Dusuk || deger > En_Yuksek)
        {
            redSayisi++;
            System.out.println("Girmiş olduğunuz değer -50 +150 aralığının dışında olduğu için işleminiz reddedildi.");
            return false;
        }

        this.deger = deger;
        olcumSayisi++;
        return true;
    }

}

