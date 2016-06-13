package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.*;
import model.*;


/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("�ѵ�add.java");
		//GuitarSpec
		String builder = request.getParameter("builder");
		String type = request.getParameter("type");
		String backWood = request.getParameter("backWood");
		String topWood = request.getParameter("topWood");
		int numStrings = Integer.parseInt(request.getParameter("numStrings"));
		String model = request.getParameter("Model");
		GuitarSpec spec = new GuitarSpec(builder, model, type, numStrings, backWood, topWood);
		//serialNumber��price
		String serialNumber=request.getParameter("serialNumber");
		double price=Double.parseDouble(request.getParameter("price"));
		
		IGuitarDao add = UsingDB.createGuitarDao();
		add.addGuitar(serialNumber,price,spec);
		
		response.sendRedirect("Html/Guitardelete.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
