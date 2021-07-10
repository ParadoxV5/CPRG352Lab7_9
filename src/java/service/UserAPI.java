package service;
import model.User;
import service.exception.ServerException;
public class UserAPI implements java.util.function.Supplier<java.util.LinkedList<User>> {
  protected final data.UserDB database;
  public UserAPI() throws ServerException { try {
    database = new data.UserDB();
  } catch(Throwable cause) { throw new ServerException(cause); } }
  
  /** R */
  @Override public java.util.LinkedList<User> get() throws ServerException {
    try { return database.getAll(); }
    catch(Throwable cause) { throw new ServerException(cause); }
  }
  
  //IDEA: Optimize by detecting modified fields and only query those to the API
  public void post(String action, String email, String active, String first_name, String last_name, String password, String role) throws service.exception.ServiceException {
    boolean isValid = false;
    try {
      if(action.equalsIgnoreCase("delete")) isValid = database.remove(email); // D
      else {
        User user = new User(email, active != null, first_name, last_name, password, model.Role.valueOf(role));
        if(action.equalsIgnoreCase("create")) isValid = database.add(user); // C
        else if(action.equalsIgnoreCase("update")) isValid = database.set(user); // U
      }
    } catch(Throwable cause) { throw new ServerException(cause); }
    if(!isValid) throw new service.exception.ClientException();
  }
}