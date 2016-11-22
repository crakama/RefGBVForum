package com.dadaabs.mhealth.Models;

/**
 * Created by crakama on 11/21/2016.
 */

public class HygeneTipsModel {


    public HygeneTipsModel() {

    }

    public HygeneTipsModel(String title, String titleBody) {
        this.title = title;
        this.titleBody = titleBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleBody() {
        return titleBody;
    }

    public void setTitleBody(String titleBody) {
        this.titleBody = titleBody;
    }

    private String title,titleBody;
}
