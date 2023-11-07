package com.example.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("post")
public class prePostController {
    private static final Logger logger = LoggerFactory.getLogger(prePostController.class);
    private final List<prePostDto> postList;

    public prePostController(){
        postList = new ArrayList<>();
    }

    @PostMapping("create")
    public void createPost(@RequestBody prePostDto prePostDto){
        logger.info(prePostDto.toString());
        this.postList.add(prePostDto);
    }
    @GetMapping("read-all")
    public List<prePostDto> readPostAll(){
        logger.info("in read all");
        return this.postList;
    }
    @GetMapping("read-one")
    public prePostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return this.postList.get(id);
    }
    @PostMapping("update")
    public void updatePost(
            @RequestParam("id") int id,
            @RequestBody prePostDto prePostDto
    ){
        prePostDto targetPost = this.postList.get(id);
        if(prePostDto.getTitle()!=null){
            targetPost.setTitle(prePostDto.getTitle());
        }
        if(prePostDto.getContent()!=null){
            targetPost.setContent((prePostDto.getContent()));
        }
        if(prePostDto.getWriter()!=null){
            targetPost.setWriter((prePostDto.getWriter()));
        }
        this.postList.set(id, targetPost);
    }
    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id){
        this.postList.remove(id);
    }
}
