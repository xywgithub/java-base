//通过数组实现一个栈（java实现）

import java.lang.reflect.Array;
//泛型类，可实现任意类型的stack
public class GenericStack<T>{
	private static final int DEFAULT_SIZE=20;
	private int count;
	private T[] mArray;
	public GenericStack(Class<T> type,int size){
		//newInstance方法创建一个数组，包含数组类型和大小
		mArray=(T[])Array.newInstance(type,size);
		count=0;
	}
	public GenericStack(Class<T> type){
		this(type,DEFAULT_SIZE);
	}
	//将元素放入栈中
	public void push(T val){
		mArray[count++]=val;
	}
	//取得栈顶元素
	public T peek(){
		return mArray[count-1];
	}
	//取得栈顶元素，并删除
	public T pop(){
		T ret = mArray[count-1];
		count--;
		return ret;
	}
	//栈大小
	public int size(){
		return count;
	}
	//判空
	public boolean isEmpty(){
		return size()==0;
	}
	//打印出栈元素
	public void sysStack(){
		if (size()==0) {
			System.out.println("this is a empty stack");
		}
		for (int i=0;i<mArray.length ;i++ ) {
			System.out.print(mArray[i]+" ");
		}
		System.out.println(mArray[0]);
	}
	//main方法测试
	public static void main(String[] args) {
		GenericStack<Integer> gs = new GenericStack<Integer>(Integer.class);
		gs.push(12);
		gs.push(15);
		gs.push(20);
		System.out.println(gs.isEmpty());
		System.out.println(gs.size());
		gs.sysStack();
		for (int i=0;i<gs.size() ;i++ ) {
				System.out.print(i+":"+" "+gs.pop());
				System.out.println();
			}	
	System.out.println(gs.peek());
	}
}