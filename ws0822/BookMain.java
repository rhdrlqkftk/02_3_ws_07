package com.ssafy.bms;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	Scanner s = new Scanner(System.in);
	IBookMgr mgr = BookMgrImpl.getInstance();

	public static void main(String[] args) {
		BookMain m = new BookMain();
		m.load();
		int num = 0;
		while (true) {
			num = m.menu();
			if (num == 0)
				break;
			switch (num) {
			case 1:
				m.insert();
				break;
			case 2:
				m.search();
				break;
			case 3:
				m.searchIsbn();
				break;
			case 4:
				m.searchTitle();
				break;
			case 5:
				m.update();
				m.search();
				break;
			case 6:
				m.delete();
				m.search();
				break;
			case 7:
				m.save();
				break;
			case 8:
				m.load();
				m.search();
				break;
			case 9:
				m.sortIsbn();
				break;
			case 10:
				m.countWord();
				break;
			}// end switch

		} // end while
	}

	public int menu() {
		int result = 0;
		System.out.println("==================================");
		System.out.println("========== 도서 관리 프로그램 ===========");
		System.out.println("==================================");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 보기");
		System.out.println("3. 도서 검색(ISBN으로 검색)");
		System.out.println("4. 도서 검색(도서명으로 검색)");
		System.out.println("5. 도서 수정");
		System.out.println("6. 도서 삭제");
		System.out.println("7. 도서 정보 파일 저장");
		System.out.println("8. 도서 정보 파일로 부터 읽어오기");
		System.out.println("9. ISBN으로 정렬해서 목록보기");
		System.out.println("10.도서명 중 가장 빈도수 높은 단어 구하기");
		System.out.println("0. 종료");
		System.out.println("원하는  번호를 선택 하세요.");
		result = s.nextInt();
//		result = Integer.parseInt(s.nextLine());
		return result;

	}

	public void print(List<Book> bbs) {
		for (Book bb : bbs) {
			System.out.println(bb);
		}
	}

	public void insert() {
		System.out.println("도서 정보를 입력하세요. 형식:ISBN,도서명,저자,금액");
		s.nextLine();
		String[] info = s.nextLine().split(",");

		// 구현하세요.
		try {
			mgr.add(new Book(info[0].trim(), info[1].trim(), info[2].trim(), Integer.parseInt(info[3].trim())));
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (DuplicateException e) {
			System.out.println(e);
		}
	}

	public void search() {
		System.out.println(">>>>>>>>  도서 목록 보기 ");

		// 구현하세요.
		print(mgr.search());
	}

	public void searchIsbn() {
		System.out.println(">>>>>>>>  도서  검색 (ISBN으로 검색) ");
		System.out.println("검색하고자하는 ISBN을 입력하세요.");
		s.nextLine();
		String isbn = s.nextLine();

		// 구현하세요.
		try {
			System.out.println(mgr.search(isbn));
		} catch (RecordNotFoundException e) {
			System.out.println(e);
		}
	}

	public void searchTitle() {
		System.out.println(">>>>>>>>  도서  검색 (이름으로 검색) ");
		System.out.println("검색하고자하는 이름을 입력하세요.");
		s.nextLine();
		String title = s.nextLine();

		// 구현하세요.
		print(mgr.searchTitle(title));
	}

	public void update() {
		System.out.println(">>>>>>>>  도서  수정 ");
		System.out.println("수정하고자하는 ISBN,가격을 입력하세요.");
		s.nextLine();
		String[] info = s.nextLine().split(",");

		// 구현하세요.
		try {
			mgr.update(info[0].trim(), Integer.parseInt(info[1]));
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (RecordNotFoundException e) {
			System.out.println(e);
		}
	}

	public void delete() {
		System.out.println(">>>>>>>>  도서  삭제 ");
		System.out.println("삭제하고자하는 ISBN을 입력하세요.");
		s.nextLine();
		String isbn = s.nextLine();

		// 구현하세요.
		try {
			Book bb = mgr.search(isbn);
			mgr.delete(isbn);
			System.out.println(bb.getTitle() + "도서가 삭제 되었습니다.");
		} catch (RecordNotFoundException e) {
			System.out.println(e);
		}
	}

	public void save() {
		System.out.println(">>>>>>>>  도서  정보 저장 ");

		// 구현하세요.
		mgr.save();
		System.out.println(mgr.search().size() + "개 정보를 저장했습니다.");

	}

	public void load() {
		System.out.println(">>>>>>>>  도서  정보 읽어오기 ");

		// 구현하세요.
		mgr.load();
		System.out.println("읽기 완료");
	}

	public void sortIsbn() {
		System.out.println(">>>>>>>>  도서ISBN로 정렬하기 ");

		// 구현하세요.
		print(mgr.sortIsbn());
	}

	public void countWord() {
		System.out.println(">>>>>>>>  빈도수 높은 단어 구하기 ");

		// 구현하세요.
		System.out.println(mgr.countWord());
	}
	/*
	 * public void sortTitle() { System.out.println(">>>>>>>>  도서이름로 정렬하기 ");
	 * List<Book> bs=mgr.sortTitle(); for(Book e: bs) { System.out.println(e); } }
	 */
}
