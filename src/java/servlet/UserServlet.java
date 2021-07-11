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
  @Override public void init() {
    try {
      api = new service.UserAPI();
    } catch(ServiceException e) {
      newAPIException = e;
      api = null;
      return;
    }
    newAPIException = null;
    getServletContext().setAttribute("roles", model.Role.values());
  }
  
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(newAPIException != null) {
      newAPIException.respond(response);
      return;
    }
    try { request.setAttribute("users", api.get()); }
    catch(ServiceException e) {
      e.respond(response);
      return;
    }
    forward("/WEB-INF/users.jsp", request, response);
  }
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(newAPIException != null) {
      newAPIException.respond(response);
      return;
    }
    try {
      api.post(
        request.getParameter("action"),
        request.getParameter("email"),
        request.getParameter("active"),
        request.getParameter("first_name"),
        request.getParameter("last_name"),
        request.getParameter("password"),
        request.getParameter("role")
      );
      request.setAttribute("users", api.get());
    } catch(ServiceException e) {
      e.respond(response);
      return;
    }
    forward("/WEB-INF/users.jsp", request, response);
  }
}