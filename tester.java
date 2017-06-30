import java.util.ArrayList;
import java.util.Comparator;

public class tester {
	public static void main(String args[]){
		Integer values[] = {-19, 12, 1, 100, 10000, -1000, 2, 9, 888, 15, 189};
		
		Comparator <Integer> int_comp = new Comparator(){
			public int compare(Object a, Object b){
				// Max heap return -((Integer) a - (Integer) b);
				// Min heap return (Integer) a - (Integer) b;
				return -((Integer) a - (Integer) b);
			} 
		};
		
		MyHeap <Integer> mh = new MyHeap<Integer>(values, int_comp);
		
		System.out.println(mh);
		
		for (int i = 0; i < values.length; i++){
			System.out.println(mh.pop());
		}
	}
}
