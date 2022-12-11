package leetcode;

public class Item_150 {
    public static int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int size = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token){
                case "+":{
                    int number1 = stack[--size];
                    int number2 = stack[--size];
                    stack[size++] = number1 + number2;
                    break;
                }
                case "-":{
                    int number1 = stack[--size];
                    int number2 = stack[--size];
                    stack[size++] = number2 - number1;
                    break;
                }
                case "*":{
                    int number1 = stack[--size];
                    int number2 = stack[--size];
                    stack[size++] = number2 * number1;
                    break;
                }
                case "/":{
                    int number1 = stack[--size];
                    int number2 = stack[--size];
                    stack[size++] = number2 / number1;
                    break;
                }
                default:{
                    stack[size++] = Integer.parseInt(token);
                    break;
                }
            }
        }
        return stack[0];
    }

    public static void main(String[] args) {
        String[] tokens;
        tokens = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
