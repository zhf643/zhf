package com.company;

import java.util.Scanner;
import java.util.*;

class MyStack<T>{
    private Object[] stack;
    private int size;
    MyStack(){
        stack=new Object[100];
    }
    public T top(){
        T t=null;
        if(size>0){
            t=(T) stack[size-1];
        }
        return t;
    }
    public void push(T t){
        stack[size]=t;
        size++;
    }
    public T pop() {
        T t = top();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MyStack<String> stack=new MyStack<>();
        int n=sc.nextInt();
        int i=0;
        while(i<=n){
            String s=sc.nextLine();
            stack.push(s);
            i++;
        }
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
