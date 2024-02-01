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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FlightDynamics extends JFrame implements ActionListener {

    JButton mainpageButton, searchButton, resetButton;

    JPanel answerPanel, titlePanel, buttonPanel;

    JLabel titleLabel, imageLabel, idLabel;

    ImageIcon droneImage;

    JTextField ID;

    JTable droneTable;

    FlightDynamics() {
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        titleLabel = new JLabel();
        titleLabel.setText("Flight Dynamics");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));

        idLabel = new JLabel("Flights: ");
		idLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
		idLabel.setBounds(150,75,180,80);
		idLabel.setForeground(Color.GREEN);

        ID = new JTextField();
        ID.setBounds(300, 100, 300, 50);

        mainpageButton = new JButton("Menu");
        mainpageButton.addActionListener(this);
        mainpageButton.setPreferredSize(new Dimension(150, 70));
        mainpageButton.setFocusable(false);
        mainpageButton.setBackground(Color.LIGHT_GRAY);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setPreferredSize(new Dimension(150, 70));
        searchButton.setFocusable(false);
        searchButton.setBackground(Color.LIGHT_GRAY);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setPreferredSize(new Dimension(150, 70));
        resetButton.setFocusable(false);
        resetButton.setBackground(Color.LIGHT_GRAY);

        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 900, 80);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0x2b2b2e));
        titlePanel.add(titleLabel);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 150, 900, 120);
        buttonPanel.setBackground(new Color(0x2d2e30));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        buttonPanel.add(mainpageButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(resetButton);

        // Create a default table model with column names
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new Object[] { "Drone", "Timestamp", "Speed", "Align Roll", "Align Pitch", "Align Yaw","Longitude","Latitude","Battery Status", "Last Seen","Status"});

        // Create the table using the model
        droneTable = new JTable(model);
        droneTable.setBackground(Color.WHITE);
        droneTable.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(droneTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        answerPanel = new JPanel();
        answerPanel.setBounds(0, 250, 900, 750);
        answerPanel.setBackground(new Color(0x2d2e30));
        answerPanel.setLayout(new BorderLayout()); // Set BorderLayout for answerPanel
        answerPanel.add(scrollPane, BorderLayout.CENTER); // Add scrollPane to the center


        this.add(answerPanel);

        this.add(titlePanel);
        this.add(buttonPanel);
        this.add(ID);
        this.add(idLabel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            // Call your getDroneFromID function
            String inputID = ID.getText();
            String[] droneInfo = DroneList.getDroneDynamic(inputID);

            // Add the data to the table
            if (droneInfo != null) {
                DefaultTableModel model = (DefaultTableModel) droneTable.getModel();
                model.setRowCount(0); // Clear previous data

                // Add a new row to the table
                model.addRow(droneInfo);
            } else {
                JOptionPane.showMessageDialog(null, "This ID do not exist!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == mainpageButton) {
            new MyFrame();
            this.dispose();
        } else if (e.getSource() == resetButton){
            ID.setText("");
        }
    }

}