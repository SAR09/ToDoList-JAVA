package repository;

import entity.ToDoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoListRepositoryImpl implements ToDoListRepository{

    private DataSource dataSource;

    public ToDoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ToDoList[] getAll() {
        String sql = "SELECT id, todo FROM todolist";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            List<ToDoList> list = new ArrayList<>();
            while(resultSet.next()){
                ToDoList toDoList = new ToDoList();
                toDoList.setId(resultSet.getInt("id"));
                toDoList.setTodo(resultSet.getString("todo"));

                list.add(toDoList);
            }

            return list.toArray(new ToDoList[]{});

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }


    }





    @Override
    public void add(ToDoList toDoList) {
      String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toDoList.getTodo());
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }

    }

    private boolean isExist(Integer number){
        String sql = "SELECT id FROM todolist WHERE id = ? ";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, number);

            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){
                    return true;
                }else {
                    return false;
                }
            }catch (SQLException exception){
                throw new RuntimeException(exception);
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {

        if (isExist(number)){
            String sql = "DELETE FROM todolist WHERE id = ? ";

            try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, number);
                statement.executeUpdate();

                return true;
            }catch (SQLException exception){
                throw new RuntimeException(exception);
            }

        }else {
            return false;
        }


    }
}
