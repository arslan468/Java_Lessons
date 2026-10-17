public class Kisi {
    private final String ad;
    private final String tcNo;
    private final int dogumYili;

    public Kisi(String ad, String tcNo, int dogumYili) {
        this.ad = (ad == null || ad.trim().isEmpty()) ? "isimsiz" : ad;
        this.tcNo = (tcNo != null && tcNo.length() == 11 ) ? tcNo: "00000000000";
        this.dogumYili = dogumYili;
    }

    public String getAd() {
        return ad;
    }

    public String getTcNo() {
        return tcNo;
    }

    public int getDogumYili() {
        return dogumYili;
    }

    public String maskeliTc()
    {
        if(tcNo.length() == 11)
        {
            return tcNo.substring(0,3) + "*****" + tcNo.substring(8);
        }
        return tcNo;
    }
    public int yas()
    {
        return 2026 - dogumYili;
    }

    public String tanit()
    {
        return ad + "\t" + maskeliTc() + "\tyaş= " + yas() + "\t[Kisi]";
    }


}
