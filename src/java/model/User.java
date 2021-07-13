package model;
import static java.util.Objects.requireNonNull;
import javax.persistence.*;

@Entity @Table(name="userdb_user") @javax.xml.bind.annotation.XmlRootElement public class User implements java.io.Serializable {
  private static final long serialVersionUID = 0;
  
  // Fields and accessors //
  
  // Primary Key
  @Basic(optional=false) @Column @Id private final String email;
  public String getEmail() { return email; }
  
  @Basic(optional=false) @Column private boolean active = true;
  public boolean isActive() { return active; }
  public void setActive(boolean active) { this.active = active; }
  
  @Basic(optional=false) @Column private String first_name, last_name, password;
  public String getFirst_name() { return first_name; }
  public void setFirst_name(String first_name) { this.first_name = requireNonNull(first_name); }
  public String getLast_name() { return last_name; }
  public void setLast_name(String last_name) { this.last_name = requireNonNull(last_name); }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = requireNonNull(password); }
  
  @Basic(optional=false) @Column @Enumerated(value=EnumType.STRING) private Role role;
  public Role getRole() { return role; }
  public void setRole(Role role) { this.role = requireNonNull(role); }
  
  // Constructor //
  public User(String email, boolean active, String first_name, String last_name, String password, Role role) {
    this.email = email;
    setActive(active);
    setFirst_name(first_name);
    setLast_name(last_name);
    setPassword(password);
    setRole(role);
  }
}