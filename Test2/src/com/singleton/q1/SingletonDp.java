package com.singleton.q1;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton implements Cloneable, Serializable{
	//lazy vs eager 
//	private static Singleton singleton=new Singleton();//eager
	private static volatile Singleton singleton;
	//lazy approach-race condition,threading issues
	private Singleton() {
		
	}
	public static Singleton getSingleton() {
		//t1, t2 double checking
		if(singleton==null) {
			synchronized (Singleton.class) {
				if(singleton==null) {
					singleton=new Singleton();
				}
			}
			
		}
		return singleton;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		 throw new CloneNotSupportedException();
	}
	     
	
	private Object readResolve() {
		return getSingleton();
	}
}
public class SingletonDp {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Singleton singleton=Singleton.getSingleton();
		System.out.println(singleton.hashCode());
		
		//clone
	/*	Singleton singleton2=(Singleton) singleton.clone();
		System.out.println(singleton2.hashCode());
		*/
		
		//reflection
		Class<?> clazz =Class.forName("com.singleton.q1");
		Constructor[] constructors=clazz.getDeclaredConstructors();
		constructors[0].setAccessible(true);
		Singleton singleton2=(Singleton) constructors[0].newInstance();
		
		System.out.println(singleton2.hashCode());
		
		
		
		
	//ser and then deser
		
/*	Singleton singleton = Singleton.getSingleton();
		System.out.println(singleton.hashCode());

	ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("demo.txt")));
	oos.writeObject(singleton);
	*/
		Runtime runtime=Runtime.getRuntime();
		Runtime runtime2=Runtime.getRuntime();
		System.out.println(runtime.hashCode());
		System.out.println(runtime2.hashCode());
		System.out.println(runtime.availableProcessors());
		
		
	}

}
