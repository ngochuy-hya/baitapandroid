package com.example.videoshort_api.models;

import java.io.Serializable;

public class VideoModel implements Serializable {
    private String id;
    private String title;
    private String description;
    private String url;

    public VideoModel() {}

    public VideoModel(String id, String title, String description, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // ✅ Lấy videoId từ URL YouTube
    public String getVideoId() {
        try {
            String[] split = url.split("v=");
            if (split.length >= 2) {
                String id = split[1];
                int andIndex = id.indexOf("&");
                if (andIndex != -1) {
                    id = id.substring(0, andIndex);
                }
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
