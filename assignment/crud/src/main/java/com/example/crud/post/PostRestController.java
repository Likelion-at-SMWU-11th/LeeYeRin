package com.example.crud.post;

import com.example.crud.exception.PostNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final List<prePostDto> postList;

    public PostRestController(){
        this.postList = new ArrayList<>();
    }

    // 1 createPost
    // http://localhost:8080/post
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody prePostDto prePostDto){
        logger.info(prePostDto.toString());
        this.postList.add(prePostDto);
    }

    // 2 get
    // http://localhost:8080/post
    // GET /post
    @GetMapping()
    public List<prePostDto> readPostAll(){
        logger.info("in read post all");
        return this.postList;
    }

    // GET /post/0/
    // GET /post?id=0/
    @GetMapping("{id}")
    public prePostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postList.get(id);
    }

    @PutMapping("{id}")
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody prePostDto prePostDto
    ){
        prePostDto targetPost= this.postList.get(id);
        if(prePostDto.getTitle()!=null) {
            targetPost.setTitle(prePostDto.getTitle());
        }
        if(prePostDto.getContent()!=null) {
            targetPost.setContent(prePostDto.getContent());
        }
        if(prePostDto.getWriter()!=null) {
            targetPost.setWriter(prePostDto.getWriter());
        }
        this.postList.set(id, targetPost);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id){
        this.postList.remove(id);
    }

    @GetMapping("/test-exception")
    public void throwException(){
        System.out.println("test-exception");
        throw new PostNotExistException();
    }
}
