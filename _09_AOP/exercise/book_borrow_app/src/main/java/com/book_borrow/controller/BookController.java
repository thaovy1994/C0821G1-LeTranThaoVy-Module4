package com.book_borrow.controller;

import com.book_borrow.model.Book;
import com.book_borrow.service.IBookBorrowService;
import com.book_borrow.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookBorrowService bookBorrowService;

//    @GetMapping("/")
//    public String showHome(Model model) {
//        return "/home";
//    }

    @GetMapping("/book")
    public String showListBook(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "list";
    }

    @GetMapping("/create-book")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/create-book")
    public String saveBook(@Valid @ModelAttribute("book") Book book, Model model) {
        bookService.save(book);
        model.addAttribute("book", book);
        model.addAttribute("message", "New book created successfully");
        return "redirect:/book";
    }

    @GetMapping("/borrow-book/{id}")
    public String showFormBorrow(@PathVariable Integer id, Model model) throws Exception {
        Optional<Book> book = bookService.findById(id);
        if (book.get().getNumber() != 0) {
            model.addAttribute("book", book.get());
            return "detail";

        } else {
            return "test";
        }
    }

    @PostMapping("/borrowBook/{id}")
    public String borrowBook(@PathVariable Integer id, Model model,
                             RedirectAttributes redirectAttributes) throws Exception {
        Optional<Book> bookOptional = bookService.findById(id);
        Book book = bookOptional.get();
        book.setNumber(book.getNumber() - 1);
        bookService.save(book);
        bookService.addBorrow(book);
        model.addAttribute("bookList", bookService.findAll());
//        redirectAttributes.addFlashAttribute("message", "Borrow successfully");
        return "/list_borrow";
    }

    @GetMapping("/return-book/{id}")
    public String showFormReturn(@PathVariable Integer id, Model model) throws Exception {
        Optional<Book> book = bookService.findById(id);
        if (book != null) {
            model.addAttribute("book", book.get());
            return "list";
        } else {
            return "test";
        }
    }

    @PostMapping("/return")
    public String returnBook(@ModelAttribute("book") Book book,
                             @RequestParam String code,
                             Model model,
                             RedirectAttributes redirectAttributes) throws Exception {
        if (bookBorrowService.returnBook(book, Integer.parseInt(code))) {
            redirectAttributes.addFlashAttribute("message", "Return successfully");
            return "redirect:/book";
        } else {
            throw new Exception();
        }
    }

    @GetMapping("/borrow-list")
    public String showListBorrow(Model model) {
        model.addAttribute("bookBorrowList", bookBorrowService.findAll());
        return "list";
    }

    //Exception/RuntimeException/InputMisMatchException/NumberFormatException/...
    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {
        return "test";
    }
}
