package com.controller;

import com.model.Product;
import com.service.IProductService;
import com.service.impl.ProductService;
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
    public String create(@ModelAttribute Product product, RedirectAttributes redirect) {
        System.out.println(product.toString());
        System.out.println(product.getId()+ product.getName()+product.getPrice()+product.getDescription()+product.getProducer());
        service.create(product);
        redirect.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/update")
    public String showEdit(@PathVariable String id, Model model) {
        model.addAttribute("product", service.showDetail(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String edit(@ModelAttribute("product")Product product, Model model, RedirectAttributes redirect) {
        service.update(product);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable String id, Model model) {
        model.addAttribute("product", service.showDetail(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String delete(@RequestParam String id, Model model, RedirectAttributes redirect) {
        service.delete(id);
        redirect.addFlashAttribute("success", "Delete product successfully!");
        return "redirect:/product";
    }
    @PostMapping(value = "/search")
    public String search(@RequestParam String productName, Model model) {
        List<Product> productList = service.findByName(productName);
        model.addAttribute("productList",productList);
        return "list";
    }
}
