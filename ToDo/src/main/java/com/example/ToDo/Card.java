package com.example.ToDo;

public class Card {
    
    String ueberschrift;
    String text;

    public Card(String ueberschrift, String text){
        setUeberschrift(ueberschrift);
        setText(text);
    }


    public String getText() {
        return text;
    }
    public String getUeberschrift() {
        return ueberschrift;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setUeberschrift(String ueberschrift) {
        this.ueberschrift = ueberschrift;
    }

}
