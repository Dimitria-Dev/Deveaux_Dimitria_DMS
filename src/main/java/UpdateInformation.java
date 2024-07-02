/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * July 1st, 2024
 * UpdateInformation.java
 *  This class allows a user to update a child's allergy or interest
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateInformation {
    JFrame frame = new JFrame("Update Information");
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel parentPanel;
    private JButton updateAllergiesButton;
    private JButton updateInterestButton;
    private JPanel updateAllergiesPanel;
    private JPanel updateInterestPanel;
    private JTextField childIdtextField;
    private JButton searchButton;
    private JTextField childIDtextField2;
    private JButton interestSearchButton1;
    private JPanel menuPanel;
    private JButton mainMenuButton;
    private JButton exitButton;
    private JButton exitToMainMenuButton;
    private JButton exitToMainMenuButton1;
    private JPanel allergiesUpdatePanel;
    private JTextField allergyTextField;
    private JButton updateButton;
    private JPanel updateInterest;
    private JButton updateButton2;
    private JTextField InterestTextField1;

    public UpdateInformation() {
        frame.setSize(500,300);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        allergiesUpdatePanel.setVisible(false);
        updateInterest.setVisible(false);


        /* method: updateAllergiesButton
         * parameter: ActionListener
         * return: none
         * purpose: to switch card panel option to allow a user to update a child's allergy
         * */
        updateAllergiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(updateAllergiesPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });

        /* method: updateInterestButton
         * parameter: ActionListener
         * return: none
         * purpose: to switch card panel option to allow a user to update a child's interest
         * */
        updateInterestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(updateInterestPanel);
                parentPanel.repaint();
                parentPanel.revalidate();

            }
        });

        /* method: mainMenuButton
         * parameter: ActionListener
         * return: none
         * purpose: to return user back to the main menu
         * */
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == exitToMainMenuButton) {
                    frame.dispose();
                    Menu menu = new Menu();
                }
            }
        });


        /* method: exitButton
         * parameter: ActionListener
         * return: none
         * purpose: to exit the system
         * */
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == exitToMainMenuButton) {
                    frame.dispose();
                    System.exit(0);
                }
            }
        });

        /* method: exitToMainMenuButton1
         * parameter: ActionListener
         * return: none
         * purpose: to exit to the main menu from the update allergy panel
         * */
        exitToMainMenuButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == exitToMainMenuButton1) {
                    frame.dispose();
                    Menu menu = new Menu();
                }
            }
        });


        /* method: exitToMainMenuButton
         * parameter: ActionListener
         * return: none
         * purpose: to exit to the main menu from the update interest panel
         * */
        exitToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == exitToMainMenuButton) {
                    frame.dispose();
                    Menu menu = new Menu();
                }
            }
        });

        /* method: searchButton
         * parameter: ActionListener
         * return: none
         * purpose: to allow a user to update a child's allergy if their ID number is found in the systems
         * */
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == searchButton) {
                    allergiesUpdatePanel.setVisible(true);
                    try {
                        int id = Integer.parseInt(childIdtextField.getText());
                        boolean found = false;

                        for(Child.ChildInfo childInfo : Child.childInfoList) {
                            if(childInfo.getChildID() == id){
                                allergiesUpdatePanel.setVisible(true);
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            JOptionPane.showMessageDialog(frame, "There was an error finding Child ID " + id + ". Please try again.");
                        }
                    } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                    }
                }

            }
        });

        /* method: updateButton
         * parameter: ActionListener
         * return: none
         * purpose: to allow a user to update a child's allergy in the system
         * */
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String updateAllergy = allergyTextField.getText();

                    int id = Integer.parseInt(childIdtextField.getText());
                    boolean found = false;

                    for (Child.ChildInfo childInfo : Child.childInfoList) {
                        if (childInfo.getChildID() == id) {
                            found = true;
                            // Update adoption status of the child
                            childInfo.setAllergies(updateAllergy);
                            JOptionPane.showMessageDialog(frame, "Allergy updated successfully for Child ID " + id + ".");
                            frame.dispose();
                            UpdateInformation updateInformation = new UpdateInformation();
                            updateInformation.frame.setVisible(true);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Child with ID " + id + " not found.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                }
            }
        });

        /* method: interestSearchButton1
         * parameter: ActionListener
         * return: none
         * purpose: to allow a user to update a child's interest if their ID number is found in the systems
         * */
        interestSearchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(childIDtextField2.getText());
                    boolean found = false;

                    for(Child.ChildInfo childInfo : Child.childInfoList) {
                        if(childInfo.getChildID() == id){
                            updateInterest.setVisible(true);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        JOptionPane.showMessageDialog(frame, "There was an error finding Child ID " + id + ". Please try again.");
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        /* method: updateButton
         * parameter: ActionListener
         * return: none
         * purpose: to allow a user to update a child's interest in the system
         * */
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String updateInterest = InterestTextField1.getText();

                    int id = Integer.parseInt(childIDtextField2.getText());
                    boolean found = false;

                    for (Child.ChildInfo childInfo : Child.childInfoList) {
                        if (childInfo.getChildID() == id) {
                            found = true;

                            childInfo.setInterest(updateInterest);
                            JOptionPane.showMessageDialog(frame, "Interest updated successfully for Child ID " + id + ".");
                            frame.dispose();
                            UpdateInformation updateInformation = new UpdateInformation();
                            updateInformation.frame.setVisible(true);
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Child with ID " + id + " not found.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID number.");
                }
            }
        });
    }
}
