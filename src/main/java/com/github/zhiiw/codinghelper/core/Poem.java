package com.github.zhiiw.codinghelper.core;

public class Poem {
  private String content;
  private String origin;
  private String author;
  private String category;

  public Poem(String content,String origin,String author,String category){
    this.author=author;
    this.content=content;
    this.origin=origin;
    this.category=category;

  }
  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public String getCategory() {
    return category;
  }

  public String getContent() {
    return content;
  }

  public String getOrigin() {
    return origin;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

}

