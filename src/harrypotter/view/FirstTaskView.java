package harrypotter.view;

import java.awt.Color;
//import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import harrypotter.exceptions.InCooldownException;
import harrypotter.exceptions.InvalidTargetCellException;
import harrypotter.exceptions.NotEnoughIPException;
import harrypotter.exceptions.OutOfBordersException;
import harrypotter.exceptions.OutOfRangeException;
import harrypotter.model.character.Champion;
import harrypotter.model.character.GryffindorWizard;
import harrypotter.model.character.HufflepuffWizard;
import harrypotter.model.character.RavenclawWizard;
import harrypotter.model.character.SlytherinWizard;
import harrypotter.model.character.Wizard;
import harrypotter.model.magic.DamagingSpell;
import harrypotter.model.magic.HealingSpell;
import harrypotter.model.magic.Potion;
import harrypotter.model.magic.RelocatingSpell;
import harrypotter.model.tournament.FirstTask;
import harrypotter.model.tournament.Tournament;
import harrypotter.model.world.Cell;
import harrypotter.model.world.ChampionCell;
import harrypotter.model.world.CollectibleCell;
import harrypotter.model.world.Direction;
import harrypotter.model.world.EmptyCell;
import harrypotter.model.world.ObstacleCell;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

public class FirstTaskView extends JFrame {
	JLabel backgroundImage;
	JPanel panel;
	Champion a;
	Wizard b;
	JLabel n1;
	JLabel h;
	JPanel frame;
	JButton[][] grid;
	JLabel title;
	JLabel chN;
	JLabel house;
	JLabel spells;
	JLabel text;
	JLabel moves;
	JButton useTrait;
	JToolBar toolbar;
	JLabel current;
	JLabel housen;
	JButton pot;
	JButton spellbox;
	JButton spellbox1;
	JButton spellbox2;
	JLabel spelln;
	FirstTask task1;
	JLabel ChampIp;
	JLabel IpBardo;
	JLabel ChampHp;
	JLabel HpBardo;
	JButton left;
	JButton right;
	JButton back;
	JButton forward;
	Direction FORWARD;
	Direction BACKWARD;
	Direction LEFT;
	Direction RIGHT;
	JLabel inv;
	JComboBox d;
	JComboBox d1;
	JComboBox num;
	JComboBox d1Relocate;
	JComboBox d2Relocate;
	JLabel sp1;
	JLabel sp2;
	JLabel sp3;
	SecondTaskView q;

