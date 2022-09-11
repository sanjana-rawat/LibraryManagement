package com.company.menuItems;
import com.company.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentInfo {

    public static void info() {
        // Creating the object for this new frame
        JFrame stdInfo = new JFrame("Student Information");
        stdInfo.setSize(880,420);
        stdInfo.setResizable(false);
        // Creating the table object
        JTable table = new JTable();
        // Setting Table column headings
        Object[] columns = {"USN", "Student Name", "Semester", "Branch", "Hostel / Day Scholar"};

        // Implementing a table model in the frame
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        // Adding that table model into the frame
        table.setModel(model);
        table.setBackground(Color.orange);
        table.setForeground(Color.black);
        Font font = new Font("", 5, 15);
        table.setFont(font);
        table.setRowHeight(30);

        // Creating Labels to Enter specified data into the textfields
        JLabel box1 = new JLabel("USN");
        JLabel box2 = new JLabel("Name");
        JLabel box3 = new JLabel("Semester");
        JLabel box4 = new JLabel("Branch");
        JLabel box5 = new JLabel("Select");

        // Text fields to enter specified data
        JTextField usn = new JTextField();
        JTextField name = new JTextField();

        JButton btn1 = new JButton("Add Info");
        JButton btn2 = new JButton("Delete Info");
        JButton btn3 = new JButton("Update Info");
        JButton btn4 = new JButton("Previous");


        btn1.setBounds(635,220,100,25);
        btn2.setBounds(635,260,100,25);
        btn3.setBounds(635,300,100,25);
        btn4.setBounds(635,335,100,25);

        box1.setBounds(150, 220,100,25);
        usn.setBounds(200,220,100,25);

        box2.setBounds(350,220,100,25);
        name.setBounds(420,220,100,25);

        box3.setBounds(135,260,100,25);

        box4.setBounds(345,260,100,25);
        
        box5.setBounds(140,300,100,25);

        // Data inside first combo box
        String[] list1 = {"--Choose--", "8", "7", "6", "5", "4", "3", "2", "1"};
        // Data inside second combo box
        String[] list2 = {"--Choose--", "CSE", "ECE", "ME", "CIV", "EEE"};

        // Object created for combobox
        JComboBox cb1 = new JComboBox(list1);
        cb1.setBounds(200,260,100,25);
        // Adding that into the frame
        stdInfo.add(cb1);

        JComboBox cb2 = new JComboBox(list2);
        cb2.setBounds(420,260,100,25);
        stdInfo.add(cb2);

        // Creating an object for radio button
        JRadioButton rd1 = new JRadioButton("Hostel");
        rd1.setBounds(200,300,100,25);
        // Adding that into the frame
        stdInfo.add(rd1);


        JRadioButton rd2 = new JRadioButton("Day Scholar");
        rd2.setBounds(340,300,100,25);
        stdInfo.add(rd2);

        // Grouping the radio buttons so that only one gets selected on pressing
        ButtonGroup btngrp = new ButtonGroup();
        // Adding two radio buttons into the btngrp object
        btngrp.add(rd1);
        btngrp.add(rd2);

        // Used to make scrollable view of content
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0 ,880, 200);

        // Adding all table data into the pane
        stdInfo.add(pane);
        stdInfo.getContentPane().setBackground(Color.gray);

        stdInfo.add(box1);
        stdInfo.add(box2);
        stdInfo.add(box3);
        stdInfo.add(box4);
        stdInfo.add(box5);

        stdInfo.add(usn);
        stdInfo.add(name);

        stdInfo.add(btn1);
        btn1.setBackground(Color.white);
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);

        stdInfo.add(btn2);
        btn2.setBackground(Color.white);
        btn2.setOpaque(true);
        btn2.setBorderPainted(false);

        stdInfo.add(btn3);
        btn3.setBackground(Color.white);
        btn3.setOpaque(true);
        btn3.setBorderPainted(false);

        stdInfo.add(btn4);
        btn4.setBackground(Color.white);
        btn4.setForeground(Color.red);
        btn4.setOpaque(true);
        btn4.setBorderPainted(false);
        // Creating an Object array to store the data entered from the text fields to the table
        Object[] row = new Object[6];
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = new String();
                // Conditions to check if all the fields are filled
                if (usn.getText().isEmpty() || name.getText().isEmpty() || !(rd1.isSelected() || rd2.isSelected()) || cb1.getSelectedItem().toString().equals("--Choose--") || cb2.getSelectedItem().toString().equals("--Choose--")){
                    JOptionPane.showMessageDialog(stdInfo,"Please Enter Data");
                } else {
                    // Getting the data entered or selected into the table
                    row[0] = usn.getText();
                    row[1] = name.getText();
                    row[2] = cb1.getSelectedItem();
                    row[3] = cb2.getSelectedItem();

                    // Getting the data of the radio button into that table
                    if (rd1.isSelected()) {
                        select = "Hostel";
                    } else {
                        select = "Day Scholar";
                    }
                    row[4] = select;

                    // Adding this row data into the table model
                    model.addRow(row);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Storing the selected table in an integer type
                int i = table.getSelectedRow();
                if (i >= 0) {
                    model.removeRow(i);
                }
                else {
                    JOptionPane.showMessageDialog(stdInfo,"No Data Selected or Entered");
                }
            }
        });

        // Adding a Mouse listener
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Storing the selected table in an integer type
                int i = table.getSelectedRow();

                // Setting the value entered in the text field to string
                usn.setText(model.getValueAt(i, 0).toString());
                name.setText(model.getValueAt(i,1).toString());
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = new String();
                int i = table.getSelectedRow();

                // Updating the value of the table at the given index
                if (i >= 0){
                    model.setValueAt(usn.getText(), i, 0);
                    model.setValueAt(name.getText(),i ,1);
                    model.setValueAt(cb1.getSelectedItem(),i,2);
                    model.setValueAt(cb2.getSelectedItem(),i,3);
                    if (rd1.isSelected()) {
                        str = "Hostel";
                    } else {
                        str = "Day Scholar";
                    }
                    model.setValueAt(str,i,4);
                } else {
                    JOptionPane.showMessageDialog(stdInfo,"Update Error");
                }
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opens the Options frame by calling the method in that class
                Options.menu();
                // Closes this frame
                stdInfo.dispose();
            }
        });

        stdInfo.setLayout(null);
        stdInfo.setVisible(true);
        stdInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        info();
    }
}
