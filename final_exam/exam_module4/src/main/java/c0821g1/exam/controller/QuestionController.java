package c0821g1.exam.controller;

import c0821g1.exam.dto.QuestionDto;
import c0821g1.exam.model.Question;
import c0821g1.exam.service.IQuestionService;
import c0821g1.exam.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IQuestionTypeService questionTypeService;

    @GetMapping(value = "/list")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("id").ascending();
        Page<Question> questionPage = questionService.findAll(PageRequest.of(page, 4, sort));
        model.addAttribute("questionTypes", questionTypeService.getAll());
        model.addAttribute("questionPage", questionPage);
        return "question/list";
    }

//    @GetMapping("/search")
//    public String searchQuestion(@RequestParam(name = "title") String title, Pageable pageable, Model model) {
//        Page<Question> questionPage = questionService.findByTitle(pageable, title);
//        model.addAttribute("questionPage", questionPage);
//        return "question/list";
//    }

    @PostMapping("/search")
    public String searchQuestion(@RequestParam(name = "title") String title,
                                 @RequestParam(name = "questionType") String questionType,
                                 Pageable pageable, Model model) {
        Page<Question> questionPage = questionService.findByTitleAndQuestionTypePage(title, questionType, pageable);
        model.addAttribute("questionTypes",questionTypeService.getAll());
        model.addAttribute("questionPage", questionPage);
        return "question/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("questionType", questionTypeService.getAll());
        model.addAttribute("question", new Question());
        return "question/create";
    }

    @PostMapping(value = "/create")
    public String createNewQuestion(Model model, @Valid @ModelAttribute("question") QuestionDto questionDto,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes,
            HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionType", questionTypeService.getAll());
            return "question/create";
        }
        questionService.save(questionDto);
        redirectAttributes.addFlashAttribute("questionPage", questionService.getAll());
        return "redirect:/question/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable(name = "id") Integer id, Model model) {
        Question question = questionService.findById(id);
        model.addAttribute("question", question);
        return "question/edit";
    }

    @PostMapping("/edit")
    public String editQuestion(Model model, @Valid @ModelAttribute("question") QuestionDto employeeDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes
            , HttpServletResponse response, @CookieValue(value = "cookieCount", defaultValue = "0") int newCookie) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionType", questionTypeService.getAll());
            return "question/edit";
        }
        questionService.save(employeeDto);
        redirectAttributes.addFlashAttribute("questionPage", questionService.getAll());
        redirectAttributes.addFlashAttribute("message", "Update successfully!");
        return "redirect:/question/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(name = "id") Integer id) {
        questionService.remove(id);
        return "redirect:/question/list";
    }

}
