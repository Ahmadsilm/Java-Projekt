package droneMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame implements ActionListener {

    ArrayList<Drone> droneList = new ArrayList<Drone>();
    JPanel panel;
    JButton back, refresh;

    Dashboard() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        droneList.add(new Drone(71, "Holy Stone: HS100", "Dec. 27, 2023, 9:07 a.m.", "HoHS-2024-F26CA5", 387, "SEN"));
        droneList.add(new Drone(72, "Snaptain: S5C", "Dec. 27, 2023, 9:07 a.m.", "SnS5-2030-360F05", 73, "ACT"));

        // droneList.add(new Drone(70, "o", "HS100", "Holystonfhcbvne", false));
        // droneList.add(new Drone(80, "Hyshit", "sdfs sdf", "3rv3 434f3", true));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Drone Type");
        model.addColumn("Created");
        model.addColumn("Serialnumber");
        model.addColumn("Carriage Weight");
        model.addColumn("Carriage Type");

        for (Drone drone : droneList) {
            model.addRow(new Object[] { drone.ID, drone.droneType, drone.createdDate, drone.serialNumber,
                    drone.carriageWeight, drone.carriageWeight });
        }

        JTable table = new JTable(model);
        JScrollPane scrollpane = new JScrollPane(table);

        back = new JButton("Back");
        back.setBounds(0, 0, 100, 35);
        back.setFocusable(false);
        back.addActionListener(this);
        refresh = new JButton("Refresh");
        refresh.setBounds(585, 0, 100, 35);
        refresh.setFocusable(false);
        refresh.addActionListener(this);
        scrollpane.setBounds(0, 50, 700, 650);

        panel = new JPanel();
        panel.setBounds(0, 0, 700, 700);
        panel.setLayout(null);

        panel.add(scrollpane);
        panel.add(refresh);
        panel.add(back);

        // this.add(scrollpane, BorderLayout.CENTER);
        this.add(panel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new MyFrame();
            this.dispose();
        }

        if (e.getSource() == refresh) {
            new DroneList();
        }

    }

}