package com.example.recyclerviewtutorialproject.models;
public class ChatList {
    private int imageView;
    private String textView1;
    private String textView2;
    private String textView3;
    private String textView4;

    public ChatList(int imageView, String textView1, String textView2, String textView3, String textView4) {
        this.imageView = imageView;
        this.textView1 = textView1;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.textView4 = textView4;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTextView1() {
        return textView1;
    }

    public void setTextView1(String textView1) {
        this.textView1 = textView1;
    }

    public String getTextView2() {
        return textView2;
    }

    public void setTextView2(String textView2) {
        this.textView2 = textView2;
    }

    public String getTextView3() {
        return textView3;
    }

    public void setTextView3(String textView3) {
        this.textView3 = textView3;
    }

    public String getTextView4() {
        return textView4;
    }

    public void setTextView4(String textView4) {
        this.textView4 = textView4;
    }
}
