package newView;

import Entity.BukuEntity;
import Model.Model;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import javax.swing.SwingUtilities;

public class loginSebagaiFrame extends JFrame {

        public void sebagai() {
            setSize(430, 800);
//        setSize(1200,800);
            setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setUndecorated(true);
            getContentPane().setBackground(Color.black);

            JLabel judul = new JLabel("Login Sebagai");
            judul.setBounds(70,150,400,60);
            judul.setForeground(Color.WHITE);
            judul.setFont(new Font("Sans",Font.BOLD,40));

            ImageIcon backgorund1 = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\pilih biru merah hd.jpg");
            Image ukuran = backgorund1.getImage().getScaledInstance((getWidth()*2)-92,getHeight(),Image.SCALE_SMOOTH);
            ImageIcon background = new ImageIcon(ukuran);
            JLabel back = new JLabel(background);
            back.setBounds(0,50,getWidth(),getHeight());


            ImageIcon biru1 = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\biru pengunjung.png");
            Image ukuranBiru  = biru1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
            ImageIcon biru = new ImageIcon(ukuranBiru);
            JLabel tanganBiru = new JLabel(biru);
            tanganBiru.setBounds(0,388,biru.getIconWidth(),biru.getIconHeight());
            tanganBiru.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new PengunjungFrame();
//                    UserFrame user = new UserFrame();
//                    user.user();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                   Image ukuranBaru = ukuranBiru.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                   ImageIcon biruUkuranBaru = new ImageIcon(ukuranBaru);
                   tanganBiru.setIcon(biruUkuranBaru);
                   tanganBiru.setBounds(0,388,biruUkuranBaru.getIconWidth(),biruUkuranBaru.getIconHeight());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Image ukuranBaru = ukuranBiru.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon biruUkuranBaru = new ImageIcon(ukuranBaru);
                    tanganBiru.setIcon(biruUkuranBaru);
                    tanganBiru.setBounds(0,388,biruUkuranBaru.getIconWidth(),biruUkuranBaru.getIconHeight());
                }
            });

            ImageIcon merah1 = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\merah admin.png");
            Image ukuranMerah  = merah1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
            ImageIcon merah = new ImageIcon(ukuranMerah);
            JLabel tanganMerah = new JLabel(merah);
            tanganMerah.setBounds(getWidth()-merah.getIconWidth(),388,biru.getIconWidth(),biru.getIconHeight());
            tanganMerah.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    LoginFrame login = new LoginFrame();
                    login.Login();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    Image ukuranBaru = ukuranMerah.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                    ImageIcon merahUkuranBaru = new ImageIcon(ukuranBaru);
                    tanganMerah.setIcon(merahUkuranBaru);
                    tanganMerah.setBounds(getWidth()-250,388,merahUkuranBaru.getIconWidth(),merahUkuranBaru.getIconHeight());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Image ukuranBaru = ukuranMerah.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon merahUkuranBaru = new ImageIcon(ukuranBaru);
                    tanganMerah.setIcon(merahUkuranBaru);
                    tanganMerah.setBounds(getWidth()-merah.getIconWidth(),388,biru.getIconWidth(),biru.getIconHeight());
                }
            });

            add(tanganMerah);
            add(tanganBiru);
            add(judul);
            getContentPane().add(back);
            setVisible(true);

        }

    }

//class mainnnn {
//        public static void main(String[] args) {
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    loginSebagaiFrame sebagai = new loginSebagaiFrame();
//                    sebagai.sebagai();
//                }
//            });
//        }
//    }
