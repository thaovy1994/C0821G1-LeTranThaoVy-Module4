package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslationController {
    @GetMapping(value = "")
    public String index() {
        return "index";
    }

    @PostMapping(value = "")
    public String translate(@RequestParam(name = "word") String word, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("dog", "con cho");
        dictionary.put("cat", "con meo");
        dictionary.put("book", "quyen vo");

        if (dictionary.containsKey(word)) {
            model.addAttribute("result", dictionary.get(word));
        } else {
            model.addAttribute("result", "Not found");
        }
        return "index";
    }
}
