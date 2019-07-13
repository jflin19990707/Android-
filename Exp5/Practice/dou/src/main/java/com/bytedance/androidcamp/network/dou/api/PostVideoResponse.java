package com.bytedance.androidcamp.network.dou.api;

import com.google.gson.annotations.SerializedName;

public class PostVideoResponse {
    @SerializedName("success") private boolean success;
    public boolean isSuccess(){return success;}
    public void getSuccess(boolean success){this.success=success;}

}



