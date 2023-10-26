package com.proj.bookbook.DTO;


import com.proj.bookbook.Model.Book;
import com.proj.bookbook.Model.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long book_id;
    private String book_isbn13;

    private String book_category;

    private String book_title;

    private String book_author;

    private String book_pubdate;
    private String book_img;

    private String book_content;

    private String book_publisher;




    public BookDTO(Book book){
        this.book_id = book.getBook_id();
        this.book_isbn13 = book.getBook_isbn13();
        this.book_category = book.getBook_category();
        this.book_title = book.getBook_title();
        this.book_author = book.getBook_author();
        this.book_pubdate = book.getBook_pubdate();
        this.book_img = book.getBook_img();
        this.book_content = book.getBook_content();
        this.book_publisher = book.getBook_publisher();

    }



    public BookDTO(String isbn13, String categoryName, String title, String author, String pubDate, String cover, String description, String publisher) {
        book_isbn13 = isbn13;
        book_category = categoryName;
        book_title = title;
        book_author = author;
        book_pubdate = pubDate;
        book_img = cover;
        book_content = description;
        book_publisher = publisher;

    }


}
