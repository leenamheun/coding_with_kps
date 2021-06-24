package test;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {

    final static int NUMBER = 0;
    final static int CHARACTER = 1;
    final static int OPEN = 2;
    final static int CLOSE = 3;
    static Stack<Integer> stackNum = new Stack<>();
    static int i = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        char[] arr = input.toCharArray();
        System.out.println(makeStr(arr));
    }

    private static String makeStr(char[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean isClosed = false;

        for (; i < arr.length; i++) {
            char c = arr[i];
            switch (getCharCase(c)) {
                case NUMBER:
                    stackNum.add(c - '0');
                    break;

                case OPEN:
                    i++;
                    sb.append(makeStr(arr));
                    break;

                case CHARACTER:
                    sb.append(c);
                    break;

                case CLOSE:
                    int n = stackNum.pop();
                    String alphabet = sb.toString();
                    for (int j = 1; j < n; j++) {
                        sb.append(alphabet);
                    }
                    isClosed = true;
                    break;
            }
            if (isClosed) break;
        }
        return sb.toString();
    }

    private static int getCharCase(char c) {
        if ('1' <= c && c <= '9') {
            return NUMBER;
        } else if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return CHARACTER;
        } else if (c == '[') {
            return OPEN;
        } else {
            return CLOSE;
        }
    }
}
