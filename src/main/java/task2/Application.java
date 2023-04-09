package task2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args){
        Employee newEmployee = new Employee(1, "Alena", "Baranova", "female", 20,4);
        int idTest = 8;
        Employee updateEmployee = new Employee(1, "Anna", "Ivanchenko", "female", 27,2);
        int idTest2 = 10;

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        employeeDAO.addEmployee(newEmployee);

        System.out.println(employeeDAO.getEmployee(idTest));

        System.out.println();
        List<Employee> employeesTest = employeeDAO.getAllEmloyees();
        for (Employee employee : employeesTest){
            System.out.println(employee);
        }

        employeeDAO.updateEmployee(idTest,updateEmployee);

        employeeDAO.deleteEmployee(employeeDAO.getEmployee(idTest2));

        System.out.println();
        List<Employee> employeesTest2 = employeeDAO.getAllEmloyees();
        for (Employee employee : employeesTest2){
            System.out.println(employee);
        }
    }
}
