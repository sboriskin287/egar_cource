package com.company.core;

import java.util.Date;

public class PersonalMessage extends Message {

    public PersonalMessage(String content,
                           String imagePath,
                           Date sentDate) {
        super(content, imagePath, sentDate);
    }

    @Override
    void print() {
        System.out.println("Это личное сообщение, " +
                "не для чата"
                + content);
    }
}
