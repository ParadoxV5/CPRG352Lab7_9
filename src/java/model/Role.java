package model;
public enum Role {
  COMPANY_ADMIN("compay admin"),
  REGULAR_USER("regular user"),
  SYSTEM_ADMIN("system admin");
  
  private String toString;
  Role(String toString) { this.toString = java.util.Objects.requireNonNull(toString); }
  @Override public String toString() { return toString; }
}