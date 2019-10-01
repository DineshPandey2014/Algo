  class TreeNode
        {
            int val;
            TreeNode left_ptr;
            TreeNode right_ptr;

            TreeNode(int _val)
            {
                val = _val;
                left_ptr = null;
                right_ptr = null;
            }
        }
        
        
        public TreeNode createBST(int a []) {
        	buildBST(a, 0, a.length-1);
        }
        
        TreeNode buildBST(int a[], int start, int end) {
        	
        	int mid = (start + end)/2
        	
        	if(start > end) {
        		return;
        	}
        	
        	TreeNode node = new TreeNode(a[mid]);
        	node.left_ptr = buildBST( a, start, mid - 1,  node.left_ptr);
        	node.right_ptr = buildBST(a, mid+1, end, node.right_ptr);
        	return node;
        
        }
        
        
        
        static TreeNode build_balanced_bst(int[] a) 
    {
       return buildBST(a, 0, a.length-1);
    }
    
   static TreeNode buildBST(int a[], int start, int end) {
        
        int mid = (start + end)/2;
        
        if( start > end) {
            return null;
        }
        
        TreeNode node = new TreeNode(mid);
        node.left_ptr = buildBST(a, start, mid-1);
        node.right_ptr = buildBST(a, mid + 1, end);
        return node;
    }
    
    
    static TreeNode buildBST(int[] a, int left , int right) {
        if (left > right) {
            return null;
        }
        
        int midElement = (left + right)/2;
        TreeNode node = new TreeNode(a[midElement]);
        node.left_ptr = buildBST(a, left , midElement -1);
        node.right_ptr = buildBST(a,  midElement +1, right);
        return node;
    }