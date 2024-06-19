import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * June 19th, 2024
 * Child.java
 *  This class creates a Child object that performs the following: adding children's information to the DMS from a text file,
 *  removing a child from the DMS by using their childID or full name, update a child's interest or allergy, checking a child's
 *  adoption status or updating their adoption status and printing all the children the DMS.
 */

public class Child extends ChildInformation{
    private List<ChildInformation> children;

    public Child() {
        this.children = new ArrayList<>();
    }

    public List<ChildInformation> getChildren() {
        return children;
    }

    public void setChildren(List<ChildInformation> children) {
        this.children = children;
    }

    public void addChild(ChildInformation child) {
        children.add(child);
        setChildren(children);
    }

    /* method: filename
     * parameter: String filename
     * return: none
     * purpose: to read the user text file and add children to the DMS
     * */
    public void fileName(String filename){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                addChild(new ChildInformation(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], fields[4], fields[5],fields[6],fields[7]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("There was an error reading the file " + filename);
        }
    }


    /* method: removeByID
     * parameter: int id
     * return: none
     * purpose: to remove a child from the DMS by their ID number
     * */
    public void removeByID(int id) throws InputMismatchException{
        try{
            for(int i = 0; i < children.size(); i++){
                if(children.get(i).getChildID() == id){
                    children.remove(i);
                }
            }
        } catch(InputMismatchException e){
            System.out.println("Input mismatch. Please enter a number.");
        }
    }


    /* method: removeByName
     * parameter: String name
     * return: none
     * purpose: to remove a child from DMS by their full name
     * */
    public void removeByName(String name){
        children.removeIf(child -> child.getName().equals(name));
    }


    /* method: addInterest
     * parameter: int childID, String interestUpdate
     * return: none
     * purpose: to update a child's interest using their ID number
     * */
    public void addInterest(int childID, String interestUpdate){
        for(ChildInformation child : children){
            if(child.getChildID() == childID){
                child.setInterest(interestUpdate);
            }
        }
    }

    /* method: addAllergy
     * parameter: int childId, String allergyUpdate
     * return: none
     * purpose: to update a child's allergy using their ID number
     * */
    public void addAllergy(int childId, String allergyUpdate){
        for (ChildInformation child : children) {
            if(child.getChildID() == childId){
                child.setAllergies(allergyUpdate);

            }
        }
    }

    /* method: status
     * parameter: int childID
     * return: none
     * purpose: to check the adoption status of a child using their ID number
     * */
    public void status(int childID){
        for(ChildInformation child : children){
            if(child.getChildID() == childID){
                child.getAdoptionStatus();
                System.out.println(child);
            }
        }
    }

    /* method: adoptionStatus
     * parameter: int childID, String adoptionStatusUpdate
     * return: none
     * purpose: to update the adoption status of a child
     * */
    public void adoptionStatus(int childID, String adoptionStatusUpdate){
        for(ChildInformation child : children){
            if(child.getChildID() == childID){
                child.setAdoptionStatus(adoptionStatusUpdate);
            }
        }
    }

    /* method: printChildren
     * parameter: none
     * return: none
     * purpose: to print all children in the DMS
     * */
    public void printChildren(){
        for (ChildInformation child : children) {
            System.out.println(child);
        }
    }

}
