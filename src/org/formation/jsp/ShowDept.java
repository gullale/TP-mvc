package org.formation.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowDept
 */
@WebServlet("/ShowDept")
public class ShowDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DeptNumService dns = new NumDeptMapper();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowDept() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// etape 1: recuperation des parametres de la requete
		String deptnum = request.getParameter("numero");
		String deptname = dns.findDept(deptnum);
		DeptPair deptPair = new DeptPair(deptnum, deptname);

		// etape 2: soumettre les parametres de la requete a la couche service et
		// recuperation parametre de requete
		/*HttpSession maSession = request.getSession();
		maSession.setAttribute("paire", deptPair);*/
		request.setAttribute("paire", deptPair);

		// etape 3: reponse a l'utilisateur
		
		 /* RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/WEB-INF/show-departement.jsp");
		 * dispatcher.forward(request, response);*/

		RequestDispatcher dispatcher;

		
		if (deptnum.isEmpty()) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/missing-num.jsp");
		} else if (deptname == null) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/unknow-num.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("/WEB-INF/show-departement.jsp");
		}
		dispatcher.forward(request, response);
	}

}
