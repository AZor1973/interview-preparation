package interview.preparation.lesson_5.dao;

import interview.preparation.lesson_5.entity.Student;
import interview.preparation.lesson_5.utils.StudentUtils;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class StudentDao {
    private final SessionFactory sessionFactory;

    public void add(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.remove(student);
        session.getTransaction().commit();
    }

    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student removeStudent = session.get(Student.class, student.getId());
        session.remove(removeStudent);
        session.getTransaction().commit();
    }

    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student updatedStudent = session.get(Student.class, student.getId());
        updatedStudent.setName(student.getName());
        updatedStudent.setMark(student.getMark());
        session.getTransaction().commit();
    }

    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = Collections.unmodifiableList(sessionFactory.getCurrentSession().createQuery("from Student s").list());
        session.getTransaction().commit();
        return students;
    }

//    Это не ошибка, но для чтения транзакцию требуется открывать не всегда.
    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    public Student findByName(String studentName) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Student> query = session.createQuery("SELECT s FROM Student s WHERE s.name =:studentName", Student.class);
        query.setParameter("studentName", studentName);
        query.setMaxResults(1);
        Student student = query.getSingleResult();
        session.getTransaction().commit();
        return student;
    }
}
