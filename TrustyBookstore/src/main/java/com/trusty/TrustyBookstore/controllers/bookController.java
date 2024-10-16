package com.trusty.TrustyBookstore.controllers;

import com.trusty.TrustyBookstore.models.book;
import com.trusty.TrustyBookstore.repository.bookJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {

    @Autowired
    private bookJPARepository bookrepo;


    @GetMapping
    public List<book> getBooks(){
        return bookrepo.findAll();
    }

    @GetMapping("{id}")
    public book getBookById(@PathVariable Integer id){

        return bookrepo.findById(id).get();
    }

    @PostMapping
    public book postBook(@RequestBody book newbook){
        return bookrepo.save(newbook);
    }

    @PutMapping("{id}")
    public book putBook(@PathVariable Integer id , @RequestBody book updatebook){
        book book = bookrepo.findById(id).get();
        book.setAuthor(updatebook.getAuthor());
        book.setDescription(updatebook.getDescription());
        book.setName(updatebook.getName());
        book.setPrice(updatebook.getPrice());
        return bookrepo.save(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Integer id){
        bookrepo.deleteById(id);
    }

    @PatchMapping("{id}")
    public book patchBook(@PathVariable Integer id, @RequestBody book updatebook){
       book book = bookrepo.findById(id).get();
        if (updatebook.getDescription() != null){
            book.setDescription(updatebook.getDescription());
        }
        if(updatebook.getAuthor() != null){
            book.setAuthor(updatebook.getAuthor());
        }
        if(updatebook.getName() != null){
            book.setName(updatebook.getName());
        }
        if(updatebook.getPrice() != -1) {
            book.setPrice(updatebook.getPrice());
        }
        return bookrepo.save(book);
    }


}
