package com.proj.bookbook.Controller;


import com.proj.bookbook.DTO.BookDTO;
import com.proj.bookbook.DTO.ResponseDTO;
import com.proj.bookbook.Model.Book;
import com.proj.bookbook.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books" )
@CrossOrigin("*")
public class BookController {

    @Autowired
    private final BookService bookService;
//
    @PostMapping("/book_list")
    public ResponseEntity<?> fetchDataFromApi(){
//        bookService.save();
        Book book = new Book( );
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("api")
    public String index(){
        return "BookSearch";
    }

    @GetMapping("/booklist")
    public ResponseEntity<?>  book_list(BookDTO bookDTO){

        bookService.book_list();
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);

    }

    @GetMapping("/books")
    public ResponseEntity<?>  books_All() {
        try{
            List<Book> restaurantList = bookService.findAll();

            List<BookDTO> bookDTOS = restaurantList.stream().map(BookDTO::new).collect((Collectors.toList()));

            return ResponseEntity.ok().body(bookDTOS);
        }
        catch(Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }




}
