<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard | Jangir IT</title>
    <style>
        body { font-family: Arial; background: #f4f7f6; padding: 50px; }
        .dashboard-table { width: 100%; border-collapse: collapse; background: white; border-radius: 10px; overflow: hidden; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }
        .dashboard-table th { background: #001f3f; color: white; padding: 15px; text-align: left; }
        .dashboard-table td { padding: 15px; border-bottom: 1px solid #eee; }
        .dashboard-table tr:hover { background: #f1f1f1; }
        .header { text-align: center; margin-bottom: 30px; color: #001f3f; }
    </style>
</head>
<body>

    <div class="header">
        <h1>Admin Dashboard - Registered Users</h1>
        <p>Jangir IT Solution Database Management</p>
    </div>

<div style="text-align: center; margin-bottom: 20px;">
    <a href="exportExcel" style="padding: 12px 25px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; font-weight: bold; display: inline-block; box-shadow: 0 4px 6px rgba(0,0,0,0.1);">
        📥 Download Excel Report
    </a>
</div>

    <table class="dashboard-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th> </tr>
</thead>
<tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <a href="deleteUser?email=${user.email}" 
                   onclick="return confirm('Kya aap sach mein ise delete karna chahte hain?')" 
                   style="color: red; text-decoration: none; font-weight: bold;">
                   Delete
                </a>
            </td>
        </tr>
    </c:forEach>
</tbody>

    <br>
    <a href="index.html" style="text-decoration:none; color:#38bdf8; font-weight:bold;">← Back to Home</a>

</body>
</html>




<!-- 
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>User List:</h2>
    <c:forEach var="u" items="${users}">
        <p>Name: ${u.name} | Email: ${u.email}</p>
    </c:forEach>
</body>
</html> -->


