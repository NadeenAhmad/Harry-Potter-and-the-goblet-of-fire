package harrypotter.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HarryPotterView extends JFrame {
	JLabel backgroundImage ;
	JButton button ;
public HarryPotterView(){
	setBounds(0, 0, 1361, 766);
	setTitle("HarryPotter & the Goblet of fire");
	setVisible(true);
	setResizable(false);
	backgroundImage = new JLabel();
	backgroundImage.setBounds(0, 0, 1360, 765);
	backgroundImage.setIcon(new ImageIcon("D:\\background.jpg"));
	button = new JButton(new ImageIcon("D:\\button1.png"));
	button.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
    button.setBounds( 100, 600, 310, 40);
    button.addActionListener( new ActionListener(){
    public void actionPerformed (ActionEvent ae){
    dispose();
    try {
		new ChampionOne();
	} catch (IOException e) {
		e.printStackTrace();
	}
    }}
);
    
	
	
	
   getContentPane().add(button);
	getContentPane().add(backgroundImage);
	pack();
	
}
public static void main(String[] args) {
	new HarryPotterView();
}
}
