package com.company;

import com.company.core.GroupMessage;
import com.company.core.Message;
import com.company.core.PersonalMessage;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Message message1 = new PersonalMessage(
                "Hello world",
                "./resources",
                new Date());
        Message message2 = new GroupMessage(
                "Hello world",
                "./resources",
                new Date());
        message1.print();
        message2.print();
    }
}
