package company;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		String disname=request.getParameter("disname");
		String adderess=request.getParameter("adderess");
		String cityname=request.getParameter("cityname");
		String statename=request.getParameter("statename");
		String country=request.getParameter("country");
		String region=request.getParameter("region");
		
		
		String ph=request.getParameter("phone");
		double phone=Double.parseDouble(ph);
		String email=request.getParameter("email");
		//double mname=Double.parseDouble(num);
				//String country=request.getParameter("country");
				
		int status=RegisterUser.register(username, password, repassword,disname, adderess,cityname,statename,country,region,phone,email);
		
		if(status>0)
		{
			request.setAttribute("welcome", "WELCOME! YOU HAVE BEEN REGISTERD");
        RequestDispatcher rd=request.getRequestDispatcher("customer.jsp");
        rd.include(request,response);
		}
		else
		{
			out.print("Sorry,Registration failed. please try later");
		RequestDispatcher rd=request.getRequestDispatcher("index.php");
		rd.include(request, response);
		}
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
