import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext servletContext = getServletContext();

    String navn = request.getParameter("name");
    String kodeord = request.getParameter("kodeord");

    if(servletContext.getAttribute("brugerMap") ==null){
        Map<String,String> brugerMap = new HashMap<>();
        brugerMap.put("test","test");
        brugerMap.put("admin", "1234");
        servletContext.setAttribute("brugerMap",brugerMap);
    }


    if( !( (Map<String,String>)  servletContext.getAttribute("brugerMap")  ).containsKey(navn) ){
        //todo gå til loginside
        request.setAttribute("besked", "Brugernavnet eksisterer ikke! Opret dig");
        request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);

    }

    if(( (Map<String, String>)servletContext.getAttribute("brugerMap")  ).get(navn).equalsIgnoreCase(kodeord)){

        if(navn.equalsIgnoreCase("admin")){

            //todo gå til adminside
            request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);
    }


        //todo gå til login DVS index siden
        request.setAttribute("besked", "Din kode var forkert! Prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
