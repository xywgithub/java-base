//java 实现双向链表
public class DoubleLink<T>{
	//表头
	private Dnode<T> mHead;
	//节点个数
	private int nCount;
	//节点结构体,包含数据，前驱，后继。内部类
	private class Dnode<T>{
		public Dnode<T> pre;
		public Dnode<T> next;
		public T value;
		public Dnode(Dnode<T> pre,Dnode<T> next,T value){
			this.pre=pre;
			this.next=next;
			this.value=value;
		}
	}
	//链表构造函数
	public DoubleLink(){
		//创建表头
		mHead=new Dnode<T>(null,null,null);
		//表头不含数据信息
		mHead.pre=mHead.next=mHead;
		//初始节点个数为0
		nCount=0;
	}
	//返回节点数目
	public int size(){
		return nCount;
	}
	//判断链表是否为空
	public boolean isEmpty(){
		if (nCount==0) {
			return false;
		}
		return true;
	}
	//获取第index位置的节点
	public Dnode<T> getNode(int index){
		if (index<0||index>nCount) {
			throw new IndexOutOfBoundsException();
		}
		//正向查找
		if (index<=nCount/2) {
			Dnode<T> node = mHead.next;
			for (int i=0;i<index ;i++ ) {
				node = node.next;
			}
			return node;
		}
		//反向查找
		Dnode<T> rnode = mHead.pre;
		int rindex = nCount-index-1;
		for (int j=0;j<rindex ;j++ ) {
			rnode = rnode.pre;
		}
		return rnode;
	}
	//获取第index位置节点的值
	public T getValue(int index){
		return getNode(index).value;
	}
	//获取第一个节点的值，即index=0
	public T getFirstValue(){
		return getNode(0).value;
	}
	//获取最后一个节点的值
	public T getLastValue(){
		return getNode(nCount-1).value;
	}
	//向index位置插入一个节点
	public void insert (int index,T t){
		if (index==0) {
			Dnode<T> node = new Dnode<T>(mHead.pre,mHead.next,t);
			mHead.next.pre=node;
			mHead.next=node;
			nCount++;
			return;
		}
		Dnode<T> inode = getNode(index);//取到第index位置的节点
		Dnode<T> tnode = new Dnode<T>(inode.pre,inode.next,t);//创建tnode节点，使得tnode的前驱与后继和inode节点的前驱和后继相同
		inode.pre.next=tnode;
		inode.pre=tnode;
		nCount++;
		return;
	}
	//将节点插入到第一个节点
	public void insertFirst(T t){
		insert(0,t);
	}
	//将节点追加到链表末尾
	public void append(T t){
		Dnode<T> node = new Dnode<T>(mHead.pre,mHead.next,t);
		mHead.pre.next=node;
		mHead.pre=node;
		nCount++;
	}
	//删除第index位置的节点
	public void delete(int index){
		Dnode<T> node=getNode(index);
		node.pre.next=node.next;
		node.next.pre=node.pre;
		node=null;
		nCount--;
	}
	//删除第一个节点
	public void delFirst(){
		delete(0);
	}
	//删除最后一个节点
	public void delLast(){
		delete(nCount-1);
	}
	//测试
	public static void main(String[] args) {
		DoubleLink<Integer> doublink = new DoubleLink<Integer>();
		doublink.insert(0, 22);
		doublink.insert(1, 23);
		doublink.insert(2, 25);
		doublink.insert(3, 62);
		doublink.insertFirst(15);
		for (int i=0;i<doublink.size() ;i++ ) {
			System.out.print(" "+doublink.getValue(i));
		}
		System.out.println(doublink.getFirstValue());
	}
}
