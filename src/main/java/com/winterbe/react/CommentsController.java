package com.winterbe.react;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Winterberg
 */
@RestController
public class CommentsController {

    private List<Comment> comments = new ArrayList<>();

    public CommentsController() {
        comments.add(new Comment("Peter Parker", "This is a comment."));
        comments.add(new Comment("John Doe", "This is *another* comment."));
    }

    @RequestMapping("comments.json")
    public List<Comment> getComments() {
        return comments;
    }

}
