package cn.jxufe.web.util;

public class ThreadTest_01 implements Runnable{  
    
    public synchronized void run() {  
        for(int i = 0 ; i < 3 ; i++){  
            System.out.println(Thread.currentThread().getName() + "run......");  
        }  
    }  
      
    public static void main(String[] args) {
        ThreadTest_01 threadTest = new ThreadTest_01();
        for(int i = 0 ; i < 5 ; i++){  
            new Thread(new ThreadTest_01(),"Thread_" + i).start();
            //new Thread(threadTest,"Thread_" + i).start();
        }  
    }  
} 
