package com.yc.bean3_datatype3.tree.BinarySearchTree;

//����������Ľ��
//�����ǹ��У��ǰ�Ȩ�ޣ�ֻ���ڱ����б�����
 class BinaryNode {
	//������������������������Ҫ��ڵ��е�Ԫ�ض��ǿ��ԱȽϵġ� 
	Comparable element;    
	BinaryNode left;   //��ڵ�
	BinaryNode right;  //�ҽڵ�
	
	BinaryNode( Comparable element){
		this( element,null, null);
	}
	
	BinaryNode( Comparable element, BinaryNode left, BinaryNode right){
		this.element=element;
		this.left=left;
		this.right=right;
	}

	@Override
	public String toString() {
		return "BinaryNode [element=" + element + ", left=" + left + ", right="
				+ right + "]";
	}
	
	
}
