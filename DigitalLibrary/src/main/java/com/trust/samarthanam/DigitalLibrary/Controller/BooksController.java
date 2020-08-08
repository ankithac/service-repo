package com.trust.samarthanam.DigitalLibrary.Controller;


import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:3000")

public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Samarthanam";
    }

    //----------------------------------------------------get all books-------------------------------------------------
    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBooks() {
        return ResponseEntity.ok().body((bookService.listBooks()));
    }

    //----------------------------------------------------get books by format-------------------------------------------

    @GetMapping("/books/format/{key}")
    public List<Books> getBookByFormat(@PathVariable String key){
        return bookService.getBookByFormat(key);
    }

    //---------------------------------------------------get book by id-------------------------------------------------
    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBookbyid(@PathVariable String id) {
        return ResponseEntity.ok().body((bookService.getById(id)));
    }

   //------------------------------------------------get book by keywords----------------------------------------------
    @GetMapping("/books/search={key}")
    public ResponseEntity<Collection<Books>> findBook(@PathVariable String key) {
        return ResponseEntity.ok().body((bookService.searchBooks(key)));
    }

    //--------------------------------------------get books by subcategory----------------------------------------------
    @GetMapping("/books/subcategory/{key}")
    public Collection<Books> findBooksByTopic( @PathVariable String key) {
        return bookService.getBooksBySubCategory(key);
    }


}

