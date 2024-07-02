/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * July 1st, 2024
 * Child.java
 *  The purpose of this class is to create an object of the children's information in the database which includes: First name,
 *  last name, child ID, age, gender, birthday, interest, allergies and adoption status
 */
import java.util.ArrayList;
import java.util.List;

public class Child {
    public static List<ChildInfo> childInfoList = new ArrayList<>();

    public static class ChildInfo {
        private int childID;
        private String firstName;
        private String lastName;
        private int age;
        private String gender;
        private String birthday;
        private String interest;
        private String allergies;
        private String adoptionStatus;

        public int getChildID() {
            return childID;
        }

        public void setChildID(int childID) {
            this.childID = childID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
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

        @Override
        public String toString() {
            return "ChildInfo{" +
                    "childID=" + childID +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", interest='" + interest + '\'' +
                    ", allergies='" + allergies + '\'' +
                    ", adoptionStatus='" + adoptionStatus + '\'' +
                    '}';
        }
    }

}
