package com.Ecommerce.Main.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Ecommerce.Main.Model.User;
import com.Ecommerce.Main.Repository.RoleRepository;
import com.Ecommerce.Main.Repository.UserRepository;

@Controller
public class LoginController {
	
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest req) throws ClassNotFoundException, SQLException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","abhi12345");
		Statement st=con.createStatement();
		String query="Select * from user where email='"+email+"'";
		ResultSet rs=st.executeQuery(query);
		if(rs.next()) {
			return "login";
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	
//	@PostMapping("/register")
//	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request)throws ServletException
//	{
//		String password = user.getPassword();
//		user.setPassword(password);
//		List<Role> roles = new ArrayList<>();
//		roles.add(roleRepository.findById(2).get());
//		user.setRoles(roles);
//		userRepository.save(user);
//		request.login(user.getEmail(), password);
//		return "redirect:/";
//	}
	
	
	@PostMapping("/register")
	public String home2(HttpServletRequest req) throws SQLException, ClassNotFoundException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/codeplanet","root","abhi12345");
		Statement stmt=con.createStatement();
		String query="Select * from user where email='"+email+"'";
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next()) {
		return "redirect:/";
		}
		else {
			String queryInsert="insert into user(email,password) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(queryInsert);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			int i=pstmt.executeUpdate();
			
			if(i>=1)
			{
				return "redirect:/";
			}
			else
			{
				return "redirect:/";
			}

        }
}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
}
