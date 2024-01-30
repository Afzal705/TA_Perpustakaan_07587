package Entity;

import javax.swing.*;

public abstract class Perpustakaan {
    protected String judul;
    protected String pengarang;
    protected String posisi;
    protected String tanggalTerbi;
    protected String penerbit;


    public Perpustakaan(String judul, String pengarang, String posisi, String tanggalTerbi, String penerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.posisi = posisi;
        this.tanggalTerbi = tanggalTerbi;
        this.penerbit = penerbit;
    }
//GETER---------------------------------------------------------------------------------------------------------
    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getPosisi() {
        return posisi;
    }

    public String getTanggalTerbi() {
        return tanggalTerbi;
    }

    public String getPenerbit() {
        return penerbit;
    }

//SETER---------------------------------------------------------------------------------------------------------

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setTanggalTerbi(String tanggalTerbi) {
        this.tanggalTerbi = tanggalTerbi;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
