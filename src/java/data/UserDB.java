package data;
import model.User;
import xyz.paradoxv5.servlet.jpa.EntityManagerFactoryWrapper;
import javax.persistence.EntityManager;

public class UserDB extends xyz.paradoxv5.servlet.jpa.AbstractEntityDB<User, String> {
  protected final static EntityManagerFactoryWrapper entityManagerFactoryWrapper = new EntityManagerFactoryWrapper("User");
  public UserDB() {
    super(User.class, entityManagerFactoryWrapper);
  }
  
  /** C **/
  @Override protected void add0(EntityManager entityManager, User user) {
    entityManager.persist(user);
  }
  
  /** R */
  @Override public String getAllQlString() { return "SELECT u FROM UserdbUser u"; }
  
  /** U */
  @Override protected void update0(EntityManager entityManager, User user) {
    entityManager.merge(user);
  }
  
  /** D */
  @Override protected void remove0(EntityManager entityManager, User entity) {
    entityManager.remove(entity);
  }
}