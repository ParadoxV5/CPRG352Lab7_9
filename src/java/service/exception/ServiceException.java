package service.exception;

public class ServiceException extends RuntimeException {
  private static final long serialVersionUID = 0;
  
  public final int httpStatusCode;
  public ServiceException(int htmlStatusCode) {
    super();
    this.httpStatusCode = htmlStatusCode;
  }
  public ServiceException(int htmlStatusCode, Throwable cause) {
    super(cause);
    this.httpStatusCode = htmlStatusCode;
  }
  
  public void respond(javax.servlet.http.HttpServletResponse httpServletResponse) throws java.io.IOException {
    httpServletResponse.sendError(httpStatusCode, getCause().toString());
  }
}