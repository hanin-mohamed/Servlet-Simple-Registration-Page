<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 50px auto;
        }
        .btn-primary {
            background-color: #0069d9;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>

    <div class="container mt-5">
        <div class="form-container">
            <h2 class="text-center mb-4">Registration Form</h2>

            <form action="register" method="post">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                    <div class="text-danger">
                        <%= request.getAttribute("firstNameError") != null ? request.getAttribute("firstNameError") : "" %>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                    <div class="text-danger">
                        <%= request.getAttribute("lastNameError") != null ? request.getAttribute("lastNameError") : "" %>
                    </div>
                </div>


                 <div class="mb-3">
                    <label for="phone" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                    <div class="text-danger">
                        <%= request.getAttribute("phoneError") != null ? request.getAttribute("phoneError") : "" %>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                    <div class="text-danger">
                        <%= request.getAttribute("emailError") != null ? request.getAttribute("emailError") : "" %>
                    </div>
                </div>

               

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                    <div class="text-danger">
                        <%= request.getAttribute("passwordError") != null ? request.getAttribute("passwordError") : "" %>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form>
        </div>
    </div>

</body>
</html>
