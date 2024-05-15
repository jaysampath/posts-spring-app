package com.assignment.hypertest.app.PostApplication.service;

import com.assignment.hypertest.app.PostApplication.entity.Post;
import com.assignment.hypertest.app.PostApplication.repository.PostRepository;
import com.assignment.hypertest.app.PostApplication.web.request.PostRequest;
import com.assignment.hypertest.app.PostApplication.web.response.PostResponse;
import com.assignment.hypertest.app.PostApplication.web.response.TimeApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private static final String TIME_API_URL = "https://worldtimeapi.org/api/timezone/Asia/Kolkata";

    @Autowired
    private PostRepository postsRepository;
    @Override
    public PostResponse createNewPost(PostRequest postRequest) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setName(postRequest.getPostName());
        post.setContents(postRequest.getPostContents());
        Post savedEntity = postsRepository.save(post);
        TimeApiResponse timeApiResponse = fetchDataFromApi();
        return buildApiResponse(savedEntity, timeApiResponse);
    }

    private PostResponse buildApiResponse(Post savedEntity, TimeApiResponse timeApiResponse) {
        PostResponse postResponse = new PostResponse();
        postResponse.setDbPost(savedEntity);
        postResponse.setHttpOutbound(timeApiResponse);
        return postResponse;
    }

    private TimeApiResponse fetchDataFromApi() {
        String response = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(TIME_API_URL);
            response = httpClient.execute(httpGet, new BasicHttpClientResponseHandler());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response, TimeApiResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
