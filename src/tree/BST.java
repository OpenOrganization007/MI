package tree;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Comparator;

public class BST<T> {

        private static class Node<T> {
                private Node<T> left, right;
                private T data;

                public Node(T data, Node<T> left, Node<T> right) {
                        this.left = left;
                        this.right = right;
                        this.data = data;
                }

        }

        private Node<T> root;
        private int n;
        private Comparator<T> comparator;

        public BST(Comparator<T> comp) {
                assert comp != null;

                this.n = 0;
                this.root = null;
                this.comparator = comp;
        }

        public void insert(T item) {
                if (item == null)
                        return;

                if (root == null) {
                        Node<T> node = new Node<T>(item, null, null);
                        root = node;
                        root.left = null;
                        root.right = null;
                } else {
                        insert(item, root);
                }
                n++;
        }

        private void insert(T item, Node<T> root) {
                int res = comparator.compare(item, root.data);
                if (res > 0) {
                        if (root.right == null) {
                                Node<T> node = new Node<T>(item, null, null);
                                root.right = node;
                        } else {
                                insert(item, root.right);
                        }
                } else {
                        if (root.left == null) {
                                Node<T> node = new Node<T>(item, null, null);
                                root.left = node;
                        } else {
                                insert(item, root.left);
                        }
                }

        }

        public void displayPreOrder() {
                displayPreOrder(root);
        }

        private void displayPreOrder(Node<T> root) {
                if (root == null)
                        return;
                System.out.print(root.data +",");
                if (root.left != null) {
                        displayPreOrder(root.left);
                }
                if (root.right != null) {
                        displayPreOrder(root.right);
                }
        }
        
        public void postOrder(){
                displayPost(root);
                
        }

        private void displayPost(Node<T> root){
                if(root == null) return ;
           if(root.left !=null){
                 displayPost(root.left);
           }
           if(root.right != null){
                 displayPost(root.right);
           }
           System.out.print(root.data +",");
        }
        public void inOrder(){
                displayInorder(root);
        }
        private void displayInorder(Node<T> root){
                if(root == null) return ;
                if(root.left !=null){
                        displayInorder(root.left);
                }
                System.out.print(root.data +",");
                if(root.right !=null){
                        displayInorder(root.right);
                }
        }
        
	public void searchItem(T item) {
		if (root == null)
			return;
		T data = search(root, item);
		if (data != null)
			System.out.println(data + " is found");
		else
			System.out.println("item not found");
	}
        private T search(Node<T> root , T item){
                T itemData = null;
                if(item == null || root.data == item)
                	itemData = item ;
                else{
                int res = comparator.compare(item, root.data);
                if(res > 0){
                	if(root.right != null && root.data != item)
                	return search(root.right, item);
                }else{
                	if(root.left != null && root.data != item)
                	return search(root.left, item);
                }
                }
                
              
      return itemData;
        }
        
        public Node getSuccessor(T item){
        	Node temp = root;
        	Node parent = root;
        	while(temp.data != item){
        		parent = temp;
        		if(comparator.compare(item, (T) temp.data) > 0){
        			temp = temp.right;
        		}else{
        			temp = temp.left;
        		}
        	}
         if(temp.right != null){
        	 return minimum(temp.right);
         }else if(comparator.compare((T) parent.data, (T)temp.data) > 0){
        	return parent;
         }
        	
        	return null;
        }
        
        private Node minimum(Node temp){
        	while(temp.left != null){
        		temp = temp.left;
        	}
        	return temp;
        	
        }
        /**
         * @param args
         */
        public static void main(String[] args) {
                int[] testCase = { 10, 6, 4, 8, 12, 11, 15,9};

                BST<Integer> tree = new BST<Integer>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer a, Integer b) {
                                if (a != null && b != null) {
                                        return a - b;
                                } else if (a != null && b == null) {
                                        return a;
                                } else if (a == null && b != null) {
                                        return b;
                                }
                                return 0;
                        }
                });
                for (int i = 0; i < testCase.length; i++) {
                        tree.insert(testCase[i]);
                }
              /*  System.out.print("pre order :");
                tree.displayPreOrder();
                System.out.println();
                System.out.print("post order :");
                tree.postOrder();
                System.out.println();*/
                System.out.print("in order :");
                tree.inOrder();
                System.out.println("successor is "+tree.getSuccessor(9).data);
             /*   System.out.println();
                
                	System.out.println("Enter item to be search in tree");
                	DataInputStream dis = new DataInputStream(System.in);
                	Integer option = null;
                	try {
						 option = Integer.parseInt(dis.readLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
              
              //  tree.searchItem(option);
*/                

        }

}