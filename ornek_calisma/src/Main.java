void main() {

}

class Urun
{
    private String ad;
    private double fiyat;

    public Urun(String ad, double fiyat)
    {
        this.ad = ad;
        this.fiyat = fiyat;
    }
    public Urun(Urun egitim)
    {
        this(egitim.ad, egitim.fiyat);
        //this.ad = egitim.ad;
        //this.fiyat = egitim.fiyat;
    }

    public Urun(String ad)
    {
        this(ad,0.0);
    }

    public double getFiyat()
    {
        return this.fiyat;
    }
    public void setFiyat(double fiyat){
        if (fiyat < 0)
        {
            System.out.println("Fiyat sıfır'dan küçük olamaz");
            return;
        }
        else
        {
            this.fiyat = fiyat;
        }
    }

    @Override
    public String toString()
    {
        return "Urun: "+this.ad + " - Fiyat: " + this.fiyat;
    }
}
