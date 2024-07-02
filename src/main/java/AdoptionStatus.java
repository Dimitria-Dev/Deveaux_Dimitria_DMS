/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * July 1st, 2024
 * AdoptionStatus.java
 *  This class allows a user to check the adoption status of a child and also update the adoption status of a child
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdoptionStatus {
    JFrame frame = new JFrame("AdoptionStatus");
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton checkAdoptionStatusButton;
    private JButton updateAdoptionStatusButton;
    private JPanel parentPanel;
    private JPanel checkAdoptionStatusPanel;
    private JPanel updateAdoptionStatusPanel;
    private JPanel adoptionStatusOptionsPanel;
    private JTextField checkStatusTextField;
    private JButton cSearchButton;
    private JTextField updateStatustextField1;
    private JButton uSearchButton;
    private JComboBox adoptionStatusOptions;
    private JPanel menuPanel;
    private JButton mainMenuButton;
    private JButton exitButton;
    private JPanel options;
    private JComboBox adoptionStatusComboBox;
    private JButton updateButton;
    private JButton update;

    public AdoptionStatus() {
        frame.setSize(500,300);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        /* method: checkAdoptionStatusButton
         * parameter: ActionListener
         * return: none
         * purpose: to switch card panel option to allow user to check an adoption status
         * */
        checkAdoptionStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(checkAdoptionStatusPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });

        /* method: updateAdoptionStatus
         * parameter: ActionListener
         * return: none
         * purpose: to switch card panel option to allow user to update a child's adoption status
         * */
        updateAdoptionStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(updateAdoptionStatusPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
                options.setVisible(false);
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
                if(e.getSource() == mainMenuButton) {
                    frame.dispose();
                    Menu menu = new Menu();
                }
            }
        });

        /* method: exitButton
         * parameter: ActionListener
         * return: none
         * purpose: to exit system
         * */
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == exitButton) {
                    System.exit(0);
                }
            }
        });

        /* method: cSearchButton
         * parameter: ActionListener
         * return: none
         * purpose: to search for a child in the DMS by their ID number to check their adoption status
         * */
        cSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(checkStatusTextField.getText());
                    boolean found = false;
                    String message = " ";

                    for(Child.ChildInfo childInfo : Child.childInfoList) {
                        if(childInfo.getChildID() == id){
                            message = " Child ID: " + childInfo.getChildID() + "\n Child name: " + childInfo.getFirstName() + " "
                                    + childInfo.getLastName() + "\n Adoption Status: " + childInfo.getAdoptionStatus();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        JOptionPane.showMessageDialog(frame, "There was an error finding Child ID " + id + ". Please try again.");
                    } else{
                        JOptionPane.showMessageDialog(frame, message);
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        /* method: uSearchButton
         * parameter: ActionListener
         * return: none
         * purpose: to search for a child in the DMS by their ID number to update their adoption status
         * */
        uSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(updateStatustextField1.getText());
                    boolean found = false;

                    for(Child.ChildInfo childInfo : Child.childInfoList) {
                        if(childInfo.getChildID() == id){
                            options.setVisible(true);
                            initializeAdoptionStatusBox(childInfo.getAdoptionStatus());
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
         * purpose: to update the child's adoption status based on the selected child ID number
         * */
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String updateStatus = adoptionStatusComboBox.getSelectedItem().toString();
                    int id = Integer.parseInt(updateStatustextField1.getText());
                    boolean found = false;

                    for (Child.ChildInfo childInfo : Child.childInfoList) {
                        if (childInfo.getChildID() == id) {
                            found = true;

                            childInfo.setAdoptionStatus(updateStatus);
                            JOptionPane.showMessageDialog(frame, "Adoption status updated successfully for Child ID " + id + ".");

                            frame.dispose();
                            AdoptionStatus adoptionStatus = new AdoptionStatus();
                            adoptionStatus.frame.setVisible(true);
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

    /* method: initializeAdoptionStatus
     * parameter: String status
     * return: none
     * purpose: to set the options for the adoption status combo box
     * */
    private void initializeAdoptionStatusBox(String status) {
        DefaultComboBoxModel<String> adoptionStatusModel = new DefaultComboBoxModel<>();
        adoptionStatusModel.addElement("Available For Adoption");
        adoptionStatusModel.addElement("Adoption In Progress");
        adoptionStatusModel.addElement("Adoption Finalized");
        adoptionStatusModel.addElement("Adoption Status Unknown");
        adoptionStatusComboBox.setModel(adoptionStatusModel);
        adoptionStatusComboBox.setSelectedItem(status);
    }
}
