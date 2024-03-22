package org.example.tests;


import org.example.domain.*;
import org.example.repository.*;
import org.example.service.*;
import org.example.validation.StudentValidator;
import org.example.validation.Validator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestStudent {
    Validator<Student> studentValidator = new StudentValidator();
    StudentXMLRepository studentXmlRepo = new StudentXMLRepository(studentValidator, "studenti.xml");


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
}
