package binaryTree;

import java.util.*;

public class ErrorTree {

    static private Map<Character, List<Character>> parentChildMap = new HashMap<>();
    static private Map<Character, List<Character>> childParentMap = new HashMap<>();

    private static char rootNode = '\0';
    private static final int ERROR = 0;
    private static final int SUCCESS = 1;
    private static final int E1 = 1; // invalid input
    private static final int E2 = 2; // Duplicate Pair
    private static final int E3 = 3; // more than 2 children
    private static final int E4 = 4; // Multiple roots
    private static final int E5 = 5; // Contains cycle
    private static boolean errorFlag = false; // to know if there were any other errors including E1, E2, E3, E4 or E5
    private static boolean[] errorArray = new boolean[6]; // saving it as an array of size 6, so that we can populate the error flags

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

//        Scanner sc = new Scanner(System.in);
//
//        String input = sc.nextLine();

//        String input = "(A,B) (A,C) (B,D) (D,E) (C,F) (E,G)"; // this is a perfect string
        String input = "(B,D) (A,B) (A,C) (C,D)"; // this is a perfect string
//        String input = ""; // this is a perfect string

        System.out.println(input);

        System.out.println(parseInput(input));
    }

    static String parseInput(String input){
        // we know that we will be getting input in the format
        // (A,A)

        // we use this to store the
//        String[] pairs = input.split(" ");
//
//        System.out.println(Arrays.toString(pairs));
//        System.out.println();

        char prevChar = '\0'; // to know which was the previous parent

        boolean validInput = true; // to maintain error state for error E1
        StringBuilder sb = new StringBuilder(input);
        // preprocessing input as sb to enable quick parsing of input

        int index = 0; // internal variable required for  the below while loop
        while(sb.length() != 0 && validInput){

            char ch = sb.charAt(0);

            switch(index){
                case 0 : {
                    if(ch != '('){
                        validInput = false;
                        break;
                    } else {
                        sb.deleteCharAt(0);
                    }
                    index++;
                    break;

                }
                case 1 :
                case 3 :
                {
                    if(!(ch >= 'A' && ch <= 'Z')){
                        validInput = false;
                    } else {
                        if(index == 1){ // if we are processing the first character, it will be a parent character
                            int[] error =  addToMap(ch, true, prevChar);
                            if(error[0] == ERROR){
                                errorArray[error[1]] = true;
                                errorFlag = true;
                            }
                            prevChar = ch;
                            // setting the previous character so that we know which
                            // parent to add the child node to when we encounter that next
                        } else {
                            // we are adding a child node
                            int[] error =  addToMap(ch, false, prevChar);
                            if(error[0] == ERROR){
                                errorArray[error[1]] = true;
                                errorFlag = true;
                            }
                            prevChar = '\0'; // resetting the previous character
                            }
                        sb.deleteCharAt(0);
                    }
                    index ++;
                    break;
                }
                case 2 : {
                    if(ch!=',' ){
                        validInput = false;
                        break;
                    } else {
                        sb.deleteCharAt(0);
                    }
                    index ++;
                    break;
                }
                case 4 : {
                    if(ch != ')'){
                        validInput = false;
                        break;
                    } else {
                        sb.deleteCharAt(0);
                    }
                    index++;
                    break;

                }
                case 5: {
                    if(ch!=' ' ){
                        validInput = false;
                        break;
                    } else {
                        sb.deleteCharAt(0);
                    }
                    index = 0;
                    break;
                }
            }

        }

        if(!validInput || input.equalsIgnoreCase("")){
            errorArray[1] = true;
            errorFlag = true;
        }

        // finding if we have multiple roots
        // we will have multiple roots, when we have more than 1 element that has no parent

        // these are the elements that are there as keys in the parentChildMap, but that are not present in the
        // childParentMap

        // Basically, if the difference in the size of both these maps is != 1 then we have a problem

//        System.out.println("Number of elements in the parent map " + parentChildMap.keySet());
//        System.out.println("Number of elements in the child map " + childParentMap.keySet());

        // Let's check if we have more than one root node
        int rootNodes = 0;

        for (char node : parentChildMap.keySet()) {
            if(!childParentMap.containsKey(node)){
                rootNode = node; // we keep track of the root node
                rootNodes++;
            }
        }

//        System.out.println("Number of root nodes " + rootNodes);

        if(rootNodes > 1){
            errorArray[4] = true;
        }

//        System.out.println("Error map " + Arrays.toString(errorArray));
//        System.out.println("Error flag " + errorFlag);


        for(int i = 0; i < errorArray.length; i++){
            if(errorArray[i]){
                return "E"+i;
            }
        }

        return generateString(rootNode);



    }

    static String generateString(char ch){

        // here we have the root node, let's construct the lexographical notation from the node
        if(parentChildMap.get(ch)==null) {
            return "("+ch+")";
        }

        String childOne = "";
        String childTwo = "";

        if(parentChildMap.get(ch).get(0) != null){
            childOne = generateString(parentChildMap.get(ch).get(0) );
        }

        if(parentChildMap.get(ch).size() > 1){
            childTwo = generateString(parentChildMap.get(ch).get(1) );
        }

        String out =  "("+ch+childOne+childTwo+")";

        return out;
    }

    static int[] addToMap(char ch, boolean parent, char prevParent){
        // we have the map and we need to see what to do with this character

        if(parent) {
            /**
             * We are getting the first letter in the mapping (first, second),
             * we can check if this node is already there in the map,
             *
             */
            /**
             * If the node is not there, then we can create a new key for this in the map
             */
            if(!parentChildMap.containsKey(ch)){
                parentChildMap.put(ch, new ArrayList<>());
            }


        }
        else {
            /**
             * We are looking at a child node,
             * we need to add it to the previous parent ,
             * that is sent as a parameter in the
             * function
             *
             * Again here we can check for 2 things
             * 1. the parent has more than 2 children
             * 2. this is a duplicate pair
             */

            char thisParent = prevParent;

            // checking if this is a duplicate pair
            if(parentChildMap.get(thisParent).contains(ch)){
                return new int[] {ERROR, E2};
            }

            // checking if this parent has more than 1 child
            // if this was a duplicate entry, it would have been identified in the prev step
            // we have a new character here
            if(parentChildMap.get(thisParent).size() == 2){
                // this parent already has 2 children
                return new int[] {ERROR, E3};
            }

            // checking if this could be a cycle

            // if this is the first time this child is being added
            if(!childParentMap.containsKey(ch)){

                parentChildMap.get(thisParent).add(ch); // adding the child to the parent map

                List<Character> parentList = new ArrayList<>();
                parentList.add(thisParent);

                childParentMap.put(ch, parentList);
            } else {
                // this child is already present in the childParent mapping
                // we can check for 2 things
                // 1. if this is a duplicate pair
                // 2. If this forms a cycle

                // checking if this is a duplicate pair
                if(childParentMap.get(ch).contains(thisParent)){
                    // this is a duplicate entry
                    return new int[] {ERROR, E2};
                } else {
                    // this child is already there but now we are entering with a different parent
                    // this indicates a cycle
                    return new int[] {ERROR, E5};
                }
            }




        }

        // If the above steps went fine, we return success
        return new int[] {SUCCESS};
    }
}
