package implementingPackages;

public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new DynamicStack(5);



        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());
        System.out.println("Popping the last element added to the stack " + stack.pop());






    }
}
