package com.kukucorn.study.springboot.web;

import com.kukucorn.study.springboot.service.posts.PostsService;
import com.kukucorn.study.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsSevice;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsSevice.findAllDesc());
        return "index"; // Controller 에서 문자열을 반환하면 mustache starter 가 자동으로 경로와 확장자를 지정해준다.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsSevice.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
