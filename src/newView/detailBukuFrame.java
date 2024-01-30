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
import javax.swing.SwingUtilities;


public class detailBukuFrame extends JFrame {
    private boolean ditekan = true;

    public void detail(BukuEntity buku){

        setSize(430,800);
//        setSize(1200,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.black);

        JPanel borderAtas = new JPanel();
        borderAtas.setBounds(0,0,getWidth(),40);
        borderAtas.setBackground(Color.black);


        Font fontKeterangan = new Font("Consolas",Font.BOLD,15);
        JLabel ketFrame = new JLabel("Detail Buku");
        ketFrame.setForeground(Color.white);
        ketFrame.setFont(fontKeterangan);

        JPanel coverBuku = new JPanel();
        coverBuku.setBounds(0,borderAtas.getHeight(),getWidth(),300);
        coverBuku.setBackground(new Color(26, 18, 11));

        ImageIcon cover = buku.getGambar();
        Image ukuran = cover.getImage().getScaledInstance(buku.getGambar().getIconWidth(),buku.getGambar().getIconHeight(),Image.SCALE_SMOOTH);
        ImageIcon newCover = new ImageIcon(ukuran);
        JLabel gambarCover = new JLabel(newCover);


        JPanel detailBuku = new JPanel();
        detailBuku.setLayout(new BoxLayout(detailBuku, BoxLayout.Y_AXIS));
        detailBuku.setBackground(new Color(138, 88, 73));
        detailBuku.setAlignmentX(Component.LEFT_ALIGNMENT);
        detailBuku.setPreferredSize(new Dimension(430, 400));


        Font fontPengarang = new Font("Sans Serif",Font.BOLD,20);
        JLabel pengarang = new JLabel(buku.getPengarang());
        pengarang.setForeground(Color.white);
//        pengarang.setBounds(5,10,400,30);
        pengarang.setAlignmentX(Component.LEFT_ALIGNMENT);
        pengarang.setFont(fontPengarang);


        Font fontJudul = new Font("Sans Serif",Font.BOLD,25);
        JLabel judulBuku = new JLabel(buku.getJudul());
        judulBuku.setFont(fontJudul);
        judulBuku.setForeground(Color.black);
//        judulBuku.setBounds(5,pengarang.getY()*2+pengarang.getY()+5,400,30);
        judulBuku.setAlignmentX(Component.LEFT_ALIGNMENT);

        String lokasi = "C:\\Users\\hp\\IdeaProjects\\cobaSwing\\src\\star_on.png";
        ImageIcon bintang = new ImageIcon(lokasi);
        Image ukuranBintang = bintang.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
        ImageIcon newBintang = new ImageIcon(ukuranBintang);
        JLabel tbintang = new JLabel(newBintang);
        tbintang.setBounds(5,judulBuku.getHeight()+judulBuku.getY()+10,newBintang.getIconWidth(),newBintang.getIconHeight());

        JLabel labelDeskripsi = new JLabel("Deskripsi Buku");
        labelDeskripsi.setBounds(5,tbintang.getHeight()+tbintang.getY()+10,getWidth(),newBintang.getIconHeight());
        labelDeskripsi.setForeground(Color.black);

//        JPanel boxUntukTeksDeskripsi = new JPanel();
//        boxUntukTeksDeskripsi.setLayout(null);
        JLabel mencoba = new JLabel(buku.getDeskripsi());
        String teksAwal = mencoba.getText().trim();
        JLabel selengkapnya = new JLabel();
        selengkapnya.setForeground(Color.BLUE);
        if (teksAwal.length() > 300) {
            String teksTerpotong = teksAwal.substring(0, 300);
            mencoba.setText(teksTerpotong);
            selengkapnya.setText(" Selengkapnya.");
            selengkapnya.setBounds(280, 520, 300, 30);
            selengkapnya.setFont(new Font("Sans", Font.BOLD, 13));
        }

        System.out.println(mencoba.getText());
        JTextArea teksDeskripsi = new JTextArea();
        teksDeskripsi.setText(mencoba.getText());
        teksDeskripsi.setEditable(false);
        teksDeskripsi.setLineWrap(true);
        teksDeskripsi.setWrapStyleWord(true);
        teksDeskripsi.setBackground(detailBuku.getBackground());
        teksDeskripsi.setForeground(Color.black);
        teksDeskripsi.setBorder(null);
        teksDeskripsi.setFont(new Font("Sans",Font.ROMAN_BASELINE,12));
        FontMetrics fontMetrics = teksDeskripsi.getFontMetrics(teksDeskripsi.getFont());
        int lebarKonten = fontMetrics.stringWidth(teksDeskripsi.getText());
        int tinggiKonten = fontMetrics.getHeight() * teksDeskripsi.getLineCount();
        teksDeskripsi.setPreferredSize(new Dimension(lebarKonten, tinggiKonten));
        teksDeskripsi.setAlignmentX(Component.LEFT_ALIGNMENT);
            selengkapnya.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (ditekan) {
                        teksDeskripsi.setText(buku.getDeskripsi());
                        System.out.println(mencoba.getText());
                        ditekan = false;
                    }else {
                        String teksTerpotong = buku.getDeskripsi().substring(0, 300);
                        teksDeskripsi.setText(teksTerpotong);
                        ditekan = true;
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    selengkapnya.setForeground(new Color(149, 180, 230));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    selengkapnya.setForeground(Color.blue);
                }
            });
