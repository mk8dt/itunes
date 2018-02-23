package com.quadran.itunes.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mario on 27/11/2017.
 */

public class Entry {

    @SerializedName("im:name")
    private Label name;
    private Label title;

    public Label getName() {
        return name;
    }

    public Label getTitle() {
        return title;
    }
}
