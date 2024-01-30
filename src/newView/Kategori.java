package newView;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kategori extends JFrame {
        public void KategoriFrame(){
            setSize(430,800);
            setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setUndecorated(true);
            getContentPane().setBackground(new Color(26, 18, 11));

            JPanel borderAtas = new JPanel();
            borderAtas.setBounds(0,0,430,40);
            borderAtas.setBackground(Color.black);
//            borderAtas.setLayout(null);
            Font fontKeterangan = new Font("Consolas",Font.BOLD,15);

            JLabel ketFrame = new JLabel("Kategori");
            ketFrame.setForeground(Color.white);
            ketFrame.setFont(fontKeterangan);

            JLabel keterangan=new JLabel("Kategori");
            keterangan.setBounds(30,50,400,30);
            keterangan.setForeground(Color.white);
            keterangan.setFont(fontKeterangan);

            JPanel pKategori = new JPanel();
//            pKategori.setLayout(new BoxLayout(pKategori, BoxLayout.Y_AXIS));
            pKategori.setLayout(null);
            pKategori.setBackground(null);
            pKategori.setBounds(0,90,430,710);
            JLabel[] lKategori ={
                    new JLabel("Fiksi"),
                    new JLabel("Non-Fiksi"),
                    new JLabel("Pendidikan dan Pembelajaran"),
                    new JLabel("Seni dan desain"),
                    new JLabel("kuliner dan masak"),
                    new JLabel("Teknologi dan komputer")
            };

            JPanel kategoriPilihan ;
            JScrollPane scroll = new JScrollPane();
            kategoriPilihan = new JPanel();
            kategoriPilihan.setBounds(0,0,430,710);
            kategoriPilihan.setLayout(new BoxLayout(kategoriPilihan,BoxLayout.Y_AXIS));
//            kategoriPilihan.setLayout(null);
            kategoriPilihan.setBackground(null);
            int tesX = 30;
            JLabel ketKategori = new JLabel();
            ketKategori.setForeground(Color.black);
            kategoriPilihan.add(ketKategori);
            for (int i = 0 ; i <=20;i++){
                Font newfont = new Font("Arial",Font.BOLD,30);
                JButton tes = new JButton("tes");
                tes.setForeground(Color.white);
                tes.setBackground(Color.black);
                tes.setFont(newfont);
                tes.setPreferredSize(new Dimension(400,100));
                tes.setMaximumSize(new Dimension(400,100));

                kategoriPilihan.add(Box.createVerticalStrut(10));
                kategoriPilihan.add(tes);
                tesX+=90;
            }

            scroll.setBounds(0,90,430,650);
            scroll.setViewportView(kategoriPilihan);
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
            scroll.setVisible(false);

            int yTombolKategori = 50;
            Font fontKategori = new Font("Consolas",Font.BOLD,20);

            for( JLabel a : lKategori){
                a.setForeground(Color.white);
                a.setFont(fontKategori);

                JButton bKategori = new JButton();
                bKategori.setBackground(Color.black);
                bKategori.setBorderPainted(false);
                bKategori.setFocusPainted(false);
                bKategori.setBounds(20,yTombolKategori,400,50);


//                JScrollPane scroll2 = scroll;
                bKategori.add(a);
                pKategori.add(bKategori);
                yTombolKategori+=100;
                bKategori.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (a.getText().equalsIgnoreCase("Fiksi") ){
                            scroll.setVisible(true);
                            pKategori.setVisible(false);
                            keterangan.setText(a.getText());
                        } else if (a.getText().equalsIgnoreCase("Non-Fiksi")) {
                            scroll.setVisible(true);
                            pKategori.setVisible(false);
                            keterangan.setText(a.getText());
                        }else if (a.getText().equalsIgnoreCase("Pendidikan dan Pembelajaran")) {
                            scroll.setVisible(true);
                            pKategori.setVisible(false);
                            keterangan.setText(a.getText());
                        }else if (a.getText().equalsIgnoreCase("Seni dan desain")) {
                            scroll.setVisible(true);
                            pKategori.setVisible(false);
                            keterangan.setText(a.getText());
                        }else if (a.getText().equalsIgnoreCase("kuliner dan masak")) {
                            scroll.setVisible(true);
                            pKategori.setVisible(false);
                            keterangan.setText(a.getText());
                        }else if (a.getText().equalsIgnoreCase("Teknologi dan komputer")) {
                            scroll.setVisible(true);
                            pKategori.setVisible(false);
                            keterangan.setText(a.getText());
                        }
                    }
                });

            }

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
                JLabel lMenuBawah = new JLabel(label[i]);
                lMenuBawah.setBounds(xLabel, 40, 100, 20);
                lMenuBawah.setFont(fontKeterangan);
                lMenuBawah.setForeground(Color.white);
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
                tombol.add(lMenuBawah);
                tombol.add(kategori);
                menuBawah.add(tombol);

            }

            borderAtas.add(ketFrame);
            add(scroll);
            add(menuBawah);
            add(pKategori);
            add(keterangan);
            add(borderAtas);
            setVisible(true);

        }
    }
    class maaasinn{
        public static void main(String[] args) {
            Kategori kategori = new Kategori();
            kategori.KategoriFrame();
        }
    }

