package com.company.core;

import java.util.Date;

public class Message {
    String content;
    String imagePath;
    Date sentDate;
    int readCount;

    public Message(String content,
                   String imagePath,
                   Date sentDate) {
        this.content = content;
        this.imagePath = imagePath;
        this.sentDate = sentDate;
    }

    public void print() {
        System.out.println(content);
    }

    void loadImage() throws InterruptedException {
        System.out.println("Идет процесс загрузки по пути "
                + imagePath);
        Thread.sleep(5000);
        System.out.println("Картинка загружена");
    }

    void printSentDate() {
        System.out.println(sentDate);
    }

    int getReadCount() {
        return readCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
