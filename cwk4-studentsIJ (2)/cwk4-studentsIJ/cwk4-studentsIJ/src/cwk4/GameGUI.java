package cwk4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 *
 * @author A.A.Marczyk
 * @version 20/10/23
 */
            public class GameGUI {
                private WIN gp = new SpaceWars("Aya");
                private JFrame myFrame = new JFrame("Game GUI");
                private JTextArea listing = new JTextArea();
                private JLabel codeLabel = new JLabel();
                private JButton fightBtn = new JButton("Fight");

                private JButton viewStateBtn = new JButton("View State");
                private JButton clearBtn = new JButton("Clear");
                private JPanel eastPanel = new JPanel();


                public GameGUI() {
                    makeFrame();
                    makeMenuBar(myFrame);
                }

                /**
                 * Create the main frame's menu bar.
                 */
                private void makeMenuBar(JFrame frame) {
                    JMenuBar menubar = new JMenuBar();
                    frame.setJMenuBar(menubar);

                    // create the Forces menu
                    JMenu forcesMenu = new JMenu("Forces");
                    menubar.add(forcesMenu);

                    JMenuItem listForcesItem = new JMenuItem("List All Forces ");
                    listForcesItem.addActionListener(new ListForcesHandler());
                    forcesMenu.add(listForcesItem);

                    JMenuItem listASFForcesItem = new JMenuItem("List ASFleet");
                    listASFForcesItem.addActionListener(new ListASFForcesHandler());
                    forcesMenu.add(listASFForcesItem);

                    JMenuItem activateForceItem = new JMenuItem("Activate a Force");
                    activateForceItem.addActionListener(new ActivateForceHandler());
                    forcesMenu.add(activateForceItem);

                    JMenuItem recallForceItem = new JMenuItem("Recall a Force");
                    recallForceItem.addActionListener(new RecallForceHandler());
                    forcesMenu.add(recallForceItem);

                    // create the Battles menu
                    JMenu battlesMenu = new JMenu("Battles");
                    menubar.add(battlesMenu);

                    JMenuItem listBattlesItem = new JMenuItem("List all battles");
                    listBattlesItem.addActionListener(new ListBattlesHandler());
                    battlesMenu.add(listBattlesItem);


                }

                /**
                 * Create the Swing frame and its content.
                 */
                private void makeFrame() {
                    myFrame.setLayout(new BorderLayout());
                    myFrame.add(listing, BorderLayout.CENTER);
                    listing.setVisible(false);
                    myFrame.add(eastPanel, BorderLayout.EAST);
                    // set panel layout and add components
                    eastPanel.setLayout(new GridLayout(4, 1));
                    eastPanel.add(fightBtn);
                    eastPanel.add(viewStateBtn);
                    eastPanel.add(clearBtn);
                    fightBtn.addActionListener(new FightBtnHandler());
                    fightBtn.setVisible(true);
                    viewStateBtn.addActionListener(new ViewStateBtnHandler());
                    viewStateBtn.setVisible(true);
                    clearBtn.addActionListener(new ClearBtnHandler());
                    clearBtn.setVisible(true);
                    // building is done - arrange the components and show
                    myFrame.pack();
                    myFrame.setVisible(true);
                }

                private String fighting(int code) {
                    switch (code) {
                        case 0:
                            return "Fight won";
                        case 1:
                            return "Fight lost as no suitable force available";
                        case 2:
                            return "Fight lost on battle strength, force destroyed";
                        case 3:
                            return "fight is lost and admiral completely defeated ";
                    }
                    return " no such fight ";
                }

                private class ListForcesHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        listing.setVisible(true);
                        String xx = gp.getAllForces();
                        listing.setText(xx);

                    }
                }

                private class ListASFForcesHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        listing.setVisible(true);
                        String xx = gp.getASFleet();
                        listing.setText(xx);

                    }
                }

                private class ActivateForceHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        String ref = JOptionPane.showInputDialog("Enter force reference: ");
                        String result = String.valueOf(gp.activateForce(ref));
                        JOptionPane.showMessageDialog(myFrame, result);
                    }
                }

                private class RecallForceHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        String ref = JOptionPane.showInputDialog("Enter force reference: ");
                        gp.recallForce(ref);
                        String result = gp.toString();
                        JOptionPane.showMessageDialog(myFrame, result);
                    }
                }

                private class ListBattlesHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        listing.setVisible(true);
                        String xx = gp.getAllBattles();
                        listing.setText(xx);
                    }
                }

                private class FightBtnHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        int result = -1;
                        String inputValue = JOptionPane.showInputDialog("Fight number ?: ");
                        int num = Integer.parseInt(inputValue);
                        result = gp.doBattle(num);
                        JOptionPane.showMessageDialog(myFrame, fighting(result));
                    }
                }

                private class ViewStateBtnHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        listing.setVisible(true);
                        String xx = gp.toString();
                        listing.setText(xx);
                    }
                }

                private class ClearBtnHandler implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        listing.setVisible(false);
                        listing.setText("");
                    }
                }

                public static void main(String[] args) {
                    new GameGUI();
                }
            }
    
    
    
