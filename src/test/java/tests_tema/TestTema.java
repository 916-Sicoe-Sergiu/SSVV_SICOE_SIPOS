package tests_tema;

import static org.junit.Assert.assertEquals;
import org.example.domain.Tema;
import org.example.repository.TemaXMLRepository;
import org.example.service.Service;
import org.example.validation.TemaValidator;
import org.example.validation.Validator;
import org.junit.Test;

public class TestTema {
    Validator<Tema> temaValidator = new TemaValidator();
    TemaXMLRepository temaXmlRepo = new TemaXMLRepository(temaValidator, "src/main/java/org/example/teme.xml");
    Service service = new Service(temaXmlRepo);
    @Test
    public void testSaveTemaSuccess() {
        assertEquals(0, service.saveTema("3", "gui", 9, 7));
    }

    @Test
    public void testSaveTemaFailure() {
        assertEquals(1, service.saveTema("S1234", "John Doe", 500, 500));
    }

    @Test
    public void testSaveTemaSucces_2() {
        assertEquals(1, service.saveTema("", "", 0, 0));
    }
}