	public FirstTaskView(ArrayList<Champion> c) throws IOException {

		task1 = new FirstTask(c);

		setBounds(0, 0, 1361, 766);
		setTitle("Tournament 1");
		setVisible(true);
		setResizable(false);
		backgroundImage = new JLabel();
		backgroundImage.setBounds(0, 0, 1360, 765);
		backgroundImage.setIcon(new ImageIcon("D:\\task1.jpg"));
		title = new JLabel("Tournament 1");
		title.setForeground(Color.WHITE);
		title.setVisible(true);
		title.setOpaque(false);

		title.setFont(new Font(Font.SERIF, Font.ITALIC, 50));
		title.setBounds(400, 20, 300, 50);

		chN = new JLabel("Champion:");
		chN.setVisible(true);
		chN.setOpaque(false);
		chN.setForeground(Color.WHITE);
		chN.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
		chN.setBounds(1110, 20, 300, 50);

		// String[] directions2 = { "FORWARD", "BACKWARD", "RIGHT", "LEFT" };
		String[] directions2 = { "FORWARD", "RIGHT", "LEFT" };

		text = new JLabel("Direction of Spell:");
		text.setVisible(false);
		text.setOpaque(false);
		text.setForeground(Color.WHITE);
		text.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		text.setBounds(1110, 240, 300, 50);

		d1 = new JComboBox(directions2);
		d1.setBounds(1110, 290, 150, 30);
		d1.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		d1.setBackground(Color.BLACK);
		d1.setForeground(Color.WHITE);
		d1.setVisible(false);

		d2Relocate = new JComboBox(directions2);
		d2Relocate.setBounds(1110, 580, 150, 30);
		d2Relocate.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		d2Relocate.setBackground(Color.BLACK);
		d2Relocate.setForeground(Color.WHITE);
		d2Relocate.setVisible(false);

		d1Relocate = new JComboBox(directions2);
		d1Relocate.setBounds(1110, 367, 150, 30);
		d1Relocate.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		d1Relocate.setBackground(Color.BLACK);
		d1Relocate.setForeground(Color.WHITE);
		d1Relocate.setVisible(false);

		String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		num = new JComboBox(nums);
		num.setBounds(1110, 367, 150, 30);
		num.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		num.setBackground(Color.BLACK);
		num.setForeground(Color.WHITE);
		num.setVisible(false);

		ChampIp = new JLabel("Inventory Points :");
		ChampIp.setVisible(true);
		ChampIp.setOpaque(false);
		ChampIp.setForeground(Color.WHITE);
		ChampIp.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		ChampIp.setBounds(1110, 480, 300, 50);

		IpBardo = new JLabel(((Wizard) task1.getCurrentChamp()).getIp() + "");
		IpBardo.setVisible(true);
		IpBardo.setOpaque(false);
		IpBardo.setForeground(Color.WHITE);
		IpBardo.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		IpBardo.setBounds(1110, 500, 300, 50);

		inv = new JLabel("Inventory :"
				+ ((Wizard) task1.getCurrentChamp()).getInventory().size());
		inv.setVisible(true);
		inv.setOpaque(false);
		inv.setForeground(Color.WHITE);
		inv.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		inv.setBounds(1110, 370, 300, 50);

		pot = new JButton("Use Potion");
		pot.setVisible(true);
		pot.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
		pot.setBounds(1210, 385, 110, 25);
		pot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// task1.usePotion((Potion)((Wizard)task1.getCurrentChamp()).getInventory().get(0));
				for (int i = 0; i < ((Wizard) task1.getCurrentChamp())
						.getInventory().size(); i++) {
					if (((Wizard) task1.getCurrentChamp()).getInventory()
							.get(i) instanceof Potion) {
						task1.usePotion((Potion) (((Wizard) task1
								.getCurrentChamp()).getInventory().get(i)));

					}

				}
			}
		});

		ChampHp = new JLabel("Health Points :");
		ChampHp.setVisible(true);
		ChampHp.setOpaque(false);
		ChampHp.setForeground(Color.WHITE);
		ChampHp.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		ChampHp.setBounds(1110, 420, 300, 50);

		HpBardo = new JLabel(((Wizard) task1.getCurrentChamp()).getHp() + "");
		HpBardo.setVisible(true);
		HpBardo.setOpaque(false);
		HpBardo.setForeground(Color.WHITE);
		HpBardo.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		HpBardo.setBounds(1110, 440, 300, 50);

		house = new JLabel("House:");
		house.setVisible(true);
		house.setOpaque(false);
		house.setForeground(Color.WHITE);
		house.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
		house.setBounds(1110, 80, 300, 50);

		spells = new JLabel("Spells:");
		spells.setVisible(true);
		spells.setOpaque(false);
		spells.setForeground(Color.WHITE);
		spells.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
		spells.setBounds(1110, 150, 300, 50);

		moves = new JLabel("Remaining Moves :" + task1.getAllowedMoves() + "");
		moves.setVisible(true);
		moves.setOpaque(false);
		moves.setForeground(Color.WHITE);
		moves.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		moves.setBounds(1110, 330, 300, 50);

		housen = new JLabel(((Wizard) task1.getCurrentChamp()).getClass()
				.getSimpleName());
		housen.setVisible(true);
		housen.setOpaque(false);
		housen.setForeground(Color.WHITE);
		housen.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		housen.setBounds(1110, 110, 300, 50);

		spelln = new JLabel(" Spells: ");
		spelln.setVisible(true);
		spelln.setOpaque(false);
		spelln.setForeground(Color.WHITE);
		spelln.setFont(new Font(Font.SERIF, Font.ITALIC, 25));

		sp1 = new JLabel(((Wizard) task1.getCurrentChamp()).getSpells().get(0)
				.getName());
		sp1.setToolTipText("CoolDown: "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(0)
						.getCoolDown()
				+ " Cost:  "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(0)
						.getCost()
				+ " Type: "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(0)
						.getClass().getSimpleName());
		sp1.setForeground(Color.WHITE);
		sp1.setOpaque(false);
		sp1.setBounds(1160, 180, 200, 50);
		sp1.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		sp1.setVisible(true);

		spellbox = new JButton(" ");
		spellbox.setVisible(true);
		spellbox.setOpaque(true);
		spellbox.setForeground(Color.BLACK);
		spellbox.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		spellbox.setBounds(1130, 200, 10, 10);

		spellbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				helper_Spell(0);

			}

		});

		sp2 = new JLabel(((Wizard) task1.getCurrentChamp()).getSpells().get(0)
				.getName());
		sp2.setToolTipText("CoolDown: "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(1)
						.getCoolDown()
				+ " Cost: "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(1)
						.getCost()
				+ " Type: "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(1)
						.getClass().getSimpleName());

		sp2.setForeground(Color.WHITE);
		sp2.setOpaque(false);
		sp2.setBounds(1160, 200, 200, 50);
		sp2.setVisible(true);
		sp2.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		spellbox1 = new JButton("");
		spellbox1.setVisible(true);
		spellbox1.setOpaque(true);

		spellbox1.setForeground(Color.BLACK);
		spellbox1.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		spellbox1.setBounds(1130, 220, 10, 10);
		spellbox1.setToolTipText("");

		spellbox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				helper_Spell(1);

			}
		});
		sp3 = new JLabel(((Wizard) task1.getCurrentChamp()).getSpells().get(0)
				.getName());
		sp3.setToolTipText("CoolDown: "
				+ (int) (((Wizard) task1.getCurrentChamp()).getSpells().get(2)
						.getCoolDown())
				+ " Cost:  "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(2)
						.getCost()
				+ " Type: "
				+ ((Wizard) task1.getCurrentChamp()).getSpells().get(2)
						.getClass().getSimpleName());
		sp3.setForeground(Color.WHITE);
		sp3.setOpaque(false);
		sp3.setBounds(1160, 220, 200, 50);
		sp3.setVisible(true);
		sp3.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		spellbox2 = new JButton("");
		// spellbox2.setToolTipText("");
		spellbox2.setVisible(true);
		spellbox2.setOpaque(true);
		spellbox2.setForeground(Color.BLACK);
		spellbox2.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		spellbox2.setBounds(1130, 240, 10, 10);
		spellbox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				helper_Spell(2);

			}

		});
		current = new JLabel(((Wizard) task1.getCurrentChamp()).getName());
		current.setVisible(true);
		current.setOpaque(false);
		current.setForeground(Color.WHITE);
		current.setFont(new Font(Font.SERIF, Font.ITALIC, 25));
		current.setBounds(1110, 50, 300, 50);

		frame = new JPanel();
		frame.setBounds(0, 100, 1100, 600);
		frame.setVisible(true);
		Cell[][] cells = task1.getMap();
		frame.setLayout(new GridLayout(10, 10));
		grid = new JButton[10][10];

		for (int y = 0; y < 10; y++) {

			for (int x = 0; x < 10; x++) {
				if (x == 4 && y == 4) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "eggcell");

					grid[x][y].setBackground(Color.YELLOW);
					grid[x][y].setIcon(new ImageIcon("D:\\egg.jpg"));
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				}
				// else
				// if(task1.getMarkedCells().get(0).getX() == x &&
				// task1.getMarkedCells().get(0).getY() == y ){
				// grid[x][y] = new JButton("(" + x + "," + y + ")"
				// + "marked cell 1 ");
				// grid[x][y].setBackground(Color.GREEN);
				// grid[x][y].setBorderPainted(false);
				// frame.add(grid[x][y]);
				// }
				// else if(task1.getMarkedCells().get(1).getX() == x &&
				// task1.getMarkedCells().get(1).getY() == y ){
				// grid[x][y] = new JButton("(" + x + "," + y + ")"
				// + "marked cell 2 ");
				// grid[x][y].setBackground(Color.GREEN);
				// grid[x][y].setBorderPainted(false);
				// frame.add(grid[x][y]);
				// }
				else if (task1.getMap()[x][y] instanceof ObstacleCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "obstacle");
					grid[x][y].setBackground(Color.GRAY);
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
					grid[x][y].setIcon(new ImageIcon("D:\\obstacle.jpg"));
					grid[x][y]
							.setToolTipText(((ObstacleCell) task1.getMap()[x][y])
									.getObstacle().getHp()
									+ " "
									+ ((ObstacleCell) task1.getMap()[x][y])
											.getObstacle().getClass()
											.getSimpleName());
				} else if (task1.getMap()[x][y] instanceof CollectibleCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "collectible");
					grid[x][y].setBackground(Color.CYAN);
					grid[x][y].setIcon(new ImageIcon("D:\\potion.jpg"));
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
					String tmp = ((CollectibleCell) task1.getMap()[x][y])
							.getCollectible().getClass().getSimpleName();
					String tmp2 = "";
					if (tmp.equals("Potion")) {
						Potion p = (Potion) ((CollectibleCell) task1.getMap()[x][y])
								.getCollectible();
						tmp2 = p.getName() + " Amount: " + p.getAmount();
					}
					grid[x][y].setToolTipText(tmp + ": " + tmp2);
				} else if (task1.getMap()[x][y] instanceof EmptyCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")" + "empty");
					grid[x][y].setBackground(Color.RED);
					grid[x][y].setIcon(new ImageIcon("D:\\grass.jpg"));
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				} else if (task1.getMap()[x][y] instanceof ChampionCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "champion");
					grid[x][y].setBackground(Color.MAGENTA);
					if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof RavenclawWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\rav.jpg"));
					} else if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof HufflepuffWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\huff.jpg"));
					} else if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof GryffindorWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\griff.jpg"));
					} else if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof SlytherinWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\sli.jpg"));
					}
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				}

			}
		}

		useTrait = new JButton("Activate Trait");
		useTrait.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
		useTrait.setBounds(1150, 660, 150, 30);
		String[] directions = { "UP", "DOWN", "RIGHT", "LEFT" };
		d = new JComboBox(directions);
		useTrait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (((Wizard) task1.getCurrentChamp()) instanceof GryffindorWizard) {
					try {
						task1.onGryffindorTrait();
					} catch (InCooldownException e) {
						JOptionPane.showMessageDialog(null,
								"CoolDown Exception", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				} else if (((Wizard) task1.getCurrentChamp()) instanceof RavenclawWizard) {
					try {
						task1.onRavenclawTrait();
					} catch (InCooldownException e) {
						JOptionPane.showMessageDialog(null,
								"CoolDown Exception", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				}

				else if (((Wizard) task1.getCurrentChamp()) instanceof HufflepuffWizard) {
					try {
						task1.onHufflepuffTrait();
					} catch (InCooldownException e) {
						JOptionPane.showMessageDialog(null,
								"CoolDown Exception", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				} else

				if (((Wizard) task1.getCurrentChamp()) instanceof SlytherinWizard) {
					// String[] directions = { "UP", "DOWN", "RIGHT",
					// " LEFT" };
					// d= new JComboBox(directions);
					d.setVisible(true);
					d.setBounds(1110, 400, 150, 30);
					d.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
					d.setBackground(Color.BLACK);
					d.setForeground(Color.WHITE);
					if ((String) d.getSelectedItem() == "UP") {
						try {
							task1.onSlytherinTrait(FORWARD);
						} catch (InCooldownException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (OutOfBordersException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidTargetCellException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					else if ((String) d.getSelectedItem() == "DOWN") {
						try {
							task1.onSlytherinTrait(BACKWARD);
						} catch (InCooldownException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (OutOfBordersException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidTargetCellException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if ((String) d.getSelectedItem() == "LEFT") {
						try {
							task1.onSlytherinTrait(LEFT);
						} catch (InCooldownException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (OutOfBordersException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidTargetCellException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if ((String) d.getSelectedItem() == "RIGHT") {
						try {
							task1.onSlytherinTrait(RIGHT);
						} catch (InCooldownException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (OutOfBordersException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvalidTargetCellException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}

		});

		left = new JButton("Left");
		left.setVisible(true);
		left.setOpaque(true);
		left.setForeground(Color.BLACK);
		left.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		left.setBounds(1110, 590, 85, 20);
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					task1.moveForward();

				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null,
							"This Cell is put of borders", "Warning",
							JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "this cell is invalid",
							"Warning", JOptionPane.WARNING_MESSAGE);
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				drawMap();
			}

		});

		right = new JButton("Right");
		right.setVisible(true);
		right.setOpaque(true);
		right.setForeground(Color.BLACK);
		right.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		right.setBounds(1220, 590, 85, 20);
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					task1.moveBackward();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null,
							"This Cell is put of borders", "Warning",
							JOptionPane.WARNING_MESSAGE);
					// e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "this cell is invalid",
							"Warning", JOptionPane.WARNING_MESSAGE);
					// TODO Auto-generated catch block
					// e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				drawMap();
			}

		});

		forward = new JButton("Up");
		forward.setVisible(true);
		forward.setOpaque(true);
		forward.setForeground(Color.BLACK);
		forward.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		forward.setBounds(1170, 560, 85, 20);
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					task1.moveLeft();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null,
							"This Cell is put of borders", "Warning",
							JOptionPane.WARNING_MESSAGE);
					// e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "this cell is invalid",
							"Warning", JOptionPane.WARNING_MESSAGE);
					// TODO Auto-generated catch block
					// e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				drawMap();
				// removeAll();

				// repaint();
				// revalidate();
			}

		});

		back = new JButton("Down");
		back.setVisible(true);
		back.setOpaque(true);
		back.setForeground(Color.BLACK);
		back.setFont(new Font(Font.SERIF, Font.ITALIC, 18));
		back.setBounds(1170, 620, 85, 20);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					task1.moveRight();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null,
							"This Cell is put of borders", "Warning",
							JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "This cell is invalid",
							"Warning", JOptionPane.WARNING_MESSAGE);
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				drawMap();

			}

		});
		getContentPane().add(sp1);
		getContentPane().add(sp2);
		getContentPane().add(sp3);
		getContentPane().add(d1);
		getContentPane().add(text);

		getContentPane().add(chN);
		getContentPane().add(current);
		getContentPane().add(house);
		getContentPane().add(housen);
		getContentPane().add(spelln);
		getContentPane().add(spellbox);
		getContentPane().add(spellbox1);
		getContentPane().add(spellbox2);
		getContentPane().add(moves);
		getContentPane().add(spells);
		getContentPane().add(back);
		getContentPane().add(forward);
		getContentPane().add(right);
		getContentPane().add(left);
		getContentPane().add(HpBardo);
		getContentPane().add(ChampHp);
		getContentPane().add(IpBardo);
		getContentPane().add(ChampIp);
		getContentPane().add(useTrait);
		getContentPane().add(title);
		getContentPane().add(frame);
		getContentPane().add(inv);
		getContentPane().add(pot);
		getContentPane().add(backgroundImage);

	}

	public FirstTask getTask1() {
		return task1;
	}

	public void drawMap() {
		frame.removeAll();
		for (int y = 0; y < 10; y++) {

			for (int x = 0; x < 10; x++) {
				if (x == 4 && y == 4) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "eggcell");

					grid[x][y].setBackground(Color.YELLOW);
					grid[x][y].setIcon(new ImageIcon("D:\\egg.jpg"));
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				}
				// else
				// if(task1.getMarkedCells().get(0).getX() == x &&
				// task1.getMarkedCells().get(0).getY() == y ){
				//
				// grid[x][y] = new JButton("(" + x + "," + y + ")"
				// + "marked cell 1 ");
				// grid[x][y].setBackground(Color.RED);
				//
				// grid[x][y].setBorderPainted(false);
				//
				// // grid[x][y].setIcon(grid[x][y].getIcon());
				// // grid[x][y].setBorderPainted(true);
				// frame.add(grid[x][y]);
				// }
				// else
				// if(task1.getMarkedCells().get(1).getX() == x &&
				// task1.getMarkedCells().get(1).getY() == y ){
				// grid[x][y] = new JButton("(" + x + "," + y + ")"
				// + "marked cell 2 ");
				// grid[x][y].setBackground(Color.RED);
				// grid[x][y].setBorderPainted(false);
				// // grid[x][y].setIcon(grid[x][y].getIcon());
				// // grid[x][y].setBorderPainted(true);
				// // frame.add(grid[x][y]);
				// }
				else if (task1.getMap()[x][y] instanceof ObstacleCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "obstacle");
					grid[x][y].setBackground(Color.GRAY);
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
					grid[x][y].setIcon(new ImageIcon("D:\\obstacle.jpg"));
					grid[x][y]
							.setToolTipText(((ObstacleCell) task1.getMap()[x][y])
									.getObstacle().getHp()
									+ " "
									+ ((ObstacleCell) task1.getMap()[x][y])
											.getObstacle().getClass()
											.getSimpleName());
				} else if (task1.getMap()[x][y] instanceof CollectibleCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "collectible");
					grid[x][y].setBackground(Color.CYAN);
					grid[x][y].setIcon(new ImageIcon("D:\\potion.jpg"));
					String tmp = ((CollectibleCell) task1.getMap()[x][y])
							.getCollectible().getClass().getSimpleName();
					String tmp2 = "";
					if (tmp.equals("Potion")) {
						Potion p = (Potion) ((CollectibleCell) task1.getMap()[x][y])
								.getCollectible();
						tmp2 += p.getName() + " Amount: " + p.getAmount();
					}
					grid[x][y].setToolTipText(tmp + ": " + tmp2);

					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				} else if (task1.getMap()[x][y] instanceof EmptyCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")" + "empty");
					grid[x][y].setBackground(Color.RED);
					grid[x][y].setIcon(new ImageIcon("D:\\grass.jpg"));
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				} else
				// error
				if (task1.getMap()[x][y] instanceof ChampionCell) {
					grid[x][y] = new JButton("(" + x + "," + y + ")"
							+ "champion");
					grid[x][y].setBackground(Color.MAGENTA);
					if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof RavenclawWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\rav.jpg"));
					} else if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof HufflepuffWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\huff.jpg"));
					} else if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof GryffindorWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\griff.jpg"));
					} else if (((ChampionCell) task1.getMap()[x][y]).getChamp() instanceof SlytherinWizard) {
						grid[x][y].setIcon(new ImageIcon("D:\\sli.jpg"));
					}
					grid[x][y].setBorderPainted(false);
					frame.add(grid[x][y]);
				}

			}
		}
		IpBardo.setText(((Wizard) task1.getCurrentChamp()).getIp() + "");
		HpBardo.setText(((Wizard) task1.getCurrentChamp()).getHp() + "");
		moves.setText("Remaining Moves :" + task1.getAllowedMoves() + "");
		housen.setText(((Wizard) task1.getCurrentChamp()).getClass()
				.getSimpleName());

		sp1.setText(((Wizard) task1.getCurrentChamp()).getSpells().get(0)
				.getName());
		sp2.setText(((Wizard) task1.getCurrentChamp()).getSpells().get(1)
				.getName());
		sp3.setText(((Wizard) task1.getCurrentChamp()).getSpells().get(2)
				.getName());
		current.setText(((Wizard) task1.getCurrentChamp()).getName());
		inv.setText("Inventory :"
				+ ((Wizard) task1.getCurrentChamp()).getInventory().size());
		revalidate();
		// repaint();
		if (task1.getChampions().isEmpty()) {
			try {
				q = new SecondTaskView(task1.getWinners());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setVisible(false);
			q.setVisible(true);
		}
	}

	public void helper_Spell(int n) {

		if (((Wizard) task1.getCurrentChamp()).getSpells().get(n) instanceof HealingSpell) {
			try {
				task1.castHealingSpell((HealingSpell) ((Wizard) task1
						.getCurrentChamp()).getSpells().get(n));
			} catch (InCooldownException e) {
				JOptionPane.showMessageDialog(null, "You ran out of cooldown",
						"Warning", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			} catch (NotEnoughIPException e) {
				JOptionPane.showMessageDialog(null, "You don't have enough Ip",
						"Warning", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (((Wizard) task1.getCurrentChamp()).getSpells().get(n) instanceof DamagingSpell) {
			d1.setVisible(true);
			text.setVisible(true);
			String d = d1.getSelectedItem().toString();
			if (d.equals("FORWARD")) {
				try {
					task1.castDamagingSpell((DamagingSpell) ((Wizard) task1
							.getCurrentChamp()).getSpells().get(n),
							harrypotter.model.world.Direction.LEFT);

				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(null, "In cooldown",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (NotEnoughIPException e) {
					JOptionPane.showMessageDialog(null, "not enough ip",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null, "out of borders",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "invalid target cell",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "IOException",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			} else if (d.equals("DOWN")) {
				// dir = (RIGHT);
				try {
					task1.castDamagingSpell((DamagingSpell) ((Wizard) task1
							.getCurrentChamp()).getSpells().get(n),
							harrypotter.model.world.Direction.RIGHT);

				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(null, "In cooldown",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (NotEnoughIPException e) {
					JOptionPane.showMessageDialog(null, "not enough ip",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null, "out of borders",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "invalid target cell",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "IOException",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			} else if (d.equals("RIGHT")) {
				// dir = BACKWARD;
				try {
					task1.castDamagingSpell((DamagingSpell) ((Wizard) task1
							.getCurrentChamp()).getSpells().get(n),
							harrypotter.model.world.Direction.BACKWARD);

				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(null, "In cooldown",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (NotEnoughIPException e) {
					JOptionPane.showMessageDialog(null, "not enough ip",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null, "out of borders",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "invalid target cell",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "IOException",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			} else if (d.equals("LEFT")) {
				// dir = FORWARD;

				try {
					task1.castDamagingSpell((DamagingSpell) ((Wizard) task1
							.getCurrentChamp()).getSpells().get(n),
							harrypotter.model.world.Direction.FORWARD);

				} catch (InCooldownException e) {
					JOptionPane.showMessageDialog(null, "In cooldown",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (NotEnoughIPException e) {
					JOptionPane.showMessageDialog(null, "not enough ip",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (OutOfBordersException e) {
					JOptionPane.showMessageDialog(null, "out of borders",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (InvalidTargetCellException e) {
					JOptionPane.showMessageDialog(null, "invalid target cell",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "IOException",
							"Warning", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			}
			drawMap();

		} else if (((Wizard) task1.getCurrentChamp()).getSpells().get(n) instanceof RelocatingSpell) {
			d1Relocate.setVisible(true);
			String d = d1Relocate.getSelectedItem().toString();
			String d2 = d2Relocate.getSelectedItem().toString();
			int x = Integer.parseInt(num.getSelectedItem().toString());
			if (d.equals("FORWARD")) {
				if (d2.equals("FORWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.LEFT,
								harrypotter.model.world.Direction.LEFT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("BACKWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.FORWARD,
								harrypotter.model.world.Direction.BACKWARD, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("LEFT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.FORWARD,
								harrypotter.model.world.Direction.LEFT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("RIGHT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.FORWARD,
								harrypotter.model.world.Direction.RIGHT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
			} else if (d.equals("BACKWARD")) {
				if (d2.equals("FORWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.BACKWARD,
								harrypotter.model.world.Direction.FORWARD, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("BACKWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.BACKWARD,
								harrypotter.model.world.Direction.BACKWARD, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("LEFT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.BACKWARD,
								harrypotter.model.world.Direction.LEFT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("RIGHT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.BACKWARD,
								harrypotter.model.world.Direction.RIGHT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
			} else if (d.equals("RIGHT")) {
				if (d2.equals("FORWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.RIGHT,
								harrypotter.model.world.Direction.FORWARD, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("BACKWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.RIGHT,
								harrypotter.model.world.Direction.BACKWARD, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("LEFT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.RIGHT,
								harrypotter.model.world.Direction.LEFT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("RIGHT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.RIGHT,
								harrypotter.model.world.Direction.RIGHT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
			} else if (d.equals("LEFT")) {
				if (d2.equals("FORWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.LEFT,
								harrypotter.model.world.Direction.RIGHT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("BACKWARD"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.LEFT,
								harrypotter.model.world.Direction.BACKWARD, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("LEFT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.LEFT,
								harrypotter.model.world.Direction.LEFT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
				else if (d2.equals("RIGHT"))
					try {
						task1.castRelocatingSpell(
								(RelocatingSpell) ((Wizard) task1
										.getCurrentChamp()).getSpells().get(n),
								harrypotter.model.world.Direction.LEFT,
								harrypotter.model.world.Direction.RIGHT, x);
					} catch (InCooldownException | NotEnoughIPException
							| OutOfBordersException
							| InvalidTargetCellException | OutOfRangeException
							| IOException e) {
						JOptionPane.showMessageDialog(null,
								"You can't use this spell", "Warning",
								JOptionPane.WARNING_MESSAGE);
						e.printStackTrace();
					}
			}
		}
	}
}
