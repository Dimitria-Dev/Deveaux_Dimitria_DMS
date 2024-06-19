import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/* Dimitria Deveaux
 * CEN 3024 - Software Development I
 * June 19th, 2024
 * ChildText.java
 *  The objective of this file is to test each method to  verify the features of the adoption agency DMS
 */

class ChildTest {
    Child child;

    @BeforeEach
    void setUp() {
        child = new Child();

    }

    @Test
    @DisplayName("adding a non existent file to the database")
    void nonExistentFile(){
        String emptyFile = "src/childInfo.txt";
        child.fileName(emptyFile);
        List<ChildInformation> children = child.getChildren();
        assertEquals(0, children.size(), "File not found exception should be thrown");
    }

    @Test
    @DisplayName("Adding a file to the database")
    void fileName() {
        String file = "src/childInformation.txt";
        child.fileName(file);
        List<ChildInformation> children = child.getChildren();
        assertEquals(20, children.size(), "20 children should be added to the database");
    }

    @Test
    @DisplayName("Remove child by their ID number")
    void removeByID() {
        ChildInformation childInformation = new ChildInformation(2, "Zander Blackburn", 8,"M","02-02-2016", "Baseball", "Eggs", "Adoption in Progress");
        ChildInformation childInformation2 = new ChildInformation(3, "Armani Norman", 4,"F","05-12-2020", "Ballet", "Wheat", "Available for adoption");
        child.addChild(childInformation);
        child.addChild(childInformation2);

        int idToRemove = 2;
        child.removeByID(idToRemove);

        assertEquals(1, child.getChildren().size(), "A child should have been removed");
    }

    @Test
    @DisplayName("Removing a child by their name")
    void removeByName() {
        ChildInformation childInformation = new ChildInformation(2, "Zander Blackburn", 8,"M","02-02-2016", "Baseball", "Eggs", "Adoption in Progress");
        ChildInformation childInformation2 = new ChildInformation(3, "Armani Norman", 4,"F","05-12-2020", "Ballet", "Wheat", "Available for adoption");
        child.addChild(childInformation);
        child.addChild(childInformation2);

        String childNameToRemove = "Zander Blackburn";
        child.removeByName(childNameToRemove);
        assertEquals(1, child.getChildren().size(), "There should be one child");
    }


    @Test
    @DisplayName("Add an Interest")
    void addInterest() {
        ChildInformation childInformation = new ChildInformation(6, "Max Brown", 14, "M", "05-12-2010", "Basketball", "None", "Adoption in Progress");
        ChildInformation childInformation2 = new ChildInformation(8, "Liza Brown", 12, "M", "03-22-2012", "Ballet", "Eggs", "Adoption in Progress");
        child.addChild(childInformation);
        child.addChild(childInformation2);

        String interest = "Football";
        int childID = 6;

        child.addInterest(childID, interest);
        assertEquals("Football", child.getChildren().get(0).getInterest(), "Interest should be updated to football in the database");
    }

    @Test
    @DisplayName("Adding an allergy to a child's information")
    void addAllergy() {
        ChildInformation childInformation = new ChildInformation(6, "Max Brown", 14, "M", "05-12-2010", "Basketball", "None", "Adoption in Progress");
        ChildInformation childInformation2 = new ChildInformation(8, "Liza Brown", 12, "M", "03-22-2012", "Ballet", "Eggs", "Adoption in Progress");
        child.addChild(childInformation);
        child.addChild(childInformation2);

        String allergy = "Fish";
        int childID = 6;
        child.addAllergy(childID,allergy);
        assertEquals("Fish", child.getChildren().get(0).getAllergies(), "The allergy should be updated to Peanuts in the database");
    }


    @Test
    @DisplayName("Updating an adoption status")
    void adoptionStatus() {
        ChildInformation childInformation = new ChildInformation(6, "Max Brown", 14, "M", "05-12-2010", "Basketball", "None", "Adoption in Progress");
        ChildInformation childInformation2 = new ChildInformation(8, "Liza Brown", 12, "M", "03-22-2012", "Ballet", "Eggs", "Adoption in Progress");
        child.addChild(childInformation);
        child.addChild(childInformation2);

        int childID = 8;
        String statusChange = "Adoption Finalized";

        child.adoptionStatus(childID, statusChange);
        assertEquals("Adoption Finalized", child.getChildren().get(1).getAdoptionStatus(), "The adoption status should be updated to Adoption Finalized.");
    }
}