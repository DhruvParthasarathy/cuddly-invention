package implementingPackages;

import java.util.EmptyStackException;

// last in first out
public class CustomStack {

    // stack has an array inside it

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    // last in first out
    private int pointer = -1;

    public CustomStack(){

        /**
         * The 'this' keyword can be used in two ways,
         * 1. to refer to the current object instance
         * 2. it can be used as a constructor, based on the type of the argument, the
         * respective constructor is called.
         */

        // this.data = new int[DEFAULT_SIZE];
        this(DEFAULT_SIZE);

    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full!" + " Unable to add " + item);
            return false;
        }
        pointer++;
        System.out.println("Adding item " + item + " to the stack.");
        data[pointer] = item;
        return true;
    }

    /**
     * This method deletes the last element from the stack and returns it
     * @return Integer - last element
     */
    public int pop() throws Exception {

        if(isEmpty()){
            throw new Exception("Cannot pop elements from an empty stack!!");
        }
        int lastElem = data[pointer];
        data[pointer] = 0;
        pointer --;
        return lastElem;
    }

    /**
     * This function returns the element at the top of the stack
     * but it does not delete it from the stack
     * @return The item at the top of the stack
     */
    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot peek into an empty stack");
        }
        return data[pointer];
    }

    public boolean isFull(){
        return pointer == data.length - 1; // pointer is at the last index of the data object
    }

    public boolean isEmpty(){
        return pointer == -1; // pointer is outside the data object, before the 0th index
    }
}
