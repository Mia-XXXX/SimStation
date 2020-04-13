package simStation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public abstract class SimStationPanel extends AppPanel {
    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;

    public SimStationPanel(AppFactory factory) {
        super(factory);
        SimStationView view = new SimStationView((Simulation) model);
        add(view);
        this.setLayout(new GridLayout(1, 2));

        start = new JButton("Start");
        suspend = new JButton("Suspend");
        resume = new JButton("Resume");
        stop = new JButton("Stop");
        stats = new JButton("Stats");


        start.addActionListener(this);
        suspend.addActionListener(this);
        resume.addActionListener(this);
        stop.addActionListener(this);
        stats.addActionListener(this);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));
        //leftPanel.setLayout(new FlowLayout());

        JPanel[] buttonPanel = new JPanel[5];

        for (int i = 0; i < buttonPanel.length; i++) {
            buttonPanel[i] = new JPanel();
            buttonPanel[i].setLayout(new FlowLayout());
        }

        buttonPanel[0].add(start);
        buttonPanel[1].add(suspend);
        buttonPanel[2].add(resume);
        buttonPanel[3].add(stop);
        buttonPanel[4].add(stats);

        for (int i = 0; i < buttonPanel.length; i++) {
            leftPanel.add(buttonPanel[i]);
        }

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());
        rightPanel.add(view);


        add(leftPanel);
        add(rightPanel);
    }


}
