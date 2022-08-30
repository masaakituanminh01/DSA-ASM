/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleMessage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author admin
 */

// Base on queue
public class TransferMessage {
    int max; // capacity of queue
    int f,l; // f, l are pointers for first and last message
    String[] queue;

    public TransferMessage(int max) {
        this.max=max;
        queue=new String[this.max];
        f=-1;
        l=-1;
    }
    
    public boolean isEmpty()
    {
        return (f==-1);
    }
    
    public boolean isFull()
    {
        return ((f==0&&l==max-1)||(l+1==f));
    }
    
    public boolean grow()
    {
        int newMax=max+max/2;
        String[] newQ = new String[newMax];
        if(newQ==null)//not enough memory
        {
            return false;
        }
        if(f<=l)
        {
            for (int i = f; i < l; i++) {
                newQ[i-f]=queue[i];
            }
        }
        else
        {
            for (int i = f; i < max; i++) {
                newQ[i-f]=queue[i];
            }
            for (int i = 0; i < l; i++) {
                newQ[max-f+i]=queue[i];
            }
        }
        
        int temp=0;
        if(f<=l)
        {
            temp=l-f+1;
        }
        else
        {
            temp=max-f+l+1;
        }
        f=0;
        l=temp-1;
        max=newMax;
        queue=newQ;
        return true;
    }
    
    public String enqueue(String str) {
        if(isFull()) {
            return null;
        }
        
        if(str.length() >= 250) {
            System.out.println("Message's content must be less than 250 characters. Please try again");
            return null;
        }
        
        if(str.isBlank()) {
            System.out.println("Message can not be empty!");
        }
        
        if(l == -1 || l == max - 1) {
            queue[0] = str;
            l = 0;
            if(f == - 1) {
                f = 0;
            }
        } else {
         l = l + 1;
         queue[l] = str;
        }
        return str;
    }
    
    public String dequeue() {
        if(isEmpty()) {
            return null;
        }
        String str = queue[f];
        queue[f] = null;
        if(f == l) {
            f = l = -1;
        } else {
            if(f == max - 1) {
                f = 0;
            } else {
                f = f + 1;
            }
        }
        return str;
    }
    
    public void show() {
        String str = null;
        if(isEmpty()) {
            System.out.println("Nothing to delete!");
        } 
        while((str = dequeue()) != null) {
            System.out.println("Deleted message: " + str);
        }
    }
}
