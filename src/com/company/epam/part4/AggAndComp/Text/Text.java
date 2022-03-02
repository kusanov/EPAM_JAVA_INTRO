package com.company.epam.part4.AggAndComp.Text;

import java.util.Arrays;

public class Text {
    private String title;
    private Sentence[] sentences;

    public Text() {
    }

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Text(String title, Sentence[] sentences) {
        this.title = title;
        this.sentences = sentences;
    }

    //вывод в консоль текста
    public void printText() {
        StringBuilder text = new StringBuilder();
        for (Sentence sent : sentences) {
            text.append(sent.convertWords() + " ");
        }
        System.out.println(text.toString().trim());
    }

    //вывод в консоль заголовка
    public void printTitle() {
        System.out.println("Заголовок текста: " + this.title);
    }

    //дополнение текста новыми предложениями
    public Sentence[] completeText(Sentence... sentenceAdd) {
        Sentence[] newText = Arrays.copyOf(this.sentences, this.sentences.length + sentenceAdd.length);
        System.arraycopy(sentenceAdd, 0, newText, this.sentences.length, sentenceAdd.length);
        return this.sentences = newText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }
    public static Word[] createArrWords(String str) {
        String[] strArr = str.split(" ");
        Word[] words = new Word[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            words[i] = new Word(strArr[i]);
        }
        return words;
    }
}
