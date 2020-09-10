package sample;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TestingClass {//Class for testing
    House testHouse;
    Person testPerson;

    @Before
    public void setup(){
        testHouse = new House("1234 Test Street", "Blue", "Testville");
        testPerson = new Person("Testy", "Testman", 25, "4321 Test Street");
    }

    @Test
    public void testChangeColour(){
        assertEquals("Blue", testHouse.colour);
        House.changeColour(testHouse, "Green");
        assertEquals("Green", testHouse.colour);
    }

    @Test
    public void testChangeAddress(){
        assertEquals("4321 Test Street", testPerson.houseAddress);
        Person.changeAddress(testPerson, "1234 Test Street");
        assertEquals("1234 Test Street", testPerson.houseAddress);
    }

    @Test
    public void testToString(){
        assertEquals("1234 Test Street", testHouse.address);
        assertEquals("Testville", testHouse.city);
        assertEquals("1234 Test Street, Testville", testHouse.toString());
    }
}
