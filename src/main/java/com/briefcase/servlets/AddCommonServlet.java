package com.briefcase.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.briefcase.dao.CategoryDao;
import com.briefcase.dao.ProductDao;
import com.briefcase.dao.UserDao;
import com.briefcase.entities.Category;
import com.briefcase.entities.Product;
import com.briefcase.entities.User;
import com.briefcase.helper.FactoryProvider;




/**
 * Servlet implementation class AddCommonServlet
 */
@MultipartConfig
public class AddCommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			
			String formType = request.getParameter("operation");
			if(formType.trim().equals("addCategory")) {
				String categoryTitle = request.getParameter("categoryTitle");
				String categoryDescription = request.getParameter("categoryDescription");
				Category category = new Category();
				category.setCategoryTitle(categoryTitle);
				category.setCategoryDescription(categoryDescription);
				
				//fetching dao to save
				CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
				int categoryId = categoryDao.saveCategory(category);
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Category added Successfully!");
				response.sendRedirect("admin.jsp");
				return;
				
						
			}else if(formType.trim().equals("addProduct")) {
				String productTitle = request.getParameter("productName");
				String description = request.getParameter("productDescription");
				int productPrice = Integer.parseInt(request.getParameter("productPrice"));
				int productDiscount = Integer.parseInt(request.getParameter("productDiscount"));
				int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				int userId = Integer.parseInt(request.getParameter("userId"));
				
				
				Part part = request.getPart("productPic");
				
				Product product = new Product();
				product.setProductName(productTitle);
				product.setProductDescription(description);
				product.setProductdiscount(productDiscount);
				product.setProductPrice(productPrice);
				product.setProductQuantity(productQuantity);
				product.setProductPhoto(part.getSubmittedFileName());
				
				//fetch category by categoryId
				
				CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
				Category category = categoryDao.getCategory(categoryId);
				product.setCategory(category);
				
				//fetch user of this product
				UserDao userDao = new UserDao(FactoryProvider.getFactory());
				User user = userDao.getUserById(userId);
				product.setUser(user);
				
				
				//pic upload
				
				//path to upload photos
				String path = request.getRealPath("product")+File.separator+part.getSubmittedFileName();
				System.out.println(path);
				
				//uploading
				
				FileOutputStream fos = new FileOutputStream(path);
				InputStream is = part.getInputStream();
				
				byte []data = new byte[is.available()];
				is.read(data);
				
				fos.write(data);
				is.close();
				fos.close();

				
											
				
				//save product
				
				ProductDao productDao = new ProductDao(FactoryProvider.getFactory());
//				productDao.saveProduct(product);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Product added Successfully!");
				response.sendRedirect("normal.jsp");
				return;
			}
			
			
		}catch(Exception e) {
			
		}
	}

}
