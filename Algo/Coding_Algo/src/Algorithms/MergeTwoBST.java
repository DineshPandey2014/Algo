

public void mergeTwoList(List<Integer> listOne, List<Integer> listTwo, List<Integer> listThree) {
	
	int l1 = one.length;
	int l2 = two.length;
	int i = 0;
	int j = 0;
	
	 while(i < l1 && j < l2) {
	  if(listOne[i] >= listTwo[j]) {
	  	listThree.add(listOne[i]);
	  	i++;
	  } else {
	  	listThree.add(listTwo[j]);
	 	 j++;
	  }
	 }
	 
	 while( i < l1 ) {
	  	listThree.add(listOne[i]);
	  	i++;
	 }
	 
	 while(j < l2) {
	 	listThree.add(listTwo[j]);
	  	j++;
	 }
	
}

public void inOrderTraversal(Node n1, List<Integer> list) {
	if(n1 == null) {
		return;
	}
	
	inOrderTraversal(n1.left,list);
	list.add(n1.data);
	inOrderTraversal(n1.right,list);
	
}


public void CreateBSTFromSortedOrder(List<Integer) list ) {

int size = list.size() - 1;


buidBST(List<Integer> list, mid) 
{
buildBST(list, 0, list.size()-1);
  
}


 public Node buildBST(list, int start, int end) {
 	if(start > mid) {
 		return;
 	}
 	
 	int mid = (start + end)/2;
 	
 	Node node = new Node(list.get(mid));
 	
 	node.left = buildBST(list, mid -1, end);
 	node.right = buildBST(list, mid + 1, end);
 	return Node;
 	
 }