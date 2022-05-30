package interview.preparation.lesson_5.service;

import interview.preparation.lesson_5.dao.StudentDao;
import interview.preparation.lesson_5.entity.Student;
import interview.preparation.lesson_5.utils.StudentUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;

    private static final Integer numberOfStudents = 1000;

    @Transactional
    public void createRandomStudents() {
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = StudentUtils.getNewStudent();
            studentDao.add(student);
        }
    }

    public void add(Student student) {
        studentDao.add(student);
    }

    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    public void delete(Student student) {
        studentDao.delete(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    public Student findByName(String name) {
        return studentDao.findByName(name);
    }
}
