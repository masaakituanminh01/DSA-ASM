/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleMessage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ducmy
 */
// Base on Stack
public class ProcessMessage {
    private int max,top;
    String[] stack;
    
    public ProcessMessage(int max) {
        this.max = max;
        stack = new String[this.max];
        top = -1;
    }
    
    public boolean grow() {
        int newMax = max + max / 4;
        String[] newStack = new String[newMax];
        if(newStack == null) {
            return false;
        }
        for (int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }
        max = newMax;
        stack = newStack;
        return true;
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == max - 1);
    }
    
    public String push(String str) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String formatted = current.format(formatter);
        if(isFull()) {
            System.out.println("Memory is full! You should clear or increase the memory!");
            return null;
        } else {
            top += 1;
            stack[top] = "(" + formatted + "): " +str;
        }
        return str;
    }
    
    public String pop() {
        if(isEmpty()) {
            return null;
        }
        String str = stack[top];
        stack[top] = null;
        top = top - 1;
        return str;
    }
    
    public String top() {
        if(isEmpty()) {
            return null;
        }
        String str = stack[top];
        return str;
    }
    
    public void show() {
        if(isEmpty()) {
            System.out.println("Nothing to show !");
        }
        String str = null;
        while((str = pop()) != null) {
            System.out.println(str);
        }
    }
}
