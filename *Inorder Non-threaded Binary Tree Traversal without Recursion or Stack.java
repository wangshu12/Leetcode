public void inorder(Node root){
	boolean finishLeft = false;
	while(root != null){
		if(!finishLeft){
			while(root.left != null){
				root = root.left;
			}
		}
		finishLeft = true;

		if(root.right != null){
			root = right;
			finishLeft = false;
		}else{
			while(root.parent != null && root == root.parent.right){
				root = root.parent;
			}

			if(root.parent == null){
				break;
			}
			root = root.parent;
		}
	}
}