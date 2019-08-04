package com.ssafy.edu.ws;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	static BookMgrImpl bmgr=BookMgrImpl.getInstance();
	static Scanner s=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		BookMain m=new BookMain();
		int num=0;
	      while(true) 
	      {
	         num=m.menu();
	         if(num==0) break;
	         switch (num)
	         {
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
	            case 5: //  sell //그 이름에 숫자를 더 해준다. 
	               m.sell();
	               break;	               
	            case 6: //  buy
	            	m.buy();
	            	break;
	            case 7: // 책 정보 파일 저장. 
	            	bmgr.close(); 
	            	break;	            
	            case 8: //  책정보 읽어보기.
	            	bmgr.open(); 
	            	break;
	            case 0:
	            	System.exit(0);
	            	break; 
		   }
		}
	}

	
	public  int menu() 
	{
	      int result=0;
	      System.out.println("==================================");
	      System.out.println("========== 책관리 프로그램 ===========");
	      System.out.println("==================================");
	      System.out.println("1. 책 등록");
	      System.out.println("2. 책목록 보기");
	      System.out.println("3. 책 검색(ISBN으로 검색)");
	      System.out.println("4. 책 검색(제목으로 검색)");
	      System.out.println("5. 책 SELL");
	      System.out.println("6. 책 BUY");
	      //...
	      System.out.println("7. 책 정보 파일 저장");
	      System.out.println("8. 책 정보 파일로 부터 읽어오기");
	      System.out.println("0. 종료");
	      System.out.println("원하는 번호를 선택 하세요.");
	      result = s.nextInt();
	      return result;
	   }
		public void add() {
	       System.out.println("책 정보를 입력하세요. 형식:isbn,제목,가격,수량");
	       //... 구현하세요.
	       s.nextLine();
	       String ss  = s.nextLine();       
	       String[] sss= ss.split(",");//007, 철수야 놀자, 12000, 20
	       bmgr.add(new Book(sss[0].trim(),sss[1].trim(), Integer.parseInt(sss[2].trim()) , Integer.parseInt(sss[3].trim())));
	       
	    }
	    public void search() {
	       System.out.println(">>>>>>>>  책목록 보기 ");
	       print(bmgr.search());
	    }
	    public void print(List<Book>lt)
	    {
	    	for( Book t : lt)
	    	{
	    		System.out.println(t);
	    	}
	    }
	    
	    
	    public void searchByISBN()
	    {
	       System.out.println(">>>>>>>>  책 검색 (isbn으로 검색) ");
	       System.out.println("검색하고자하는 isbn을 입력하세요.");
	       //구현하세요
	       String isbn = s.nextLine(); 
	       Book bbb= bmgr.searchByIsbn(isbn);
	       if( bbb != null)
	       {
	    	   System.out.println(bbb);
	       }
	       else
	       {
	    	   System.out.println("존재하지 않습니다.!");
	       }
	    }
	    public void searchByTitle() {

	    	 System.out.println(">>>>>>>>  책 검색 (제목으로 검색) ");
		     System.out.println("검색하고자하는 제목을 입력하세요.");
		     String title = s.nextLine(); 
		     List<Book> bbb= bmgr. searchByTitle(title);
		     for( Book z : bbb)
		     {
		    	 if (z!= null) 
			     {
			    	 System.out.println(z);
			     } 
			     else 
			     {
			    	 System.out.println("존재하지 않습니다.!");
			     } 
		     }
		     
	    }
	    
	    public void sell() {
	    	System.out.println(" SELL입니다. ");
	    	System.out.println(" 형식(책번호, 수량)으로 넣어주세요!");
	    	String ss = s.nextLine();
	    	String[] sss = ss.split(",");// 007, 철수야 놀자, 12000, 20
	    	try {
	    		bmgr.sell(sss[0].trim(), Integer.parseInt(sss[1].trim()));
	    	} catch (QuantityException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	} catch (ISBNNotFoundException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    }
	    public void buy()
	    {
	    	 System.out.println(" BUY입니다. ");
	    	 System.out.println(" 형식(책번호, 수량)으로 넣어주세요!");
	    	 String ss = s.nextLine();
		     String[] sss = ss.split(",");
	    	 try {
				bmgr.buy(sss[0].trim(), Integer.parseInt(sss[1].trim()));
			} catch (ISBNNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
}
