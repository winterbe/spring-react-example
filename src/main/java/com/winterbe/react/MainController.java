package com.winterbe.react;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Benjamin Winterberg
 */
@Controller
public class MainController {

    private CommentService service;

    private React react;

    @Autowired
    public MainController(CommentService service) {
        this.service = service;
        this.react = new React();
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) throws ScriptException {
        List<Comment> comments = service.getComments();
        String commentBox = react.renderCommentBox(comments);
        model.put("content", commentBox);
        return "index";
    }

}
