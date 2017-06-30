import java.util.ArrayList;
import java.util.Comparator;

public class MyHeap <T extends Comparable<T>> {
	private static final int INITIAL = 32;
	private ArrayList<T> heap;
	private int size; 
	private Comparator <T> comp;
	
	public MyHeap(Comparator <T> comp){
		this.comp = comp;
		
		heap = new ArrayList<T>();
		size = 0;
	}
	
	public MyHeap(T value, Comparator <T> comp){
		this.comp = comp;
		
		heap = new ArrayList <T>();
		heap.add(value);
		
		size = 1;
	}
	
	public MyHeap(T[] values, Comparator <T> comp){
		this.comp = comp;
		
		heap = new ArrayList <T>();
		
		size = 0;
		for (T value : values){
			heap.add(size, value);
			size++;
		}
		
		for (int s = size - 1; s >= 0; s--){
			percolateDown(s);
		}
	}
	
	public void insert(T value) {
		heap.add(size, value);
		percolateUp(size);
		size++;
	}
	
	public T peek(T value) {
		return heap.get(0);
	}
	
	public T pop(){
		if (size <= 0){
			return null;
		}
		
		T to_return = heap.get(0);
		T temp = heap.get(size - 1);
		heap.set(size - 1, null);
		heap.set(0, temp);
		size --;

		percolateDown(0);
		
		return to_return;
	}
	
	private void percolateDown(int index) {
		while (true) {
			int child_1 = (int) (index * 2 + 1);
			int child_2 = (int) (index * 2 + 2);
		
			if (child_2 >= size){
				child_2 = child_1;
			}
			
			if (child_1 >= size){
				return; 
			}
			
			// Get min
			int min_idx;
			if (comp.compare(heap.get(child_1), heap.get(child_2)) < 0){
				min_idx = child_1;
			}else{
				min_idx = child_2;
			}
		
			if (comp.compare(heap.get(min_idx), heap.get(index)) < 0){
				T temp = heap.get(index);
				heap.set(index, heap.get(min_idx));
				heap.set(min_idx, temp);
			}
			
			index = min_idx;
		}
	}
	
	
	private void percolateUp(int index){
		while (true){
			int parent = (int) Math.floor((index - 1)/2.); 
		
			if (parent < 0){
				return ;
			}
				if (comp.compare(heap.get(index), heap.get(parent)) < 0){
					T temp = heap.get(index);
					heap.set(index, heap.get(parent));
					heap.set(parent, temp); 
				}else{
					return ;
				}
			
			index = parent;
		}
	}
	
	public String toString(){
		String build = "";
		for (T node : heap){
			if (node == null){
				build += "NULL ";
			}else{
			build += node.toString() + " ";
			}
		}
		
		return build;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return (size == 0);}
}
