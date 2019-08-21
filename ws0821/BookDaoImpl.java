package afternoon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BookDB implements IBookDao {

	private static BookDaoImpl dao = new BookDaoImpl(); 
	private BookDaoImpl()
	{
		super();
	}
	public static BookDaoImpl getInstance()
	{
		return dao;
	}
	
	
	
	@Override
	public List<Book> listBooks() {
		String sql =" SELECT ISBN, TITLE, AUTHOR, PUBLISER, PRICE, DESCRIPTION "+ "FROM BOOK ORDER BY ISBN";
		List<Book> books = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			log(" 2/6 listBooks s");
			psmt = conn.prepareStatement(sql);
			log(" 3/6 listBooks s");
			rs = psmt.executeQuery();
			log(" 4/6 listBooks s");
			while(rs.next())
			{
				int i = 1; 
				Book b = new Book(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++));
				books.add(b);
			}
			log(" 5/6 listBooks s");
		} catch (SQLException e) {
			log("listBooks F",e);
		}finally
		{
			close(conn, psmt, rs);
			log(" 6/6 listBooks s");
		}
		
		
		return books;
	}

	@Override
	public List<Book> listLikeBooks(String kind, String what) {
		
		String sql =" SELECT ISBN, TITLE, AUTHOR, PUBLISER, PRICE, DESCRIPTION "
				+ "FROM BOOK WHERE " + kind + " LIKE? " 
				+ "  ORDER BY ISBN";
		
		List<Book> books = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			log(" 2/6 listLikeBooks s");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+ what + "%");
			log(" 3/6 listLikeBooks s");
			rs = psmt.executeQuery();
			log(" 4/6 listLikeBooks s");
			while(rs.next())
			{
				int i = 1; 
				Book b = new Book(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++));
				books.add(b);
			}
			log(" 5/6 listBooks s");
		} catch (SQLException e) {
			log("listBooks F",e);
		}finally
		{
			close(conn, psmt, rs);
			log(" 6/6 listBooks s");
		}
		return books;
	}

	@Override
	public Book findByBook(String isbn) {
		String sql =" SELECT ISBN, TITLE, AUTHOR, PUBLISER, PRICE, DESCRIPTION "
				+ "FROM BOOK WHERE ISBN =?";
		
		Book b= null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			log(" 2/6 listLikeBooks s");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, isbn.trim());
			log(" 3/6 listLikeBooks s");
			rs = psmt.executeQuery();
			log(" 4/6 listLikeBooks s");
			while(rs.next())
			{
				int i = 1; 
				b = new Book(
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++));
			}
			log(" 5/6 listBooks s");
		} catch (SQLException e) {
			log("listBooks F",e);
		}finally
		{
			close(conn, psmt, rs);
			log(" 6/6 listBooks s");
		}
		return b;
	}

	@Override
	public void insertBook(Book b) {
		String sql =" insert into book(ISBN, TITLE, AUTHOR, PUBLISER, PRICE, DESCRIPTION )"
				+ "VALUES(?,?,?,?,?,?) ";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		int count=0;
		try {
			conn = getConnection();
			log(" 2/6 insertBook s");
			psmt = conn.prepareStatement(sql);
			int j = 1; 
			psmt.setString(j++, b.getIsbn());
			psmt.setString(j++, b.getTitle());
			psmt.setString(j++, b.getAuthor());
			psmt.setString(j++, b.getPublisher());
			psmt.setInt(j++, b.getPrice());
			psmt.setString(j++, b.getDescription());
			log(" 3/6 insertBook s");
			count= psmt.executeUpdate();
			log(" 4/6 insertBook s");
		} catch (SQLException e) {
			log("listBooks F",e);
		}finally
		{
			close(conn, psmt, null);
			log(" 6/6 listBooks s");
		}
	}

	@Override
	public void updateBook(Book b) {
		String sql =" UPDATE BOOK SET"
				+ "TITLE =?, AUTHOR =?, PUBLISER =?, PRICE=?, DESCRIPTION =? "
				+ "WHERE ISBN =? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count=0;
		try {
			conn = getConnection();
			log(" 2/6 updateBooks");
			psmt = conn.prepareStatement(sql);
			int j = 1; 
			psmt.setString(j++, b.getTitle());
			psmt.setString(j++, b.getAuthor());
			psmt.setString(j++, b.getPublisher());
			psmt.setInt(j++, b.getPrice());
			psmt.setString(j++, b.getDescription());
			psmt.setString(j++, b.getIsbn()); //¡÷¿«
			log(" 3/6 updateBook s");
			count= psmt.executeUpdate();
			log(" 4/6 updateBook s");
		} catch (SQLException e) {
			log("updateBook F",e);
		}finally
		{
			close(conn, psmt, null);
			log(" 6/6 updateBook s");
		}
	}

	@Override
	public void deleteBook(String isbn) {
		String sql = "DELETE FROM BOOK WHERE ISBN =? ";
		Connection conn = null;
		PreparedStatement psmt = null;
		int count=0;
		try {
			conn = getConnection();
			log(" 2/6 deleteBook s");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, isbn);
			log(" 3/6 deleteBookk s");
			count= psmt.executeUpdate();
			log(" 4/6 deleteBook s");
		} catch (SQLException e) {
			log("deleteBook F",e);
		}finally
		{
			close(conn, psmt, null);
			log(" 6/6 deleteBook s");
		}

	}

	@Override
	public int count() {
		String sql =" SELECT COUNT(*) FROM BOOK ";
		int count =0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			log(" 2/6 count s");
			psmt = conn.prepareStatement(sql);
			log(" 3/6 count s");
			rs = psmt.executeQuery();
			log(" 4/6  count s");
			while(rs.next())
			{
				count = rs.getInt(1);
			}
			log(" 5/6 listBooks s");
		} catch (SQLException e) {
			log("listBooks F",e);
		}finally
		{
			close(conn, psmt, rs);
			log(" 6/6 listBooks s");
		}
		return count;
	}

}
