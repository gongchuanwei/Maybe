package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDao;

import pojo.Person;

import util.DBUtil;

public class PersonServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response){
		String url=request.getRequestURI();
		String path=url.substring(url.lastIndexOf("/"));
		
		if(path.equals("/show.do")){
			try {
				PersonDao dao=new PersonDao();
				List<Person> list=new ArrayList<Person>();
				list=dao.getPersonList();
				System.out.println(list.get(0).getId()+"色泽");
				request.setAttribute("persons", list);
				request.getRequestDispatcher(
				"personlist.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("/insert.do")){
			//System.out.println("arrive!");
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String gender=request.getParameter("gender");
			String email=request.getParameter("email");
			System.out.println(name+age+gender+email);
			try {
				PersonDao p=new PersonDao();
				p.insertPerson(name, Integer.parseInt(age), gender, email);
				response.sendRedirect("show.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if(path.equals("/updateperson.do")){
			String id=request.getParameter("id");
			System.out.println(id+"dfdfdddf");
			try {
				PersonDao p=new PersonDao();
				Person person=p.getperson(Integer.parseInt(id));
				request.setAttribute("person", person);
				request.getRequestDispatcher(
				"updatePerson.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("/save.do")){
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String gender=request.getParameter("gender");
			String email=request.getParameter("email");
			System.out.println(name+age+gender+email);
			System.out.println("id~~~"+id);
			try {
				PersonDao p=new PersonDao();
				p.savePerson(Integer.parseInt(id), name, Integer.parseInt(age), gender, email);
				response.sendRedirect("show.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("/deleteperson.do")){
			String id=request.getParameter("id");
			System.out.println("id!!!!!"+id);
			try {
				PersonDao p=new PersonDao();
				p.deletePerson(Integer.parseInt(id));
				response.sendRedirect("show.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	

}
