package com.proj.bookbook.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long book_id;

    @Column(name="book_isbn13", nullable = false, unique = true)
    private String book_isbn13;  // isbn 13 자리

    @Column(name = "book_category" , nullable = false)
    private String book_category;

    @Column(name = "book_title" , nullable = false)
    private String book_title;

    @Column(name = "book_author" , nullable = false)
    private String book_author;  // 저자

    @Column(name = "book_pubdate" , nullable = false)
    private String book_pubdate; // 출간일


    @Column(name = "book_img" , nullable = false)
    private String book_img;

    @Column(name = "book_content" , nullable = false)
    private String book_content;

    @Column(name = "book_publisher", nullable = false)
    private String book_publisher;   // 출판사




}
