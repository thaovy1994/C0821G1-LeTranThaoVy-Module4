package vy.exam_module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vy.exam_module4.dto.ProductDto;
import vy.exam_module4.model.Product;
import vy.exam_module4.service.IOrderProductService;
import vy.exam_module4.service.IProductService;
import vy.exam_module4.service.IProductTypeService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IOrderProductService orderProductService;

    @GetMapping(value = "/list")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("id").ascending();
        Page<Product> productPage = productService.findAll(PageRequest.of(page, 5, sort));
        model.addAttribute("productPage", productPage);
        return "product/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable(name = "id") Integer id, Model model) {
        Product question = productService.findById(id);
        model.addAttribute("productTypeService", productTypeService.getAll());
        model.addAttribute("orderProductService", orderProductService.getAll());
        model.addAttribute("product", question);
        return "product/edit";
    }

    @PostMapping("/edit")
    public String editProduct(Model model, @Valid @ModelAttribute("product") ProductDto productDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes
            , HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypeService", productTypeService.getAll());
            model.addAttribute("orderProductService", orderProductService.getAll());
            model.addAttribute("productPage", productService.getAll());
            return "product/edit";
        }
        productService.save(productDto);
        redirectAttributes.addFlashAttribute("productPage", productService.getAll());
        return "redirect:/product/list";
    }
}
