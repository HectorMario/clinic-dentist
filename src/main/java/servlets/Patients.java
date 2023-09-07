package servlets;

import logic.Controller;
import logic.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patients")
public class Patients extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = new Controller();
        List<Patient> patients = controller.getPatients();

        req.setAttribute("patients", patients);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/patients.jsp");
        dispatcher.forward(req, resp);
    }

}
