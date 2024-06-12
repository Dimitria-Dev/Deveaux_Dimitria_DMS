/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * June 12th, 2024
 * ChildInformation.java
 *  This class creates a ChildInformation object that sets a childID, name, age, gender, birthday,
 *  interest, allergies and adoptionStatus:
 */

public class ChildInformation {
    private int childID;
    private String name;
    private int age;
    private String gender;
    private String birthday;
    private String interest;
    private String allergies;
    private String adoptionStatus;

    public ChildInformation(int childID, String name, int age, String gender, String birthday, String interest, String allergies, String adoptionStatus){
        this.childID = childID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.interest = interest;
        this.allergies = allergies;
        this.adoptionStatus = adoptionStatus;
    }

    public ChildInformation(){
        this.childID = 0;
        this.name = "";
        this.age = 0;
        this.gender = "";
        this.birthday = "";
        this.interest = "";
        this.allergies = "";
        this.adoptionStatus = "";
    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    /* Method: ToString
     * parameter: none
     * return: String
     * purpose: to display a child's information
     * */
    @Override
    public String toString() {
        return "Child ID: " + childID + " | Name: " + name + " | Age " + age + " | Gender: " + gender
                + " | Birthdate: " + birthday + " | Interest: " + interest + " | Allergies: " + allergies + " | Adoption Status: " + adoptionStatus;
    }

}
