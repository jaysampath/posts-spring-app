package com.assignment.hypertest.app.PostApplication.web;

import com.assignment.hypertest.app.PostApplication.service.PostService;
import com.assignment.hypertest.app.PostApplication.web.request.PostRequest;
import com.assignment.hypertest.app.PostApplication.web.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/createNewPost")
    public PostResponse createNewPost(@RequestBody PostRequest postRequest) {
        return postService.createNewPost(postRequest);
    }
}
