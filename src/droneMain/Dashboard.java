package droneMain;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame implements ActionListener {

    JButton backpageButton;

    JPanel answerPanel, titlePanel, buttonPanel;

    JLabel titleLabel, imageLabel;

    ImageIcon droneImage;

    JTable droneTable;

    Dashboard() {
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        titleLabel = new JLabel();
        titleLabel.setText("Dashboard");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));

        backpageButton = new JButton("Back");
        backpageButton.addActionListener(this);
        backpageButton.setPreferredSize(new Dimension(100, 35));
        backpageButton.setFocusable(false);
        backpageButton.setBackground(Color.LIGHT_GRAY);

        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 900, 80);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0x2b2b2e));
        titlePanel.add(titleLabel);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 100, 700, 50);
        buttonPanel.setBackground(new Color(0x2d2e30));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.add(backpageButton);

        // Create a default table model with column names
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new Object[] { "ID", "Drone Type", "Created", "Serial Number", "Carriage Weight", "Carriage Type" });

        // Create the table using the model
        droneTable = new JTable(model);
        droneTable.setBackground(Color.WHITE);
        droneTable.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(droneTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        answerPanel = new JPanel();
        answerPanel.setBounds(0, 150, 900, 750);
        answerPanel.setBackground(new Color(0x2d2e30));
        answerPanel.setLayout(new BorderLayout()); // Set BorderLayout for answerPanel
        answerPanel.add(scrollPane, BorderLayout.CENTER); // Add scrollPane to the center

        // Call the method from DroneList class to get drone information
        String[][] droneInfo = DroneList.getAllDrones();

        // Update the JTable with the obtained information
        if (droneInfo != null) {
            model.setRowCount(0); // Clear previous data

            // Add new rows to the table
            for (String[] row : droneInfo) {
                model.addRow(row);
            }
        }

        this.add(answerPanel);

        this.add(titlePanel);
        this.add(buttonPanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backpageButton) {
            new MyFrame();
            this.dispose();
        }
    }

}