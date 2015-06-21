package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by vincent on 15/6/21.
 */
public class MyStack {

    public MyStack() {
        queueList = new ArrayList<>();
        queueList.add(new LinkedList<Integer>());
        queueList.add(new LinkedList<Integer>());
        optWhich = 0;
    }


    private void changeOptWhich() {
        this.optWhich = 1 - optWhich;
    }

    private int getOptWhich(){
        return optWhich;
    }

    // Push element x onto stack.
    public void push(int x) {
        queueList.get(getOptWhich()).add(x);
    }

    private int inverseQueue(){
        int optInd = getOptWhich();
        int backInd = 1- optInd;
        while (queueList.get(optInd).size() > 1){
            queueList.get(backInd).add(queueList.get(optInd).remove());
        }
        return queueList.get(optInd).element();
    }
    // Removes the element on top of the stack.
    public void pop() {
        if (empty())
            return;
        inverseQueue();
        queueList.get(getOptWhich()).remove();
        changeOptWhich();

    }

    // Get the top element.
    public int top() {
        if (empty())
            return -1;
        int xx = inverseQueue();
        queueList.get(getOptWhich()).remove();
        queueList.get(1- getOptWhich()).add(xx);
        changeOptWhich();
        return xx;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queueList.get(getOptWhich()).isEmpty();
    }

    private List<Queue<Integer>> queueList;
    private int optWhich;

    public static void main(String[] args) {
//        push(1),push(2),push(3),top,pop,top,pop,top,empty,pop,empty
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.empty());
        stack.pop();
        System.out.println(stack.empty());
        System.out.println(stack.top());

    }

}
