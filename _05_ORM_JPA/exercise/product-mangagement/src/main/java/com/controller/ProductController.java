package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private IProductService service;

    @GetMapping(value = "")
    public String showList(Model model) {
        model.addAttribute("productList", service.show());
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        service.create(product);
        redirect.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/update")
    public String showEdit(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("product", service.showDetail(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String edit(@ModelAttribute("product")Product product, RedirectAttributes redirect) {
        service.update(product);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("product", service.showDetail(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestParam(name = "id") String id, RedirectAttributes redirect) {
        service.delete(id);
        redirect.addFlashAttribute("success", "Delete product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "{id}/detail")
    public String getStudentDetail(@PathVariable(name = "id") String id, Model model) {
        model.addAttribute("product", service.showDetail(id));
        return "detail";
    }

    @PostMapping(value = "/detail")
    public String detail(@RequestParam(name = "id") String id, RedirectAttributes redirect) {
        service.showDetail(id);
        redirect.addFlashAttribute("success", "Detail product successfully!");
        return "redirect:/product";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam(name = "name") String name, Model model) {
        List<Product> productList = service.findByName(name);
        model.addAttribute("productList",productList);
        return "list";
    }
}
