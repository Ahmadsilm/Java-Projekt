package droneMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame implements ActionListener {

    ArrayList<Drone> droneList = new ArrayList<Drone>();

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

        this.add(scrollpane, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}