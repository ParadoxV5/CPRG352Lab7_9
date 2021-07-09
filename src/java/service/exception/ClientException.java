package service.exception;
public class ClientException extends ServiceException {
  private static final long serialVersionUID = 0;
  public ClientException() { super(javax.servlet.http.HttpServletResponse.SC_CONFLICT); }
}