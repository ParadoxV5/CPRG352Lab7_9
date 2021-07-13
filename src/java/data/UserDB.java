package data;
import model.User;
import xyz.paradoxv5.servlet.jpa.EntityManagerWrapper;
import javax.persistence.EntityManager;

public class UserDB extends xyz.paradoxv5.servlet.jpa.AbstractEntityDB<User, String> {
  public UserDB() {
    super(User.class, new xyz.paradoxv5.servlet.jpa.EntityManagerSupplier("User"));
  }
  
  /** C **/
  @Override protected void add0(EntityManager entityManager, User user) {
    entityManager.persist(user);
  }
  
  /** R */
  @Override public java.util.Set<User> getAll() {
    try(EntityManagerWrapper entityManager = entityManagerSupplier.getWrapped()) {
      return entityManager.get().createQuery("SELECT u FROM UserdbUser u", User.class).getResultStream().collect(java.util.stream.Collectors.toSet());
    }
  }
  
  /** U */
  @Override protected void update0(EntityManager entityManager, User user) {
    entityManager.merge(user);
  }
  
  /** D */
  @Override protected void remove0(EntityManager entityManager, User entity) {
    entityManager.remove(entity);
  }
}