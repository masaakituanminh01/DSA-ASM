/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;
import HandleMessage.*;
/**
 *
 * @author ducmy
 */
public class NewMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TransferMessage send = new TransferMessage(10);
        ProcessMessage store = new ProcessMessage(3);
        boolean run = true;
        String message;
        while(run) {
            System.out.println("***************************");
            System.out.println("* Send and store messages *");
            System.out.println("* 1. Send message         *");
            System.out.println("* 2. See sent messages    *");
            System.out.println("* 3. Exit                 *");
            System.out.println("* Choose one option       *");
            System.out.println("***************************");
            int choice =  s.nextInt();
            s.nextLine();
            switch(choice) {
                case 1: {
                    System.out.println("You have chosen option 1");
                    System.out.println("Please enter your message: ");
                    message = s.nextLine();
                    send.enqueue(message);
                    send.dequeue();
                    store.push(message);
                    break;
                }
                case 2: {
                    System.out.println("You have chosen option 2");
                    System.out.println("Sent messages");
                    store.show();
                    break;
                }
                case 3: {
                    run = false;
                    break;
                }
                default: {
                    System.out.println("Please choose option 1, 2 or 3.");
                    break;
                }
            }
        }
    }    
}
