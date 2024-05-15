package ru.itis.semester_work3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.semester_work3.dto.BookDto;
import ru.itis.semester_work3.dto.FavouriteDto;
import ru.itis.semester_work3.security.UserDetailsImpl;
import ru.itis.semester_work3.services.impl.BookServiceImpl;
import ru.itis.semester_work3.services.impl.FavouriteServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteServiceImpl favouriteService;
    private final BookServiceImpl bookService;

    @PostMapping("/main")
    public void saveFavouriteBook(@AuthenticationPrincipal UserDetailsImpl user, BookDto book) {
        FavouriteDto favouriteDto = FavouriteDto.builder()
                .userId(user.getUserEntity().getUserId())
                .bookId(book.getBookId())
                .build();

        favouriteService.addFavourite(favouriteDto);

    }

    @GetMapping("/favourite")
    public String showFavourites(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        List<FavouriteDto> favouriteList;
        List<BookDto> bookList = new ArrayList<>();
        favouriteList = favouriteService.getUsersFavourites(user.getUserEntity().getUserId());
        for (FavouriteDto favouriteDto : favouriteList) {
            BookDto book = bookService.getBookDtoById(favouriteDto.getBookId());
            bookList.add(book);
        }
        model.addAttribute("bookList", bookList);
        return "favourite_page";
    }

    @PostMapping("/favourite")
    public void deleteFavouriteBook(@AuthenticationPrincipal UserDetailsImpl user, BookDto book) {
        FavouriteDto favouriteDto = FavouriteDto.builder()
                .userId(user.getUserEntity().getUserId())
                .bookId(book.getBookId())
                .build();

        favouriteService.deleteFavourite(favouriteDto);

    }
}
