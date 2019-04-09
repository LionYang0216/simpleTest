package linkList;

import java.util.ArrayList;
import java.util.Iterator;  
import java.util.LinkedList; 

public class LinkListTest {
	
	public static void main(String[] args) {  
		
		ArrayList aList = new ArrayList(4);
		
		aList.add(1);
		System.out.println("aList-------------------"+aList.get(1));
		
		LinkedList<Object> list= new LinkedList<Object>();  
	    list.add("张三");  
	    list.add("李四");  
	    list.add("王五");  
	/* 
	    list.addFirst("首位"); //把元素添加到集合的首位置上。 
	    list.addLast("结尾");  //把元素添加到集合的末尾处。 
	     

	    System.out.println("获取集合中首位置的元素:"+list.getFirst()); 
	    System.out.println("获取集合中末尾的元素："+ list.getLast()); 
	 
	    System.out.println("删除集合中的首位置元素并返回："+ list.removeFirst()); 
	    System.out.println("删除集合中的末尾素并返回："+ list.removeLast()); 
	         
	     
	    list.push("首位");   //将该元素插入此集合的开头处。  
	    System.out.println("删除集合的首元素："+list.pop()); // 移除并返回集合中的第一个元素  

	     
	    list.offer("结尾"); 
	    System.out.println("删除集合的首元素: "+list.poll()); 
	 
	    System.out.println("集合中的元素："+ list); 
	    */    
	    Iterator<Object>  it = list.descendingIterator();  
	    while(it.hasNext()){  
	        System.out.println(it.next());  
	    }  
	}
	
	
      

}
