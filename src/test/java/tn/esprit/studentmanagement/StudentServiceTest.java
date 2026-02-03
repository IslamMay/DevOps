package tn.esprit.studentmanagement;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;
import tn.esprit.studentmanagement.services.StudentService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetAllStudents() {
        Student s1 = new Student();
        s1.setIdStudent(1L);
        s1.setFirstName("Islem");
        s1.setLastName("ELMAY");
        s1.setEmail("islem@mail.com");

        Student s2 = new Student();
        s2.setIdStudent(2L);
        s2.setFirstName("Ahmed");
        s2.setLastName("Ben Ali");
        s2.setEmail("ahmed@mail.com");

        when(studentRepository.findAll()).thenReturn(List.of(s1, s2));

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
    }
    @Test
    void testSaveStudent() {
        // GIVEN
        Student student = new Student();
        student.setIdStudent(3L);
        student.setFirstName("Sami");
        student.setLastName("Trabelsi");
        student.setEmail("sami@mail.com");
        student.setPhone("55555555");
        student.setDateOfBirth(LocalDate.of(2001, 1, 15));
        student.setAddress("Sousse");   

        when(studentRepository.save(student)).thenReturn(student);

        // WHEN
        Student saved = studentService.saveStudent(student);

        // THEN
        assertEquals("Sami", saved.getFirstName());
        assertEquals("Trabelsi", saved.getLastName());
    }

}
