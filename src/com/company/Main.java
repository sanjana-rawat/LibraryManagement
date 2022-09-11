package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main{

    public static void login(){
        // Create an Object for the frame
        JFrame frameLogin = new JFrame("Login");
        // Setting the size of the frame
        frameLogin.setSize(400,400);
        // Setting frame to fixed size
        frameLogin.setResizable(false);

        try {
            final Image backgroundImage = ImageIO.read(new File("C:\\Users\\shama\\Downloads\\photo.jpg"));
            frameLogin.setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Object for labels
        JLabel label1 = new JLabel("Username");
        // Label positions
        label1.setBounds(160,70,58,30);
        // Adding the label to the frame
        label1.setForeground(Color.WHITE);
        label1.setBackground(Color.black);
        label1.setOpaque(true);
        frameLogin.add(label1);

        // Adding Text field to the frame
        JTextField username = new JTextField();
        username.setBounds(140,110,100,30);
        frameLogin.add(username);


        JLabel label2 = new JLabel("Password");
        label2.setBounds(160,150,58,30);
        label2.setForeground(Color.WHITE);
        label2.setBackground(Color.black);
        label2.setOpaque(true);
        frameLogin.add(label2);

        // Adding Password field to the frame
        JPasswordField password = new JPasswordField();
        password.setBounds(140,190,100,30);
        frameLogin.add(password);

        // Adding Button to the table
        JButton loginbtn = new JButton("Login");
        loginbtn.setBounds(140,250,100,30);
        frameLogin.add(loginbtn);
        loginbtn.setBackground(Color.darkGray);
        loginbtn.setForeground(Color.green);
        loginbtn.setOpaque(true);
        loginbtn.setBorderPainted(false);

        // Creating a menubar
        JMenuBar mBar = new JMenuBar();
        mBar.setBounds(0,0,400,20);
        frameLogin.add(mBar);

        // To create a menu inside the menu bar
        JMenu menuFile = new JMenu("File");
        mBar.add(menuFile);

        // To create an item inside menu of the menubar
        JMenuItem mItem = new JMenuItem("Exit");
        menuFile.add(mItem);

        mItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // To exit out of the frame
                System.exit(0);
            }
        });

        // Setting the ActionListener to the button
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creating variable to store Username and Password
                String str1 = username.getText();
                String str2 = new String(password.getPassword());
                // Checking the condition if it satisfies the required condition
                if (str1.equals("admin") && str2.equals("admin")){
                    // Calling the new frame
                    Options.menu();
                    // To get rid of this frame when I switch to the next frame
                    frameLogin.dispose();
                } else {
                    // Displays a popup display
                    JOptionPane.showMessageDialog(frameLogin,"Invalid!");
                }
            }
        });

        frameLogin.setLayout(null); // To set the layout of the contents inside the frame
        frameLogin.setVisible(true);    // To make the frame visible
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exiting out of frame on pressing 'X' in the frame
    }

    public static void main(String[] args) {
	// Calling the static method
            login();
    }
}
