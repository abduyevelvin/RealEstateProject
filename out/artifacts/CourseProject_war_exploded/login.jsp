<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EAAbduyev
  Date: 09/04/2018
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/login.gif"/>

    <!-- CSS-->
    <link rel="stylesheet" type="text/css" href="css/login/vendor/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/animate.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/select2.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/util.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/login.css">

    <!-- JS -->
    <script type="text/javascript" src="js/jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/login/popper.js"></script>
    <script type="text/javascript" src="js/login/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/login/select2.min.js"></script>
    <script type="text/javascript" src="js/login/tilt.jquery.min.js"></script>
    <script type="text/javascript" src="js/login/login.js"></script>

    <script type="text/javascript">
        history.pushState(null, null, 'login.jsp');
        window.addEventListener('popstate', function (event) {
            history.pushState(null, null, 'login.jsp');
        });

        $(function () {
            $('.js-tilt').tilt({
                scale: 1.1
            });
        });
    </script>

</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="images/loginImage.jpg" alt="NO IMG">
            </div>

            <form class="login100-form validate-form" action="ls" method="post">
					<span class="login100-form-title">
						LOGIN REAL ESTATE
					</span>

                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input class="input100" type="text" name="username" placeholder="Username" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <input class="input100" type="password" name="password" placeholder="Password" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit">
                        Login
                    </button>
                    <button class="login100-form-btn-clear" type="reset">
                        Reset
                    </button>
                    <c:if test="${not empty invalid}">
                        <label style="color: red; font-weight: bold">${invalid}</label>
                    </c:if>
                </div>

                <div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
                    <a class="txt2" href="#">
                        Username / Password?
                    </a>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="cs?action=registration">
                        Create new Account
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
