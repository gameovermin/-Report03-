package 과제5주차;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree<Key extends Comparable<Key>> {

	private BTNode<Integer> root;
	public BinaryTree() {
		root = null;	//트리 생성자
	}
	public BTNode<Integer> getRoot(){
		return root;
	}
	public void setRoot(BTNode<Integer> newRoot) {
		root = newRoot;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public void inorder(BTNode<Integer> n) { // 중위 순회
		if(n != null) {
			inorder(n.getLeft());  // n의 왼쪽 서브 트리를 순회하기 위해
			System.out.print(n.getKey()+" ");  // 노드 n 방문
			inorder(n.getRight());  // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
	public void postorder(BTNode<Integer> n) {  // 후위 순회
		if(n != null) {
			postorder(n.getLeft());  //n의 왼쪽 서브 트리를 순회하기 위해
			postorder(n.getRight());  // n의 오른쪽 서브 트리를 순회하기 위해
			System.out.print(n.getKey()+" "); // 노드 n 방문
		}
	}
	
	public void preorder(BTNode<Integer> n) { //전위 순회
		if(n != null) {
			System.out.print(n.getKey()+" "); // 노드 n 방문
			preorder(n.getLeft());  //n의 왼쪽 서브 트리를 순회하기 위해
			preorder(n.getRight());  // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
	public int size(BTNode<Integer> n) { // n을 루트로하는 (서브)트리에 있는 노드 수
		if(n == null)
			return 0; //null이면 0리턴
		else
			return (1 + size(n.getLeft()) + size(n.getRight()));
	}
	
	public int height(BTNode<Integer> n) { // n을 루트로하는 (서브)트리의 높이
		if(n == null)
			return 0;	// null이면 0 리턴
		else
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}
	
	public static boolean isEqual(BTNode<Integer> n, BTNode<Integer> m) {
		//두 트리의 동일성 검사
		if(n == null || m == null) //둘중에 하나라도 null이면
			return n == m;  //둘다 null이면 true
		if(n.getKey().compareTo(m.getKey()) != 0) //둘다 아니면 item 비교
			return false;
		return (isEqual(n.getLeft(), m.getLeft()) && 
								// item이 같으면 왼쪽/오른쪽 자식으로 재귀 호출
				isEqual(n.getRight(), m.getRight()));
		
	}
	
	public BTNode<Integer> copy (BTNode<Integer> n){
		BTNode<Integer> left, right;
		if(n == null)
			return null;
		else {
			left = copy(n.getLeft());
			right = copy(n.getRight());
			return new BTNode<Integer>(n.getKey(), left, right);
		}
	}
	public void levelorder(BTNode<Integer> root) { // 레벨 순회
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		//큐 자료구조 이용
		BTNode<Integer> t;
		q.add(root);
		while(!q.isEmpty()) {
			t = q.remove(); // 큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey() + " "); // 제거된 노드 출력(방문)
			if(t.getLeft() != null)	//제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());		//큐에 왼쪽 자식 삽입
			if(t.getRight() != null)	//제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());	//큐에 오른쪽 자식 삽입
		}
	}

}
