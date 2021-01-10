package com.example.playingapp.Adapters;

public class feature_home_model {
    int image;
    String text_name,text_des;

    public feature_home_model(int image, String text_name, String text_des) {
        this.image = image;
        this.text_name = text_name;
        this.text_des = text_des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }

    public String getText_des() {
        return text_des;
    }

    public void setText_des(String text_des) {
        this.text_des = text_des;
    }
}
