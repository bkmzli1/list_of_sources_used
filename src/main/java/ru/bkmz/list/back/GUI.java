package ru.bkmz.list.back;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;


class GUI extends JFrame {
    static Collection collection;
    static JTextArea input = new JTextArea("processing to list the links after 3 commas"), output = new JTextArea("");
    private JButton generateBaton = new JButton("start");
    private eHendler hendler = new eHendler();

    GUI(String s) {
        super(s);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3, 0, 0));
        container.add(input);
        container.add(generateBaton);
        container.add(output);
        generateBaton.setSelected(true);
        generateBaton.addActionListener(hendler);
    }

    public class eHendler extends Thread implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == generateBaton) {
                List list = new List();
                list.start();
            }
        }
    }
}
