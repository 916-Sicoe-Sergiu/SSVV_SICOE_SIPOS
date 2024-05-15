import org.example.domain.Nota;
import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.repository.NotaXMLRepository;
import org.example.repository.StudentXMLRepo;
import org.example.repository.TemaXMLRepository;
import org.example.service.Service;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;
import org.example.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIncrementalIntegration {

    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepo studentXmlRepo = new StudentXMLRepo(studentValidator, "src/main/java/org/example/studenti.xml");
    TemaXMLRepository temaXmlRepo = new TemaXMLRepository(temaValidator, "src/main/java/org/example/teme.xml");
    NotaXMLRepository notaXmlRepo = new NotaXMLRepository(notaValidator, "src/main/java/org/example/note.xml");

    Service service = new Service(studentXmlRepo, temaXmlRepo, notaXmlRepo);

    @Test
    public void testAddStudent() {
        String id = "s1";
        String name = "Student One";
        int group = 200;

        int result = service.saveStudent(id, name, group);
        assertEquals("Expected to return 0 on successful save", 0, result);
    }

    @Test
    public void testAddAssignment() {
        String studentId = "s2";
        String studentName = "Student Two";
        int studentGroup = 201;
        service.saveStudent(studentId, studentName, studentGroup);

        String assignmentId = "a1";
        String description = "Assignment One";
        int deadline = 9;
        int startline = 7;

        int result = service.saveTema(assignmentId, description, deadline, startline);
        assertEquals("Expected to return 0 on successful save", 0, result);
    }

    @Test
    public void testAddGrade() {
        String studentId = "s3";
        String studentName = "Student Three";
        int studentGroup = 202;
        service.saveStudent(studentId, studentName, studentGroup);

        String assignmentId = "a2";
        String description = "Assignment Two";
        int deadline = 10;
        int startline = 8;
        service.saveTema(assignmentId, description, deadline, startline);

        double gradeValue = 9.5;
        int week = 10;
        String feedback = "Excellent";

        int result = service.saveNota(studentId, assignmentId, gradeValue, week, feedback);
        assertEquals("Expected to return 0 on successful save", 0, result);
    }
}

