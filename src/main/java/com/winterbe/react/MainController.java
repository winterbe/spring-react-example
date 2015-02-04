package com.winterbe.react;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptException;
import java.util.Map;

/**
 * @author Benjamin Winterberg
 */
@Controller
public class MainController {

    private React react = new React();

    @RequestMapping("/")
    public String index(Map<String, Object> model) throws ScriptException {
        String commentBox = react.renderCommentBox();
        model.put("content", commentBox);
        return "index";
    }

}
