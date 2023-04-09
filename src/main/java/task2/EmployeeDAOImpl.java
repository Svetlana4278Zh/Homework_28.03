package task2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public void addEmployee(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public Employee getEmployee(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmloyees() {
        List<Employee> employees = (List<Employee>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From Employee ").list();
        return employees;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        employee.setId(id);
        session.update(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();

    }
}
