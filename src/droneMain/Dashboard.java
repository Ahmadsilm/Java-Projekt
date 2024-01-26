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

    JButton mainpageButton;

    JPanel answerPanel, titlePanel, buttonPanel;

    JLabel titleLabel, imageLabel;

    ImageIcon droneImage;

    JTable droneTable;

    Dashboard() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        titleLabel = new JLabel();
        titleLabel.setText("Dashboard");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));

        mainpageButton = new JButton("Menu");
        mainpageButton.addActionListener(this);
        mainpageButton.setPreferredSize(new Dimension(150, 70));
        mainpageButton.setFocusable(false);
        mainpageButton.setBackground(Color.LIGHT_GRAY);

        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 700, 80);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0x2b2b2e));
        titlePanel.add(titleLabel);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 100, 700, 120);
        buttonPanel.setBackground(new Color(0x2d2e30));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        buttonPanel.add(mainpageButton);

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
        answerPanel.setBounds(0, 250, 700, 350);
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
        if (e.getSource() == mainpageButton) {
            new MyFrame();
            this.dispose();
        }
    }

}