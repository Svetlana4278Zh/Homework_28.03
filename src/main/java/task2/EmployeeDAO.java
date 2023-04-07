package task2;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmloyees();
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(Employee employee);
}
