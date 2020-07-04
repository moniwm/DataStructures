package Trees;

import java.util.ArrayList;

public class ExpressionTree {

    String expression;
    Node<Integer> root;
    ArrayList<Integer> stack;
    ArrayList<Integer> queue;

    public ExpressionTree(String expression){
        this.root = null;
        this.expression = expression;
        this.stack = new ArrayList<>();
        this.queue = new ArrayList<>();


    }

    public boolean isOperator(char c){
        if(c == '+' ||c == '-'|| c == '*'|| c == '/' || c == '^'){
            return true;
        }
        return false;

    }




}
