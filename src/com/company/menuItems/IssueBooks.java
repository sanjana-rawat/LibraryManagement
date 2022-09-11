package com.company.menuItems;

import com.company.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IssueBooks {

    public static void issued() {

                JFrame issue = new JFrame("Issue Books");
                issue.setSize(880,420);
                issue.setResizable(false);

                // Creating the table object
                JTable table = new JTable();
                // Setting Table column headings
                Object[] columns = {"Book ID", "Book Name", "Student ID", "Student Name"};

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
                JLabel box1 = new JLabel("Book ID");
                JLabel box2 = new JLabel("Book Name");
                JLabel box3 = new JLabel("Student ID");
                JLabel box4 = new JLabel("Student Name");

                // Text fields to enter specified data
                JTextField bookId = new JTextField();
                JTextField bookName = new JTextField();
                JTextField stdId = new JTextField();
                JTextField stdName = new JTextField();

                JButton btn1 = new JButton("Issue");
                JButton btn2 = new JButton("Delete");
                JButton btn3 = new JButton("Update");
                JButton btn4 = new JButton("Back");


                btn1.setBounds(635,220,100,25);
                btn2.setBounds(635,260,100,25);
                btn3.setBounds(635,300,100,25);
                btn4.setBounds(635,335,100,25);

                box1.setBounds(150, 260,100,25);
                bookId.setBounds(200,260,100,25);

                box2.setBounds(350,260,100,25);
                bookName.setBounds(420,260,100,25);

                box3.setBounds(135,300,100,25);
                stdId.setBounds(200,300,100,25);

                box4.setBounds(335,300,100,25);
                stdName.setBounds(420,300,100,25);

                // Used to make scrollable view of content
                JScrollPane pane = new JScrollPane(table);
                pane.setBounds(0, 0 ,880, 200);

                // Adding all table data into the pane
                issue.add(pane);
                issue.getContentPane().setBackground(Color.gray);

                issue.add(box1);
                issue.add(box2);
                issue.add(box3);
                issue.add(box4);

                issue.add(bookId);
                issue.add(bookName);
                issue.add(stdId);
                issue.add(stdName);

                issue.add(btn1);
                btn1.setBackground(Color.white);
                btn1.setOpaque(true);
                btn1.setBorderPainted(false);
                issue.add(btn2);
                btn2.setBackground(Color.white);
                btn2.setOpaque(true);
                btn2.setBorderPainted(false);
                issue.add(btn3);
                btn3.setBackground(Color.white);
                btn3.setOpaque(true);
                btn3.setBorderPainted(false);
                issue.add(btn4);
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
                        if (bookId.getText().isEmpty() || bookName.getText().isEmpty() || stdId.getText().isEmpty() || stdName.getText().isEmpty()){
                            JOptionPane.showMessageDialog(issue,"Please Enter Data");
                        } else {
                            // Getting the data entered into the table
                            row[0] = bookId.getText();
                            row[1] = bookName.getText();
                            row[2] = stdId.getText();
                            row[3] = stdName.getText();

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
                            JOptionPane.showMessageDialog(issue,"No Data Selected or Entered");
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
                        bookId.setText(model.getValueAt(i, 0).toString());
                        bookName.setText(model.getValueAt(i,1).toString());
                        stdId.setText(model.getValueAt(i,2).toString());
                        stdName.setText(model.getValueAt(i,3).toString());
                    }
                });

                btn3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int i = table.getSelectedRow();

                        if (i >= 0){
                            // Updating the value of the table at the given index
                            model.setValueAt(bookId.getText(), i, 0);
                            model.setValueAt(bookName.getText(),i ,1);
                            model.setValueAt(stdId.getText(), i,2);
                            model.setValueAt(stdName.getText(), i,3);
                        } else {
                            JOptionPane.showMessageDialog(issue,"Update Error");
                        }
                    }
                });

                btn4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Opens the Options frame by calling the method in that class
                        Options.menu();
                        // CLoses this frame
                        issue.dispose();
                    }
                });

                issue.setLayout(null);
                issue.setVisible(true);
                issue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    public static void main(String[] args) {
        issued();
    }
}
