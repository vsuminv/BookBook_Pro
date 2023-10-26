package com.proj.bookbook.Repository;

import com.proj.bookbook.DTO.BookDTO;
import com.proj.bookbook.Model.Book;
import com.proj.bookbook.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();


//    Book save( BookDTO bookDTO);
////
//    void save(ArrayList<BookDTO> arrayList);

}
