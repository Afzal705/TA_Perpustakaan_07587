package Entity;

import javax.swing.*;

public class BukuEntity extends Perpustakaan{
    private int jumlahHalaman;
    private int stockBuku;
    private ImageIcon gambar;
    private String deskripsi;
    private double rating;

    public BukuEntity(String judul, String pengarang, String posisi, String tanggalTerbit, String penerbit, int jumlahHalaman, int stockBuku, ImageIcon gambar,String deskripsi) {
        super(judul, pengarang, posisi, tanggalTerbit, penerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.stockBuku = stockBuku;
        this.gambar = gambar;
        this.deskripsi =deskripsi;
    }
    public BukuEntity(String judul, String pengarang, String posisi, String tanggalTerbi, String penerbit, int jumlahHalaman, int stockBuku) {
        super(judul, pengarang, posisi, tanggalTerbi, penerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.stockBuku = stockBuku;

    }

    public BukuEntity(String judul, String pengarang, String posisi, String tanggalTerbi, String penerbit, int jumlahHalaman, int stockBuku, ImageIcon gambar, String deskripsi, double rating) {
        super(judul, pengarang, posisi, tanggalTerbi, penerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.stockBuku = stockBuku;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.rating = rating;
    }



    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

    public int getStockBuku() {
        return stockBuku;
    }

    public void setStockBuku(int stockBuku) {
        this.stockBuku = stockBuku;
    }

    public ImageIcon getGambar() {
        return gambar;
    }

    public void setGambar(ImageIcon gambar) {
        this.gambar = gambar;
    }

    public void tampilData(){
        System.out.printf("| %-20s | %-30s | %-30s | %-15s | %-15s | %-10s |%n", getJudul(), getPengarang(), getPenerbit(), getJumlahHalaman(), getPosisi(), getStockBuku());
        System.out.println("|----------------------|--------------------------------|--------------------------------|-----------------|-----------------|------------|");
    }
    public void tampil2(){
        System.out.println("|=====================================================|");
        System.out.println("|                     Detail Buku                     |");
        System.out.println("|-----------------------------------------------------|");
        System.out.printf("| %-20s: %-30s|%n", "Judul Buku", judul);
        System.out.printf("| %-20s: %-30s|%n", "Pengarang", pengarang);
        System.out.printf("| %-20s: %-30s|%n", "Penerbit", penerbit);
        System.out.printf("| %-20s: %-30d|%n", "Jumlah Halaman", jumlahHalaman);
        System.out.printf("| %-20s: %-30d|%n", "Stok Buku", stockBuku);
        System.out.printf("| %-20s: %-30s|%n", "Posisi Rak", posisi);
        System.out.println("|=====================================================|");

    }
}
