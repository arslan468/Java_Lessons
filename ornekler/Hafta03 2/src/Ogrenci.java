public class Ogrenci extends Kisi {

    private  final int numara;
    private double ortalama;

    public Ogrenci(String ad, String tcNo, int dogumYili, int numara, double ortalama) {
        super(ad, tcNo, dogumYili);
        this.numara = numara;
        setOrtalama(ortalama);
    }

    public int getNumara()
    {
        return numara;
    }
    public double getOrtalama()
    {
        return ortalama;
    }
    public void setOrtalama(double ortalama)
    {
        if(ortalama >= 0.0 && ortalama <= 4.0)
        {
            this.ortalama = ortalama;
        }
        else
        {
            System.out.println("Uyari: ortalama 0.0-4.0 araliginda olmalidir; 0.0 kullanildi.");
            this.ortalama = 0.0;
        }
    }

    public boolean onurListesinde()
    {
        return  ortalama >= 3.0;
    }

    @Override
    public  String tanit()
    {
        String onur = onurListesinde() ? " *onur* " : "";
        return getAd() + "\t" + maskeliTc() + "\tyaş = " + yas() + "\t[Ogrenci no=" + numara + " ort=" + ortalama + onur + "]";
    }
}