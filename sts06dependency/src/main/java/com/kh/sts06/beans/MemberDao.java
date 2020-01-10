package com.kh.sts06.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	//자원 참조하는 변수 생성(리모컨)

	
	
	
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		return	DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "home", "home");
	}
	public void regist(MemberDto dto) throws Exception{
		Connection con = this.getConnection();
		
		String sql = "insert into member values(?, ?, ?, sysdate, '일반회원', 0, ?, ?, ?, ?, null)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPw());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getPost());
		ps.setString(5, dto.getBasic_addr());
		ps.setString(6, dto.getExtra_addr());
		ps.setString(7, dto.getPhone());
		
		ps.execute();
		
		con.close();
		
	}
		public boolean login(String id, String pw) throws Exception{
			Connection con = getConnection();

			String sql = "select * from member where id=? and pw=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();

			boolean result = rs.next();

			con.close();

			return result;
		}

		public boolean login(MemberDto dto) throws Exception{
			return this.login(dto.getId(), dto.getPw());
		}
		public String find(String name, String phone) throws Exception {
			Connection con = getConnection();
			
			String sql = "select id from member where name=? and phone=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			
			System.out.println(name +" " +phone);
			ResultSet rs = ps.executeQuery();
			
			String id=null;
			if(rs.next()) {
			 id = rs.getString("id");
			}
	
			con.close();
			return id;
			
		}
		public MemberDto get(String id) throws Exception {
			Connection con = getConnection();
			
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			MemberDto dto = new MemberDto();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getString("grade"));
				dto.setPoint(rs.getInt("point"));
				dto.setPost(rs.getString("post"));
				dto.setBasic_addr(rs.getString("basic_addr"));
				dto.setExtra_addr(rs.getString("extra_addr"));
				dto.setPhone(rs.getString("phone"));
				dto.setLast_login(rs.getString("last_login"));
				dto.setJoindate(rs.getString("joindate"));
			}	
			else {
				dto = null;
			}
			
			
			con.close();
			return dto;
			
		}
		public void updateLastLogin(String id) throws Exception {
			Connection con = getConnection();
			
			String sql = "update member set last_login = sysdate where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  id);
			ps.execute();
			
			con.close();
		}
		
		public boolean exit(String id) throws Exception{
			Connection con = getConnection();
			
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs =ps.executeQuery();
			boolean result = rs.next();
			
			con.close();
			
			return result;
			
			
					
			
		}
		public void chagePassword(String id, String pw) throws Exception {
		 Connection con = getConnection();
		 
		 String sql = "update member set pw=? where id =?";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setString(1, pw);
		 ps.setString(2, id);
		 
		 ps.execute();
		 
		con.close();
			
		}
		public void changeInfo(MemberDto dto) throws Exception {
			Connection con =getConnection();
			
			String sql = "update member "
						+ "set phone = ?, post = ?, basic_addr=?, extra_addr=?, pw=?, point=?, grade=?  where id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
	
			ps.setString(1, dto.getPhone());
			ps.setString(2, dto.getPost());
			ps.setString(3, dto.getBasic_addr());
			ps.setString(4, dto.getExtra_addr());
			ps.setString(5, dto.getPw());
			ps.setInt(6, dto.getPoint());
			ps.setString(7, dto.getGrade());
			ps.setString(8, dto.getId());
			
			ps.execute();
			
			
			con.close();
		}
		public MemberDto findAdmin(String id) throws Exception {
			Connection con = getConnection();
			
			String sql = "select id from member where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			
			MemberDto dto = new MemberDto();
			if(rs.next()) {
			 dto.setId(id);
			 dto.setBasic_addr(rs.getString("basic_addr"));
			 dto.setExtra_addr(rs.getString("extra_addr"));
			 dto.setGrade(rs.getString("grade"));
			 dto.setJoindate(rs.getString("joindate"));
			 dto.setName(rs.getString("name"));
			 dto.setPhone(rs.getString("phone"));
			 dto.setPost(rs.getString("post"));
			
			}
			con.close();
			
			return dto;
		

		}
		
		public List<MemberDto> search(String type, String keyword) throws Exception{
			Connection con = getConnection();
			
			String sql = "select * from member where "+type+" like '%'||?||'%' order by "+type+" asc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  keyword);
			ResultSet rs = ps.executeQuery();
			
			List<MemberDto> list = new ArrayList<>();
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				 dto.setId(rs.getString("id"));
				 dto.setBasic_addr(rs.getString("basic_addr"));
				 dto.setExtra_addr(rs.getString("extra_addr"));
				 dto.setGrade(rs.getString("grade"));
				 dto.setJoindate(rs.getString("joindate"));
				 dto.setName(rs.getString("name"));
				 dto.setPhone(rs.getString("phone"));
				 dto.setPost(rs.getString("post"));
				 
				 list.add(dto);
				}
			con.close();
			
			return list;
			
	
			
			
		}
		
	
}
