import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintChildren extends Child{
    JFrame frame = new JFrame("PrintChildren");
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JButton mainMenuButton;
    private JTable showTable;

    public PrintChildren() {
        frame.setSize(800,400);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        createTable();
        
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == mainMenuButton) {
                    frame.dispose();
                    Menu menu = new Menu();
                }
            }
        });
    }

    private void createTable() {
        showTable.setModel(new DefaultTableModel(
                null,
                new Object[]{"Child ID", "First Name", "Last Name", "Age", "Gender", "Birthday", "Interest", "Allergies", "Adoption Status"}
        ));
        for(ChildInfo childInfo : childInfoList) {
            ((DefaultTableModel) showTable.getModel()).addRow(new Object[]{
                    childInfo.getChildID(),
                    childInfo.getFirstName(),
                    childInfo.getLastName(),
                    childInfo.getAge(),
                    childInfo.getGender(),
                    childInfo.getBirthday(),
                    childInfo.getInterest(),
                    childInfo.getAllergies(),
                    childInfo.getAdoptionStatus()
            });
        }

        TableColumnModel columnModel = showTable.getColumnModel();
        columnModel.getColumn(8).setPreferredWidth(100);

    }
}

