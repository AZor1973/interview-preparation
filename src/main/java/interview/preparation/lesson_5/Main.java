package interview.preparation.lesson_5;

import interview.preparation.lesson_5.dao.StudentDao;
import interview.preparation.lesson_5.entity.Student;
import interview.preparation.lesson_5.service.StudentService;
import interview.preparation.lesson_5.utils.SessionFactoryUtils;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtils.getSessionFactory();
        StudentService studentService = new StudentService(new StudentDao(sessionFactory));

        studentService.createRandomStudents();
        System.out.println("Number of students: " + studentService.findAll().size());

        Student newStudent = new Student("Newbie", 5);
        studentService.add(newStudent);
        System.out.println("Add new student");
        System.out.println("Number of students: " + studentService.findAll().size());
        System.out.println("New student: " + studentService.findByName(newStudent.getName()));

        System.out.println("Exclude new student");
        newStudent = studentService.findByName(newStudent.getName());
        studentService.delete(newStudent);
        System.out.println("Number of students: " + studentService.findAll().size());

        Student student = studentService.findById(1L);
        System.out.println("Student number 1: " + student);

        System.out.println("Update student number 1");
        student.setName("Peter");
        student.setMark(5);
        studentService.update(student);
        System.out.println("Updated student number 1: " + studentService.findById(1L));

        System.out.println("Exclude student number 1");
        studentService.delete(student);
        System.out.println("Number of students: " + studentService.findAll().size());
        System.out.println("Student number 1: " + studentService.findById(1L));
        SessionFactoryUtils.closeSessionFactory();
    }
}
