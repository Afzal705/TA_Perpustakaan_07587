package newView;

import Controller.ControlControler;
import Entity.BukuEntity;
import Entity.Peminjam;
import Model.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class DataPeminjamPanel {

    ControlControler control = new ControlControler();
    public JPanel tampilDataPeminjam(JFrame induk) {
        int nomor = 1;
        JPanel tampilData = new JPanel();
        tampilData.setBounds(205,105,975,550);
        tampilData.setBackground(Color.white);
        tampilData.setLayout(null);

        JPanel boxTabel = new JPanel();
        boxTabel.setBackground(Color.lightGray);



        String[] kolom = {"NO.","Nama ","Judul", "Pengarang", "Penerbit", "Lama Pinjam", "Biaya","No-Telp" };

        DefaultTableModel tableModel = new DefaultTableModel(null, kolom);


        for (Peminjam p : control.ambilDataPeminjam()) {
            tableModel.addRow(new Object[]{
                    nomor,
                    p.getNama(),
                    p.getBuku().getJudul(),
                    p.getBuku().getPengarang(),
                    p.getBuku().getPenerbit(),
                    p.getLamaPinjam()+"Hari",
                    p.getBiaya(),
                    p.getNoTelp(),
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


        JScrollPane scrollTampilData = new JScrollPane(table);
        scrollTampilData.setBounds(0, 0, tampilData.getWidth(), tampilData.getHeight());
        tampilData.add(scrollTampilData);
        return tampilData;
    }

}
