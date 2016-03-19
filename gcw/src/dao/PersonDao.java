package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import pojo.Person;
public class PersonDao {
	DBUtil db=new DBUtil();
	public List<Person> getPersonList(){
		List<Person> list=new ArrayList<Person>();
		Connection conn=db.getConnection();
		try {
			
			PreparedStatement ps=conn.prepareStatement("select * from zxp");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Person p=new Person();
				p.setId(rs.getInt("id"));
				p.setEmail(rs.getString("email"));
				p.setAge(rs.getInt("age"));
				p.setGender(rs.getString("gender"));
				p.setName(rs.getString("name"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void insertPerson(String name,int age,String gender,String email){
		Connection conn=db.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into gcw" +
					"(name,age,gender,email) values('"+name+"',"+age+",'"+gender+"','"+email+"')");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void savePerson(int id,String name,int age,String gender,String email){
		Connection conn=db.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("update gcw set name='"+name+"',age="+age+",gender='"+gender+"',email='"+email+"' where id="+id+"");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletePerson(int id){
		Connection conn=db.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from gcw where id="+id+"");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Person getperson(int id){
		Connection conn=db.getConnection();
		Person p=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select *from gcw where id="+id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				p=new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setEmail(rs.getString("email"));
				p.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
