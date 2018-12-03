package re.web;

import re.dao.GeneralDao;
import re.dao.impl.GeneralDaoImpl;
import re.model.Users;
import re.service.GeneralService;
import re.service.impl.GeneralServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/ls")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "";

        GeneralDao generalDao = new GeneralDaoImpl();
        GeneralService generalService = new GeneralServiceImpl(generalDao);

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int count = 0;
            if(username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                Users users = generalService.login(username, password);
                count = generalService.countNewUsers();
                if(users != null) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("users",users);
                    request.setAttribute("count", count);
                    address = "index.jsp";
                } else {
                    request.setAttribute("invalid", "UserName or Password is invalid!");
                    address = "login.jsp";
                }

            } else {
                request.setAttribute("invalid", "UserName or Password is empty!");
                address = "login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
