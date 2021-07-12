package diploma.controller;


import diploma.model.Answer;
import diploma.model.Post;
import diploma.repository.AnswerRepository;
import diploma.service.AnswerService;
import diploma.service.PostService;
import diploma.service.TredService;
import diploma.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.util.*;

@Controller
public class TredController {
    final UserService userService;
    final PostService postService;
    final TredService tredService;
    final AnswerService answerService;

    TredController(UserService userService, PostService postService, TredService tredService, AnswerService answerService) {
        this.userService = userService;
        this.postService = postService;
        this.tredService = tredService;
        this.answerService = answerService;

    }

    @GetMapping("/info/{tred_id}")
    String tredPosts(@PathVariable("tred_id") String id, Model model) {

        model.addAttribute("item",id);
        List<Post> posts = postService.getPostsByTredId(id);

        if (posts.isEmpty())
            throw new TemplateProcessingException(" помилка контроллера" + TredController.class.getName());

        model.addAttribute("posts", postService.getPostsByTredId(id));

        List<Answer> answers = new ArrayList<>();



        for (var object : postService.getPostsByTredId(id)) {
            answers.addAll(answerService.getAllByPostId(object.getPostId()));

        }
            for(var show: answers){
                System.err.println(show.getId());


            }
        model.addAttribute("answers", answers);

        return "tred";
    }


}
