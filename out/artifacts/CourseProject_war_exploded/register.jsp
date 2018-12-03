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
    <title>Register Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/register.gif"/>

    <!-- CSS-->
    <link rel="stylesheet" type="text/css" href="css/login/vendor/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/animate.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/select2.min.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/util.css">
    <link rel="stylesheet" type="text/css" href="css/login/vendor/login.css">
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />

    <!-- JS -->
    <script type="text/javascript" src="js/login/jquery.min.js"></script>
    <script type="text/javascript" src="js/login/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="js/combo.js"></script>
    <script type="text/javascript" src="js/login/popper.js"></script>
    <script type="text/javascript" src="js/login/select2.min.js"></script>
    <script type="text/javascript" src="js/login/tilt.jquery.min.js"></script>
    <script type="text/javascript" src="js/login/login.js"></script>

    <script type="text/javascript">

        $(function () {
            $('.js-tilt').tilt({
                scale: 1.1
            });

            //Date picker
            $('#datepicker').datepicker({
                changeMonth: true,
                changeYear: true
            });

            $('#usernameId').on('keyup', function () {
                checkUserName($(this).val());
                $(this).focus();
            });

            $('#passId, #confirmPassId').on('keyup', function () {
                if ($('#passId').val() == $('#confirmPassId').val()) {
                    $('#message').html('Passwords are matching').css('color', 'green');
                } else
                    $('#message').html('Passwords are not matching').css('color', '#ff4000');
            });

            $('#passId').on('keyup', function () {
                if($('#passId').val().length < 3) {
                    $('#lenPass').html('Weak Password').css('color', '#ff4000');
                } else
                    $('#lenPass').html('');
            });

            $('#roleId').on('change', function () {
                if (this.selectedIndex == 1) {
                    $('#roleCodeId').show();
                } else if(this.selectedIndex == 2) {
                    $('#roleCodeId').hide();
                }
            });

            $('#dialog-message').dialog({
                autoOpen: false,
                modal: true,
                height: 200,
                width: 430,
                buttons: {
                    Ok: function() {
                        $( this ).dialog("close");
                    }
                }
            });

            /*$('#registerBtnId').on('click', function () {
                $('#dialog-message').dialog('open');
            });*/
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

            <form class="login100-form validate-form" action="cs?action=register" method="post">
					<span class="login100-form-title">
						REGISTER REAL ESTATE
					</span>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" name="firstName" id="firstNameId" placeholder="Enter First name" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" name="surname" id="surnameId" placeholder="Enter Surname" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" name="username" id="usernameId" placeholder="Enter UserName" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="email" name="email" id="emailId" placeholder="Enter Email" required pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="password" id="passId" name="password" placeholder="Enter Password" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                    <span id='lenPass'></span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="password" id="confirmPassId" name="confirmPass" placeholder="Retype Password" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                    <span id='message'></span>
                </div>

                <div class="wrap-input100 validate-input">
                    <select class="input100" name="gender" id="genderId" required>
                        <option selected disabled>Choose gender</option>
                        <c:forEach items="${gendersList}" var="gl">
                            <option value="${gl.id}">${gl.gender}</option>
                        </c:forEach>
                    </select>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-male" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" id="datepicker" name="datepicker" placeholder="Enter Birth Date" required>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-calendar" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <select class="input100" name="secretQuestion" id="secretQuestionId" required>
                        <option selected disabled>Choose secret question</option>
                        <c:forEach items="${questionsList}" var="ql">
                            <option value="${ql.id}">${ql.question}</option>
                        </c:forEach>
                    </select>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-question" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <textarea class="form-control" rows="3" name="secretAnswer" id="secretAnswerId" placeholder="Please enter your answer ..." data-gramm="true" data-txt_gramm_id="73e5eeec-3819-b624-3f3c-4082bb993a8a" data-gramm_id="73e5eeec-3819-b624-3f3c-4082bb993a8a" spellcheck="false" data-gramm_editor="true" style="z-index: auto; position: relative; line-height: 20px; font-size: 14px; transition: none; background: transparent !important; border-radius: 1.25rem; width: 120%;" required></textarea>
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input">
                    <select class="input100" name="role" id="roleId" required>
                        <option selected disabled>Choose your role</option>
                        <c:forEach items="${rolesList}" var="rl">
                            <option value="${rl.id}">${rl.role}</option>
                        </c:forEach>
                    </select>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-users" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" id="roleCodeId" style="display: none;">
                    <input class="input100" type="text"  name="roleCode" placeholder="Enter role code" value="0">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-sort-numeric-asc" aria-hidden="true"></i>
						</span>
                </div>

                <div id="dialog-message" title="Registration info" style="display:none;">
                    <p>
                        <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
                        Your registration request will be checked by <b>admin</b>.
                    </p>
                    <p>
                        After approve you will be able to login to the system. Thanks
                    </p>
                </div>

                <div id="usernameInfoId" title="Username info" style="display:none;">
                    <p>
                        <span class="ui-icon ui-icon-info" style="float:left; margin:0 7px 50px 0;"></span>
                        <span>This username is already taken.</span>
                    </p>
                </div>
                
                <div class="container-login100-form-btn" id="buttonsId">
                    <button class="login100-form-btn" type="submit" id="registerBtnId">
                        Register
                    </button>
                    <button class="login100-form-btn-clear" type="reset">
                        Reset
                    </button>
                    <c:if test="${not empty invalid}">
                        <label style="color: red; font-weight: bold">${invalid}</label>
                    </c:if>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="login.jsp">
                        You have already an acount? Login
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
