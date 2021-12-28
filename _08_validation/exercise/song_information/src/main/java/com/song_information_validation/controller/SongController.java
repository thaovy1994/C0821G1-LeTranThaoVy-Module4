package com.song_information_validation.controller;

import com.song_information_validation.dto.SongDTO;
import com.song_information_validation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public ModelAndView listPage() {
        return new ModelAndView("list_song", "songList", songService.getAll());
    }

    @GetMapping("/create_song")
    public String showCreateForm(Model model) {
        model.addAttribute("songs", new SongDTO());
        return "create_song";
    }

    @PostMapping(value = "/create_song")
    public String createNewBlog(@Valid @ModelAttribute("songs") SongDTO songDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "create_song";
        }
        songService.save(songDto);
        redirectAttributes.addFlashAttribute("songList", songService.getAll());
        redirectAttributes.addFlashAttribute("message", "Create new successfully!");
        return "redirect:/list";
    }
}
