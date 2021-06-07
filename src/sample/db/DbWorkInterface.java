package sample.db;

import sample.models.Category;
import sample.models.User;

import java.sql.Connection;
import java.util.ArrayList;

public interface DbWorkInterface {
    boolean checkUser(User user);
    boolean saveUser(User user);
    boolean saveCategory(Category category);
    ArrayList<Category> selectAllCategories();
    ArrayList<Category> selectAllActiveCategories();
    Connection getConnection();

}