//二叉查找树（二叉搜索树）即对于任一节点，其左子树的key值<=该节点的key值，其右子树的key值>=该节点的key值
public class BinarySearchTree<T extends Comparable<T>>{
	//根节点
	BstNode<T> mRoot; 
	//定义节点内部类
	public class BstNode<T extends Comparable>{
		T key;				//键值（节点值）
		BstNode<T> left;	//左孩子
		BstNode<T> right;	//右孩子
		BstNode<T> parent; 	//父节点
	//节点构造方法
	public BstNode(T key,BstNode<T> parent,BstNode<T> left,BstNode<T> right){
		this.key=key;
		this.parent=parent;
		this.left=left;
		this.right=right;
		}	
	public T getKey(){
		return key;
	}
	public String toString(){
		return "key:"+key;
	}
	}
	//二叉树构造方法
	public BinarySearchTree(){
		mRoot=null;
	}

	//前序遍历二叉树
	private void preTree(BstNode<T> tree){
		if (tree!=null) {
			System.out.print(tree.key+" ");
			preTree(tree.left);
			preTree(tree.right);
		}
	}
	public void preTree(){
		preTree(mRoot);
	}
	//中序遍历二叉树
	private void midTree(BstNode<T> tree){
		if (tree!=null) {
			midTree(tree.left);
			System.out.print(tree.key+" ");
			midTree(tree.right);
		}
	}
	public void midTree(){
		midTree(mRoot);
	}
	//后序遍历
	private void postTree(BstNode<T> tree){
		if (tree!=null) {
			postTree(tree.left);
			postTree(tree.right);
			System.out.print(tree.key+" ");
		}
	}
	public void postTree(){
		postTree(mRoot);
	}
	//递归查找关键字key
	private BstNode<T> search(BstNode<T> tree,T key){
		if (tree==null) {
			return null;
		}
		int cmp = key.compareTo(tree.key);
		if (cmp<0) {
			return search(tree.left,key);
		}else if(cmp>0){
			return search(tree.right,key);
		}
		return tree;
	}
	public BstNode<T> search(T key){
		return search(mRoot,key);
	}
	//非递归的方法查找关键字key
	private BstNode<T> iteratorSearch(BstNode<T> tree,T key){
		while(tree!=null){
			int cmp = key.compareTo(tree.key);
			if (cmp<0) {
				return iteratorSearch(tree.left,key);
			}else if (cmp>0) {
				return iteratorSearch(tree.right,key);
			}
			return tree;
		}
		return tree;
	}
	public BstNode<T> iteratorSearch(T key){
		return iteratorSearch(mRoot,key);
	} 
	//查找最小节点
	private BstNode<T> minBstNode(BstNode<T> tree){
		if (tree==null) 
			return null;
		while(tree.left!=null)
			tree = tree.left;
		return tree;
	}
	public T minBstNode(){
		BstNode<T> min = minBstNode(mRoot);
		if (min!=null) {
			return min.key;
		}
		return null;
	}
	//查找最大节点
	private BstNode<T> maxBstNode(BstNode<T> tree){
		if (tree==null) 
			return null;
		while(tree.right!=null)
			tree = tree.right; 
		return tree;
	}
	public T maxBstNode(){
		BstNode<T> max = maxBstNode(mRoot);
		if (max!=null) {
			return max.key;
		}
		return null;
	}
	//插入节点。插入一开始感觉比较吃力，调试了好多次才成功。
	private void insert(BinarySearchTree<T> tree,BstNode<T> node){
		int cmp;
		BstNode<T> x = tree.mRoot;
		BstNode<T> y = null;
		//查找node的插入位置
		 while (x != null) {
		        y = x;
		        cmp = node.key.compareTo(x.key);
		        if (cmp < 0)
		            x = x.left;
		        else
		            x = x.right;
		    }
		 //此刻y即为node节点需要插入的位置
		    node.parent = y;
		    if (y==null)
		        tree.mRoot = node;
		    else {
		        cmp = node.key.compareTo(y.key);
		        if (cmp < 0)
		            y.left = node;
		        else
		            y.right = node;
		    }
	}
	//插入key值，创建新节点
	public void insert(T key){
		BstNode<T> node = new BstNode<T>(key,null,null,null);
		if (node!=null) {
			insert(this,node);
		}
		return;
	} 
	//销毁树
	private void destroy(BstNode<T> tree){
		if (tree==null) {
			return;
		}
		if (tree.left!=null) {
			destroy(tree.left);
		}
		if (tree.right!=null) {
			destroy(tree.right);
		}
		tree=null;
	}
	public void clear(){
		destroy(mRoot);
		mRoot = null;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,8,7,6,5};
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for (int i=0;i<arr.length ;i++ ) {
			bst.insert(arr[i]);
		}
		//前序遍历
		bst.preTree();
		System.out.println();
		//后序遍历
		bst.midTree();
		System.out.println();
		//后序遍历
		bst.postTree();
		System.out.println();
		System.out.println(bst.maxBstNode());
		System.out.println(bst.minBstNode());
		System.out.println(bst.search(4));
		bst.clear();
	}
}
