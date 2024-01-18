package droneMain;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;



public class MyFrame extends JFrame implements  ActionListener{
	JButton buttonID;
	JButton buttonManufacture;
	JButton buttonSerialnumber;
	JPanel buttonPanel;
	JPanel imagePanel;
	ImageIcon DroneImage;
	
	 
	JLabel title;
	JLabel question;
	JLabel ImageLabel;
	
	
	MyFrame(){
		
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0x2d2e30));
		
		
		title= new JLabel();
		title.setText("Welcome to Drone app");
		title.setForeground(Color.GREEN);
		title.setFont(new Font("MV Boli",Font.PLAIN,20));
		title.setBounds(225,0,600,80);
		
		DroneImage = new ImageIcon("drone(1).png");
		
		ImageLabel= new JLabel();
		ImageLabel.setIcon(DroneImage);
		ImageLabel.setBounds(280,200,400,400);
		
		question= new JLabel();
		question.setText("In Which Categories do you whant to search ?");
		question.setForeground(Color.GREEN);
		question.setFont(new Font("MV Boli",Font.BOLD,25));
		question.setBounds(50,100,700,80);
		
		buttonPanel= new JPanel();
		buttonPanel.setBounds(40,200,180,400);
		buttonPanel.setBackground(new Color(0x424447));
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,25,25)); 
		
		
		
		
		buttonID= new JButton("ID");
		buttonID.addActionListener(this);
		buttonID.setPreferredSize(new  Dimension(150,100));
		buttonID.setFocusable(false);
		buttonID.setBackground(Color.LIGHT_GRAY);
		
		buttonManufacture= new JButton("Manufacture");
		buttonManufacture.addActionListener(this);
		buttonManufacture.setPreferredSize(new Dimension(150,100));
		buttonManufacture.setBackground(Color.LIGHT_GRAY);
		buttonManufacture.setFocusable(false);
		
		buttonSerialnumber= new JButton("SerialNumber");
		buttonSerialnumber.addActionListener(this);
		buttonSerialnumber.setPreferredSize(new  Dimension(150,100));
		buttonSerialnumber.setBackground(Color.LIGHT_GRAY);
		buttonSerialnumber.setFocusable(false);
		
		buttonPanel.add(buttonID);
		buttonPanel.add(buttonManufacture);
		buttonPanel.add(buttonSerialnumber);
		
		
		this.add(title);
		this.add(question);
		this.add(ImageLabel);
		this.add(buttonPanel);
		
		this.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== buttonID) {
			new IdSearch();
			this.dispose();
		}
		if(e.getSource()== buttonManufacture) {
			new ManufactureSearch();
			this.dispose();
			
		}
		if(e.getSource()== buttonSerialnumber) {
			new SerialSearch();
			this.dispose();
			
		}

		
	}
	
	
	
}
