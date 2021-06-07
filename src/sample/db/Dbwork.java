package sample.db;

import sample.db.DbWorkInterface;
import sample.models.Category;
import sample.models.User;

import java.sql.*;
import java.util.ArrayList;

public class Dbwork implements DbWorkInterface {

    public boolean  checkUser(User user){
        Connection connection = getConnection();
        try{
            Statement statement = connection.createStatement();
            String query = "Select * from User u where u.login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getLogin());
          ResultSet resultSet= preparedStatement.executeQuery();

            System.out.println("вывод"+ resultSet);
            String login=null,password = null;
          while (resultSet.next()){
              login = resultSet.getString("Login");
              password = resultSet.getString("password");
          }
          return user.getLogin().equals(login)&& user.getPassword().equals(password)? true:false;
//          if(user.getLogin().equals(login)&& user.getPassword().equals(password)){
//             return true;
//          }else {
//              return false;
//          }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;

    }
    public boolean saveUser(User user){
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "insert into User(login,password) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getPassword());
            int resultOfSaving = preparedStatement.executeUpdate();
            return resultOfSaving == 1 ? true : false;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            if(connection!= null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return false;
    }
        public boolean saveCategory(Category category){
        Connection connection = getConnection();
        try {
            String query = "Insert into category(name,active) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2,category.isActive());
            int resultOfSaving = preparedStatement.executeUpdate();
            return resultOfSaving == 1 ? true : false;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
        }
        public ArrayList<Category>selectAllCategories(){
       ArrayList<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();
                String query= "Select name,active from category";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    int activator = resultSet.getInt("active");
                    Category category = new Category(name,activator);
                    categories.add(category);
                }
                return categories;

            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return null;
    }

    @Override
    public ArrayList<Category> selectAllActiveCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            String query= "Select name,active from category c  where c.active = 1";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int activator = resultSet.getInt("active");
                Category category = new Category(name,activator);
                categories.add(category);
            }
            return categories;

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    public Connection getConnection(){
        Connection connection=null;
        try{

            Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:C:\\edb\\dbjava.db");
            System.out.println("Connection");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;

    }
}
