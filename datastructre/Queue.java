package datastructre;

import java.util.Scanner;

/*
 * implementing queue using 2 stacks.
 * In this challenge, you must first implement a queue using two stacks. Then process queries, where each query is one of the following types:
 * 1 x: Enqueue element into the end of the queue.
 * 2: Dequeue the element at the front of the queue.
 * 3: Print the element at the front of the queue.
 */

/*
 * this class  implements stack data structure
 */
class Stack{
  int[] stack=new int[10000000];
  int top=-1;
  
  /*here we push the elements into stack*/
  
  void push(int x){
      stack[++top]=x;
  }
  
  /*This function remove the top most element of stack and returns the value*/
  
  int pop(){
      
      return stack[top--];
  }
  
  /*this function is used to display top most element of stack*/
  
  int peek()
  {
      return stack[top];
  }
  
  /*this function is used to check is stack is empty*/
  
  boolean isEmpty()
  {
      return (top<0);
  }

}

public class Queue {
  Stack firststack=new Stack();
  Stack secondstack=new Stack();
   static Scanner sc=new Scanner(System.in);
public void queryresult(int query) {
  switch(query){
  case 1:firststack.push(sc.nextInt());       /*here we push the elements to the stack*/
        break;
        
        /* if second stack stack is empty then we pop all the elements of first stack 
        and then add them to the second stack as a result in second stack the element will be in first in first out manner*/

  case 2:if(secondstack.isEmpty()) {
            while(!firststack.isEmpty())
              secondstack.push(firststack.pop());
        }
        secondstack.pop();                 /* here we remove the element which entered first into the queue*/   
        break;
        
        /* if second stack stack is empty then we pop all the elements of first stack 
        and then add them to the second stack as a result in second stack the element will be in first in first out manner*/
case 3: if(secondstack.isEmpty()) {  
        while(!secondstack.isEmpty()) {
            secondstack.push(firststack.pop());
        }
   }
   System.out.println(firststack.peek()); /*here we display first element of queue*/
   break;
}
  
}
public static void main(String[] args) {

  Queue queue=new Queue();
  int n=sc.nextInt();                 /*here we read total no of queries*/
  int query;
  for(int i=0;i<n;i++){
    query=sc.nextInt();
    queue.queryresult(query);
  }
  
}
}

