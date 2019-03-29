package clickme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickMe extends JFrame{
    
    private JButton buttonCounter, buttonReset;
    private JLabel labelCount;
    private int clicks = 0;
    
    public ClickMe(){
        createView();
        this.setTitle("Click me");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void createView(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        
        labelCount = new JLabel();
        labelCount.setPreferredSize(new Dimension(200, 30));
        panel.add(labelCount);
        
        updateCounter();
        buttonCounter = new JButton("Click me");
        buttonCounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                updateCounter();
            }
        });
        panel.add(buttonCounter);
        
        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks = 0;
                updateCounter();
            }
        });
        panel.add(buttonReset);
    }
    
    private void updateCounter(){
        labelCount.setText("Clicked " + clicks + " times");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ClickMe().setVisible(true);
            }
        });
    }
    
}
