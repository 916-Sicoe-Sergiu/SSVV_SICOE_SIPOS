package org.example;

import org.example.console.*;
import org.example.domain.*;
import org.example.repository.*;
import org.example.service.*;
import org.example.validation.*;

public class Main {
    public static void main(String[] args) {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepo fileRepository1 = new StudentXMLRepo(studentValidator, "src/main/java/org/example/studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "src/main/java/org/example/teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "src/main/java/org/example/note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI consola = new UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura
    }
}
