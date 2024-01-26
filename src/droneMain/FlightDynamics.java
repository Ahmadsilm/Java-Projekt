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

public class FlightDynamics extends JFrame implements ActionListener {

    ArrayList<DroneDynamic> droneDynamicList = new ArrayList<DroneDynamic>();
    JPanel panel;
    JButton back, refresh;

    FlightDynamics() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        droneDynamicList.add(
                new DroneDynamic(86832, "Dec. 26, 2023, 6:32 p.m.",
                        new Drone(72, "Snaptain: S5C", "Dec. 27, 2023, 9:07 a.m.", "SnS5-2030-360F05", 73, "ACT"), 0,
                        0.00, 0.00, 42.00, 8.678137129, 50.107668121, 0, "Dec. 26, 2023, 6:07 p.m.", false));
        droneDynamicList.add(
                new DroneDynamic(86833, "Dec. 26, 2023, 6:32 p.m.",
                        new Drone(72, "Snaptain: S5C", "Dec. 27, 2023, 9:07 a.m.", "SnS5-2030-360F05", 73, "ACT"), 0,
                        0.00, 0.00, 235.00, 8.276398911, 49.998956812, 0, "Dec. 26, 2023, 6:07 p.m.", false));
        // droneDynamicList
        // .add(new DroneDynamic(72, "Snaptain: S5C", "Dec. 27, 2023, 9:07 a.m.",
        // "SnS5-2030-360F05", 73, "ACT"));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Timestamp");
        model.addColumn("Drone");
        model.addColumn("Speed");
        model.addColumn("Alignment Roll");
        model.addColumn("Control Range");
        model.addColumn("Alignment Yaw");
        model.addColumn("Longitude");
        model.addColumn("Latitude");
        model.addColumn("Battery Status");
        model.addColumn("Status");

        for (DroneDynamic droneDynamic : droneDynamicList) {
            model.addRow(new Object[] { droneDynamic.ID, droneDynamic.Timestamp, droneDynamic.drone, droneDynamic.speed,
                    droneDynamic.alignmentRoll, droneDynamic.controlRange, droneDynamic.alignmentYaw,
                    droneDynamic.longitude, droneDynamic.latitude, droneDynamic.batteryStatus, droneDynamic.status });
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