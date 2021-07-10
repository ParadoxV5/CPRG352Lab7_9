package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import service.exception.ServiceException;

public class UserServlet extends xyz.paradoxv5.servlet.AbstractServlet {
  private static final long serialVersionUID = 0;
  
  protected service.UserAPI api;
  protected ServiceException newAPIException;
  public UserServlet() {
    super();
    initialize();
  }
  protected void initialize() {
    try {
      api = new service.UserAPI();
      newAPIException = null;
    } catch(ServiceException e) {
      newAPIException = e;
      api = null;
    }
  }
  
  protected void doGet0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("users", api.get());
    forward("/WEB-INF/users.jsp", request, response);
  }
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(newAPIException != null) newAPIException.respond(response);
    else try { doGet0(request, response); }
    catch(ServiceException e) { e.respond(response); }
  }
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(newAPIException != null) newAPIException.respond(response);
    else try {
      api.post(
        request.getParameter("method"),
        request.getParameter("email"),
        request.getParameter("active"),
        request.getParameter("first_name"),
        request.getParameter("last_name"),
        request.getParameter("password"),
        request.getParameter("role")
      );
      doGet0(request, response);
    } catch(ServiceException e) { e.respond(response); }
  }
}