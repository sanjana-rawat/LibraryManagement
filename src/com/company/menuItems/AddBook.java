package com.company.menuItems;
import com.company.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddBook{

    public static void book() {
        // Creating the object for this new frame
        JFrame books = new JFrame("Adding Book");
        books.setSize(880,420);
        books.setResizable(false);


        // Creating the table object
        JTable table = new JTable();
        // Setting Table column headings
        Object[] columns = {"ID", "Book Name", "Author", "Domain"};
        // Implementing a table model in the frame
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        // Adding that table model into the frame
        table.setModel(model);
        // Setting background for the table
        table.setBackground(Color.orange);
        table.setForeground(Color.black);
        Font font = new Font("", 5, 15);
        table.setFont(font);
        table.setRowHeight(30);

        // Creating Labels to Enter specified data into the text fields
        JLabel box1 = new JLabel("ID");
        JLabel box2 = new JLabel("Name");
        JLabel box3 = new JLabel("Author");
        JLabel box4 = new JLabel("Domain");


        // Text fields to enter specified data
        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtAuthor = new JTextField();
        JTextField txtDomain = new JTextField();

        JButton btn1 = new JButton("Add");
        JButton btn2 = new JButton("Delete");
        JButton btn3 = new JButton("Update");
        JButton btn4 = new JButton("Previous");


        btn1.setBounds(700,220,100,25);
        btn2.setBounds(700,260,100,25);
        btn3.setBounds(700,300,100,25);
        btn4.setBounds(700,335,100,25);

        box1.setBounds(30, 260,100,25);
        txtId.setBounds(50,260,100,25);

        box2.setBounds(180,260,100,25);
        txtName.setBounds(220,260,100,25);

        box3.setBounds(340,260,100,25);
        txtAuthor.setBounds(390,260,100,25);

        box4.setBounds(510,260,100,25);
        txtDomain.setBounds(560,260,100,25);

        // Used to make scrollable view of content
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0 ,880, 200);

        // Adding all table data into the pane
        books.add(pane);
        books.getContentPane().setBackground(Color.gray);
        books.add(box1);
        books.add(box2);
        books.add(box3);
        books.add(box4);

        books.add(txtId);
        books.add(txtName);
        books.add(txtAuthor);
        books.add(txtDomain);

        books.add(btn1);
        btn1.setBackground(Color.white);
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);

        books.add(btn2);
        btn2.setBackground(Color.white);
        btn2.setOpaque(true);
        btn2.setBorderPainted(false);

        books.add(btn3);
        btn3.setBackground(Color.white);
        btn3.setOpaque(true);
        btn3.setBorderPainted(false);

        books.add(btn4);
        btn4.setBackground(Color.white);
        btn4.setForeground(Color.red);
        btn4.setOpaque(true);
        btn4.setBorderPainted(false);

        // Creating an Object array to store the data entered from the text fields to the table
        Object[] row = new Object[4];
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    // Conditions to check if all the fields are filled
                    if (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtAuthor.getText().isEmpty() || txtDomain.getText().isEmpty()){
                        JOptionPane.showMessageDialog(books,"Please Enter Data");
                    } else {
                        // Getting the data entered into the table
                        row[0] = txtId.getText();
                        row[1] = txtName.getText();
                        row[2] = txtAuthor.getText();
                        row[3] = txtDomain.getText();
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
                // Checking if there is a data in the table to delete
                if (i >= 0) {
                    model.removeRow(i);
                }
                else {
                    JOptionPane.showMessageDialog(books,"No Data Selected or Entered");
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
                    txtId.setText(model.getValueAt(i, 0).toString());
                    txtName.setText(model.getValueAt(i,1).toString());
                    txtAuthor.setText(model.getValueAt(i,2).toString());
                    txtDomain.setText(model.getValueAt(i,3).toString());
                }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0){
                    // Updating the value of the table at the given index
                    model.setValueAt(txtId.getText(), i, 0);
                    model.setValueAt(txtName.getText(),i ,1);
                    model.setValueAt(txtAuthor.getText(), i,2);
                    model.setValueAt(txtDomain.getText(), i,3);
                } else {
                   JOptionPane.showMessageDialog(books,"Update Error");
                }
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calling the method of Options to open the previous frame
                Options.menu();
                // Closes this frame
                books.dispose();
            }
        });

        books.setLayout(null);
        books.setVisible(true);
        books.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
       book();
    }
}
