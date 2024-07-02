/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * July 1st, 2024
 * AddChild.java
 *  This class allows a user to add a child to the DMS by entering their child ID number, first name, last name, age, gender,
 *  birthday, allergies and interest.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddChild {
    JFrame frame = new JFrame("AddChild");
    private JPanel mainPanel;
    private JPanel formPanel;
    private JTextField childIDTextField;
    private JTextField firstNameTextField;
    private JTextField ageTextField;
    private JTextField birthdayTextField;
    private JTextField interestTextField;
    private JTextField allergiesTextField;
    private JComboBox adoptionStatusOptions;
    private JButton mainMenuButton;
    private JButton exitButton;
    private JPanel menuPanel;
    private JButton submitButton;
    private JLabel enterChildInformationBelowLabel;
    private JComboBox gendercomboBox;
    private JTextField lastNameTextField;

    public AddChild() {
        frame.setSize(500,400);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        initializeGenderComboBox();
        initializeAdoptionStatusBox();

        /* method: mainMenuButton
         * parameter: ActionListener
         * return: none
         * purpose: to return user back to the main menu
         * */
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mainMenuButton) {
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
                if (e.getSource() == exitButton) {
                    System.exit(0);
                }
            }
        });

        /* method: submitButton
         * parameter: ActionListener
         * return: none
         * purpose: to allow a user to add a child to the system
         * */
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int childID = Integer.parseInt(childIDTextField.getText());
                    String firstName = firstNameTextField.getText();
                    String lastName = lastNameTextField.getText();
                    int age = Integer.parseInt(ageTextField.getText());
                    String gender = gendercomboBox.getSelectedItem().toString();
                    String birthday = birthdayTextField.getText();
                    String interest = interestTextField.getText();
                    String allergies = allergiesTextField.getText();
                    String adoptionStatus = adoptionStatusOptions.getSelectedItem().toString();

                    Child.ChildInfo childInfo = new Child.ChildInfo();
                    childInfo.setChildID(childID);
                    childInfo.setFirstName(firstName);
                    childInfo.setLastName(lastName);
                    childInfo.setAge(age);
                    childInfo.setGender(gender);
                    childInfo.setBirthday(birthday);
                    childInfo.setInterest(interest);
                    childInfo.setAllergies(allergies);
                    childInfo.setAdoptionStatus(adoptionStatus);

                    Child.childInfoList.add(childInfo);
                    JOptionPane.showMessageDialog(mainPanel, "Child Added Successfully!");
                    frame.dispose();
                    AddChild newFrame = new AddChild();
                    newFrame.frame.setVisible(true);
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid number.");
                }
            }
        });
    }

    /* method: initializeGenderComboBox
     * parameter: none
     * return: none
     * purpose: to set the gender options for the dropdown box
     * */

    private void initializeGenderComboBox() {
        DefaultComboBoxModel<String> genderModel = new DefaultComboBoxModel<>();
        genderModel.addElement("Male");
        genderModel.addElement("Female");
        gendercomboBox.setModel(genderModel);
    }

    /* method: initializeAdoptionStatusBox
     * parameter: none
     * return: none
     * purpose: to set the adoption status options for the dropdown box
     * */
    private void initializeAdoptionStatusBox() {
        DefaultComboBoxModel<String> adoptionStatusModel = new DefaultComboBoxModel<>();
        adoptionStatusModel.addElement("Available For Adoption");
        adoptionStatusModel.addElement("Adoption In Progress");
        adoptionStatusModel.addElement("Adoption Finalized");
        adoptionStatusModel.addElement("Adoption Status Unknown");
        adoptionStatusOptions.setModel(adoptionStatusModel);
    }
}
