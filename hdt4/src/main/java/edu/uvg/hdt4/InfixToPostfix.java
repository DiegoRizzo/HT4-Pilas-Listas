package edu.uvg.hdt4;

public class InfixToPostfix {

    public static int precedence(char operator) {
        if (operator == '^') return 3;
        else if (operator == '/' || operator == '*') return 2;
        else if (operator == '+' || operator == '-') return 1;
        else return -1;
    }

    public static boolean isRightAssociative(char operator) {
        return operator == '^';
    }

    public static String conversionStackVector(String infix) {
        StackVector stack = new StackVector();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && (char)stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && (char)stack.peek() != '(' &&
                        (precedence((char)stack.peek()) > precedence(c) ||
                        (precedence((char)stack.peek()) == precedence(c) && !isRightAssociative((char)stack.peek())))) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static String conversionStackArrayList(String infix) {
        StackArrayList stack = new StackArrayList();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && (char)stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && (char)stack.peek() != '(' &&
                        (precedence((char)stack.peek()) > precedence(c) ||
                        (precedence((char)stack.peek()) == precedence(c) && !isRightAssociative((char)stack.peek())))) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static String conversionStackLista(String infix) {
        StackLista stack = new StackLista(infix.length());
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && (char)stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && (char)stack.peek() != '(' &&
                        (precedence((char)stack.peek()) > precedence(c) ||
                        (precedence((char)stack.peek()) == precedence(c) && !isRightAssociative((char)stack.peek())))) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
    
}
