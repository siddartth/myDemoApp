package com.drund.viewsrequestsdemo.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Model for the `members/create/` error response to simplify forming a proper JSON String.
 * <p>
 * Created by amwomer on 1/8/18.
 */

public class CreateMemberRequestErrors {

    @Nullable
    public Errors errors;

    public CreateMemberRequestErrors() {
        errors = new Errors();
    }

    public class Errors {

        @SerializedName("display_name")
        public String displayName;
        @SerializedName("job_title")
        public String jobTitle;
        @SerializedName("job_description")
        public String description;

        Errors() {
        }
    }
}
