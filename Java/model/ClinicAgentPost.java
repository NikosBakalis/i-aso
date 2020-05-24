package model;

public class ClinicAgentPost {
    private static String username, title, postText;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        ClinicAgentPost.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        ClinicAgentPost.title = title;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        ClinicAgentPost.postText = postText;
    }
}
