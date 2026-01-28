<!DOCTYPE html>
<html>
<head>
    <title>Jangir IT Solution - Registration</title>
    <style>
        body { font-family: Arial; background: #f4f4f4; text-align: center; }
        .form-container { background: white; width: 300px; margin: 50px auto; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px gray; }
        input { width: 90%; padding: 10px; margin: 10px 0; }
        button { background: #28a745; color: white; border: none; padding: 10px 20px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Register User</h2>
        <form action="register" method="post">
            <input type="text" name="name" placeholder="Enter Full Name" required>
            <input type="email" name="email" placeholder="Enter Email" required>
            <input type="password" name="password" placeholder="Enter Password" required>
            <button type="submit">Save to Database</button>
        </form>
    </div>
</body>
</html>