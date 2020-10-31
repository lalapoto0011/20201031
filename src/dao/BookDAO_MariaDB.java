package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVO;

public class BookDAO_MariaDB {
	
	//아래 sql 처리하는 메소드
	public List<BookVO> booklist() {  //이 메소드를 호출할 때 정말 테이블 구조 내용이 나오는지 확인해야 함
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book order by bookno desc"; //얘를 처리하고 싶음..
		//이 sql구문 처리한 결과가 테이블 내용
		
		//DB연동 코드  - 연결할 변수들?
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; //결과값 처리할 객체
		
		try { //sql구문 처리하는 부분 들어감
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); //테이블 내용을 ??
			
			while(rs.next()) { //커서가 메타태그를 가리키고 있음, rs.next하면 밑으로 내려감, 데이터를 꺼내서 자바북브이오에 객체화시킴???
				BookVO vo = new BookVO(); //vo객체가 만들어졌지만 비어있음
				vo.setBookno(rs.getInt("bookno"));
				vo.setPrice(rs.getInt("price"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setTitle(rs.getString("title"));   //테이블의 데이터들을 꺼내서 부유 객체에 넣어줌
				list.add(vo); //vo객체를 add해주세요?
			}
			
			
		} catch (Exception e) {
			System.out.println("error" + e);
		} finally { //무조건 자원 반납
			JDBCUtil.close(con, ps, rs);
		}
		
		
		
		return list;
		//resultset을 자바로 뭐 어쩐다고????
		//리턴타입 -> 레코드가 하나가 아니라 여러개니까 -> 무조건 배열 아니면 컬렉션
	}
	
	public int Insertlist() { //void도 가능
		int row = 0;
		String sql = 
		"insert into book (title, publisher, price)" + 
		"values ('자바','한빛', 900)";
		//얘를 처리한 다음에 리턴타입을 어떻게 할 것인지..??
		
		return row; //int에 대한..
	}
}
