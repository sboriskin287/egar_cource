package com.company;

import com.company.domain.GroupMessage;
import com.company.domain.Message;
import com.company.domain.PersonalMessage;

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
