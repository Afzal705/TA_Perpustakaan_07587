package newView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame {
        private CrudPanel crud = new CrudPanel();
        private DataPeminjamPanel peminjam = new DataPeminjamPanel();
        private JButton CRUD;
        private int perubahan = crud.perubahan();
public void admin(){

        SwingUtilities.invokeLater(()-> {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,700);
        frame.setTitle("Admin");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JPanel atas = new JPanel();
        atas.setBackground(Color.white);
        atas.setLayout(null);
        atas.setBounds(0,0,1200,50);

        JPanel pilihCRUD = new JPanel();
        pilihCRUD.setBackground(Color.lightGray);
        pilihCRUD.setLayout(null);
        pilihCRUD.setBounds(0,55,1200,50);
        pilihCRUD.setLayout(new FlowLayout(FlowLayout.RIGHT));

        Font font1 = new Font(Font.MONOSPACED,Font.BOLD,40);
        JLabel judul = new JLabel("TAMBAH DATA");
        judul.setFont(font1);
        judul.setBounds(850,20,300,100);
        judul.setForeground(Color.black);

        JPanel kiri = new JPanel();
        kiri.setBackground(new Color(17, 24, 38));
        kiri.setSize(200,700);
        kiri.setLayout(null);


            JButton tombolProfile = new JButton("\uD835\uDDD4\uD835\uDDF1\uD835\uDDFA\uD835\uDDF6\uD835\uDDFB");
            tombolProfile.setBounds(0,0,200,50);
            tombolProfile.setBorderPainted(false);
            tombolProfile.setBackground(Color.blue);
            tombolProfile.setForeground(Color.white);
            tombolProfile.setFont(new Font("",Font.BOLD,30));
            tombolProfile.setFocusPainted(false);




        JLabel []label = {
                new JLabel("MENU CRUD"),
                new JLabel("Tampil DATA PENGUNJUNG"),

        };

        JLabel []labelCRUD = {
                    new JLabel("Tambah Data"),
                    new JLabel("Tampil Data"),

        };


        int y = 300;
        ImageIcon profileIcon = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Tugas PBO jadi - Swing\\gambar\\Admin\\logoku.jpeg"); // Ganti dengan path gambar profil Anda
        Image image = profileIcon.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon newFoto = new ImageIcon(image);
        JLabel profil = new JLabel(newFoto);

        JPanel fotoProfile = new JPanel();
        fotoProfile.setBounds((kiri.getWidth()/2)-(newFoto.getIconWidth()/2),tombolProfile.getHeight()+5,newFoto.getIconWidth(),newFoto.getIconHeight());
        fotoProfile.setBackground(null);


        fotoProfile.add(profil);
        kiri.add(fotoProfile,BorderLayout.CENTER);
        frame.add(crud.tambahData());

        int yMenu = 300;
        for (JLabel l : label ){
            JButton menu = new JButton();
            menu.setText(l.getText());
            menu.setBackground(null);
            menu.setForeground(Color.white);
            menu.setBounds(5,yMenu,kiri.getWidth(),30);
            kiri .add(menu);
            menu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    frame.getContentPane().revalidate();
                    frame.getContentPane().repaint();
                    atas.add(judul);
                    kiri.add(tombolProfile);
                    frame.add(kiri,BorderLayout.WEST);
                    frame.add(atas,BorderLayout.NORTH);
                    if(menu.getText().equals("MENU CRUD")){
                        frame.add(pilihCRUD);
                        frame.getContentPane().add(crud.tambahData());
                    } else if (menu.getText().equals("Tampil DATA PENGUNJUNG")) {
                        frame.getContentPane().add(peminjam.tampilDataPeminjam(frame));
                    }
                }
            });
            yMenu+=30;
        }


            for(JLabel labels : labelCRUD) {
                        CRUD = new JButton();
                        CRUD.setText(labels.getText());
                        CRUD.setBackground(Color.black);
                        CRUD.setBorderPainted(false);
                        CRUD.setForeground(Color.white);
                        CRUD.setPreferredSize(new Dimension(100,pilihCRUD.getHeight()));
                        CRUD.setMaximumSize(new Dimension(100,pilihCRUD.getHeight()));
                        pilihCRUD.add(CRUD);
                        pilihCRUD.add(Box.createHorizontalStrut(10));
                        y+=60;

                        CRUD.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("diklik");
                                frame.getContentPane().removeAll();
                                frame.getContentPane().revalidate();
                                frame.getContentPane().repaint();
                                atas.add(judul);
                                kiri.add(tombolProfile);
                                frame.add(kiri,BorderLayout.WEST);
                                frame.add(atas,BorderLayout.NORTH);
                                frame.add(pilihCRUD);

                                if (labels.getText().equals("Tambah Data")){
                                    judul.setText(labels.getText());
                                    frame.getContentPane().add(crud.tambahData());
                                } else if (labels.getText().equals("Tampil Data")){
                                    judul.setText(labels.getText());
                                    frame.getContentPane().add(crud.tampilData(frame));
                                    JOptionPane.showMessageDialog(null,"Tekan Judul 2x Untuk Update/Delete");
                                }

                                if (perubahan == 1){
                                    labels.setText("Tampil Data");
                                    CRUD.doClick();
                                }
                            }
                        });
                System.out.println("keluar dari klik");

//cek prubahan =================================================

        }

        atas.add(judul);
        kiri.add(tombolProfile);
        frame.add(kiri,BorderLayout.WEST);
        frame.add(atas,BorderLayout.NORTH);
        frame.add(pilihCRUD);
        frame.setVisible(true);

        });
    }

}

class mainnnnn {
    public static void main(String[] args) {
        AdminFrame admin = new AdminFrame();
        admin.admin();
    }
}