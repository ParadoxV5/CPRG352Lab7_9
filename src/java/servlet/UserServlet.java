package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class UserServlet extends xyz.paradoxv5.servlet.AbstractServlet {
  private static final long serialVersionUID = 0;
  
  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    forward("/WEB-INF/users.jsp", request, response);
    //TODO: readall
  }
  
  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //TODO: update delete create
  }
}