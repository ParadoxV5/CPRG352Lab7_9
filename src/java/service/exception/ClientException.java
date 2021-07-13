package service.exception;

public class ClientException extends ServiceException {
  private static final long serialVersionUID = 0;
  
  protected static final int HTML_STATUS_CODE = javax.servlet.http.HttpServletResponse.SC_CONFLICT;
  public ClientException() { super(HTML_STATUS_CODE); }
  public ClientException(Throwable cause) { super(HTML_STATUS_CODE, cause);  }
}