//            add(selengkapnya);


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
                    if (label[a].equalsIgnoreCase("Home")){
                        UserFrame home = new UserFrame();
                        home.user();
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

        String[] teksDetailTambahan = {
                " Detail Buku : ",
                "- Tahun terbit          : " + buku.getTanggalTerbi(),
                "- Jumlah Halaman : " + buku.getJumlahHalaman(),
                "- Stok Buku             : " + buku.getStockBuku(),
                "- Lokasi Rak            : " + buku.getPosisi(),
        };
        JButton pinjam = new JButton("PINJAM");
        pinjam.setBackground(Color.black);
        pinjam.setForeground(Color.WHITE);
        pinjam.setPreferredSize(new Dimension(400,30));
        pinjam.add(Box.createHorizontalStrut(getWidth()));

        pinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pinjamPanel pinjam = new pinjamPanel();
                pinjam.pinjam(buku,getWidth(),getHeight());
//                getContentPane().removeAll();
//                revalidate();
//                repaint();
//                pinjamPanel pinjam = new pinjamPanel();
//                JPanel panelPinjam = pinjam.pinjam(buku,getWidth(),getHeight());
//                getContentPane().add(panelPinjam);
            }
        });

        JScrollPane detaiBukuScroll = new JScrollPane();
        detaiBukuScroll.setViewportView(detailBuku);
        detaiBukuScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        detaiBukuScroll.setBounds(0,coverBuku.getHeight()+borderAtas.getHeight()+5,getWidth(),getHeight()-(borderAtas.getHeight()+coverBuku.getHeight())-62);

        detaiBukuScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI(){

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

        detailBuku.add(judulBuku);
        detailBuku.add(pengarang);
        detailBuku.add(Box.createVerticalStrut(10));
        detailBuku.add(tbintang);
        detailBuku.add(labelDeskripsi);
        detailBuku.add(teksDeskripsi);
        detailBuku.add(selengkapnya);
        for (String c : teksDetailTambahan){
            JLabel detailTambahan = new JLabel(c);
            detailTambahan.setForeground(Color.black);
            detailTambahan.setFont(new Font("Sans",Font.BOLD,13));
            detailBuku.add(detailTambahan);
        }
        detailBuku.add(pinjam);
        add(menuBawah);
        add(detaiBukuScroll);
        coverBuku.add(gambarCover);
        add(coverBuku);
        borderAtas.add(ketFrame);
        add(borderAtas);
        setVisible(true);
    }

}
//class maainn{
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                Model.ambil();
//                Model.initialData();
//                detailBukuFrame detaiBuku = new detailBukuFrame();
//                detaiBuku.detail(Model.getData().get(8));
//            }
//        });
//    }
//}
