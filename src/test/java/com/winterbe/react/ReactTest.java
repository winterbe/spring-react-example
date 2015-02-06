package com.winterbe.react;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReactTest {

    @Test
    public void testRenderCommentBox() throws Exception {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("Peter Parker", "This is a comment."));
        comments.add(new Comment("John Doe", "This is *another* comment."));

        React react = new React();
        String html = react.renderCommentBox(comments);

        Assert.assertThat(html, Matchers.startsWith("<div"));
    }

}