package newView;

import Controller.ControlControler;
import Entity.BukuEntity;
import Model.Model;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class CrudPanel {
private JTextField[] input=new JTextField[7];
private JTextArea deskripsiBuku;
private ControlControler control = new ControlControler();
private JScrollPane scrollTampilData;
private int kodePerubahan =0;

        public JPanel tambahData(){
            JPanel tambahData = new JPanel();
            tambahData.setBounds(205,105,975,590);
            tambahData.setBackground(Color.white);
            tambahData.setLayout(null);

            JPanel box = new JPanel();
            box.setBounds(10,10,600,500);
            box.setBackground(Color.lightGray);
            box.setLayout(null);

            String[] keterangan = {
                    "JUDUL BUKU           => ",
                    "PENGARANG            => ",
                    "PERBIT                      => ",
                    "JUMLAH HALAMAN  => ",
                    "STOK BUKU             =>",
                    "POSISI RAK              =>",
                    "TAHUN TERBIT       =>",
                    "DESKRIPSI BUKU    =>",
            };
            int y= 50;
            for ( String i : keterangan){
                JLabel label = new JLabel();
                label.setText(i);
                label.setBounds(20,y,200,30);
                box.add(label);
                y+=40;
            }
            int yFiled = 53;
            for (int i = 0 ; i < keterangan.length-3;i++){
                JTextField teks = new JTextField();
                input[i]=teks;
            }
            for(int i = 0 ; i < keterangan.length-3;i++){

                input[i].setBounds(155,yFiled,200,20);
                input[i].setBorder(null);
                box.add(input[i]);
                yFiled+=40;

            }
            String[] rak = {"Rak Novel","Rak Teknologi/TI","Pembelajaran ","rak Kuliner" ,"anak anak"};
            JComboBox pilihRak = new JComboBox(rak);
            pilihRak.setBounds(155,yFiled,200,20);
            box.add(pilihRak);

            JTextField tahunTerbit = new JTextField();
            tahunTerbit.setBounds(155,yFiled+40,200,20);
            tahunTerbit.setBorder(null);


            deskripsiBuku = new JTextArea();
            deskripsiBuku.setWrapStyleWord(true);
            deskripsiBuku.setLineWrap(true);

            JScrollPane scrollDeskripsi = new JScrollPane();
            scrollDeskripsi.setViewportView(deskripsiBuku);
            scrollDeskripsi.setBounds(155,yFiled+80,400,100);
            box.add(scrollDeskripsi);



            JPanel pilihGambar = new JPanel();
            pilihGambar.setBackground(Color.gray);
            pilihGambar.setBounds(650,90,300,400);
            pilihGambar.setLayout(null);


            JLabel Gambar = new JLabel("GAMBAR");
            Gambar.setBounds(120,10,100,40);
            Gambar.setFont(new Font("Consolas",Font.BOLD,20));
            Gambar.setForeground(Color.white);

            JLabel gambarDiPilih = new JLabel();

            JPanel boxGambar = new JPanel();
            boxGambar.setBounds(5,70,290,200);
            boxGambar.setBackground(Color.white);

            JButton pilih = new JButton("Pilih Gambar ");
            pilih.setBounds(0,350,300,50);
            pilih.setBorderPainted(false);
            pilih.setBackground(Color.black);
            pilih.setForeground(Color.white);

            JLabel url = new JLabel("Lokasi Gambar         =>");
            url.setBounds(20,y,300,20);
            JTextField lokasiFile = new JTextField();
            lokasiFile.setEditable(false);
            lokasiFile.setBounds(0,320,300,30);

            pilih.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser pilihFile = new JFileChooser();
                    pilihFile.setCurrentDirectory(new File(System.getProperty("user.home")));

                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
                    pilihFile.setFileFilter(filter);

                    int result = pilihFile.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = pilihFile.getSelectedFile();
                        String imagePath = selectedFile.getAbsolutePath();
                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        Image image = imageIcon.getImage().getScaledInstance(boxGambar.getWidth(),boxGambar.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon pilihan = new ImageIcon(image);
                        gambarDiPilih.setIcon(pilihan);
                        gambarDiPilih.setBounds(5,70,gambarDiPilih.getWidth(),gambarDiPilih.getHeight());


                        lokasiFile.setText(imagePath);
                    }
                }

            });

            JButton submit = new JButton("SUBMIT");
            submit.setForeground(Color.white);
            submit.setBackground(Color.black);
            submit.setBorderPainted(false);
            submit.setBounds(0,box.getHeight()-40,600,40);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String judul = input[0].getText();
                    String pengarang =input[1].getText();
                    String penerbit=input[2].getText();
                    int jumlahHalaman= Integer.parseInt(input[3].getText());
                    int stokBuku= Integer.parseInt(input[4].getText());
                    String Posisi=pilihRak.getActionCommand();
                    ImageIcon gambar = new ImageIcon(lokasiFile.getText());
                    String tanggal = tahunTerbit.getText();
                    String deskripsi = deskripsiBuku.getText();
                    control.tambahBuku(new BukuEntity(judul,pengarang,Posisi,tanggal,penerbit,jumlahHalaman,stokBuku,gambar,deskripsi));
                    JOptionPane.showMessageDialog(tambahData,"BERHASIL MENAMBAH DATA");

                }
            });

            box.add(tahunTerbit);
            box.add(submit);
            boxGambar.add(gambarDiPilih);
            pilihGambar.add(boxGambar);
            pilihGambar.add(pilih);
            pilihGambar.add(Gambar);
            pilihGambar.add(lokasiFile);
            tambahData.add(pilihGambar);
            tambahData.add(box);

        return tambahData;
    }

    public JPanel tampilData(JFrame induk) {
        kodePerubahan = 0;
        int nomor = 1;
        JPanel tampilData = new JPanel();
        tampilData.setBounds(205,105,975,550);
        tampilData.setBackground(Color.white);
        tampilData.setLayout(null);

        JPanel boxTabel = new JPanel();
        boxTabel.setBackground(Color.lightGray);



        String[] kolom = {"NO.", "Judul", "Pengarang", "Penerbit", "Jumlah Halaman", "Stok Buku", "Posisi Rak" };

        DefaultTableModel tableModel = new DefaultTableModel(null, kolom);


            for (BukuEntity b : control.ambilDataBuku()) {
                tableModel.addRow(new Object[]{
                        nomor,
                        b.getJudul(),
                        b.getPengarang(),
                        b.getPenerbit(),
                        b.getJumlahHalaman(),
                        b.getStockBuku(),
                        b.getPosisi(),
                });

                nomor++;
            }

        JTable table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setCellEditor(new DefaultCellEditor(new JTextField()));

            if (i == 0) {
                column.setPreferredWidth(30);
                column.setMaxWidth(30);

            }
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedColumn = table.columnAtPoint(e.getPoint());
                    int pilihCell = table.rowAtPoint(e.getPoint());

                    if (selectedColumn != -1 && pilihCell != -1) {
                        if (selectedColumn == 1) {

                                String judulDiKolom = (String) table.getValueAt(pilihCell, selectedColumn);
                                System.out.println(judulDiKolom);

                                JWindow detailBuku = new JWindow(induk);
                                detailBuku.setSize(1200, 700);
                                detailBuku.setBackground(new Color(0, 0, 0, 197));
                                detailBuku.setLayout(null);

                                JPanel back = new JPanel();
                                back.setBounds((induk.getWidth() / 2) - 800 / 2, (induk.getHeight() / 2) - 500 / 2, 800, 500);
                                back.setBackground(Color.white);
                                back.setLayout(null);


                                JPanel backCoverBuku = new JPanel();
                                backCoverBuku.setBounds(0, 0, back.getWidth() / 2, back.getHeight());
                                backCoverBuku.setBackground(Color.darkGray);
                                backCoverBuku.setLayout(new BorderLayout());
                                back.add(backCoverBuku);

                                BukuEntity buku = control.periksaKecocokan(1,judulDiKolom);
                                if (buku!= null){
                                    JLabel cover = new JLabel(buku.getGambar());

                                    backCoverBuku.add(cover,BorderLayout.CENTER);
                                }

                                ImageIcon iconClose = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\Icon\\icons8-close-50.png");
                                Image ukuran = iconClose.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
                                ImageIcon iconKeluar = new ImageIcon(ukuran);
                                JLabel close = new JLabel(iconKeluar);
                                close.setBounds (1000,100,iconKeluar.getIconWidth(),iconKeluar.getIconHeight());
                                close.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        detailBuku.dispose();
                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {
                                        close.setBounds (1000,105,iconKeluar.getIconWidth(),iconKeluar.getIconHeight());
                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {
                                        close.setBounds (1000,100,iconKeluar.getIconWidth(),iconKeluar.getIconHeight());
                                    }
                                });
                                Font font = new Font("Sans",Font.BOLD,13);
                                String[] keterangan = {
                                        "PENGARANG              => ",
                                        "PENERBIT                   => ",
                                        "JUMLAH HALAMAN  => ",
                                        "STOK BUKU                =>",
                                        "POSISI RAK                 =>",
                                        "TAHUN TERBIT          =>",

                                };
                                int y= 60;
                                for ( String i : keterangan){
                                    JLabel label = new JLabel();
                                    label.setText(i);
                                    label.setBounds((back.getWidth()/2),y,back.getWidth()-100,40);
                                    label.setFont(font);
                                    back.add(label);
                                    y+=40;
                                }

                                JTextField judulBuku = new JTextField(buku.getJudul());
                                judulBuku.setBounds(back.getWidth()/2+5,10,back.getWidth()-100,50);
                                judulBuku.setFont(new Font("Sans",Font.BOLD,20));
                                judulBuku.setEditable(false);
                                judulBuku.setBorder(null);


                                JTextField pengarang = new JTextField(buku.getPengarang());
                                pengarang.setBounds((back.getWidth()/2)+145,65,back.getWidth()-100,30);
                                pengarang.setFont(font);
                                pengarang.setEditable(false);
                                pengarang.setBackground(null);
                                pengarang.setBorder(null);

                                JTextField penerbit = new JTextField(buku.getPenerbit());
                                penerbit.setBounds((back.getWidth()/2)+145,105,back.getWidth()-100,30);
                                penerbit.setFont(font);
                                penerbit.setEditable(false);
                                penerbit.setBackground(null);
                                penerbit.setBorder(null);

                                JTextField jumlahHalaman = new JTextField(String.valueOf(buku.getJumlahHalaman()));
                                jumlahHalaman.setBounds((back.getWidth()/2)+145,145,back.getWidth()-100,30);
                                jumlahHalaman.setFont(font);
                                jumlahHalaman.setEditable(false);
                                jumlahHalaman.setBackground(null);
                                jumlahHalaman.setBorder(null);

                                JTextField stokBuku = new JTextField(String.valueOf(buku.getStockBuku()));
                                stokBuku.setBounds((back.getWidth()/2)+145,185,back.getWidth()-100,30);
                                stokBuku.setFont(font);
                                stokBuku.setEditable(false);
                                stokBuku.setBackground(null);
                                stokBuku.setBorder(null);

                                JTextField labelRak = new JTextField(buku.getPosisi());
                                labelRak.setBounds((back.getWidth()/2)+145,235,200,20);
                                labelRak.setFont(font);
                                labelRak.setBackground(null);
                                labelRak.setBorder(null);


                                String[] rak = {"Rak Novel","Rak Teknologi/TI","Pembelajaran ","rak Kuliner" ,"anak anak"};
                                JComboBox pilihRak = new JComboBox(rak);
                                pilihRak.setBounds((back.getWidth()/2)+145,235,200,20);
                                pilihRak.setEditable(false);
                                pilihRak.setVisible(false);

                                JTextField tanggalTerbit = new JTextField(buku.getTanggalTerbi());
                                tanggalTerbit.setFont(font);
                                tanggalTerbit.setBounds((back.getWidth()/2)+145,265,back.getWidth()-100,30);
                                tanggalTerbit.setEditable(false);
                                tanggalTerbit.setBackground(null);
                                tanggalTerbit.setBorder(null);



                                JLabel labeldeskripsi = new JLabel("Deskripsi");
                                labeldeskripsi.setBounds(back.getWidth()/2,back.getHeight()-200,back.getWidth()/2,50);
                                labeldeskripsi.setFont(new Font("Sans",Font.BOLD,15));

                                JTextArea deskirpsiBuku = new JTextArea();
                                deskirpsiBuku.setEditable(false);
                                deskirpsiBuku.setWrapStyleWord(true);
                                deskirpsiBuku.setLineWrap(true);
                                deskirpsiBuku.setText(buku.getDeskripsi());

                                JScrollPane scroll = new JScrollPane();
                                scroll.setViewportView(deskirpsiBuku);
                                scroll.setBounds(back.getWidth()/2,back.getHeight()-150,back.getWidth()/2,150);

                                ImageIcon iconSampah = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\Icon\\icons8-trash-50.png");
                                Image ukuranIconsampah = iconSampah.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH);
                                ImageIcon iconHapus = new ImageIcon(ukuranIconsampah);
                                JLabel tombolHapus = new JLabel();
                                tombolHapus.setIcon(iconHapus);
                                tombolHapus.setBounds((detailBuku.getWidth()/2)-100,30,50,50);
                                tombolHapus.setBackground(null);
                                tombolHapus.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        int a= JOptionPane.showConfirmDialog(back,"YAKIN INGIN MENGHAPUS DATA ?");
                                        if (a == JOptionPane.YES_OPTION){
                                            control.hapusBuku(buku.getJudul());
                                            detailBuku.dispose();
                                            JOptionPane.showMessageDialog(null,"Tekan Tombol Tampil Data Untuk Refresh");
                                        }
                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {
                                        super.mouseEntered(e);
                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {
                                        super.mouseExited(e);
                                    }
                                });

                                JButton konfirmasi = new JButton("KONFIRMASI");
                                konfirmasi.setBackground(Color.blue);
                                konfirmasi.setForeground(Color.black);
                                konfirmasi.setFocusPainted(false);
                                konfirmasi.setBounds(detailBuku.getWidth()/2-75,610,150,30);
                                konfirmasi.setVisible(false);

                                ImageIcon iconUpdate = new ImageIcon("C:\\Users\\hp\\IdeaProjects\\TA_Perpustakaan - Swing\\src\\img\\Icon\\update.png");
                                Image ukuranIconUpdate = iconUpdate.getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH);
                                ImageIcon iconPerbarui = new ImageIcon(ukuranIconUpdate);
                                JLabel tombolUpdate = new JLabel();
                                tombolUpdate.setIcon(iconPerbarui);
                                tombolUpdate.setBounds((detailBuku.getWidth()/2)+100,30,50,50);
                                tombolUpdate.setBackground(null);

                                tombolUpdate.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        konfirmasi.setVisible(true);

                                        judulBuku.setEditable(true);
                                        judulBuku.setBackground(Color.lightGray);
                                        judulBuku.setCaretColor(Color.black);

                                        pengarang.setEditable(true);
                                        pengarang.setBackground(Color.lightGray);
                                        pengarang.setCaretColor(Color.black);

                                        penerbit.setEditable(true);
                                        penerbit.setBackground(Color.lightGray);
                                        penerbit.setCaretColor(Color.black);

                                        jumlahHalaman.setEditable(true);
                                        jumlahHalaman.setBackground(Color.lightGray);
                                        jumlahHalaman.setCaretColor(Color.black);

                                        stokBuku.setEditable(true);
                                        stokBuku.setBackground(Color.lightGray);
                                        stokBuku.setCaretColor(Color.black);

                                        labelRak.setVisible(false);
                                        pilihRak.setVisible(true);

                                        tanggalTerbit.setEditable(true);
                                        tanggalTerbit.setBackground(Color.lightGray);
                                        tanggalTerbit.setCaretColor(Color.black);

                                        deskirpsiBuku.setEditable(true);
                                        deskirpsiBuku.setBackground(Color.lightGray);
                                        deskirpsiBuku.setCaretColor(Color.black);


                                        konfirmasi.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                            String ambilJudul = judulBuku.getText();
                                            String ambilPengarang = pengarang.getText();
                                            String ambilPenerbit = penerbit.getText();
                                            int ambilJmlHalaman = Integer.parseInt(jumlahHalaman.getText());
                                            int ambilStok = Integer.parseInt(stokBuku.getText());
                                            String ambilRak = (String) pilihRak.getItemAt(pilihRak.getSelectedIndex());
                                            String ambilTahun = tanggalTerbit.getText();
                                            String ambilDeskripsi = deskirpsiBuku.getText();
                                            control.updateBuku(buku,ambilJudul,ambilPengarang,ambilPenerbit,ambilJmlHalaman,ambilStok,ambilRak,ambilTahun,ambilDeskripsi);
                                            detailBuku.dispose();
                                            JOptionPane.showMessageDialog(null,"Tekan Tombol Tampil Data Untuk Refresh");
                                            }
                                        });

                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {
                                        super.mouseEntered(e);
                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {
                                        super.mouseExited(e);
                                    }
                                });

                                detailBuku.add(konfirmasi);
                                detailBuku.add(tombolUpdate);
                                detailBuku.add(tombolHapus);
                                back.add(tanggalTerbit);
                                back.add(labelRak);
                                back.add(pilihRak);
                                back.add(stokBuku);
                                back.add(jumlahHalaman);
                                back.add(penerbit);
                                back.add(pengarang);
                                back.add(judulBuku);
                                back.add(labeldeskripsi);
                                back.add(scroll);
                                detailBuku.add(close);
                                detailBuku.add(back);
                                detailBuku.setLocationRelativeTo(induk);
                                detailBuku.setVisible(true);

                                System.out.println("bisakok");


                        }
                    }
                }
            }
        });


        scrollTampilData = new JScrollPane(table);
        scrollTampilData.setBounds(0, 0, tampilData.getWidth(), tampilData.getHeight());
        tampilData.add(scrollTampilData);
        return tampilData;
    }
    public  int perubahan(){
        if (kodePerubahan == 1){
            System.out.println(kodePerubahan);
            return kodePerubahan;
        }
        System.out.println(kodePerubahan);
        return kodePerubahan;
    }
}
