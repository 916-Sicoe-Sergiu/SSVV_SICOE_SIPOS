package tests_student;

import org.example.domain.*;
import org.example.repository.*;
import org.example.service.*;
import org.example.validation.StudentValidator;
import org.example.validation.ValidationException;
import org.example.validation.Validator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestStudent {
    Validator<Student> studentValidator = new StudentValidator();
    StudentXMLRepository studentXmlRepo = new StudentXMLRepository(studentValidator, "src/main/java/org/example/studenti.xml");
    Service service = new Service(studentXmlRepo);

    @Test
    public void testSaveStudentSuccess() {
        Service service = new Service(studentXmlRepo);
        String id = "s1";
        String name = "Student One";
        int group = 200;

        int result = service.saveStudent(id, name, group);

        assertEquals("Expected to return 0 on successful save", 0, result);
    }

    @Test
    public void testSaveStudentFailure() {
        Service service = new Service(studentXmlRepo);
        String id = "s2";
        String name = "Student 2";
        int group = 10;


        int result = service.saveStudent(id, name, group);

        assertEquals("Expected to return 1 on failure to save", 1, result);
    }


    // Valid ECs
    @Test
    public void whenValidIdNameGroup_thenReturnSuccess() {
        assertEquals(0, service.saveStudent("S123", "John Doe", 500));
    }

    // IEC1: Empty ID
    @Test
    public void whenEmptyId_thenThrowValidationException() {
        assertEquals(service.saveStudent("", "John Doe", 500), 1);
    }

    // IEC2: Null ID
    @Test
    public void whenNullId_thenThrowValidationException() {
        assertEquals(service.saveStudent(null, "John Doe", 500), 1);
    }

    // IEC3: Empty Name
    @Test
    public void whenEmptyName_thenThrowValidationException() {
        assertEquals(service.saveStudent("S123", "", 500), 1);
    }

    // IEC4: Null Name
    @Test
    public void whenNullName_thenThrowValidationException() {
        assertEquals(service.saveStudent("S123", null, 500), 1);
    }

    // IEC5: Group Less Than 111
    @Test
    public void whenGroupTooLow_thenThrowValidationException() {
        assertEquals(service.saveStudent("S123", "John Doe", 110), 1);
    }

    // IEC6: Group More Than 937
    @Test
    public void whenGroupTooHigh_thenThrowValidationException() {
        assertEquals(service.saveStudent("S123", "John Doe", 938), 1);
    }

    // BVA: Group is 111
    @Test
    public void whenGroupIs111_thenReturnSuccess() {
        assertEquals(0, service.saveStudent("S123", "John Doe", 111));
    }

    // BVA: Group is 937
    @Test
    public void whenGroupIs937_thenReturnSuccess() {
        assertEquals(0, service.saveStudent("S123", "John Doe", 937));
    }

    // BVA: Group is 110
    @Test
    public void whenGroupIs110_thenThrowValidationException() {
        assertEquals(service.saveStudent("S123", "John Doe", 110), 1);
    }

    // BVA: Group is 938
    @Test
    public void whenGroupIs938_thenThrowValidationException() {
        assertEquals(service.saveStudent("S123", "John Doe", 938), 1);
    }
}
