package service;
import model.User;
import service.exception.*;
public class UserAPI implements java.util.function.Supplier<java.util.Set<User>> {
  protected final data.UserDB database;
  public UserAPI() throws ServerException { try {
    database = new data.UserDB();
  } catch(Throwable cause) { throw new ServerException(cause); } }
  
  /** R */
  @Override public java.util.Set<User> get() throws ServerException {
    try { return database.getAll(); }
    catch(Throwable cause) { throw new ServerException(cause); }
  }
  
  //IDEA: Optimize by detecting modified fields and only query those to the API
  public void post(String action, String email, String active, String first_name, String last_name, String password, String role) throws ServiceException {
    User user = new User(email, active != null, first_name, last_name, password, model.Role.valueOf(role));
    try { switch(action.toLowerCase()) {
      case "create": database.add(user); break; // C
      case "update": database.update(user); break; // U
      case "delete": database.remove(user); break; //D
      default: throw new ClientException();
    } } catch(javax.persistence.EntityExistsException cause) { throw new ClientException(cause); }
        catch(ClientException e) { throw e; } // Ignore and re-throw
        catch(Throwable cause) { throw new ServerException(cause); } // All other exceptions are considered Serverr problems by default
  }
}