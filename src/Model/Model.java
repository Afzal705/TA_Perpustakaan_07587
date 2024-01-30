package Model;

import Entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model{
        static DefaultUsernameDAnPw userPassword = new DefaultUsernameDAnPw();

        private static  ArrayList<BukuEntity>daftarBuku = new ArrayList<>();
        private static  ArrayList<Peminjam>daftarPeminjam = new ArrayList<>();
        private static ArrayList<String> dataDeskripsiBuku = new ArrayList<>();
//Data Bawaan ----------------------------------------------------------------------------------------------------------
    public static void initialData(){

        ImageIcon[] gambar ={
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\laskar pelangi.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\bumi manusia.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\ayat ayat cinta.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\garis waktu.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\negri 5 menara.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\Perahu kertas.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\sang Pemimpi.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\ronggeng dukuh paruk.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\cinta dalam gelas.jpg"),
          new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\cover\\padang bulan.jpg")
        };
        tambahBuku(new BukuEntity("Laskar Pelangi", "Andrea Hirata", "A001", "2005", "Bentang Pustaka", 529, 15,gambar[0],dataDeskripsiBuku.get(0)));
        tambahBuku(new BukuEntity("Bumi Manusia", "Pramoedya Ananta Toer", "A002", "1980", "Hasta Mitra", 464, 20,gambar[1],dataDeskripsiBuku.get(1)));
        tambahBuku(new BukuEntity("Ayat-Ayat Cinta", "Habiburrahman El-Shirazy", "A003", "2004", "Republish", 368, 25,gambar[2],dataDeskripsiBuku.get(2)));
        tambahBuku(new BukuEntity("Garis Waktu", "Fiersa Besari", "A004", "2018", "Media Pressindo", 224, 18,gambar[3],dataDeskripsiBuku.get(3)));
        tambahBuku(new BukuEntity("Negeri 5 Menara", "Ahmad Fuadi", "A005", "2009", "Gramedia Pustaka Utama", 412, 12,gambar[4],dataDeskripsiBuku.get(4)));
        tambahBuku(new BukuEntity("Perahu Kertas", "Dee Lestari", "A006", "2008", "Bentang Pustaka", 368, 20,gambar[5],dataDeskripsiBuku.get(5)));
        tambahBuku(new BukuEntity("Sang Pemimpi", "Andrea Hirata", "A007", "2006", "Bentang Pustaka", 396, 15,gambar[6],dataDeskripsiBuku.get(6)));
        tambahBuku(new BukuEntity("Ronggeng Dukuh Paruk", "Ahmad Tohari", "A008", "1982", "Lentera Dipantara", 478, 22,gambar[7],dataDeskripsiBuku.get(7)));
        tambahBuku(new BukuEntity("Cinta dalam Gelas", "Andrea Hirata", "A009", "2005", "Bentang Pustaka", 392, 18,gambar[8],dataDeskripsiBuku.get(8)));
        tambahBuku(new BukuEntity("Padang Bulan", "Andrea Hirata", "A010", "2008", "Bentang Pustaka", 436, 20,gambar[9],dataDeskripsiBuku.get(9)));
    }
//================================================================================================================
    public static void tambahBuku(BukuEntity buku){
daftarBuku.add(buku);
}
    public  static void tmabahPeminjam(Peminjam pinjam){daftarPeminjam.add(pinjam);}
//================================================================================================================
public static void ambil() {
    try {
        File myobjek = new File("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\data", "deskripsi.txt");
        Scanner membaca = new Scanner(myobjek);
        StringBuilder sementara = new StringBuilder();

        while (membaca.hasNextLine()) {
            String data = membaca.nextLine().trim();
            if (!data.isEmpty() && !data.equals("}")) {
                sementara.append(data).append("\n");
            } else if (data.equals("}")) {
                dataDeskripsiBuku.add(sementara.toString());
                sementara.setLength(0);
            }
        }

        membaca.close();
    } catch (FileNotFoundException a) {
        System.out.println("File tidak ditemukan ");
//        a.printStackTrace();
    }
}




//================================================================================================================
    public  static BukuEntity cari2 (String pencarian ) {
    for (BukuEntity buku : daftarBuku) {
        if (buku.getJudul().equalsIgnoreCase(pencarian)||buku.getPengarang().equalsIgnoreCase(pencarian)||buku.getPenerbit().equalsIgnoreCase(pencarian)) {
            return buku;
        }
    }
    return null;
}
//================================================================================================================
public static int tambahDeskripsi(String judul,String deskripsi){
        try {
            String lokasiFile ="C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\data\\DeskripsiBuku";
            File file = new File(lokasiFile,judul+".txt");
            if (file.createNewFile()){
                FileWriter tulis = new FileWriter(file,true);
                tulis.write(deskripsi);
            }else {
                return 1;
            }
        }catch (IOException e ){
        }
        return 0;
}
    //================================================================================================================
    public static  void hapusBuku(String nama) {
        BukuEntity buku = cari2(nama);
        if (buku != null) {
                    daftarBuku.remove((BukuEntity)buku);
            }
        }

    //================================================================================================================
   public static void updateGambarBuku(ImageIcon gambar,String nama){
        BukuEntity buku = (BukuEntity)cari2(nama);
        buku.setGambar(gambar);
   }


    public static void updateBuku(BukuEntity buku ,String judul,String pengarang ,String penerbit,int jumlahHalaman,int stokBuku,
    String tahun,String posisi,String deskripsi){
        buku.setJudul(judul);
        buku.setPenerbit(penerbit);
        buku.setPengarang(pengarang);
        buku.setPenerbit(penerbit);
        buku.setJumlahHalaman(jumlahHalaman);
        buku.setStockBuku(stokBuku);
        buku.setTanggalTerbi(tahun);
        buku.setPosisi(posisi);
        buku.setDeskripsi(deskripsi);
    }


    //================================================================================================================
    public static boolean cekUserPw(String username, String password) {
        if (username.equals(userPassword.getUsername()) && password.equals(userPassword.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

//================================================================================================================
public static ArrayList<BukuEntity> getData() {
    return daftarBuku;
}

public static ArrayList<Peminjam>getDataPeminjam(){
        return daftarPeminjam;
}


//================================================================================================================
    public static void tambahPeminjam (Peminjam pinjam ){
        BukuEntity buku = pinjam.getBuku();
        int perbaruiJumlah=buku.getStockBuku()-pinjam.getJumlah();
        buku.setStockBuku(perbaruiJumlah);

        int biaya = 1000 * pinjam.getJumlah();
        int totalBiaya = biaya*pinjam.getJumlah();
        pinjam.setBiaya(totalBiaya);
        daftarPeminjam.add(pinjam);
    }
//================================================================================================================
    public static int tampilPeminjam(){
        int i = 1;
        if (daftarPeminjam.isEmpty()) {
            i = 0;
        } else {
            for (Peminjam pinjam : daftarPeminjam) {
                pinjam.tampilData();
            }
        }
        return i;
    }
//================================================================================================================
public static BukuEntity cekKecocokan(String judul){
        for (BukuEntity buku : daftarBuku){
            if (buku.getJudul().equalsIgnoreCase(judul)){
                return buku;
            }
        }
        return null;
}
//================================================================================================================

public static int totalBiaya(int lamaPinjam){
        int total = 1000 * lamaPinjam;
    return total;
}
    //================================================================================================================
}
//  class Mainn{
//      public static void main(String[] args) {
////          Model.tampilData();
//          Model.ambil();
//          Model.initialData();
//          for (BukuEntity b :Model.getData()){
//              System.out.println("========================================");
//              System.out.println(b.getDeskripsi());
//          }
//
//
//      }
//  }