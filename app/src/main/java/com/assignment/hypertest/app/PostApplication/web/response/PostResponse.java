package com.assignment.hypertest.app.PostApplication.web.response;

import com.assignment.hypertest.app.PostApplication.entity.Post;
import lombok.Data;

@Data
public class PostResponse {
    private Post dbPost;
    private TimeApiResponse httpOutbound;
}
