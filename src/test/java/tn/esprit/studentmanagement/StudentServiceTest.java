package tn.esprit.studentmanagement;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.repositories.StudentRepository;
import tn.esprit.studentmanagement.services.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test 1 : getAllStudents
    @Test
    void testGetAllStudents() {
        Student student1 = new Student();
        student1.setIdStudent(1L);
        student1.setFirstName("Alice");

        Student student2 = new Student();
        student2.setIdStudent(2L);
        student2.setFirstName("Bob");

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        List<Student> students = studentService.getAllStudents();
        assertEquals(2, students.size());
        assertEquals("Alice", students.get(0).getFirstName());

        verify(studentRepository, times(1)).findAll();
    }

    // Test 2 : saveStudent
    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setIdStudent(1L);
        student.setFirstName("Charlie");

        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.saveStudent(student);
        assertNotNull(savedStudent);
        assertEquals("Charlie", savedStudent.getFirstName());

        verify(studentRepository, times(1)).save(student);
    }
}
