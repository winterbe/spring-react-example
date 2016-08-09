package com.winterbe.react;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Benjamin Winterberg
 */
@RestController
@RequestMapping("/comments.json")
public class CommentController {

    private CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> getComments() {
        return service.getComments();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Comment> addComment(Comment comment) {
        return service.addComment(comment);
    }

}
