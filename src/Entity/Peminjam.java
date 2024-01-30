package Entity;

public class Peminjam {
    private String nama;
    private int lamaPinjam ;
    private int jumlah;
    private String noTelp;
    private int biaya;

    private BukuEntity buku ;


    public Peminjam(String nama, int lamaPinjam, int jumlah, BukuEntity buku, String noTelp) {
        this.nama = nama;
        this.lamaPinjam = lamaPinjam;
        this.jumlah = jumlah;
        this.buku = buku;
        this.noTelp = noTelp;
    }


    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public void setLamaPinjam(int lamaPinjam) {
        this.lamaPinjam = lamaPinjam;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public BukuEntity getBuku() {
        return buku;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setBuku(BukuEntity buku) {
        this.buku = buku;
    }
    public void tampilData(){
        System.out.printf("| %-20s | %-30s | %-30s | %-15s | %-15s |%n", getNama(), getNoTelp(), getBuku().getJudul(), getJumlah(), getLamaPinjam());
        System.out.println("|----------------------|--------------------------------|--------------------------------|-----------------|-----------------|");
    }
}
