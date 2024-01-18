package droneMain;

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
import javax.swing.JTextField;

public class SerialSearch extends JFrame implements ActionListener{
	JButton searchButton, resetButton,mainpageButton;
	
	JPanel answerPanel, titlePanel, buttonPanel;
	
	JLabel titleLabel, IDLabel, imageLabel;
	
	ImageIcon droneImage;
	
	JTextField ID;
	
	SerialSearch() {
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0x2d2e30));
		
		titleLabel = new JLabel();
		titleLabel.setText("Serial number Search");
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setFont(new Font("MV Boli",Font.BOLD,30));
		
		IDLabel = new JLabel("Serial number:");
		IDLabel.setFont(new Font("MV Boli",Font.PLAIN,25));
		IDLabel.setBounds(10,150,200,80);
		IDLabel.setForeground(Color.GREEN);
		
		ID = new JTextField();
		ID.setBounds(200,170,300,50);
		
		mainpageButton= new JButton("Menu");
		mainpageButton.addActionListener(this);
		mainpageButton.setPreferredSize(new  Dimension(150,70));
		mainpageButton.setFocusable(false);
		mainpageButton.setBackground(Color.LIGHT_GRAY);
		
		
		searchButton= new JButton("Search");
		searchButton.addActionListener(this);
		searchButton.setPreferredSize(new  Dimension(150,70));
		searchButton.setFocusable(false);
		searchButton.setBackground(Color.LIGHT_GRAY);
		
		
		resetButton= new JButton("Reset");
		resetButton.addActionListener(this);
		resetButton.setPreferredSize(new  Dimension(150,70));
		resetButton.setFocusable(false);
		resetButton.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		titlePanel= new JPanel();
		titlePanel.setBounds(0,0,700,80);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(new Color(0x2b2b2e));
		titlePanel.add(titleLabel);
		
		buttonPanel= new JPanel();
		buttonPanel.setBounds(0,250,700,120);
		buttonPanel.setBackground(new Color(0x2d2e30));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,25,25));
		buttonPanel.add(mainpageButton);
		buttonPanel.add(searchButton);
		buttonPanel.add(resetButton);
		
		this.add(titlePanel);
		this.add(IDLabel);
		this.add(ID);
		this.add(buttonPanel);
	
		this.setVisible(true);;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== mainpageButton) {
			new MyFrame();
			this.dispose();
		}		
	}

}
