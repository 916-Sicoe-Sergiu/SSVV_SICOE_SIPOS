import org.junit.Test;
import tests_grade.TestGrade;
import tests_student.TestStudent;
import tests_tema.TestTema;

public class BigBangIntegration {
    TestGrade testGrade = new TestGrade();
    TestStudent testStudent = new TestStudent();
    TestTema testTema = new TestTema();
    @Test
    public void testAll() {
        testStudent.testSaveStudentFailure();
        testTema.testSaveTemaFailure();
        testGrade.testFailAddGrade();
    }
}
