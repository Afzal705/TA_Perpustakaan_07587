package newView;

import Controller.ControlControler;
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


public class UserFrame extends JFrame {
    private String inputKeyboar = "";
    private String inputJudul = "";
    private String inputPengarang = "";
    private String inputPenerbit = "";
    int waktu = 0;
    private ControlControler control = new ControlControler();


    private int a =0;
    public void user(){
        setSize(430,800);
//        setSize(1200,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(26, 18, 11));

        Font font = new Font("Arial",Font.BOLD,15);
        String lokasi = "C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\background\\background atas 2.jpg";
        ImageIcon background = new ImageIcon(lokasi);
        JPanel atas = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(background.getImage(),0,0,getWidth(),200,this);
            }
        };
        atas.setLayout(null);
        atas.setBounds(0,0,getWidth(),200);
        atas.setBackground(new Color(3, 6, 90));

        JLabel labelPerpustakaan = new JLabel("ℙ\uD835\uDD3Cℝℙ\uD835\uDD4C\uD835\uDD4A\uD835\uDD4B\uD835\uDD38\uD835\uDD42\uD835\uDD38\uD835\uDD38ℕ");
        labelPerpustakaan.setBounds(70,60,400,50);
        labelPerpustakaan.setFont(new Font("",Font.BOLD,30));
        atas.add(labelPerpustakaan);

        JPanel borderAtas = new JPanel();
        borderAtas.setBounds(0,0,getWidth(),40);
        borderAtas.setBackground(Color.black);


        JPanel dataCari = new JPanel();
        dataCari.setBackground(Color.white);
        dataCari.setBounds(20, 200, 310, 30);
        dataCari.setLayout(new BoxLayout(dataCari, BoxLayout.Y_AXIS));
        dataCari.setVisible(false);



        JTextField search = new JTextField();
        search.setFont(font);
        search.setBounds((getWidth()/2)/2-87, 130, 310, 30);

        ImageIcon iconCari = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\Tugas PBO jadi - Swing\\gambar\\icons8-search-24 (1).png");
        JButton tombolCari = new JButton(iconCari);
        tombolCari.setBackground(Color.black);
        tombolCari.setBounds(search.getWidth()+search.getX(),130,60,30);
        tombolCari.setBorderPainted(false);
        tombolCari.setFocusPainted(false);

        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {


                    System.out.println("input baru");

                    int ukuran = 0;
                    List<String> matchedJuduls = new ArrayList<>();
                    char keyChar = e.getKeyChar();
                    if (keyChar == '\b' && inputKeyboar.length() > 0) {
                        inputKeyboar = inputKeyboar.substring(0, inputKeyboar.length() - 1);
                    } else {
                        inputKeyboar += keyChar;
                    }

                    a = 0;

                    if (inputKeyboar.isEmpty()) {
                        dataCari.setVisible(false);
                        dataCari.setVisible(false);
                        dataCari.removeAll();
//                        dataCari.revalidate();
//                        dataCari.repaint();
                    } else {
                        dataCari.setVisible(true);
                        dataCari.setVisible(true);


                        for (int i = 0; i < control.ambilDataBuku().size(); i++) {

                            String ambilJudul = control.ambilDataBuku().get(i).getJudul();
                            String ambilPengarang = control.ambilDataBuku().get(i).getPengarang();
                            String ambilPenerbit = control.ambilDataBuku().get(i).getPenerbit();


                            if (ambilJudul.toLowerCase().startsWith(inputKeyboar.toLowerCase())) {
                                matchedJuduls.add(new String(ambilJudul + "," + ambilPengarang + "," + ambilPenerbit));
                            } else if (ambilPengarang.toLowerCase().startsWith(inputKeyboar.toLowerCase())) {
                                matchedJuduls.add(new String(ambilJudul + "," + ambilPengarang + "," + ambilPenerbit));
                            } else if (ambilPenerbit.toLowerCase().startsWith(inputKeyboar.toLowerCase())) {
                                matchedJuduls.add(new String(ambilJudul + "," + ambilPengarang + "," + ambilPenerbit));
                            }
                        }

                        dataCari.removeAll();
                        if (matchedJuduls.isEmpty()) {
                            JLabel kosong = new JLabel("Tidak Ada ...");
                            Dimension ukuranTombol = kosong.getPreferredSize();
                            int tinggi = ukuranTombol.height;
                            System.out.println(tinggi);
                            ukuran += tinggi;
                            dataCari.add(kosong);

                        } else {
                            for (String matchedJudul : matchedJuduls) {

                                JButton kontenDataPencarian = new JButton(matchedJudul);
                                kontenDataPencarian.setBackground(null);
                                kontenDataPencarian.setFocusPainted(false);
                                kontenDataPencarian.setBorder(null);
                                kontenDataPencarian.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        for (BukuEntity b : Model.getData()){

                                            if (new String(b.getJudul()+","+b.getPengarang()+","+b.getPenerbit()).equalsIgnoreCase(matchedJudul)){
                                                detailBukuFrame detail = new detailBukuFrame();
                                                detail.detail(b);
                                                dispose();
                                            }
                                        }
                                    }
                                });
                                dataCari.add(kontenDataPencarian);

                                Dimension ukuranTombol = kontenDataPencarian.getPreferredSize();
                                int tinggi = ukuranTombol.height;
                                System.out.println(tinggi);
                                ukuran += tinggi;

                            }
                        }
                        dataCari.revalidate();
                        dataCari.repaint();

                        inputJudul = "";
                    }
                    dataCari.setBounds(20, 160, 310, ukuran + 5);
                    dataCari.revalidate();
                    dataCari.repaint();
            }
        });


        tombolCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teks  = search.getText();
                System.out.println(teks);
            }
        });


        Font fontKeterangan = new Font("Consolas",Font.BOLD,15);

        JLabel ketFrame = new JLabel("Home");
        ketFrame.setForeground(Color.white);
        ketFrame.setFont(fontKeterangan);

        JLabel keterangan=new JLabel("Rekomendasi");
        keterangan.setBounds(20,210,100,30);
        keterangan.setForeground(Color.white);
        keterangan.setFont(fontKeterangan);

