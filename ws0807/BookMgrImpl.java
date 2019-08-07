package com.ssafy.edu.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookMgrImpl implements IBookMgr {

	private ArrayList<Book> books=new ArrayList<>();
	
	private  static BookMgrImpl bmgr=new BookMgrImpl();
	private BookMgrImpl() {
		books.clear();
	}
	public static BookMgrImpl getInstance() {
		return bmgr;
	}

	private Book findByIsbn(String isbn) {
		Book b=null;
		for (Book nb : books) {
			if(nb.getIsbn().equals(isbn)) {
				b=nb; 
			}
		}
		return b;
	}
	
	
	@Override
	public void add(Book b) {
		Book nb= findByIsbn(b.getIsbn());
		if(nb==null) {
			books.add(b);
		}
	}

	@Override
	public List<Book> search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book nb= findByIsbn(isbn);
		if(nb==null) {
			throw new ISBNNotFoundException(isbn+"이 존재하지 않습니다.");
		}else {
			int curPrice=nb.getQuantity();
			if(curPrice-quantity<0) {
				throw new QuantityException("수량이 부족합니다.");
			}else {
				nb.setQuantity(curPrice-quantity);
			}
		}
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book nb= findByIsbn(isbn);
		if(nb==null) {
			throw new ISBNNotFoundException(isbn+"이 존재하지 않습니다.");
		}else {
			int curPrice=nb.getQuantity();
			nb.setQuantity(curPrice+quantity);
		}
	}

	@Override
	public int getTotalAmount() {
		int tot=0;
		for (Book nb : books) {
			tot+=nb.getPrice()*nb.getQuantity();
		}
		return tot;
	}

	@Override
	public void open() {
		
		String fname="book.dat";
		File fbook=new File(fname);
		if(!fbook.exists()) {
/*			try {
				fbook.createNewFile();
			} catch (IOException e) {
				System.out.println("파일이 존재하지 않습니다.");
			}*/
			return;
		}
		books.clear();// 중복저장 제외
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream(fbook));
			int count=ois.readInt(); // 
			for (int i = 0; i < count; i++) {
				Book bb=(Book)ois.readObject();
				books.add(bb);
			}
			System.out.println("Open Successfully~~~~~~");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	@Override
	public void close() {
		String fname="book.dat";
		File fbook=new File(fname);
		if(!fbook.exists()) {
			try {
				fbook.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream(fbook,false));
			oos.writeInt(books.size());
			for (Book bbbb: books) {
				oos.writeObject(bbbb);
				oos.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					
				}
			}
			System.out.println("Close Successfully~~~~~~");
		}
		

	}
	@Override
	public List<Book> searchByPrice(int price) {
		List<Book> lbs=new ArrayList<>();
		for (Book nb : books) {
			if(nb.getPrice()<price) {
				lbs.add(nb);
			}
		}
		return lbs;
	}
	@Override
	public void sortByTitleAsc() {
		books.sort(new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		
	}
	@Override
	public void sortByTitleDesc() {
		//anonymous -> 람다.
		books.sort((Book b1, Book b2)-> {
				return -b1.getTitle().compareTo(b2.getTitle());
			});
	}
	@Override
	public void sortByQuantity() {
		books.sort(new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getQuantity()-b2.getQuantity();
			}
		});
		
	}
	@Override
	public Book searchByIsbn(String isbn) {
		return findByIsbn(isbn);
	}
	@Override
	public List<Book> searchByTitle(String title) {
		List<Book> lbs=new ArrayList<>();
		for (Book nb : books) {
			if(nb.getTitle().contains(title)) {
				lbs.add(nb);
			}
		}
		return lbs;
	}
	
	
	String ip="127.0.0.1";
	int port=9987;
	
	@Override
	public void send() {
		Socket s=null;
		try {
			s=new Socket(ip,port);
			BookClient bc=new BookClient(s, books);
			bc.start();
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//
		
	}
    class BookClient extends Thread {
		Socket s;
		ArrayList<Book> books;
		ObjectOutputStream oos=null;
		public BookClient(Socket s, ArrayList<Book> books) {
				this.s=s;
				this.books=books;
				try {
					oos=new ObjectOutputStream(s.getOutputStream());
				} catch (IOException e) {
					System.out.println(e);
				}
		}
		@Override
		public void run() {
			try {
				oos.writeInt(books.size());
				oos.flush();
				for (Book kk: books) {
					oos.writeObject(kk);
					oos.flush();
				}
			} catch (IOException e) {
				System.out.println(e);
			}finally {
				if(oos!=null) {try {
					oos.close();
				} catch (IOException e) {
					System.out.println(e);
				}}
				if(s!=null) {try {
					s.close();
				} catch (IOException e) {
					System.out.println(e);
				}}
			}
		}
		
		

	}
	
	
	
}
