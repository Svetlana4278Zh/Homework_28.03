package task2;

import java.util.List;

public interface CityDAO {
    void addCity(City city);
    City getCity(int id);
    List<City> getAllCities();
    void updateCity(City city);
    void deleteCity(City city);
}
