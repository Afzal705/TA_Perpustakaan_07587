package newView;

import Controller.ControlControler;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {

    public void Login() {
        ControlControler control = new ControlControler();
        AdminFrame admin = new AdminFrame();
        JFrame login = new JFrame("LOGIN");
        login.setSize(1200,700);
        ImageIcon latarBelakang = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Tugas PBO jadi - Swing\\gambar\\backgrounf login.jpg");
        Image image = latarBelakang.getImage();
        Image ukuran = image.getScaledInstance(login.getWidth(), login.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon background = new ImageIcon(ukuran);
        login.setContentPane(new JLabel(background));
        login.setUndecorated(true);
        login.getRootPane().setWindowDecorationStyle(JRootPane.NONE);


        JPanel back = new JPanel();
        back.setBackground(Color.white);
        back.setBounds(420,90,360,500);
        JPanel border = new JPanel();
        border.setBackground(Color.darkGray);
        border.setBounds(424,98,364,500);

        JPanel garis1 = new JPanel();
        garis1.setBounds(450,160,300,4);
        garis1.setBackground(Color.black);

        JPanel garis2 = new JPanel();
        garis2.setBounds(450,300,280,2);
        garis2.setBackground(Color.black);

        JPanel garis3 = new JPanel();
        garis3.setBounds(450,360,280,2);
        garis3.setBackground(Color.black);


        Font font;
        JLabel judul =new JLabel("LOGIN");
        judul.setBounds(560,100,200,100);
        font = new Font("Consolas",Font.BOLD,30);
        judul.setForeground(Color.black);
        judul.setFont(font);
        login.add(judul);

        JLabel username = new JLabel("USERNAME : ");
        username.setBounds(450,250,200,20);
        Font font2 = new Font("Consolas",Font.BOLD,13);
        username.setFont(font2);
        login.add(username);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(450,270,200,30);
        txtUser.setBackground(Color.white);
        txtUser.setBorder(null);
        login.add(txtUser);

        JLabel password = new JLabel("PASSWORD : ");
        password.setBounds(450,310,200,20);
        password.setFont(font2);
        login.add(password);

        JPasswordField txtPass= new JPasswordField();
        txtPass.setBounds(450,330,200,30);
        txtPass.setBackground(Color.white);
        txtPass.setBorder(null);
        login.add(txtPass);

        Font fontTombol;
        JButton tombol = new JButton("LOGIN");
        fontTombol = new Font("Consolas",Font.BOLD,20);
        tombol.setForeground(Color.white);
        tombol.setFont(fontTombol);
        tombol.setBounds(420,450,360,60);
        tombol.setBackground(Color.black);
        login.add(tombol);

        JLabel peringatan = new JLabel("PASSWORD DAN USERNAME SALAH !!");
        peringatan.setForeground(Color.RED);
        peringatan.setBounds(500, 520, 250, 20);
        peringatan.setVisible(false);
        login.add(peringatan);

//        txtUser.setText("Admin");
//        txtPass.setText("12345");


        tombol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUser.getText();
                String password = new String(txtPass.getPassword());
                if (control.cekUserdanPw(username, password) == true) {
                    admin.admin();
                    login.setVisible(false);
                } else if (control.cekUserdanPw(username, password) == false) {
                    peringatan.setVisible(true);

                }
            }
            });
        login.add(garis1);
        login.add(garis2);
        login.add(garis3);
        login.add(back);
        login.add(border);
        login.setLocationRelativeTo(null);
        login.setLayout(null);
        login.setVisible(true);
    }



}

//class Main2 {
//    public static void main(String[] args) {
//        LoginFrame login = new LoginFrame();
//        login.Login();
//    }
//}
