package diploma.controller;


import diploma.model.Answer;
import diploma.model.Post;
import diploma.model.Tred;
import diploma.model.User;
import diploma.service.AnswerService;
import diploma.service.PostService;
import diploma.service.TredService;
import diploma.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    final PostService postService;
    final TredService tredService;
    final UserService userService;
    final AnswerService answerService;

    PostController(PostService postService, TredService tredService, UserService userService, AnswerService answerService) {
        this.postService = postService;
        this.tredService = tredService;
        this.userService = userService;
        this.answerService = answerService;
    }


    @PostMapping("/info/{tred_id}")
    String getPost(@RequestParam("post_value") String post_value, @PathVariable("tred_id") String id, Model model) {

       model.addAttribute("item",id);

        String userIp;
        Object obj = SecurityContextHolder.
                getContext().
                getAuthentication().
                getPrincipal();

        if (obj instanceof UserDetails) {
            userIp = ((UserDetails) obj).getUsername();


        } else {
            userIp = obj.toString();
        }
        User user_1 = userService.findByIp(userIp);

        Tred tred = tredService.readById(Long.parseLong(id));

        Post post = new Post();
        post.setMessage(post_value);
        post.setTime(LocalDateTime.now());
        post.setOwner(user_1);
        post.setTred(tred);

        postService.create(post);
        List<Post> posts = postService.getPostsByTredId(id);

        if (posts.isEmpty())
            throw new TemplateProcessingException(" помилка контроллера" + TredController.class.getName());

        model.addAttribute("posts", postService.getPostsByTredId(id));

        List<Answer> answers = new ArrayList<>();


        for (var object : postService.getPostsByTredId(id)) {
            answers.addAll(answerService.getAllByPostId(object.getPostId()));

        }
        for (var show : answers) {
            System.err.println(show.getId());


        }
        model.addAttribute("answers", answers);


        return "tred";
    }

}
