public class Personel extends Kisi{

    private String unvan;
    private int hizmetYili;

    public Personel(String ad, String tcNo, int dogumYili, String unvan, int hizmetYili) {
        super(ad, tcNo, dogumYili);
        this.unvan = unvan;
        this.hizmetYili = hizmetYili;



    }


    public double kidemKatsayisi(int hizmetYili)
    {
        return  1.0+ hizmetYili * 0.05;
    }

    @Override
    public String tanit()
    {
        return getAd() + "\t" + maskeliTc() + "\tyaş = " + yas() + "        (Ünvan:"+getUnvan() + "---Kıdem Katsayısı: " + kidemKatsayisi(getHizmetYili());
    }


    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public int getHizmetYili() {
        return hizmetYili;
    }

    public void setHizmetYili(int hizmetYili) {
        this.hizmetYili = hizmetYili;
    }
}
