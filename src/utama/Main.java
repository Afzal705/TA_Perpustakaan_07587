package utama;
import Model.Model;
//import View.RunProgram;
import newView.loginSebagaiFrame;

public class Main {
    public static void main(String[] args) {
        Model.ambil();
        Model.initialData();
        loginSebagaiFrame login = new loginSebagaiFrame();
        login.sebagai();

    }
}



