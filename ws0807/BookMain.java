package com.ssafy.edu.ws;

import java.util.List;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		BookMain m=new BookMain();
		m.open();
		int num=0;
	      while(true) {
	         num=m.menu();
	         if(num==0) {
	        	m.save(); 
	        	break;
	         }
	         switch (num){
	            case 1:
	               m.add();
	               break;
	            case 2:
	               m.search();
	               break;
	            case 3:
	               m.searchByISBN();
	               break;
	            case 4:
	               m.searchByTitle();
	               break;
	            case 5:
	               m.sell();
	               break;
	            case 7:
	               m.save();
	               break;
	            case 8:
	               m.open();
	               break;
	            case 11:
		               m.send();
		               break;
		   }
	
		}
	}
	
	private void send() {
		System.out.println(">>>>>>>>  서버로 책 보내기 ");
	    bmgr.send();
	}

	public void sell() {
		System.out.println(">>>>>>>>  책 판매 ");
	    System.out.println("책 판매 정보를 입력하세요. 형식:isbn,수량");
	    String ss=s.nextLine();
	    String[] tt=ss.split(",");
	    try {
			bmgr.sell(tt[0], Integer.parseInt(tt[1]));
		} catch (NumberFormatException e) {
			System.out.println("잘못된 형식을 입력하셨습니다. ");
			System.out.println("책 판매 정보를 입력하세요. 형식:isbn,수량");
		} catch (QuantityException e) {
			System.out.println(e.getMessage());
		} catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	BookMgrImpl bmgr=BookMgrImpl.getInstance();
	Scanner s=new Scanner(System.in);
	
	public  int menu() {
      int result=0;
      System.out.println("==================================");
      System.out.println("========== 책관리 프로그램 ===========");
      System.out.println("==================================");
      System.out.println("1. 책 등록");
      System.out.println("2. 책목록 보기");
      System.out.println("3. 책 검색(ISBN으로 검색)");
      System.out.println("4. 책 검색(제목으로 검색)");
      //...
      System.out.println("7. 책 정보 파일 저장");
      System.out.println("8. 책 정보 파일로 부터 읽어오기");
      System.out.println("0. 종료");
      System.out.println("원하는 번호를 선택 하세요.");
      result=Integer.parseInt(s.nextLine());
      return result;
    }
    public void open() {
    	bmgr.open();
    }
    public  void save() {
		bmgr.close();
	}
	public void add() {
	   System.out.println(">>>>>>>>  책 등록 ");
       System.out.println("책 정보를 입력하세요. 형식:isbn,제목,가격,수량");
       String ss=s.nextLine();
       //007,철수야 놀자,12000,20
       String[] sss=ss.split(",");
       bmgr.add(new Book(sss[0].trim(),sss[1].trim(),
    		   Integer.parseInt(sss[2].trim()), 
    		   Integer.parseInt(sss[3].trim())));
       //... 구현하세요.
    }
    public void search() {
       System.out.println(">>>>>>>>  책목록 보기 ");
       print(bmgr.search());
    }
    public   void print(List<Book> lt) {
		for (Book t: lt) {
			System.out.println(t);
		}
	}
    public void searchByISBN() {
       System.out.println(">>>>>>>>  책 검색 (isbn으로 검색) ");
       System.out.println("검색하고자하는 isbn을 입력하세요.");
       String isbn=s.nextLine();
       Book bbb=bmgr.searchByIsbn(isbn);
       if(bbb!=null) {
    	   System.out.println(bbb); 
       }else {
    	   System.out.println("없는  isbn입니다.");
       }
       
    }
    public void searchByTitle() {
       System.out.println(">>>>>>>>  책 검색 (제목으로 검색) ");
	   System.out.println("검색하고자하는 제목을 입력하세요.");
	   String title=s.nextLine();
	   print(bmgr.searchByTitle(title));
    }
}
