package diploma.controller;


import diploma.model.Tred;
import diploma.service.SectionService;
import diploma.service.TredService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class SectionController {
    SectionService sectionService;
    TredService tredSrvice;

    SectionController(SectionService sectionService, TredService tredService) {
        this.sectionService = sectionService;
        this.tredSrvice = tredService;
    }


    @GetMapping("/{teg}")
    String anime(@PathVariable("teg") String teg , Model model){
        List<Tred> list= tredSrvice.getTredBySection(teg);
        model.addAttribute("treds",tredSrvice.getTredBySection(teg));

        return "treds";
    }


}
