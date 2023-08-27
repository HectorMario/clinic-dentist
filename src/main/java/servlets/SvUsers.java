package servlets;

import controller.DentistController;
import controller.SecretaryController;
import controller.UserController;
import logic.Dentist;
import logic.Secretary;
import logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/users")
public class SvUsers extends HttpServlet {
    private UserController userController;

    public void init() {
        userController = new UserController(); // Inicializa el controlador
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>List of Users</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Role</th></tr>");

        for (User user : userController.readAllUsers()) {
            out.println("<tr>");
            out.println("<td>" + user.getId_user() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getRol() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String dateOfBirth = request.getParameter("dateOfBirth");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String role = request.getParameter("role");

        User newUser = new User();
        String salt = BCrypt.gensalt(12);
        newUser.setUsername(username);
        newUser.setPassword(BCrypt.hashpw(password,salt));
        newUser.setRol(role);
        boolean success = userController.createUser(newUser);
        if (success && role.equals("dentist")){
            String specialty = request.getParameter("specialty");
            Dentist newDentist = new Dentist();
            newDentist.setUser(newUser);
            newDentist.setAddress(address);
            newDentist.setName(name);
            newDentist.setSurName(surname);
            newDentist.setDateOfBirth(date);
            newDentist.setSpecialty(specialty);
            DentistController dentistController = new DentistController();
            dentistController.createDentist(newDentist);
        } else {
            String sector = request.getParameter("sector");
            Secretary newSecretary = new Secretary();
            newSecretary.setUser(newUser);
            newSecretary.setAddress(address);
            newSecretary.setName(name);
            newSecretary.setSurName(surname);
            newSecretary.setDateOfBirth(date);
            newSecretary.setSector(sector);
            SecretaryController secretaryController = new SecretaryController();
            secretaryController.createSecretary(newSecretary);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Actualizar un usuario existente
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User userToUpdate = new User();
        userToUpdate.setId_user(userId);
        userToUpdate.setUsername(username);
        userToUpdate.setPassword(password);
        userToUpdate.setRol(role);

        userController.updateUser(userToUpdate);
        response.sendRedirect(request.getContextPath() + "/users");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Eliminar un usuario
        int userId = Integer.parseInt(request.getParameter("id"));
        userController.deleteUser(userId);
        response.sendRedirect(request.getContextPath() + "/users");
    }

    public void destroy() {
    }
}

