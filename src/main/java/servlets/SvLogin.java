package servlets;

import logic.Controller;
import logic.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class SvLogin extends HttpServlet {
    private Controller controller = new Controller();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = controller.getUser(username);
        if (user != null) {
            String passwordDB = user.getPassword();
            if (BCrypt.checkpw(password, passwordDB)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("username", username);
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login.jsp?error=true");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=true");
        }
    }

}
