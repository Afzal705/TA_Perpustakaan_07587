package newView;

import Controller.ControlControler;
import Entity.BukuEntity;
import Entity.Peminjam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinjamPanel {
    private ControlControler control = new ControlControler();
    private int y = 40;

    private  int lamaPinjam =0;
    public void pinjam (BukuEntity buku,int lebar , int tinggi){
        JFrame panelPinjam = new JFrame();
        panelPinjam.setSize(430,800);
        panelPinjam.setLayout(null);
        panelPinjam.getContentPane().setBackground(Color.black);
        panelPinjam.setUndecorated(true);
        panelPinjam.setLocationRelativeTo(null);

        JPanel coverBuku = new JPanel();
        coverBuku .setBackground(Color.gray);
        coverBuku.setBounds(0,40,lebar,160);

        JPanel dataDiri = new JPanel();
        dataDiri.setBounds(0,400,lebar,tinggi-400);
        dataDiri.setBackground(Color.darkGray);
        dataDiri.setLayout(null);

        JLabel judulForm = new JLabel("MASUKKAN INFORMASI ANDA ");
        judulForm.setFont(new Font("Sans",Font.BOLD,25));
        judulForm.setBackground(null);
        judulForm.setForeground(Color.white);
        judulForm.setBounds(0,0,lebar,50);


        String[] menu ={
                "NAMA                          : ",
                "No.TELEFON             :",
                "JUMLAH                     :",
                "PILIH LAMA PINJAM :"
        };
//        JPanel

        Font font =new Font("Arial",Font.BOLD,12);
        for (String a : menu){
            JLabel label = new JLabel(a);
            label.setBounds(5,y,150,30);
            label.setFont(font);
            label.setForeground(Color.white);
            dataDiri.add(label);
            y+=30;
        }
        JTextField inputNama = new JTextField();
        inputNama.setBounds(130,40,200,25);
        inputNama.setFont(font);
        inputNama.setBorder(null);

        JTextField inputNomor = new JTextField();
        inputNomor.setBounds(130,70,200,25);
        inputNomor.setFont(font);
        inputNomor.setBorder(null);

        JTextField inputJumlah = new JTextField();
        inputJumlah.setBounds(130,110,200,25);
        inputJumlah.setFont(font);
        inputJumlah.setBorder(null);

        String[] durasi = {
                "1 bulan ",
                "1 Pekan ",
        };


        for (String d : durasi){
            JButton tombol = new JButton(d);
            tombol.setBackground(Color.white);
            tombol.setForeground(Color.black);
            tombol.setBounds(5,y,130,25);
            tombol.setFocusPainted(false);
            dataDiri.add(tombol);
            y+=30;
            tombol.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tombol.getText().equals("1 bulan")){
                        lamaPinjam = 30;
                    } else if (tombol.getText().equals("1 Pekan")) {
                        lamaPinjam = 7;
                    }
                }
            });
        }

        JLabel durasiHarian = new JLabel( "Pilih Manual");
        durasiHarian.setBounds(5,230,150,25);
        durasiHarian.setForeground(Color.white);
        durasiHarian.setFont(font);

        JTextField inputHarian = new JTextField();
        inputHarian.setBounds(130,230,200,25);
        inputHarian.setBorder(null);
        inputHarian.setFont(font);

//        lamaPinjam = Integer.parseInt(inputHarian.getText());

        JButton konfirmasi = new JButton("Konfirmasi");
        konfirmasi.setBounds(0,dataDiri.getHeight()-40,lebar,40);
        konfirmasi.setBackground(Color.WHITE);
        konfirmasi.setForeground(Color.black);
        konfirmasi.setFont(font);


        konfirmasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = inputNama.getText();
                String noTelp = inputNomor.getText();
                int jumlahBuku = Integer.parseInt(inputJumlah.getText());
                int durasiPinjam = Integer.parseInt(inputHarian.getText());
                lamaPinjam = durasiPinjam;

                control.tambahPeminjam(new Peminjam(nama, lamaPinjam, jumlahBuku, buku, noTelp));
                panelPinjam.dispose();
            }
        });

        dataDiri.add(inputHarian);
        dataDiri.add(durasiHarian);
        panelPinjam.add(coverBuku);
        dataDiri.add(konfirmasi);
        dataDiri.add(judulForm);
        dataDiri.add(inputJumlah);
        dataDiri.add(inputNomor);
        dataDiri.add(inputNama);
        panelPinjam.add(dataDiri);
        panelPinjam.setVisible(true);

    }
}
