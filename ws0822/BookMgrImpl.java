package com.ssafy.bms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMgrImpl implements IBookMgr {

	private ArrayList<Book> books = new ArrayList<>();

	private static BookMgrImpl bmgr = new BookMgrImpl();

	private BookMgrImpl() {
		books.clear();
	}

	public static BookMgrImpl getInstance() {
		return bmgr;
	}

	private Book findByISBN(String isbn) {
		Book b = null;
		for (Book bb : books) {
			if (bb.getIsbn().equals(isbn)) {
				b = bb;
			}
		}
		return b;
	}

	@Override
	public void load() {
		String fileName = "books.dat";
		File file = new File(fileName);
		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				System.out.println(e);
//			}
			return;
		}
		books.clear();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			int size = ois.readInt();
			for (int i = 0; i < size; i++) {
				Book bb = (Book) ois.readObject();
				books.add(bb);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	@Override
	public void save() {
		String fileName = "books.dat";
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file, false));
			oos.writeInt(books.size());
			for (Book bb : books) {
				oos.writeObject(bb);
				oos.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	@Override
	public void add(Book b) throws DuplicateException {
		Book bb = findByISBN(b.getIsbn());
		if (bb == null) {
			books.add(b);
		} else {
			throw new DuplicateException("데이터가 중복되었습니다.");
		}
	}

	@Override
	public List<Book> search() {
		return books;
	}

	@Override
	public Book search(String isbn) throws RecordNotFoundException {
		Book b = findByISBN(isbn);
		if (b == null) {
			throw new RecordNotFoundException("데이터가 없습니다.");
		} else {
			return b;
		}
	}

	@Override
	public void update(String isbn, int price) throws RecordNotFoundException {
		Book b = findByISBN(isbn);
		if (b == null) {
			throw new RecordNotFoundException("데이터가 없습니다.");
		} else {
			b.setPrice(price);
		}
	}

	@Override
	public void delete(String isbn) throws RecordNotFoundException {
		Book b = findByISBN(isbn);
		if (b == null) {
			throw new RecordNotFoundException("데이터가 없습니다.");
		} else {
			books.remove(b);
		}
	}

	@Override
	public List<Book> searchTitle(String title) {
		List<Book> bbs = new ArrayList<>();
		for (Book bb : books) {
			if (bb.getTitle().contains(title)) {
				bbs.add(bb);
			}
		}
		return bbs;
	}

	@Override
	public List<Book> sortIsbn() {
		List<Book> bbs = new ArrayList<>();
		books.sort((Book o1, Book o2) -> {
			if (o1.getIsbn().compareTo(o2.getIsbn()) > 0) {
				return 1;
			} else if (o1.getIsbn().compareTo(o2.getIsbn()) < 0) {
				return -1;
			} else {
				return 0;
			}
		});
		bbs = books;
		return bbs;
	}

	@Override
	public String countWord() {
		Map<String, Integer> map = new HashMap<>();
		for (Book bb : books) {
			String[] tt = bb.getTitle().split(" ");
			for (String t : tt) {
				if (map.containsKey(t)) {
					map.put(t, map.get(t) + 1);
				} else {
					map.put(t, 1);
				}
			}
		}
		int max = -99;
		String ans = null;
		for (String key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				ans = key;
			}
		}

		return ans;
	}
}
