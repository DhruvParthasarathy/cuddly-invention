package binaryTree;

import java.util.*;

public class BinaryTreeCustom {

    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      a
        //     / \
        //   b     c
        //  / \     \
        // d   e     f

//        dfs(a);

//        System.out.println("Depth first search : " + dfsRec(a));
//        System.out.println("Breath first search : " + bfs(a));
//        System.out.println("Breath first search recursive : " + bfsRec(a));

        Character target = 'x';
//        System.out.println("Is the element " + "e present ? " + isPresent('j', a));
        System.out.println("Is the element " + target + " present recursive check ? " + isPresentRecDFS(target, a));

        Node g = new Node('1');
        Node h = new Node('2');
        Node i = new Node('3');
        Node j = new Node('4');
        Node k = new Node('5');
        Node l = new Node('6');
        Node m = new Node('9');

        g.left = h;
        g.right = i;
        h.left = k;
        h.right = j;
        j.left = l;
        l.right = m;

//             1
//            / \
//           2   3
//          / \
//         5   4
//            /
//           6
//             \
//               9


//        System.out.println("Sum of all nodes in this tree is " + calculateSum(g));
        System.out.println("Max sum of all paths in this tree is " + calculateMaxOfPathSums(g));
    }


    public static void dfs(Node root){
        // in depth first traversal, we use a stack data structure as an temp storage as we traverse through the stack

        List<Character> output = new ArrayList<Character>();

        if(root == null){
            System.out.println(output);
        }
        Stack<Node> stack = new Stack<Node>(); // creating a new stack

        Node node = root;

        stack.push(node);



        /**
         * Check if the stack is empty, if so, first push the right child and then push the left child
         * Then till the stack is empty, process the node that is on the top of the stack and
         * then push it's children to the stack
         *
         * Keep doing this till the stack becomes empty
         * Return the processed output
         */

        while(!stack.isEmpty()){

            Node tempNode = stack.pop(); // processing the top node
            output.add(tempNode.value); // saving it into the output array

            // adding the children to the stack
            if(tempNode.right!=null){
                stack.push(tempNode.right); // pushing the rigth child first so that it is processed later
            }
            if(tempNode.left!=null) {
                stack.push(tempNode.left);
            }

        }

        System.out.println(output);
    }


    public static ArrayList<Character> dfsRec(Node root){

        if(root == null){
            return new ArrayList<Character>();
        }

        ArrayList<Character> outPut =  new ArrayList<Character>();

        outPut.add(root.value); // addding the current node's value
        ArrayList<Character> left = dfsRec(root.left); // adding the values obtained from the left nodes
        ArrayList<Character> right = dfsRec(root.right); // adding the values obtiained from the right nodes

        left.addAll(right);
        outPut.addAll(left);

        return outPut;

    }

    public static ArrayList<Character> bfs(Node root){

        // in the bfs algorithm, we return the elements in the tree based on their level
        // the root node will be reutrned first, followed by the second level nodes, followed by the next
        // level , so on and so forth

        // to help us achieve this, we will be using a queue data structure as our ancillary object


        // Since we need to always to breath first, we first store the left element in the queue and then the right element
        // but when popping, we pop the element that is the first element in the queue

        // when we pop and process each node, we then add it's children to the queue, but these children will alwyas be added
        // to the end of the queue, thus when we process elements it would be parent's at the same level first then the child
        // elements

        if(root == null){
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        ArrayList<Character> result = new ArrayList<>();

        while(!queue.isEmpty()){

            Node node = queue.remove();
            result.add(node.value);

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }

        return result;
    }

    public static ArrayList<Character> bfsRec(Node root){

        // here instead of iterative, we try doing it recursively
        // we need a root node for this

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Character> output = new ArrayList<>();

        // If we need to achieve this recursively, we need to know that once we enter into a recursive loop,
        // on one side of the tree, we lose track of the elements on the other side of the tree

        // hence it is not a straightforward implementation of bfs using recursion


        return output;


    }

    public static boolean isPresent(Character target, Node node){
        // is the character target present in this sub tree ?

//        if(node == null){
//            return false;
//        }

        // here we note that the tree is not ordered in any particular way
        // we cannot be sure that the element will lie in the left half or the right half
        // so we need to do a standard traversal to identify the element

        // performing a breath first search

        // we need a queue for bfs
        Queue<Node> qu = new LinkedList();

        qu.add(node);

        while(!qu.isEmpty()){

            Node tempNode = qu.remove();

            if(tempNode.value == target){
                return true;
            }

            if(tempNode.left != null){
                qu.add(tempNode.left);
            }
            if(tempNode.right != null){
                qu.add(tempNode.right);
            }
        }

        // if we have not found the element at all
        return false;
    }

    public static boolean isPresentRecDFS(Character target, Node node){

        // here we are going to recursively check if the target is present in the sub tree

        if(node == null){
            return false;
        }

        if(node.value == target){
            return true;
        }

        boolean left = false;
        boolean right = false;

        if(node.left != null){
            // check left
            left = isPresentRecDFS(target, node.left);
        }

        if(node.right != null) right = isPresentRecDFS(target, node.right);

        return left || right;


    }

    public static int calculateSum(Node node){

        int sum = 0;
        // we do a depth first approach and keep calulating the cumilative um as it returns

        if(node == null) return 0;

        return sum = (node.value -48 )+ calculateSum(node.left) + calculateSum(node.right);
    }

    public static int calculateMaxOfPathSums(Node node){

        //in this problem, we need to traverse through all the nodes in a df approach and find out which path
        // from the root has the max sum till the
        // leaf node

        // for dfs we use a stack
        // and when we return from each call, we take along with us the max sum of the return value

//             1
//            / \
//           2   3
//          / \
//         5   4
//            /
//           6
//             \
//               9

        int maxSum = 0;

        if(node == null) {
            return 0;
        }

        // if this node is not null, then we need to see what is the max sum that we are getting from
        // either the left leaf or the right leaf

        maxSum += (node.value -48 );

        int leftSum = 0;
        int rightSum = 0;

        if(node.left!=null) leftSum = calculateMaxOfPathSums(node.left);
        if(node.right!=null) rightSum = calculateMaxOfPathSums(node.right);

        maxSum += Math.max(leftSum, rightSum);

        return maxSum;

    }
}


