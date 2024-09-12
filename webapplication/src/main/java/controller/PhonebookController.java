package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.PhonebookVO;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController {

    @Autowired
    private PhonebookService phonebookService;

    @GetMapping("/")
    public String home() {
        return "phonebooklist";
    }

    @GetMapping("/list")
    public String getAllPhonebooks(Model model) {
        List<Map<String, Object>> phonebooks = phonebookService.selectAll();
        model.addAttribute("phonebooks", phonebooks);
        return "phonebooklist";  
    }

    @GetMapping("/add")
    public String addPhonebookForm() {
        return "phonebookadd";  
    }

    @PostMapping("/insert")
    public String addPhonebook(PhonebookVO phonebook) {
        phonebookService.insert(phonebook);
        return "redirect:/list";  
    }

    @GetMapping("/edit/{id}")
    public String editPhonebookForm(@PathVariable int id, Model model) {
        Map<String, Object> phonebook = phonebookService.selectById(id);
        model.addAttribute("phonebook", phonebook);
        return "phonebookedit";  
    }

    @PostMapping("/update")
    public String updatePhonebook(PhonebookVO phonebook) {
        phonebookService.update(phonebook);
        return "redirect:/list";  
    }
}