package controller;

import Entities.Categoria;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpautil.JPAUtil;



/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
            HttpSession session = request.getSession();
            RequestDispatcher dispatcher;
            
            //Session singleton = HibernateUtil.getSessionFactory().openSession();
            
            EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
            
            String op = request.getParameter("op");
            List<Categoria> categorias;
            
            if (op.equals("inicio")) {
                Query q = em.createQuery("SELECT c from Categoria c");  
                categorias =(List<Categoria>) q.getResultList();
                session.setAttribute("categorias", categorias);
                dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);

            } else if (op.equals("")) {
            }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
