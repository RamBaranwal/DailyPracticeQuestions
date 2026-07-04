// package SumPepTest1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.ArrayList;
import java.util.Stack;
import java.io.IOException;

public class ValidPrenthesis {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        ValidPrenthesis obj = new ValidPrenthesis();
        boolean res = obj.isValidParenthesis(st);
        System.out.println(res);
    }

    private boolean isValidParenthesis(String str){
        Stack<Character> ch = new Stack<>();
        for(char cha : str.toCharArray()){
            if(cha == '(' || cha == '{' || cha == '['){
                ch.add(cha);
            }
            else{
                if(ch.isEmpty()){
                    return false;
                }
                char lst = ch.pop();
                if(cha == ']' && lst != '[' || cha == ')' && lst != '('  ||  cha == '}' && lst != '{'){
                    return false;
                }
            }
        }
        return true;
    }
}
