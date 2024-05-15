package com.assignment.hypertest.app.PostApplication.service;

import com.assignment.hypertest.app.PostApplication.web.request.PostRequest;
import com.assignment.hypertest.app.PostApplication.web.response.PostResponse;

public interface PostService {
    PostResponse createNewPost(PostRequest postRequest);
}
