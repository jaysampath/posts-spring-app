package com.assignment.hypertest.app.PostApplication.web.request;

import lombok.Data;

@Data
public class PostRequest {
    private String postName;
    private String postContents;
}
