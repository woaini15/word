package com.example.word.pojo;

/**
 * 单词题库表
 */
public class Worda {
    private int wordid;                       //单词序号
    private String wordmeaning;       //汉语意思
    private String word;                     //单词

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public String getWordmeaning() {
        return wordmeaning;
    }

    public void setWordmeaning(String wordmeaning) {
        this.wordmeaning = wordmeaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
