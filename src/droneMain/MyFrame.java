package droneMain;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyFrame extends JFrame implements ActionListener {
	JButton dashboard, flightDynamics, buttonID, buttonManufacture, buttonSerialnumber,buttonHistorical;
	JPanel buttonPanel, imagePanel, titlePanel;
	ImageIcon DroneImage;

	JLabel titleLabel, questionLabel, ImageLabel;

	MyFrame() {
		this.setSize(900, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0x2d2e30));

		
		titleLabel = new JLabel();
        titleLabel.setText("Welcome to Drone app");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 30));


		DroneImage = new ImageIcon("drone.png");

		ImageLabel = new JLabel();
		ImageLabel.setIcon(DroneImage);
		ImageLabel.setSize(new Dimension(450,450));

		questionLabel = new JLabel();
        questionLabel.setText("In Which Categories do you want to search?");
        questionLabel.setForeground(Color.GREEN);
        questionLabel.setFont(new Font("MV Boli", Font.BOLD, 36));

		titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 900, 170);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0x2b2b2e));
        titlePanel.add(titleLabel);
		titlePanel.add(questionLabel);
		

		

		buttonPanel = new JPanel();
		buttonPanel.setBounds(40, 190, 250, 650);
		buttonPanel.setBackground(new Color(0x424447));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));

		imagePanel = new JPanel();
		imagePanel.setBounds(450, 450, 450, 450);
		imagePanel.setBackground(new Color(0x2d2e30));
		imagePanel.setLayout(null);
		imagePanel.setBounds(420,350,300,400);
		imagePanel.add(ImageLabel);

		

		dashboard = new JButton("Dashboard");
		dashboard.addActionListener(this);
		dashboard.setPreferredSize(new Dimension(200, 80));
		dashboard.setFocusable(false);
		dashboard.setBackground(Color.LIGHT_GRAY);
		dashboard.setCursor(new Cursor(Cursor.HAND_CURSOR));

		flightDynamics = new JButton("Flight Dynamics");
		flightDynamics.addActionListener(this);
		flightDynamics.setPreferredSize(new Dimension(200, 80));
		flightDynamics.setFocusable(false);
		flightDynamics.setBackground(Color.LIGHT_GRAY);
		flightDynamics.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonID = new JButton("Drone Type ID");
		buttonID.addActionListener(this);
		buttonID.setPreferredSize(new Dimension(200, 80));
		buttonID.setFocusable(false);
		buttonID.setBackground(Color.LIGHT_GRAY);
		buttonID.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonManufacture = new JButton("Manufacture");
		buttonManufacture.addActionListener(this);
		buttonManufacture.setPreferredSize(new Dimension(200, 80));
		buttonManufacture.setFocusable(false);
		buttonManufacture.setBackground(Color.LIGHT_GRAY);
		buttonManufacture.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonSerialnumber = new JButton("Serial Number");
		buttonSerialnumber.addActionListener(this);
		buttonSerialnumber.setPreferredSize(new Dimension(200, 80));
		buttonSerialnumber.setFocusable(false);
		buttonSerialnumber.setBackground(Color.LIGHT_GRAY);
		buttonSerialnumber.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonHistorical = new JButton("Historical Analysis");
		buttonHistorical.addActionListener(this);
		buttonHistorical.setPreferredSize(new Dimension(200, 80));
		buttonHistorical.setFocusable(false);
		buttonHistorical.setBackground(Color.LIGHT_GRAY);
		buttonHistorical.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonPanel.add(dashboard);
		buttonPanel.add(flightDynamics);
		buttonPanel.add(buttonID);
		buttonPanel.add(buttonManufacture);
		buttonPanel.add(buttonSerialnumber);
		buttonPanel.add(buttonHistorical);

		
		this.add(titlePanel);
		//this.add(ImageLabel);
		this.add(buttonPanel);
		this.add(imagePanel);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dashboard) {
			new Dashboard();
			this.dispose();
		}
		if (e.getSource() == flightDynamics) {
			new FlightDynamics();
			this.dispose();
		}
		if (e.getSource() == buttonID) {
			new IdSearch();
			this.dispose();
		}
		if (e.getSource() == buttonManufacture) {
			new ManufactureSearch();
			this.dispose();
		}
		if (e.getSource() == buttonSerialnumber) {
			new SerialSearch();
			this.dispose();
		}
		if (e.getSource() == buttonHistorical) {
			new HistoricalAnalysis();
			this.dispose();
			
		}
	}
}
