
import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        process(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        process(req, res);
    }

    private void process(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String u = req.getParameter("u1");
        String p = req.getParameter("p1");

        HttpSession session = req.getSession();
        //String a = "";
        session.setAttribute("user", u);
        session.setAttribute("pass", p);


        if (session.getAttribute("user") == null || session.getAttribute("pass") == null) res.sendRedirect("wlcm.jsp");
        LoginDao ld = new LoginDao();
        if (ld.validate(u, p)) res.sendRedirect("wlcm.jsp");
        else
            res.sendRedirect("wrong.html");

    }
}



	