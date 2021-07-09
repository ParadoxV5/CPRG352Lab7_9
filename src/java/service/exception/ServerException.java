package service.exception;
public class ServerException extends ServiceException {
  private static final long serialVersionUID = 0;
  public ServerException(Throwable cause) { super(javax.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE, cause); }
}