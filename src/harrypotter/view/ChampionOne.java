package harrypotter.view;

import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.Spell;
import harrypotter.model.tournament.FirstTask;
import harrypotter.model.tournament.Tournament;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChampionOne extends JFrame {
	int counter = 0;
	JLabel backgroundImage;
	JButton button;
	JComboBox wizardsBox;
	JComboBox SpellBox;
	JComboBox SpellBox2;
	JComboBox SpellBox3;
	JCheckBox spell;
	JTextField champName;
	ArrayList<Champion> champs = new ArrayList<Champion>();
	FirstTaskView T;
	SecondTaskView T2 ;
	JLabel name;
	// JButton ChooseSpells ;
	JLabel ChooseSpells;
	JLabel ChooseHouse;

	public ChampionOne() throws IOException {

		setBounds(0, 0, 1361, 766);
		setTitle("Choose Champion 1 ");
		setVisible(true);
		setResizable(false);
		// setLayout(null);
		Tournament t = new Tournament();
		backgroundImage = new JLabel();
		backgroundImage.setBounds(0, 0, 1360, 765);
		backgroundImage.setIcon(new ImageIcon("D:\\background2.jpg"));
		name = new JLabel("Name Of Champion");
		name.setVisible(true);
		name.setOpaque(false);
		name.setForeground(Color.WHITE);
		name.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
		name.setBounds(50, 50, 300, 50);
		ChooseHouse = new JLabel("Choose House");
		ChooseHouse.setVisible(true);
		ChooseHouse.setOpaque(false);
		ChooseHouse.setForeground(Color.WHITE);
		ChooseHouse.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
		ChooseHouse.setBounds(50, 200, 300, 50);

		String[] wizards = { "Gryffindor", "Hufflepuff", "Ravenclaw",
				"Slytherin" };
		wizardsBox = new JComboBox(wizards);
		wizardsBox.setVisible(true);
		wizardsBox.setBounds(50, 270, 150, 30);
		wizardsBox.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		wizardsBox.setBackground(Color.BLACK);
		wizardsBox.setForeground(Color.WHITE);

		champName = new JTextField();
		champName.setBounds(50, 120, 150, 30);
		champName.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		champName.setVisible(true);
		champName.setOpaque(false);
		champName.setForeground(Color.WHITE);
		champName.setCaretColor(Color.WHITE);

		ArrayList<Spell> spell2 = new ArrayList<Spell>();
//		String[] spell1 = { "Sectumsempra", "Reducto", "Piertotum Locomotor ",
//				"Oppugno", "Incendio", "Expulso", "Bombarda", "Avada Kedavra",
//				"Crucio", "Igni", "Kamehameha", "Cheering Charm",
//				"Expecto Patronum", "Ferula", "Protego Horribilis",
//				"Rennervate", "Quen", "Accio", "Imperio", "Wingardium Leviosa",
//				"Axii" };
		String[] spell1 = { "Sectumsempra", "Reducto", "Piertotum Locomotor ",
				"Oppugno", "Incendio", "Expulso", "Bombarda", "Avada Kedavra",
				"Crucio", "Igni", "Kamehameha"};
		SpellBox = new JComboBox(spell1);
		SpellBox.setVisible(true);
		SpellBox.setBounds(80, 450, 180, 30);
		SpellBox.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		SpellBox.setBackground(Color.BLACK);
		SpellBox.setForeground(Color.WHITE);
	
		SpellBox2 = new JComboBox(spell1);
		SpellBox2.setVisible(true);
		SpellBox2.setBounds(280, 450, 180, 30);
		SpellBox2.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		SpellBox2.setBackground(Color.BLACK);
		SpellBox2.setForeground(Color.WHITE);
		
		SpellBox3 = new JComboBox(spell1);
		SpellBox3.setVisible(true);
		SpellBox3.setBounds(480, 450, 180, 30);
		SpellBox3.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		SpellBox3.setBackground(Color.BLACK);
		SpellBox3.setForeground(Color.WHITE);
	
		ChooseSpells = new JLabel("Choose Spells");
		ChooseSpells.setVisible(true);
		ChooseSpells.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
		ChooseSpells.setForeground(Color.white);
		ChooseSpells.setBounds(270, 400, 400, 40);
		button = new JButton("Next");
		button.setFont(new Font(Font.SERIF, Font.ITALIC, 30));

		button.setBounds(700, 650, 150, 50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (champName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"You must choose a name", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
				

					if (counter < 3) {

						if ((String) wizardsBox.getSelectedItem() == "Gryffindor") {
						
							String c = champName.getText();
							GryffindorWizard x = new GryffindorWizard(c);
							//champs.add(x);
						//	t.getChampions().add(x);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String a = (String) SpellBox.getSelectedItem();
								String b = t.getSpells().get(i).getName();
								if (a.equals(b)) {
									x.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									x.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									x.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(x);
							champName.setText("");
							counter++;
							setTitle("Choose Champion " + (counter + 1));
						} else if ((String) wizardsBox.getSelectedItem() == "Hufflepuff") {
							String c = champName.getText();
							HufflepuffWizard y = new HufflepuffWizard(c);
							//champs.add(y);
							//t.getChampions().add(y);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String a = (String) SpellBox.getSelectedItem();
								String b = t.getSpells().get(i).getName();
								if (a.equals(b)) {
									y.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									y.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									y.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(y);
							counter++;
							champName.setText("");
							setTitle("Choose Champion " + (counter + 1));
						} else if ((String) wizardsBox.getSelectedItem() == "Ravenclaw") {
							String c = champName.getText();
							RavenclawWizard z = new RavenclawWizard(c);
							//champs.add(z);
							//t.getChampions().add(z);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String a = (String) SpellBox.getSelectedItem();
								String b = t.getSpells().get(i).getName();
								if (a.equals(b)) {
									// System.out.println(b);
									z.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									z.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									z.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(z);
							counter++;
							champName.setText(" ");
							setTitle("Choose Champion" + (counter +1));
						} else if ((String)wizardsBox.getSelectedItem() == "Slytherin") {
							
							String c = champName.getText();
							SlytherinWizard a = new SlytherinWizard(c);
							//champs.add(a);
							//t.getChampions().add(a);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String n = (String) SpellBox.getSelectedItem();
								String m = t.getSpells().get(i).getName();
								if (n.equals(m)) {
									a.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									a.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									a.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(a);
							counter++;
							champName.setText("");
							setTitle("Choose Champion" + (counter + 1));
						}
					} else if (counter == 3) {
						if ((String) wizardsBox.getSelectedItem() == "Gryffindor") {
							String c = champName.getText();
							GryffindorWizard x = new GryffindorWizard(c);
							//champs.add(x);
							//t.getChampions().add(x);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String a = (String) SpellBox.getSelectedItem();
								String b = t.getSpells().get(i).getName();
								if (a.equals(b)) {
									x.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									x.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									x.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(x);
							counter++;
						} else if ((String) wizardsBox.getSelectedItem() == "Hufflepuff") {
							String c = champName.getText();
							HufflepuffWizard y = new HufflepuffWizard(c);
							//champs.add(y);
							//t.getChampions().add(y);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String a = (String) SpellBox.getSelectedItem();
								String b = t.getSpells().get(i).getName();
								if (a.equals(b)) {
									y.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									y.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									y.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(y);
							counter++;
						} else if ((String) wizardsBox.getSelectedItem() == "Ravenclaw") {

							String c = champName.getText();
							RavenclawWizard z = new RavenclawWizard(c);
							//champs.add(z);
							//t.getChampions().add(z);
							for (int i = 0; i < t.getSpells().size(); i++) {
								String a = (String) SpellBox.getSelectedItem();
								String b = t.getSpells().get(i).getName();
								if (a.equals(b)) {
									z.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String h = (String) SpellBox2.getSelectedItem();
								String g = t.getSpells().get(i).getName();
								if (h.equals(g)) {
									z.getSpells().add(t.getSpells().get(i));

								}
							}
							for (int i = 0; i < t.getSpells().size(); i++) {
								String q = (String) SpellBox3.getSelectedItem();
								String s = t.getSpells().get(i).getName();
								if (q.equals(s)) {
									z.getSpells().add(t.getSpells().get(i));

								}
							}
							t.getChampions().add(z);
							counter++;
						} else if ((String) wizardsBox.getSelectedItem() == "Slytherin") {
//							if (spell2.size() < 3) {
//								JOptionPane.showMessageDialog(null,
//										"Please Choose At Least 3 Spells",
//										"Warning", JOptionPane.WARNING_MESSAGE);
//							} else {
								String c = champName.getText();
								SlytherinWizard a = new SlytherinWizard(c);
								//champs.add(a);
								//t.getChampions().add(a);
								for (int i = 0; i < t.getSpells().size(); i++) {
									String m = (String) SpellBox
											.getSelectedItem();
									String b = t.getSpells().get(i).getName();
									if (m.equals(b)) {
										a.getSpells().add(t.getSpells().get(i));

									}
								}
								for (int i = 0; i < t.getSpells().size(); i++) {
									String h = (String) SpellBox2
											.getSelectedItem();
									String g = t.getSpells().get(i).getName();
									if (h.equals(g)) {
										a.getSpells().add(t.getSpells().get(i));

									}
								}
								for (int i = 0; i < t.getSpells().size(); i++) {
									String q = (String) SpellBox3
											.getSelectedItem();
									String s = t.getSpells().get(i).getName();
									if (q.equals(s)) {
										a.getSpells().add(t.getSpells().get(i));

									}
								}
								t.getChampions().add(a);
								counter++;

							//}
						}
						 try {
						 
						 t.beginTournament();
						 
						
						 } catch (IOException e) {
						
						 e.printStackTrace();
						 }
						try {
							T = new FirstTaskView(t.getChampions());
							//T2 = new SecondTaskView(t.getChampions());
						} catch (IOException e) {

							e.printStackTrace();
						}
						T.setVisible(true);
						//T2.setVisible(true);
						setVisible(false);

					}
				}
			}
		});
		getContentPane().add(ChooseHouse);
		getContentPane().add(ChooseSpells);
		getContentPane().add(name);
		getContentPane().add(button);
		getContentPane().add(champName);
		getContentPane().add(wizardsBox);
		getContentPane().add(SpellBox);
		getContentPane().add(SpellBox2);
		getContentPane().add(SpellBox3);
		getContentPane().add(backgroundImage);

	}


}
