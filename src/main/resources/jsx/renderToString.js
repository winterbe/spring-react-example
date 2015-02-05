var renderCommentBox = function (title) {
    return React.renderToString(
        <CommentBox title={title} url='comments.json' pollInterval={5000} />
    );
};
