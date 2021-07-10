package data;
import model.User;
import java.sql.*;
import static java.util.Objects.requireNonNull;
@SuppressWarnings("javadoc") public class UserDB extends xyz.paradoxv5.servlet.DBConnectionPool {
  public UserDB() throws javax.naming.NamingException { super("AccessDB"); }
  
  /** helper */
  protected static void serializeData(PreparedStatement preparedStatement, int startIndex, User user) throws SQLException {
    preparedStatement.setBoolean(startIndex++, user.isActive     ());
    preparedStatement.setString (startIndex++, user.getFirst_name());
    preparedStatement.setString (startIndex++, user.getLast_name ());
    preparedStatement.setString (startIndex++, user.getPassword  ());
    preparedStatement.setString (startIndex, user.getRole().name());
  }
  
  /** C **/
  public boolean add(User user) throws SQLException {
    requireNonNull(user);
    try(
      Connection connection = get();
      PreparedStatement preparedStatement = connection.prepareStatement(
        "INSERT INTO userdb_user VALUES ?, ?, ?, ?, ?, ?"
      );
    ) {
      preparedStatement.setString(1, user.getEmail());
      serializeData(preparedStatement, 2, user);
      return preparedStatement.executeUpdate() == 1;
    }
  }
  
  /** R */
  public java.util.LinkedList<User> getAll() throws SQLException {
    java.util.LinkedList<User> getAll = new java.util.LinkedList<>();
    try(
      Connection connection = get();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM userdb_user");
    ) { while(resultSet.next()) getAll.add(new User(
      resultSet.getString(1),
      resultSet.getBoolean(2),
      resultSet.getString(3),
      resultSet.getString(4),
      resultSet.getString(5),
      model.Role.valueOf(resultSet.getString(6))
    )); }
    return getAll;
  }
  
  /** U */
  public boolean set(User user) throws SQLException {
    requireNonNull(user);
    try(
      Connection connection = get();
      //IDEA: Optimize by only update modified fields detected by Servlet
      PreparedStatement preparedStatement = connection.prepareStatement(
        "UPDATE userdb_user SET active=?, first_name=?, last_name=?, password=?, role=? WHERE email=?"
      );
    ) {
      serializeData(preparedStatement, 1, user);
      preparedStatement.setString(6, user.getEmail());
      return preparedStatement.executeUpdate() == 1;
    }
  }
  
  /** D */
  public boolean remove(String email) throws SQLException {
    requireNonNull(email);
    try(
      Connection connection = get();
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE userdb_user WHERE email=?"); //FROM
    ) {
      preparedStatement.setString(1, email);
      return preparedStatement.executeUpdate() == 1;
    }
  }
}