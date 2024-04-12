import org.junit.Test;
import tests_grade.TestGrade;
import tests_student.TestStudent;
import tests_tema.TestTema;

public class BigBangIntegration {
    TestGrade testGrade = new TestGrade();
    TestStudent testStudent = new TestStudent();
    TestTema testTema = new TestTema();


    @Test
    public void testFailAddGrade() {
        testGrade.testFailAddGrade();
    }

    @Test
    public void testSaveTemaFailure() {
        testTema.testSaveTemaFailure();
    }

    @Test
    public void testSaveStudentFailure() {
        testStudent.testSaveStudentFailure();
    }

    @Test
    public void testAll() {
        testSaveStudentFailure();
        testSaveTemaFailure();
        testFailAddGrade();
    }
}
