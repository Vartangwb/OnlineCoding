import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by twb on 2017/6/1.
 */
public class Solution {
    public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return false;
        // iteration, add the node
        Stack<String> stack = new Stack();
        for(String s : preorder.split(",")) {
            // check 2 "#"
            if(s.equals("#")) {
                while(!stack.isEmpty() && stack.peek().equals("#")) {
                    // pop "#"
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    // pop parent of "#" & "#"
                    stack.pop();
                }
            }
            stack.push(s);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }


    public static boolean slove(String preOrder){
        String[] preOrderArr = preOrder.split(",");
        LinkedList<String > ls = new LinkedList<>();
        for(int i = 0; i < preOrderArr.length; i++){
            ls.add(preOrderArr[i]);
            while(ls.size() >= 3 && ls.get(ls.size() - 1).equals("#") &&
                    ls.get(ls.size() - 2).equals("#") &&
                    ls.get(ls.size() - 3).equals("#") == false){
                ls.remove(ls.size() - 1);
                ls.remove(ls.size() - 1);
                ls.remove(ls.size() - 1);
                ls.add("#");
            }
        }
        if(ls.size() == 1 && ls.get(0).equals("#")){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }


}
