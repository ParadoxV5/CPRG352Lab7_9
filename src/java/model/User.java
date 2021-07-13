package model;
import static java.util.Objects.requireNonNull;
import javax.persistence.*;

@Entity @Table(name="userdb_user") @javax.xml.bind.annotation.XmlRootElement public class User extends xyz.paradoxv5.servlet.jpa.AbstractEntity<String> {
  private static final long serialVersionUID = 0;
  
  // Fields and accessors //
  
  // Primary Key
  @Basic(optional=false) @Id @Column(name="email") private String email;
  public String get_email() { return email; }
  @Override protected String primaryKey() { return email; }
  
  @Basic(optional=false) @Column private boolean active = true;
  public boolean is_active() { return active; }
  public void set_active(boolean active) { this.active = active; }
  
  @Basic(optional=false) @Column private String first_name, last_name, password;
  public String get_first_name() { return first_name; }
  public void set_first_name(String first_name) { this.first_name = requireNonNull(first_name); }
  public String get_last_name() { return last_name; }
  public void set_last_name(String last_name) { this.last_name = requireNonNull(last_name); }
  public String get_password() { return password; }
  public void set_password(String password) { this.password = requireNonNull(password); }
  
  @Basic(optional=false) @Column @Enumerated(value=EnumType.STRING) private Role role;
  public Role get_role() { return role; }
  public void set_role(Role role) { this.role = requireNonNull(role); }
  
  // Constructor //
  public User() { this("", true, "", "", "", Role.REGULAR_USER); }
  
  public User(String email, boolean active, String first_name, String last_name, String password, Role role) {
    this.email = requireNonNull(email);
    set_active(active);
    set_first_name(first_name);
    set_last_name(last_name);
    set_password(password);
    set_role(role);
  }
}