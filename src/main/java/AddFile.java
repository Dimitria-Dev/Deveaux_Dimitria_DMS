/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * July 1st, 2024
 * AddFile.java
 *  This class allows a user to add a text file with the children's information to the database
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddFile {
    JFrame frame = new JFrame("Add File");
    private JPanel mainPanel;
    private JButton selectFileButton;
    private JButton mainMenuButton;
    private JButton exitButton;

    public AddFile() {
        frame.setSize(500,300);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /* method: selectFileButton
         * parameter: ActionListener
         * return: none
         * purpose: to allow a user to select a text file and upload it to the DMS
         * */
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectFileButton) {
                    JFileChooser fileChooser = new JFileChooser();
                    int response = fileChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        BufferedReader br = null;
                        try {
                            br = new BufferedReader(new FileReader(file));
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] fields = line.split(",");
                                if (fields.length == 9) {

                                    Child.ChildInfo childInfo = new Child.ChildInfo();

                                    childInfo.setChildID(Integer.parseInt(fields[0]));
                                    childInfo.setFirstName(fields[1]);
                                    childInfo.setLastName(fields[2]);
                                    childInfo.setAge(Integer.parseInt(fields[3]));
                                    childInfo.setGender(fields[4]);
                                    childInfo.setBirthday(fields[5]);
                                    childInfo.setInterest(fields[6]);
                                    childInfo.setAllergies(fields[7]);
                                    childInfo.setAdoptionStatus(fields[8]);

                                    Child.childInfoList.add(childInfo);
                                } else {
                                    JOptionPane.showMessageDialog(frame, "There was an error reading the file");
                                }
                            }

                            JOptionPane.showMessageDialog(frame, "Data from file imported successfully.");

                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(frame, "File not found.");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "There was an error reading the file.");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid data format in file.");
                        } finally {
                            try {
                                if (br != null) {
                                    br.close();
                                }
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error.");
                            }
                        }
                    }
                }
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
                if (e.getSource() == mainMenuButton) {
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
                if (e.getSource() == exitButton) {
                    System.exit(0);
                }
            }
        });
    }

}
