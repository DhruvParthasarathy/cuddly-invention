package implementingPackages;

import java.beans.ExceptionListener;
import java.util.concurrent.ExecutionException;

public class CustomQueue {

    protected int[] data;

    // first in first out
    private int end = -1;

    private static final int DEFAULT_SIZE = 10;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot peek into an empty queue");
        }
        return data[0];
    }

    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty queue");
        }

        // FIX this function here

        return data[end--];  // here we return the end value and also decrement the end index by 1
    }

    public boolean push(int item) throws Exception
    {
        if(isFull()){
            throw new Exception(" Cannot add more elements to a filled stack");
        } else {
            data[++end] = item;
            return true;
        }
    }
    public boolean isEmpty(){
        return end == -1;
    }

    public boolean isFull(){
        return end == data.length - 1;
    }


}
