package myservlet.control;

import mybean.data.Register;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class handleRegister extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {  Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e) {}
    }

    public String handleString(String s) {
        try{
               byte bb[]=s.getBytes("iso-8859-1");
               s=new String(bb);
           }
        catch(Exception e) {}
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con;
        Satement sql;
        ResultSet rs;

        Register register=new Register();
        request.setAttribute("register", register);
		String usr=request.getParameter("usr").trim();
		String passwd=request.getParameter("passwd").trim();
		String email=request.getParameter("email").trim();
		String phone=request.getParameter("phone").trim();

		if(usr==null) usr="";
		if(passwd==null) passwd="";
		boolean isLD=true;//检查是否符合命名规范
		for(int i=0;i<usr.length();i++) {
			char c=usr.charAt(i);
			if( !( (c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0') ) )
				isLD=false;
		}
		boolean boo=usr.length()>0&&passwd.length()>0&&isLD;
		String backNews="";
		try{
			usr=handleString(usr);
			passwd=handleString(passwd);
			phone=handleString(phone);
			email=handleString(email);
			String insertRecord="('"+usr+"','"+passwd+"','"+phone+"','"+email+"');";
			String uri="jdbc:mysql://127.0.0.1/Messages?"+"user=root&password=&characterEncoding=gb2312";
			con=DriverManager.getConection(uri);
			String insertCondition="INSERT INTO Messages VALUES "+insertRecord;
			sql=con.createStatement();
			if(boo) {
				int m=sql.executeUpdate(insertCondition);
				if(m!=0) {
					backNews="注册成功！";
					register.setBackNews(backNews);
					register.setUsr(usr);
					register.setPasswd(passwd);
					register.setPhone(phone);
					register.setEmail(email);
				}
				else{
					backNews="信息填写不完整或名字中有非法字符！";
					register.setBackNews(backNews);
				}
			}
			con.close();
		}
		catch(SQLException e) {
			backNews="该会员名已被使用，请您更换名字"+e;
			register.setBackNews(backNews);
		}

		RequestDispatcher dispacther=request.geReuqestDispatcher("showRegisterMessage.jsp");
		dispatcher.forward(request, response);
	}

}
