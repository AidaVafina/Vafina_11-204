package ru.itis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetRepositoryJdbc {


    public final static String SQL_SAVE_PREP = "INSERT INTO pets (name, height, weight, color, sex, owner_name) VALUES (?, ?, ?, ?, ?, ?)";
    public final static String SQL_GET_BY_ID = "SELECT * FROM pets WHERE id = ?";
    private final static String SQL_GET_ALL = "SELECT * FROM pets";
    private final static String SQL_GET_PETS_BY_NAME = "SELECT * FROM pets WHERE name = ?";
    private final static String SQL_GET_PETS_BY_OWNER = "SELECT * FROM pets WHERE owner_name = ?";
    private final static String SQL_DELETE_BY_NAME = "DELETE FROM pets WHERE name = ?";
    private final static String SQL_UPDATE = "UPDATE pets SET name = ?, height = ?, weight = ?, color = ?, sex = ? WHERE id = ?";

    private final String HOST;
    private final String USER;
    private final String PASS;

    public PetRepositoryJdbc(String HOST, String USER, String PASS) {
        this.HOST = HOST;
        this.USER = USER;
        this.PASS = PASS;
    }

    public void save(Pet entity) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE_PREP)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getHeight());
            preparedStatement.setDouble(3, entity.getWeight());
            preparedStatement.setString(4, entity.getColor());
            preparedStatement.setString(5, entity.getSex());
            preparedStatement.setString(6, entity.getOwnerName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setId(resultSet.getLong("id"));
                pet.setName(resultSet.getString("name"));
                pet.setHeight(resultSet.getDouble("height"));
                pet.setWeight(resultSet.getDouble("weight"));
                pet.setColor(resultSet.getString("color"));
                pet.setSex(resultSet.getString("sex"));
                pet.setOwnerName(resultSet.getString("owner_name"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public Optional<Pet> findById(Long id) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Pet pet = new Pet();
                    pet.setId(resultSet.getLong("id"));
                    pet.setName(resultSet.getString("name"));
                    pet.setHeight(resultSet.getDouble("height"));
                    pet.setWeight(resultSet.getDouble("weight"));
                    pet.setColor(resultSet.getString("color"));
                    pet.setSex(resultSet.getString("sex"));
                    pet.setOwnerName(resultSet.getString("owner_name"));
                    return Optional.of(pet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Boolean deleteByName(String petName) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_NAME)) {
            preparedStatement.setString(1, petName);
            int deletedRows = preparedStatement.executeUpdate();
            return deletedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Pet> getPetsByOwner(String ownerName) {
        List<Pet> petList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PETS_BY_OWNER)) {
            preparedStatement.setString(1, ownerName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Pet pet = new Pet();
                    pet.setId(resultSet.getLong("id"));
                    pet.setName(resultSet.getString("name"));
                    pet.setHeight(resultSet.getDouble("height"));
                    pet.setWeight(resultSet.getDouble("weight"));
                    pet.setColor(resultSet.getString("color"));
                    pet.setSex(resultSet.getString("sex"));
                    pet.setOwnerName(resultSet.getString("owner_name"));
                    petList.add(pet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return petList;
    }

    public Optional<Pet> findByName(String petName) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PETS_BY_NAME)) {
            preparedStatement.setString(1, petName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Pet pet = new Pet();
                    pet.setId(resultSet.getLong("id"));
                    pet.setName(resultSet.getString("name"));
                    pet.setHeight(resultSet.getDouble("height"));
                    pet.setWeight(resultSet.getDouble("weight"));
                    pet.setColor(resultSet.getString("color"));
                    pet.setSex(resultSet.getString("sex"));
                    pet.setOwnerName(resultSet.getString("owner_name"));
                    return Optional.of(pet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public boolean updatePetData(Long id, String updatedName, Double updatedHeight, Double updatedWeight, String updatedColor, String updatedSex) {
        try (Connection connection = DriverManager.getConnection(HOST, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {

            preparedStatement.setString(1, updatedName != null ? updatedName : findById(id).get().getName());
            preparedStatement.setDouble(2, updatedHeight != null ? updatedHeight : findById(id).get().getHeight());
            preparedStatement.setDouble(3, updatedWeight != null ? updatedWeight : findById(id).get().getWeight());
            preparedStatement.setString(4, updatedColor != null ? updatedColor : findById(id).get().getColor());
            preparedStatement.setString(5, updatedSex != null ? updatedSex : findById(id).get().getSex());
            preparedStatement.setLong(6, id);

            int updatedRows = preparedStatement.executeUpdate();
            return updatedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
