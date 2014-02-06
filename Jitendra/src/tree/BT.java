package tree;

import java.util.Comparator;

public class BT<T> {
	private Node root;
	private Comparator comp;
	
	public BT(Comparator<T> comp){
		this.comp = comp;
	}
	
	public boolean add(T x){
	
		Node p = findLast(x);
		return addChild(p,new Node(x));
		
	}
	
	private boolean addChild(Node  p , Node u){
		if(p == null) {
			root = u;
		}else{
			int res = comp.compare(p.data, u.data);
			if(res < 0){
				p.left = u;
			}else if( res > 0){
				p.right = u;
			}else{
				return false; // already exist in tree
			}
			u.parent = p;
		}
		return true;
	}
	
	private Node findLast(T x){
		Node w = root , prev = null;
		while(w != null){
			prev = w;
			int res = comp.compare(x, w.data);
			if(res > 0){
				w = w.right;
			}else if(res < 0){
				w = w.left;
			}else{
				return w;
			}
		}
		return prev;
	}
	
	public T find(T x){
		Node w = root ,z = null;
		while(w != null){
			int res = comp.compare(x, w.data);
			
			if(res > 0){
				w = w.right;
			}else if(res < 0){
				z= w;
				w = w.left;
			}else{
				return (T) w.data;
			}
		}
		return (T) (z == null? null:z.data);
	}
	
	public void print(){
		TreePrinter.printNode(root);
	}

	public static void main(String[] args) {
		BT<Integer> tree = new BT<Integer>( 
		new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 != null && o2 != null) {
					return o1 - o2;
				}
				if (o1 != null && o2 == null) {
					return o1;
				}
				if (o1 == null && o2 != null) {
					return o2;
				}
				return 0;
			}
		});
			int[] test = { 13, 4, 5, 56, 6, 7, 2, 14, 12 };
			for(int i : test){
				tree.add(i);
			}
			
			tree.print();

	}

}
