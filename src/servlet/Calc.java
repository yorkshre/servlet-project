package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter w = response.getWriter();
		   double l1, l2;
		    if(request.getParameter("l1") == null) {
				l1 = 0;
			}
			else {
				l1 = Double.parseDouble(request.getParameter("l1"));
		        //l1 = new Double(l1.doubleValue());
			}

		    if(request.getParameter("l2") == null) {
				l2 = 0;
			} else {
				l2 = Double.parseDouble(request.getParameter("l2"));
			}
		   String op = request.getParameter("op");
		    if(op == null) {
				op = "+";
			}
		    double wynik = 0;

		    if(op.equals("+")) {
				wynik = l1 + l2;
			} else if(op.equals("-")) {
				wynik = l1 - l2;
			} else if(op.equals("*")) {
				wynik = l1 * l2;
			} else if(op.equals("/")) {
				wynik = l1 / l2;
			}
		String html = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8;'><title>Servlet Page</title></head><body><h1>calc</h1>";
		html +="  <form method='get'>";
		html +="<input type='text' name='l1' value='"+l1+"' />";
		html +="<select name='op'>";
		html +="<option" + (op.equals("+")?" selected=\'selected\'":"") + ">+</option>";
		html +="<option"  + (op.equals("-")?" selected=\'selected\'":"") + ">-</option>";
		html +="<option" + (op.equals("*")?" selected=\'selected\'":"") + ">*</option>";
		html +="<option" + (op.equals("/")?" selected=\'selected\'":"") + ">/</option>";
		html +="</select>";
		html +="<input type='text' name='l2' value='"+l2+"' />";
		html +="<input type='submit' value='=' />";
		html +="<h1>wynik: " +wynik + "</h1>";
		html +="</form>";
		html +="    </body>";
		html +="</html>";
		w.print(html);
		w.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
