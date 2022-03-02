package com.company.epam.part4.AggAndComp.Text;

public class MainText {
    public static void main(String[] args) {

        //1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
//    консоль текст, заголовок текста.

        Text text = new Text("Анекдот.", sentencesList);
        text.printTitle();
        System.out.println("\nИсходный текст: ");
        text.printText();
        System.out.println("\nИзмененный текст: ");
        text.completeText(sentencesAdd);
        text.printText();
    }


    private static Word[] words_01 = Text.createArrWords("Мама укладывает спать маленького сына:" +
            "— Спокойной ночи, сыночек, тебе уже, наверное, сон про зайчика из мультика снится?");
    private static Word[] words_02 = Text.createArrWords("Что было дальше?..");
    private static Word[] wordsAdd_01 = Text.createArrWords("Мальчик сонным голосом:");
    private static Word[] wordsAdd_02 = Text.createArrWords("— Нет, мама, пока ещё реклама...");
    private static Sentence[] sentencesList = new Sentence[]{new Sentence('!', words_01),
            new Sentence('.', words_02)};
    private static Sentence[] sentencesAdd = new Sentence[]{new Sentence('.', wordsAdd_01),
            new Sentence('!', wordsAdd_02)};
}
