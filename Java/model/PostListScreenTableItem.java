package model;

import java.sql.Timestamp;

public class PostListScreenTableItem {
    private Timestamp postDatetime;
    private String postAuthor;
    private String postTitle;
    private String postId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Timestamp getPostDatetime() {
        return postDatetime;
    }

    public void setPostDatetime(Timestamp postDatetime) {
        this.postDatetime = postDatetime;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}
