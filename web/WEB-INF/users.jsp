<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

<head>
  <meta charset="UTF-8">
  <title>User Management</title>
  
  <link rel="stylesheet" href="users.css">
  <script src="user.js"></script>
</head>
<body>
  
  <table>
    <caption><h1>Users</h1></caption>
    <thead><tr>
      <th>✍</th>
      <th>🆔 email</th>
      <th>active</th>
      <th>first_name</th>
      <th>last_name</th>
      <th>password</th>
      <th>role</th>
    </tr></thead>
    <c:forEach var="_user_" items="${users}"><tr>
      <td><input type="radio" name="user index" onclick="existingRadio(this)"></td>
      <td>${_user_.email}</td>
      <td>${_user_.active ? "✅" : "❎"}</td>
      <td>${_user_.first_name}</td>
      <td>${_user_.last_name}</td>
      <td title="${_user_.password}">🔐</td>
      <td>${_user_.role}</td>
    </tr></c:forEach>
    <tfoot><tr>
      <th><input type="radio" name="user index" checked onchange="newRadio()"></th>
      <th>{new}</th>
      <th colspan="5"></th>
    </tr></tfoot>
  </table>
  
  <form method="POST">
    <h1>Edit</h1>
    <label for="email">🆔 email</label>
    <input type="email" id="email" name="email" autocomplete="email" required>
    <label for="active">active</label>
    <input type="checkbox" id="active" name="active" checked>
    <label for="first_name">first_name</label>
    <input type="text" id="first_name" name="first_name" autocomplete="given-name" required>
    <label for="last_name">last_name</label>
    <input type="text" id="last_name" name="last_name" autocomplete="family-name" required>
    <label for="password">password</label>
    <input type="password" id="password" name="password" required>
    <label for="role">role</label>
    <select id="role" name="role" required><c:forEach var="_role_" items="${roles}">
      <option value="${_role_}">${_role_}</option>
    </c:forEach></select>
    
    <div>
      <input type="submit" id="new" name="action" value="Create">
      <span id="existing" style="display: hidden">
        <input type="submit" name="action" value="Update">
        <input type="submit" name="action" value="Delete">
      </span>
    </div>
  </form>
  
</body>
</html>