package task2;

import java.util.List;

public class Application {
    public static void main(String[] args){
        Employee newEmployee = new Employee(1, "Ivan", "Kozlov", "male", 26,new City(4, "Novosibirsk"));
        int idTest = 3;
        Employee updateEmployee = new Employee(1, "Anastasiya", "Ivanchenko", "female", 26,new City(1,"Moscow"));
        int idTest2 = 2;

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        employeeDAO.addEmployee(newEmployee);

        System.out.println(employeeDAO.getEmployee(idTest));

        System.out.println();
        List<Employee> employeesTest = employeeDAO.getAllEmloyees();
        for (Employee employee : employeesTest){
            System.out.println(employee);
        }

        employeeDAO.updateEmployee(idTest,updateEmployee);

        employeeDAO.deleteEmployee(idTest2);

        System.out.println();
        List<Employee> employeesTest2 = employeeDAO.getAllEmloyees();
        for (Employee employee : employeesTest2){
            System.out.println(employee);
        }
    }
}
