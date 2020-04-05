package 과제;

public class main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DList<String> s = new DList<String>(); // 이중 연결 리스트 객체 s생성
		
		s.insertAfter(s.head, "apple");
		s.insertBefore(s.tail, "orange");
		s.insertBefore(s.tail, "cherry");
		s.insertAfter(s.head.getNext(), "pear");
		s.print();
		System.out.println();
		
		s.delete(s.tail.getPrevious());
		s.print();
		System.out.println();
		
		s.insertBefore(s.tail, "grape");
		s.print();
		System.out.println();
		
		s.delete(s.head.getNext());
		s.print();
		s.delete(s.head.getNext());
		s.print();
		s.delete(s.head.getNext());
		s.print();
		s.delete(s.head.getNext());
		s.print();
		
		
	}

}
