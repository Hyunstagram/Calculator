package com.kang.calculator;

import android.text.SpannableStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

//Referred to https://jamanbbo.tistory.com/54's Priority
public class CalculateHelper {
    public static Integer num1;
    public static Integer num2;

    public int process(SpannableStringBuilder str) {
        ArrayList<java.io.Serializable> array_content = new ArrayList<>();
        ArrayList<Object> array_stack = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        Stack<Object> stack_in = new Stack<>();
        Stack<Object> stack_post = new Stack<>();

        String[] content = String.valueOf(str).split(" ");
        int num = 0;
        boolean flag = false;
        hash.put("*", 1);
        hash.put("/", 1);
        hash.put("+", 0);
        hash.put("-", 0);

        for (String data : content) {
            if (data.equals(" ")) {
                continue;
            }
            if (checkNumber(data)) {
                num = Integer.parseInt(data);
                flag = true;
            } else {
                if (flag) {
                    array_content.add(num);
                    num = 0;
                }
                flag = false;
                array_content.add(data);
            }
        }

        if (flag) {
            array_content.add(num);
        }

        for (Object object : array_content) {
            if (hash.containsKey(object)) {
                if (!stack_in.isEmpty()) {
                    if (Integer.parseInt(hash.get(stack_in.peek()).toString()) >= Integer.parseInt(hash.get(object).toString())) {
                        array_stack.add(stack_in.pop());
                    }
                }
                stack_in.push(object);
            } else {
                array_stack.add(object);
            }
        }

        while (!stack_in.isEmpty()) {
            array_stack.add(stack_in.pop());
        }

        for (Object object : array_stack) {
            if (object instanceof Integer) {
                stack_post.push(object);
            } else if (object.equals("+")) {
                num1 = (Integer) stack_post.pop();
                num2 = (Integer) stack_post.pop();
                stack_post.push(num2 + num1);
            } else if (object.equals("-")) {
                num1 = (Integer) stack_post.pop();
                num2 = (Integer) stack_post.pop();
                stack_post.push(num2 - num1);
            } else if (object.equals("*")) {
                num1 = (Integer) stack_post.pop();
                num2 = (Integer) stack_post.pop();
                stack_post.push(num2 * num1);
            } else if (object.equals("/")) {
                num1 = (Integer) stack_post.pop();
                num2 = (Integer) stack_post.pop();
                stack_post.push(num2 / num1);
            }
        }

        return (Integer) stack_post.pop();
    }

    public boolean checkNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char check = str.charAt(i);
            if (check < 48 || check > 58) {
                if (check != '.')
                    return false;
            }
        }
        return true;
    }
}