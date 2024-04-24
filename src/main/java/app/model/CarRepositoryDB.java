package app.model;


import app.constants.Constants;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static app.constants.Constants.*;

public class CarRepositoryDB implements CarRepository {

    private Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);

            // jdbc:postgresql://120.230.12.10:5432/g_37_jp_cars?user=postgres&password=ppp77777
            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USERNAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car save(Car car) {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Car getById(Long id) {

        try (Connection connection = getConnection()) {

            String query = String.format("SELECT * FROM car WHERE id = %d", id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            String brand = resultSet.getString(2);
            BigDecimal price = resultSet.getBigDecimal(3);
            int year = resultSet.getInt(4);

            return new Car(id, brand, price, year);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getAll() {
        try (Connection connection = getConnection()) {

            // while (resultSet.next())
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Car car) {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = getConnection()) {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}