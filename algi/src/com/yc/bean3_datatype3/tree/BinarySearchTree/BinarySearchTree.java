package com.yc.bean3_datatype3.tree.BinarySearchTree;

/**
 * ����������
 *
 *void insert( x)
 *void remove( x)
 *Comparable  find( x)
 *Comparable findMin()
 *Comparable findMax()
 *boolean isEmpty()
 *void makeEmpty()
 *void printTree()
 */
public class BinarySearchTree {
	private BinaryNode root;
	
	public BinarySearchTree(){
		this.root=null;
	}
	
	/**
	 * �ж��Ƿ�Ϊ����
	 */
	public boolean isEmpty(){
		return root==null;
	}
	
	/**
	 * �����ÿ�
	 */
	public void makeEmpty(){
		root=null;
	}
	
	/**
	 * �������е����ֵ
	 * @return
	 */
	public Comparable findMax(){
		BinaryNode maxNode=findMax( root  );
		return maxNode.element;
	}
	/**
	 * ���ڵݹ�������������ֵ�ķ���.  ���ֵ���ڵĽڵ���ص�: ����ڵ���û���ҽڵ��
	 * @param t:Ҫ���ҵ�����
	 * @return:���ֵ���ڵĽڵ�
	 */
	private BinaryNode findMax(  BinaryNode t  ){
		if(t!=null){
			while(t.right!=null){
				t=t.right;
			}
		}
		return t;
	}
	
	/**
	 * �������е���Сֵ
	 * @return
	 */
	public Comparable findMin(){
		BinaryNode minNode=findMin( root  );
		return minNode.element;
	}
	/**
	 * ���ڵݹ������������Сֵ�ķ���.  ��Сֵ���ڵĽڵ���ص�: ����ڵ���û����ڵ��
	 * @param t:Ҫ���ҵ�����
	 * @return:��Сֵ���ڵĽڵ�
	 */
	private BinaryNode findMin(  BinaryNode t  ){
		if(t!=null){
			while(t.left!=null){
				t=t.left;
			}
		}
		return t;
	}
	
	
	/**
	 * ����Ԫ�������еĽڵ��Ԫ��
	 */
	public Comparable  find(  Comparable element  ){
		BinaryNode node=find(    element, root);
		return node==null?null:node.element;
	}
	private BinaryNode find(  Comparable element, BinaryNode t  ){
		if( t==null){
			return null;
		}
		if(   element.compareTo(t.element)<0  ){
			return find( element, t.left );   //���element�ȵ�ǰ��t�ڵ��elementֵС�����������
		}else if( element.compareTo(t.element)>0){
			return find( element,t.right);
		}else{
			return t;
		}
	}
	
	/**
	 * ��Ӳ���: 1.����Ҫ��ӵ�λ��     2. ��ӽ�ȥ
	 */
	public void insert( Comparable element){
		root=insert( element,root);
	}
	//���������ǲ����ظ�.  
	private BinaryNode insert(Comparable element, BinaryNode root) {
		// ��������Ϊ�ա������ȵ������ɸ���㡣
		if( root==null ){
			root=new BinaryNode( element, null, null);
		}else if(  element.compareTo(root.element)<0  ){    //���ǿ���������Ҫ��ӵ�����������������
			BinaryNode newNode=insert( element,root.left);
			root.left=newNode;
		}else if(  element.compareTo(root.element)>0){
			BinaryNode newNode=insert( element,root.right);
			root.right=newNode;
		}
		return root;
	}
	
	/**
	 * ɾ������:   1. ��λ��
	 */
	public void remove( Comparable element){
		root=remove( element, root);
	}

	private BinaryNode remove(Comparable element, BinaryNode root) {
		if( root==null){
			return root;
		}
		if(   element.compareTo(root.element)<0){
			BinaryNode newNode=remove( element, root.left);
			root.left=newNode;
		}else if( element.compareTo(root.element)>0){
			BinaryNode newNode=remove( element,root.right);
			root.right=newNode;
		}else if(   root.left!=null&& root.right!=null    ){     //root�ǵ�ǰҪɾ���Ľڵ�,��������������������Ϊ��
			//���������в�����С��ֵ
			root.element=(findMin(   root.right )).element;
			root.right=remove(  root.element, root.right );
		}else{
			root=root.left!=null?root.left:root.right;
		}
		return root;
	}
	
	public void printTree(){
		printTree( this.root );
	}
	
	/**
	 * �����ӡ
	 */
	private void printTree(   BinaryNode root    ){
		if(root!=null){
			printTree( root.left );
			System.out.println(  root.element );
			printTree( root.right);
		}
	}
	
	
	public static void main(String[] args){
		BinarySearchTree root=new BinarySearchTree();
		root.insert(3);
		root.insert(4);
		root.insert(10);
		
		root.insert(15);
		root.insert(15);
		
		root.insert(1);
		
		root.insert(7);
		root.insert(11);
		root.insert(12);
		root.insert(14);
		root.insert(9);
	
		root.insert(6);
	
	
		root.printTree();
		
		root.remove(12);
		root.printTree();
		
	}
	
	
	
	
	
}
