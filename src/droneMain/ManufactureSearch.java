package droneMain;

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

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class ManufactureSearch extends JFrame implements ActionListener {
    JButton searchButton, resetButton, comebackButton, mainpageButton;

    JPanel answerPanel, titlePanel, buttonPanel;

    JLabel titleLabel, IDLabel, imageLabel;

    ImageIcon droneImage;

    JTextField ID;

    JTable droneTable;

    ManufactureSearch() {
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        titleLabel = new JLabel();
        titleLabel.setText("Manufacture Search");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));

        IDLabel = new JLabel("Company name: ");
        IDLabel.setFont(new Font("MV Boli", Font.PLAIN, 25));
        IDLabel.setBounds(110, 80, 200, 80);
        IDLabel.setForeground(Color.GREEN);

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


        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new Object[] { "ID", "Drone Type", "Created", "Serial Number", "Carriage Weight", "Carriage Type" });

        // Create the table using the model
        droneTable = new JTable(model);
        droneTable.setBackground(Color.WHITE);
        droneTable.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(droneTable);
        scrollPane.setPreferredSize(new Dimension(600, 200));

        answerPanel = new JPanel();
        answerPanel.setBounds(0, 250, 900, 750);
        answerPanel.setBackground(new Color(0x2d2e30));
		answerPanel.setLayout(new BorderLayout() );
        answerPanel.add(scrollPane,BorderLayout.CENTER);

        this.add(answerPanel);

        this.add(titlePanel);
        this.add(IDLabel);
        this.add(ID);
        this.add(buttonPanel);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == mainpageButton) {
            new MyFrame();
            this.dispose();
        } else if (e.getSource() == searchButton) {
            // Get manufacturer name from the text field
            String manufacturer = ID.getText();

            // Call the method from DroneList class to get drone information
            String[][] droneInfo = DroneList.getAllDronesFromManufactures(manufacturer);

            // Update the JTable with the obtained information
            if (droneInfo != null) {
                DefaultTableModel model = (DefaultTableModel) droneTable.getModel();
                model.setRowCount(0); // Clear previous data

                // Add new rows to the table
                for (String[] row : droneInfo) {
                    model.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(null, "This ID do not exist!", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } else if(e.getSource() == resetButton){
            ID.setText("");
        }

    }

}