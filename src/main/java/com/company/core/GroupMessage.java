package com.company.core;

import java.util.Date;

public class GroupMessage extends Message {
    public GroupMessage(String content,
                        String imagePath,
                        Date sentDate) {
        super(content, imagePath, sentDate);
    }
}
