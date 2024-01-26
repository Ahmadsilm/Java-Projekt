package droneMain;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DroneDetail extends JFrame implements ActionListener {

	JButton mainpageButton;

	JLabel IDLabel;

	// int ID, carriageWeight;
	// String droneType, createdDate, serialNumber, carriageType;

	// public void Drone(int ID, String droneType, String createdDate, String
	// serialNumber, int carriageWeight,
	// String carriageType) {
	// this.ID = ID;
	// this.droneType = droneType;
	// this.createdDate = createdDate;
	// this.serialNumber = serialNumber;
	// this.carriageWeight = carriageWeight;
	// this.carriageType = carriageType;
	// }

	DroneDetail(int ID, String droneType, String createdDate, String serialNumber, int carriageWeight,
			String carriageType) {
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0x2d2e30));

		IDLabel = new JLabel("ID: " + ID + " droneType: " + droneType + "\ncreatedDate: " + createdDate
				+ "serialNumber: " + serialNumber);
		IDLabel.setFont(new Font("MV Boli", Font.PLAIN, 14));
		IDLabel.setBounds(100, 150, 500, 500);
		IDLabel.setForeground(Color.GREEN);

		mainpageButton = new JButton("Back");
		mainpageButton.addActionListener(this);
		mainpageButton.setBounds(100, 150, 100, 80);
		mainpageButton.setFocusable(false);
		mainpageButton.setBackground(Color.LIGHT_GRAY);

		this.add(IDLabel);
		// this.add(mainpageButton);

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
