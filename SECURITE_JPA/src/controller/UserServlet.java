package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUser;
import dao.UserDao;
import entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  IUser userdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		userdao=new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("page")!= null){
			String page = request.getParameter("page");
			if(page.equalsIgnoreCase("liste")){
				List<User> liste = userdao.liste();
				request.setAttribute("users", liste);
				request.getRequestDispatcher("/user/liste.jsp").forward(request, response);
			}else if (page.equalsIgnoreCase("add")) {
				request.getRequestDispatcher("/user/add.jsp").forward(request, response);	
			}
			else if (page.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("idU"));
				userdao.delete(id);
				List<User> liste = userdao.liste();
				request.setAttribute("users", liste);
				request.getRequestDispatcher("/user/liste.jsp").forward(request, response);
			}else if (page.equalsIgnoreCase("edit")) {
				int id = Integer.parseInt(request.getParameter("idU"));
				User user=userdao.getServeurById(id);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action")!= null){
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("Envoyer")){
				String nom=request.getParameter("nomU");
				String prenom=request.getParameter("prenomU");
				String login=request.getParameter("loginU");
				String password=request.getParameter("passwordU");
				User user=new User();
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setLogin(login);
                user.setPassword(password);
                int ok= userdao.add(user);
                request.setAttribute("message", ok);
                request.getRequestDispatcher("user/add.jsp").forward(request, response);
			}
			if(action.equalsIgnoreCase("Modifier")){
				int id = Integer.parseInt(request.getParameter("idU"));
				String nom=request.getParameter("nomU");
				String prenom=request.getParameter("prenomU");
				String login=request.getParameter("loginU");
				String password=request.getParameter("passwordU");
				User user= new User();
				user.setIdU(id);
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setLogin(login);
                user.setPassword(password);
                userdao.update(user);
                List<User> liste= userdao.liste();
                request.setAttribute("users", liste);
                request.getRequestDispatcher("/user/liste.jsp").forward(request, response);
			}

		}
	}


}