//Menampilkan konten didalam box rekomendasi -------------------------------------------------------------------------------------
        JPanel rekomendasi = new JPanel();
        rekomendasi.setLayout(new BoxLayout(rekomendasi, BoxLayout.Y_AXIS));
        rekomendasi.setBounds(0,0,430,550);
        rekomendasi.setBackground(null);
        int ykonten = 5;
        for (BukuEntity b : Model.getData()) {
            Image ambilGambar = b.getGambar().getImage().getScaledInstance(400,200,Image.SCALE_SMOOTH);
            ImageIcon newGambar = new ImageIcon(ambilGambar);

            JLabel gambar = new JLabel(){
                    protected void paintComponent(Graphics g) {
                        Shape roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);

                        Graphics2D g2d = (Graphics2D) g.create();
                        g2d.setClip(roundedRect);
                        g2d.drawImage(newGambar.getImage(), 0, 0, 400, 200, this);
                        g2d.setClip(null);
                        g2d.dispose();
                    }
                };
            Font foncst = new Font("Arial",Font.BOLD,15);
            JPanel konten = new JPanel();
            konten.setLayout(null);
            gambar.setBounds(10,0,400,200);
            konten.setBounds(10, ykonten, 350, 200);
            konten.setPreferredSize(new Dimension(350, 250));
            konten.setBackground(null);


            JLabel labelJudul = new JLabel(b.getJudul());
            labelJudul.setBounds(20,200,200,30);
            labelJudul.setForeground(Color.white);
            labelJudul.setFont(foncst);
            konten.add(gambar);
            if (ykonten == 5){
            rekomendasi.add(Box.createVerticalStrut(10));

            }else {
                rekomendasi.add(Box.createVerticalStrut(20));
            }
            konten.add(labelJudul);
            rekomendasi.add(konten);
            konten.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    detailBukuFrame detail = new detailBukuFrame();
                    detail.detail(b);
                    System.out.println(b.getDeskripsi());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    gambar.setBounds(15,5,400,200);
                    labelJudul.setBounds(25,205,200,30);
//
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    gambar.setBounds(10,0,400,200);
                    labelJudul.setBounds(20,200,200,30);
                }
            });
            ykonten += 55;
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(0,240,430,500);
        scroll.setViewportView(rekomendasi);
        scroll.setBackground(null);
        scroll.getViewport().setBackground(null);
        scroll.setBorder(new MatteBorder(10, 0, 0, 0, Color.black));
        scroll.getVerticalScrollBar().setBackground(Color.black);

        scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI(){

            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new Color(100, 100, 100));
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
                g2.dispose();
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                Dimension zeroDim = new Dimension(0, 0);
                button.setPreferredSize(zeroDim);
                button.setMinimumSize(zeroDim);
                button.setMaximumSize(zeroDim);
                return button;
            }
            @Override
            protected Dimension getMinimumThumbSize() {
                return new Dimension(5, 5);
            }

            @Override
            public Dimension getPreferredSize(JComponent c) {
                return new Dimension(5, 5);
            }
        });

        JPanel menuBawah = new JPanel();
        menuBawah.setBounds(0,getHeight()-60,430,60);
        menuBawah.setBackground(Color.black);
        menuBawah.setLayout(null);

        int x = 20;
        int xLabel = 30;
        int xTombol = 0;
        ImageIcon[] gKategori = {
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\Icon\\icons8-home-50.png"),
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\Icon\\icons8-category-50.png"),
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\Icon\\icons8-history-30 (1).png"),
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\Icon\\icons8-male-user-24.png"),
        };
        String[] label = {"Home","kategori","Riwayat","Profil"};
        int i = 0;
        for (ImageIcon gambarKategori : gKategori) {
            JButton tombol = new JButton();
            tombol.setBounds(xTombol,0,menuBawah.getWidth()/4,menuBawah.getHeight());
            tombol.setBorderPainted(false);
            tombol.setBackground(null);
            tombol.setLayout(null);

            Image atur = gambarKategori.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon gKategori2 = new ImageIcon(atur);
            JLabel kategori = new JLabel(gKategori2);
            kategori.setBounds(x, 0, 50, 50);
            JLabel lKategori = new JLabel(label[i]);
            lKategori.setBounds(xLabel, 40, 100, 20);
            lKategori.setFont(fontKeterangan);
            lKategori.setForeground(Color.white);
            int a = i;
            tombol.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label[a].equalsIgnoreCase("Kategori")){
                        Kategori kategori = new Kategori();
                        kategori.KategoriFrame();
                        dispose();
                    }
                }
            });
            if (xLabel == 15){
                xLabel+=20;
            } else if (xLabel == 20) {
                xLabel+=17;
            }
            xLabel-=15;
            i++;
            xTombol+=tombol.getWidth();
            tombol.add(lKategori);
            tombol.add(kategori);
            menuBawah.add(tombol);
        }


        add(dataCari);
        add(menuBawah);
        borderAtas.add(ketFrame);
        add(scroll);
        add(keterangan);
        atas.add(borderAtas);
        atas.add(tombolCari);
        atas.add(search);
        add(atas);
        setVisible(true);

    }

}
//class mainn{
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                Model.ambil();
//                Model.initialData();
//                UserFrame user = new UserFrame();
//                user.user();
//            }
//        });
//    }
//}
