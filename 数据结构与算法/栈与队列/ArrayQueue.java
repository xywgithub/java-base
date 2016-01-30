//利用数组来实现队列（FIFO），下面的实现仅可存储int类型

public class ArrayQueue{
	private int[] mArray;
	private int count;
	//构造函数，设置了队列的容量大小
	public ArrayQueue(int size){
		mArray = new int[size];
		count = 0;
	}
	//添加元素，即入队
	public void addElement(int val){
		mArray[count++] = val;
	}
	//取出队首元素，并删除。即出队
	public int pop(){
		int ret = mArray[0];
		count--;
		for (int i=0;i<=count-1 ;i++ ) {
			mArray[i]=mArray[i+1];
		}
		return ret;
	}
	//返回队首元素
	public int firstElement(){
		return mArray[0];
	}
	//返回队尾元素
	public int lastElement(){
		return mArray[count-1];
	}
	//队列大小
	public int size(){
		return count;
	}
	//判空
	public boolean isEmpty(){
		return size()==0;
	}
	//main方法测试
	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue(5);
		aq.addElement(11);
		aq.addElement(22);
		aq.addElement(33);
		System.out.println(aq.pop());
		System.out.println(aq.size());
		System.out.println(aq.isEmpty());
		System.out.println(aq.firstElement());
		System.out.println(aq.lastElement());
	}
}