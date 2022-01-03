package com.book_borrow.controller;

import com.book_borrow.model.Book;
import com.book_borrow.model.BookBorrow;
import com.book_borrow.service.IBookBorrowService;
import com.book_borrow.service.IBookService;
import com.book_borrow.util.QuantityBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookBorrowService bookBorrowService;

    @GetMapping(value = {"/", ""})
    public String showHome() {
        return "home";
    }

    @GetMapping("/borrow")
    public String showListBook(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "borrow";
    }

    //C2: Use ModelAndView
//    @GetMapping("/borrow")
//    public ModelAndView showListBook() {
//        return new ModelAndView("borrow", "bookList", bookService.findAll());
//    }

    @GetMapping("/borrow/{id}")
    public String showBorrowForm(@PathVariable(value = "id") Integer id, Model model) throws QuantityBookException {
        //Lấy id của Book
//        Optional<Book> bookOptional = bookService.findById(id);
//        Book book = bookOptional.get();
//        Integer quantityBook = book.getQuantity();
        Book book = bookService.findById(id);
        Integer quantityBook = book.getQuantity();
        //Kiểm tra số lượng sách có = 0 hay ko
        if (quantityBook == 0) {
            throw new QuantityBookException();
        }
        book.setQuantity(quantityBook - 1);
        //lưu vào DB
        bookService.save(book);
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("message", "Borrow successfully");
        //tạo biến random
        int num = (int) (Math.random() * 89999 + 10000);   //10k + 89,000 =99,000
        //Code là String => ép kiểu
        String codeBorrow = String.valueOf(num);
        //hiển thị cho ng dùng
        model.addAttribute("code",codeBorrow);
        //lưu code vào DB
        BookBorrow bookBorrow = new BookBorrow(codeBorrow,book);
        bookBorrowService.save(bookBorrow);
        return "home";
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

//    @GetMapping("/return-book/{id}")
//    public String showFormReturn(@PathVariable Integer id, Model model) throws Exception {
//        Optional<Book> book = bookService.findById(id);
//        if (book != null) {
//            model.addAttribute("book", book.get());
//            return "borrow";
//        } else {
//            return "test";
//        }
//    }

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
        return "borrow";
    }

    //Exception/RuntimeException/InputMisMatchException/NumberFormatException/...
    @ExceptionHandler(Exception.class)
    public String handleException(Model model) {
        return "test";
    }
}
