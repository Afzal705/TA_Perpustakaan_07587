package newView;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PengunjungFrame {
    private static final int FRAME_WIDTH = 430;
    private static final int FRAME_HEIGHT = 800;
    private static final int animasi = 10;
    private int nilai = 0;

    private JFrame frame;
    private JPanel backgroundsPanel;
    private JLabel[] backgrounds;

    private int sumbux = 0;
    private Timer animationTimer;

    private void animate() {
        sumbux += 10;
        System.out.println(sumbux);
        if (sumbux >= FRAME_WIDTH * 2 + 11) {
            sumbux = 0;
        }
        if (sumbux == 0 || sumbux == FRAME_WIDTH || sumbux == (FRAME_WIDTH * 2)) {
            animationTimer.stop();
            Timer delay = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    animationTimer.start();
                }
            });
            delay.setRepeats(false);
            delay.start();
        }
        backgroundsPanel.setLocation(-sumbux, 0);

        frame.revalidate();
        frame.repaint();
    }

    private void startAnimation() {
        animationTimer = new Timer(animasi, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
            }
        });
        animationTimer.start();
        Timer checkTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nilai == 1) {
                    System.out.println("Nilai nilai = " + nilai);
                    frame.dispose();
                }
            }
        });

    }

    public PengunjungFrame() {
        frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        backgroundsPanel = new JPanel(null);
        backgroundsPanel.setSize(FRAME_WIDTH * 3, FRAME_HEIGHT);
        backgroundsPanel.setOpaque(false);

        backgrounds = new JLabel[3];

        // Load images
        ImageIcon[] images = {
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\anime.jpg"),
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\anime2.jpg"),
                new ImageIcon("C:\\Users\\hp\\IdeaProjects\\GUI\\src\\img\\back3.jpg"),
        };

        Font font = new Font("Arial", Font.BOLD, 20);
        JButton tombol = new JButton("GET STARTED");
        tombol.setBounds(FRAME_WIDTH / 2 - 100, FRAME_HEIGHT - 120, 200, 40);
        tombol.setBorderPainted(false);
        tombol.setFocusPainted(false);
        tombol.setBackground(Color.black);
        tombol.setForeground(Color.white);
        tombol.setFont(font);


        for (int i = 0; i < backgrounds.length; i++) {
            Image img = images[i].getImage();
            Image scaledImage = img.getScaledInstance(FRAME_WIDTH, FRAME_HEIGHT, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            backgrounds[i] = new JLabel(scaledIcon);
            backgrounds[i].setSize(FRAME_WIDTH, FRAME_HEIGHT);
            backgrounds[i].setOpaque(false);
            backgroundsPanel.add(backgrounds[i]);
            backgrounds[i].setLocation(i * FRAME_WIDTH, 0);
        }


        frame.add(tombol);
        frame.add(backgroundsPanel);

        tombol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nilai += 1;

                UserFrame user = new UserFrame();
                user.user();
            }
        });

        frame.setVisible(true);
        if (nilai == 0) {
            startAnimation();
        } else if (nilai == 1) {
            System.out.println("Nilai nilai = " + nilai);
            frame.dispose();
        }
    }
}

//class miiiimn{
//    public static void main(String[] args) {
////        SwingUtilities.invokeLater(new Runnable() {
////            @Override
////            public void run() {
//                new PengunjungFrame();
////            }
//
////        });
//    }
//}
