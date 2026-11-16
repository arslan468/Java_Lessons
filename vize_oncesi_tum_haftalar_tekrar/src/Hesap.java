class Hesap {
    private int bakiye;

    public void paraYatir(int tutar) {
        if (tutar>0)
        {
            this.bakiye+=tutar;
        }
        else{System.out.println("Tutar pozitif olmalı");}
    }

    public int getBakiye() {
        return bakiye;
    }
}