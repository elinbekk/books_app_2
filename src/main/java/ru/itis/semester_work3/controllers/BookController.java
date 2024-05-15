package ru.itis.semester_work3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.security.UserDetailsImpl;
import ru.itis.semester_work3.services.impl.BookServiceImpl;
import ru.itis.semester_work3.services.impl.FilesServiceImpl;

import java.util.List;
import java.util.UUID;

import static ru.itis.semester_work3.config.UploadConfig.storagePath;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;
    private final FilesServiceImpl fileService;

    @GetMapping("/add_book")
    public String showAddBookPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", user.getUserEntity());
        return "add_book_page";
    }

    @PostMapping("/add_book")
    public String addBook(@AuthenticationPrincipal UserDetailsImpl user, @ModelAttribute("book") BookDto book,
                          @RequestParam("file") MultipartFile file, Model model) {
        String photoUrl = storagePath + file.getOriginalFilename();
        book.setOwnerId(user.getUserEntity().getUserId());
        book.setPhotoUrl(photoUrl);
        // System.err.println("Image name: " + fileName);
        bookService.saveBook(book);
        fileService.saveFile(file);
        model.addAttribute("book", book);
        model.addAttribute("user", user.getUserEntity());
        model.addAttribute("message", "Книга \"" + book.getTitle() + "\" добавлена");
        return "add_book_page";
    }


    @GetMapping("/my_books")
    public String showMyBooksPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        UUID userId = user.getUserEntity().getUserId();
        model.addAttribute("books", bookService.getBooksByUserId(userId));
        return "my_books_page";
    }




}
