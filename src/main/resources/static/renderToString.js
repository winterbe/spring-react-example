var renderCommentBox = function (data) {
    var comments = Java.from(data);
    return React.renderToString(
        React.createElement(CommentBox, {data: comments, url: "comments.json", pollInterval: 5000})
    );
};
