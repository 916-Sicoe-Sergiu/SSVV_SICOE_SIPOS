package tests_grade;

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

import static junit.framework.TestCase.assertEquals;

public class TestGrade {
    Validator<Nota> notaValidator = new NotaValidator();
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    NotaXMLRepository notaXMLRepo = new NotaXMLRepository(notaValidator, "src/main/java/org/example/note.xml");
    TemaXMLRepository temaXmlRepo = new TemaXMLRepository(temaValidator, "src/main/java/org/example/teme.xml");
    StudentXMLRepo studentXmlRepo = new StudentXMLRepo(studentValidator, "src/main/java/org/example/studenti.xml");

    Service service = new Service(studentXmlRepo, temaXmlRepo, notaXMLRepo);
    @Test
    public void testFailAddGrade() {
        int result = service.saveNota("2", "3", 9.0, 2, "Very good");
        assertEquals("Expected to return 1 on unsuccessful save", 1, result);
    }


}
