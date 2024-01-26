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

public class Catalog extends JFrame implements ActionListener {

    ArrayList<DroneType> droneTypeList = new ArrayList<DroneType>();
    JPanel panel;
    JButton back, refresh;

    Catalog() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x2d2e30));

        droneTypeList.add(new DroneType(81, "Syma", "X5C", 102, 40, 500, 150, 70));
        droneTypeList.add(new DroneType(82, "Cheerson", "CX-10", 25, 20, 100, 50, 30));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Manifacture");
        model.addColumn("Typename");
        model.addColumn("Weight");
        model.addColumn("Maximum Speed");
        model.addColumn("Battery Capecity");
        model.addColumn("Controll Range");
        model.addColumn("Maximum Carriage");

        back = new JButton("Back");
        back.setBounds(0, 0, 100, 35);
        back.setFocusable(false);
        back.addActionListener(this);
        refresh = new JButton("Refresh");
        refresh.setBounds(585, 0, 100, 35);
        refresh.setFocusable(false);
        refresh.addActionListener(this);

        for (DroneType droneType : droneTypeList) {
            model.addRow(new Object[] { droneType.ID, droneType.manifacture, droneType.typeName, droneType.weight,
                    droneType.maxSpeed, droneType.batteryCapacity, droneType.controlRange, droneType.maxCarriage });
        }
        JTable table = new JTable(model);
        // table.setBackground(new Color(0x424447));

        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(0, 50, 700, 650);

        panel = new JPanel();
        panel.setBounds(0, 0, 700, 700);
        panel.setLayout(null);
        panel.setBackground(new Color(0x424447));

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