var renderCommentBox = function (title) {
    return React.renderToString(
        React.createElement(CommentBox, {title: title, url: "comments.json", pollInterval: 5000})
    );
};
