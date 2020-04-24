package Course2.ch03.exercises;

import java.util.*;

public class Suffix {
    static double evalPostFix() {
        Stack <Double> s = new Stack <Double>();
        String token;
        Double a, b, result = 0.0;
        boolean isNumber;
        Scanner sc = new Scanner(System.in);
        token = sc.next();
        while (token.charAt(0) != '=') {
            try {
                isNumber = true;
                result = Double.parseDouble(token);
            } catch (Exception e) {
                isNumber = false;
            }
            if (isNumber) s.push(result);
            else {
                switch (token.charAt(0)) {
                    case '+':
                        a = s.pop();
                        b = s.pop();
                        s.push(a + b);
                        break;
                    case '-':
                        a = s.pop();
                        b = s.pop();
                        s.push(a - b);
                        break;
                    case '*':
                        a = s.pop();
                        b = s.pop();
                        s.push(a * b);
                        break;
                    case '/':
                        a = s.pop();
                        b = s.pop();
                        s.push(a / b);
                        break;
                    case '^':
                        a = s.pop();
                        b = s.pop();
                        s.push(Math.exp(a * Math.log(b)));
                        break;
                }
            }
            token = sc.next();
        }
        return s.peek();
    }

    static Stack <Character> op = new Stack <>();

    public static Float getv(char op, Float f1, Float f2) {
        if (op == '+') return f2 + f1;
        else if (op == '-') return f2 - f1;
        else if (op == '*') return f2 * f1;
        else if (op == '/') return f2 / f1;
        else return Float.valueOf(-0);
    }




    /**
     * calculate the value of the reverse Polish expression
     * @param rp - reverse Polish expression
     * @return - result of the expression
     */
    public static float calrp(String rp){
        Stack<Float> v = new Stack<>();
        char[] arr = rp.toCharArray();
        int len = arr.length;
        for(int i = 0; i < len; i++){
            Character ch = arr[i];

            // if is operand, push to the stack
            if(ch >= '0' && ch <= '9') v.push(Float.valueOf(ch - '0'));

                // if is operator, calculate the result
                // with top 2 operands in the stack,
                // push the result into the stack
            else v.push(getv(ch, v.pop(), v.pop()));
        }
        return v.pop();
    }

    /**
     * from infix to postfix
     * @param s - String in the form of infix
     * @return String in the form of postfix
     */
    public static String getrp(String s){
        char[] arr = s.toCharArray();
        int len = arr.length;
        String out = "";

        for(int i = 0; i < len; i++){
            char ch = arr[i];
            if(ch == ' ') continue;

            // if is operand, add to
            // the output stream directly
            if(ch >= '0' && ch <= '9') {
                out+=ch;
                continue;
            }

            //if is '(', push to the stack directly
            if(ch == '(') op.push(ch);

            //if is '+' or '-', pop the operator
            // from the stack until '(' and add to
            // the output stream
            //push the operator to the stack
            if(ch == '+' || ch == '-'){
                while(!op.empty() && (op.peek() != '('))
                    out+=op.pop();
                op.push(ch);
                continue;
            }

            //if is '*' or '/', pop the operator stack and
            // add to the output stream
            // until lower priority or '('
            //push the operator to the stack
            if(ch == '*' || ch == '/'){
                while(!op.empty() && (op.peek() == '*' || op.peek() == '/'))
                    out+=op.pop();
                op.push(ch);
                continue;
            }

            //if is ')' pop the operator stack and
            // add to the output stream until '(',
            // pop '('
            if(ch == ')'){
                while(!op.empty() && op.peek() != '(')
                    out += op.pop();
                op.pop();
                continue;
            }
        }
        while(!op.empty()) out += op.pop();
        return out;
    }

//    public static void main(String[] args){
//        //constraint: the operand should be
//        // equal or greater than 0
//        // but equal or less than 9
//        String exp = "5+2*(3*(2-1))";
//        System.out.println(calrp(getrp(exp)));
//    }
    private static List <String> parseToSuffixExpression(List <String> expressionList) {
        //创建一个栈用于保存操作符
        Stack <String> opStack = new Stack <>();
        //创建一个list用于保存后缀表达式
        List <String> suffixList = new ArrayList <>();
        for (String item : expressionList) {
            //得到数或操作符
            if (isOperator(item)) {
                //是操作符 判断操作符栈是否为空
                if (opStack.isEmpty() || "(".equals(opStack.peek()) || priority(item) > priority(opStack.peek())) {
                    //为空或者栈顶元素为左括号或者当前操作符大于栈顶操作符直接压栈
                    opStack.push(item);
                } else {
                    //否则将栈中元素出栈如队，直到遇到大于当前操作符或者遇到左括号时
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())) {
                        if (priority(item) <= priority(opStack.peek())) {
                            suffixList.add(opStack.pop());
                        }
                    }
                    //当前操作符压栈
                    opStack.push(item);
                }
            } else if (isNumber(item)) {
                //是数字则直接入队
                suffixList.add(item);
            } else if ("(".equals(item)) {
                //是左括号，压栈
                opStack.push(item);
            } else if (")".equals(item)) {
                //是右括号 ，将栈中元素弹出入队，直到遇到左括号，左括号出栈，但不入队
                while (!opStack.isEmpty()) {
                    if ("(".equals(opStack.peek())) {
                        opStack.pop();
                        break;
                    } else {
                        suffixList.add(opStack.pop());
                    }
                }
            } else {
                throw new RuntimeException("有非法字符！");
            }
        }
        //循环完毕，如果操作符栈中元素不为空，将栈中元素出栈入队
        while (!opStack.isEmpty()) {
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    /**
     * 判断字符串是否为操作符
     *
     * @param op
     * @return
     */
    public static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    /**
     * 判断是否为数字
     *
     * @param num
     * @return
     */
    public static boolean isNumber(String num) {
        return num.matches("\\d+");
    }

    /**
     * 获取操作符的优先级
     *
     * @param op
     * @return
     */
    public static int priority(String op) {
        if (op.equals("*") || op.equals("/")) {
            return 1;
        } else if (op.equals("+") || op.equals("-")) {
            return 0;
        }
        return -1;
    }


    //    public static void main(String[] args) {
////        evalPostFix();
//        List<String> one = new LinkedList <>();
//        one.add("1");
//        one.add("+");
//        one.add("2");
//        parseToSuffixExpression(one);
//    }
    public static void main(String[] args) {

        ArrayList <Integer> inputs = new ArrayList <Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        //字符串判空不能用"=="
        if (expr.equals("") || expr == null)
            return -1;
        expr = expr.replaceAll(" ", "");
        int N = expr.length();
        Stack <Integer> stack = new Stack <Integer>();
        char c1;
        int tmp1, tmp2;
        for (int i = 0; i < N; i++) {
            c1 = expr.charAt(i);
            if (c1 != '^' && c1 != '+' && c1 != '*') {
                stack.push((int) (c1 - '0'));
                if (stack.size() > 16)
                    return -2;
            } else {
                switch (c1) {
                    case '^':
                        if (stack.isEmpty())
                            return -1;
                        int tmp = stack.pop();
                        stack.push(++tmp);
                        break;
                    case '+':
                        if (stack.isEmpty())
                            return -1;
                        tmp1 = stack.pop();
                        if (stack.isEmpty())
                            return -1;
                        tmp2 = stack.pop();
                        stack.push(tmp1 + tmp2);
                        break;
                    case '*':
                        if (stack.isEmpty())
                            return -1;
                        tmp1 = stack.pop();
                        if (stack.isEmpty())
                            return -1;
                        tmp2 = stack.pop();
                        stack.push(tmp1 * tmp2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
