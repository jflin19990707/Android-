package com.bytedance.androidcamp.network.dou.api;

import com.bytedance.androidcamp.network.dou.model.Video;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetVideoResponse {
    @SerializedName("success") private boolean success;
    @SerializedName("feeds") private List<Video> videos;

    public boolean isSuccess(){return success;}

    public void setSuccess(boolean success){this.success=success;}

    public List<Video> getVideos(){return videos;}

    public void setVideos(List<Video> videos){this.videos=videos;}

}
