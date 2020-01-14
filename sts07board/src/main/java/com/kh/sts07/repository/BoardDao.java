package com.kh.sts07.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kh.sts07.entity.BoardDto;

public class BoardDao {

	
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "home", "home");
	}
	public List<BoardDto> list(int start, int finish) throws Exception{
		Connection con = getConnection();
		
		
		
		
		String sql = "select*from("  
				+ "select rownum rn, A.*from("
				
				
				+ "select * from board "
				+ "connect by prior no=superno "
				+"start with superno is null "
				+ "order siblings by groupno desc, no asc"
				+  ")A"
				+ ") where rn between ? and ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, start);
		ps.setInt(2, finish);
		
		ResultSet rs = ps.executeQuery();
		
		
		List<BoardDto> list = new ArrayList<>();
		
		
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			
			int rn = rs.getInt("rn");
			dto.setRn(rn);
			dto.setNo(rs.getInt("no"));
			dto.setHead(rs.getString("head"));
			dto.setContent(rs.getString("content"));
			dto.setTitle(rs.getString("title"));
			dto.setWdate(rs.getString("wdate"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setWriter(rs.getString("writer"));
			dto.setReplycount(rs.getInt("replycount"));
			dto.setGroupno(rs.getInt("groupno"));
			dto.setDepth(rs.getInt("depth"));
			dto.setSuperno(rs.getInt("superno"));

			list.add(dto);

		}
		con.close();
		
		return list;
		
	}
	public void rwrite(BoardDto dto) throws Exception{
		Connection con = getConnection();
		System.out.println(dto.getNo());
	
		String sql = "insert into reply "
				+ "(rwriter, rwdate, rgroupno, rsuperno, rdepth, rcontent, rno)"
				+ "values(?, sysdate, ?, ?, ?, ?, reply_seq.nextval)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getRwriter());
		if(dto.getRgroupno()==0) {
		ps.setInt(2, dto.getNo());
		ps.setNull(3, Types.INTEGER);
		ps.setInt(4, 0);
		}
		else {
			ps.setInt(2, dto.getGroupno());
			ps.setInt(3, dto.getRsuperno());
			ps.setInt(4, dto.getRdepth());
		}
		ps.setString(5, dto.getRcontent());
		ps.execute();
		
		con.close();
	}
	
	
	public void BoardWrite(BoardDto dto) throws Exception {
		Connection con = getConnection();
		System.out.println("asd");
		String sql = "insert into board "
				+ "(no, head, title, writer, content, groupno, superno, depth, wdate) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getNo());
		ps.setString(2, dto.getHead());
		ps.setString(3, dto.getTitle());
		ps.setString(4, dto.getWriter());
		ps.setString(5, dto.getContent());
		
		if(dto.getGroupno()==0) {
			ps.setInt(6, dto.getNo());
			ps.setNull(7, Types.INTEGER);
			ps.setInt(8, 0);
		}else {
			ps.setInt(6, dto.getGroupno());
			ps.setInt(7, dto.getSuperno());
			ps.setInt(8, dto.getDepth()+1);
		}
	
	
		
		ps.execute();
	
		con.close();
		
		
		
		
	}
	
	public List<BoardDto> list(int start, int finish, String type, String keyword) throws Exception{
		Connection con = getConnection();
		

		
		String sql = "select * from ( "  
						+ "select rownum rn, A.*from( " 
						+  "select * from board where "+type+ " like '%'||?||'%' "
						+"connect by prior no=superno "
						+ "start with superno is null "
						+	"order siblings by groupno desc, no asc "
						+  ")A " 
						+ ") where rn between ? and ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(2, start);
		ps.setInt(3, finish);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		
		List<BoardDto> list = new ArrayList<>();
		
		
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			
			dto.setRn(rs.getInt("rn"));
			dto.setNo(rs.getInt("no"));
			dto.setHead(rs.getString("head"));
			dto.setContent(rs.getString("content"));
			dto.setTitle(rs.getString("title"));
			dto.setWdate(rs.getString("wdate"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setWriter(rs.getString("writer"));
			dto.setReplycount(rs.getInt("replycount"));
			dto.setGroupno(rs.getInt("groupno"));
			dto.setDepth(rs.getInt("depth"));
			dto.setSuperno(rs.getInt("superno"));
			list.add(dto);

		}
		con.close();
		
		return list;
	}
	
		public BoardDto get(int no) throws Exception{
		Connection con = getConnection();
			
			String sql = "select * from board where no =?";
			PreparedStatement ps =con.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs = ps.executeQuery();
		   BoardDto dto = new BoardDto();
		   if(rs.next()) {
			    dto.setNo(rs.getInt("no"));
				dto.setHead(rs.getString("head"));
				dto.setContent(rs.getString("content"));
				dto.setTitle(rs.getString("title"));
				dto.setWdate(rs.getString("wdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriter(rs.getString("writer"));
				dto.setReplycount(rs.getInt("replycount"));
				dto.setGroupno(rs.getInt("groupno"));
				dto.setDepth(rs.getInt("depth"));
				dto.setSuperno(rs.getInt("superno"));
		   }
		   else {
			   dto=null;
		   }
		   return dto;
		
		
	}
	
		public BoardDto rget(int no) throws Exception{
			Connection con = getConnection();
			  System.out.println(no+"dd");
				String sql = "select * from reply where rgroupno =?";
				PreparedStatement ps =con.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs = ps.executeQuery();
			   BoardDto dto = new BoardDto();
			   System.out.println(no);
			   if(rs.next()) {
					dto.setRcontent(rs.getString("rcontent"));
					dto.setRwdate(rs.getString("rwdate"));
					dto.setRwriter(rs.getString("rwriter"));
					dto.setRgroupno(rs.getInt("rgroupno"));
					dto.setRdepth(rs.getInt("rdepth"));
					dto.setRsuperno(rs.getInt("rsuperno"));
			   }
			   else {
				   dto=null;
			   }
			   
			   System.out.println(dto.getRwriter());
			   return dto;
			
			
		}
		
		
		
	
	
	public int getSequence() throws Exception{
	Connection con = getConnection();
		
		String sql = "select board_no.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		int seq = rs.getInt(1);

		con.close();
		
		return seq;
		
	}
	
	public void cu(int no) throws Exception{
		Connection con = getConnection();
		
		String sql ="update board set readcount = readcount+1 where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
		
	}
	public void delete(int no) throws Exception {
		Connection con = getConnection();
		System.out.println("dao 삭제전");
		String sql= "delete board where no = ? ";
		System.out.println("dao 삭제후");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.execute();
		
		con.close();
		
	}
	public void BoardEdit(BoardDto dto) throws Exception {
		Connection con = getConnection();
		
		String sql = "update board set head=?, title=?, content=? where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getHead());
		ps.setString(2, dto.getTitle());
		ps.setString(3, dto.getContent());
		ps.setInt(4, dto.getNo());
		
		ps.execute();
	
		con.close();
		
		
	}
	
	public int getCount(String type, String keyword) throws Exception{
		Connection con = getConnection();
		
//		String sql = "select count(*) from board";
//		String sql = "select count(*) from board where "+type+" like '%'||?||'%'"; 
		boolean isSearch = type!=null &&keyword!= null;

		String sql = "select count(*) from board";
		if(isSearch){
			sql +=" where " +type+ " like '%'||?||'%'";
		}
		
	
		
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		if(isSearch) {
			ps.setString(1, keyword);
			
			
		}
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		int count = rs.getInt(1);
		
		con.close();
		
		return count;
		
	
	}
	public void calculate(int no) throws Exception{
		Connection con = getConnection();

		String sql = 
				"update board "
				+ "set replycount = (select count(*) from reply where origin = ?) "
				+ "where no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, no);
		ps.setInt(2, no);

		ps.execute();
		con.close();
	}
}
