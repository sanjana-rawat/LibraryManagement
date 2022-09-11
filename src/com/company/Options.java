package com.company;

import com.company.menuItems.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Options {
    public static void menu() {
        // Creating a newer frame
        JFrame option = new JFrame("Menu");
        option.setSize(400,400);
        option.setResizable(false);
        try {
            final Image backgroundImage = ImageIO.read(new File("C:\\Users\\shama\\Downloads\\photo.jpg"));
            option.setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Setting Button parameters
        JButton btn1 = new JButton("Books Details");
        btn1.setBounds(120,80,150,30);
        option.add(btn1);
        btn1.setBackground(Color.lightGray);
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);


        JButton btn2 = new JButton("Issue Books");
        btn2.setBounds(120,130,150,30);
        option.add(btn2);
        btn2.setBackground(Color.lightGray);
        btn2.setOpaque(true);
        btn2.setBorderPainted(false);

        JButton btn3 = new JButton("Student Information");
        btn3.setBounds(120,180,150,30);
        option.add(btn3);
        btn3.setBackground(Color.lightGray);
        btn3.setOpaque(true);
        btn3.setBorderPainted(false);

        JButton btn4 = new JButton("Logout");
        btn4.setBounds(120,230,150,30);
        option.add(btn4);
        btn4.setBackground(Color.lightGray);
        btn4.setForeground(Color.red);
        btn4.setOpaque(true);
        btn4.setBorderPainted(false);

        // Adding the ActionListener to the button
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logs out from the account
                Main.login();
                // CLoses this frame
                option.dispose();
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling the newer frame when pressed on this button
                AddBook.book();
                // Closing this frame when that new frame is opened pressed
                option.dispose();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling the newer frame when pressed on this button
               IssueBooks.issued();
                // Closing this frame when that new frame is opened pressed
                option.dispose();
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling the newer frame when pressed on this button
                StudentInfo.info();
                // Closing this frame when that new frame is opened pressed
                option.dispose();
            }
        });

        option.setLayout(null); // To set the layout of the contents inside the frame
        option.setVisible(true);    // To make the frame visible
        option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exiting out of frame on pressing 'X' in the frame
    }

    public static void main(String[] args) {
        menu();
    }
}