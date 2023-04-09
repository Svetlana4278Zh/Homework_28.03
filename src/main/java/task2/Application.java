package task2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City newCity = new City("Krasnodar");
        cityDAO.addCity(newCity);
        int idNewCity = newCity.getCity_id();
        Employee newEmployee1 = new Employee("Irina", "Vinogradova", "female", 19, newCity);
        Employee newEmployee2 = new Employee("Anatolii", "Vinogradov", "male", 21,newCity);

        newCity.setEmployees(List.of(newEmployee1, newEmployee2));
        cityDAO.updateCity(newCity);

        printList(cityDAO.getAllCities());
        printList(employeeDAO.getAllEmloyees());

        newEmployee1.setLast_name("Nevinogradova");
        newCity.setEmployees(List.of(newEmployee1, newEmployee2));
        cityDAO.updateCity(newCity);

        System.out.println();
        printList(cityDAO.getAllCities());
        printList(employeeDAO.getAllEmloyees());

        cityDAO.deleteCity(newCity);

        System.out.println();
        printList(cityDAO.getAllCities());
        printList(employeeDAO.getAllEmloyees());

    }
    public static <T> void printList(List<T> list){
        for (T value : list){
            System.out.println(value);
        }
    }
}
