package Controller;
import Entity.BukuEntity;
import Entity.Peminjam;
import Model.Model;
import newView.AdminFrame;
import java.util.ArrayList;


public class ControlControler {

    //================================================================================================================
    public BukuEntity periksaKecocokan (int pil, String judul){
        switch (pil){
            case 1:
               return Model.cekKecocokan(judul);
        }
        return null;
    }
    //================================================================================================================
    public  void hapusBuku (String judul){
        Model.hapusBuku(judul);
    }
    //================================================================================================================
    public void updateBuku (BukuEntity buku ,String judul,String pengarang ,String penerbit,int jumlahHalaman,int stokBuku,
                            String tahun,String posisi,String deskripsi){
        Model.updateBuku(buku,judul,pengarang,penerbit,jumlahHalaman,stokBuku,tahun,posisi,deskripsi);
    }
    //================================================================================================================

    public void tambahBuku (BukuEntity buku){
        Model.tambahBuku(buku);
    }

    //================================================================================================================
    public void tambahPeminjam (Peminjam pinjam){
        Model.tambahPeminjam(pinjam);
    }
    //================================================================================================================
    public ArrayList<Peminjam>ambilDataPeminjam(){
        return Model.getDataPeminjam();
    }
    //================================================================================================================
    public ArrayList<BukuEntity>ambilDataBuku(){
        return Model.getData();
    }
    //================================================================================================================
public boolean cekUserdanPw (String username , String password){
    if (Model.cekUserPw(username, password) == true) {
        return true;
    } else if (Model.cekUserPw(username, password) == false) {
        return false;
    }
    return false;
}

//================================================================================================================
}