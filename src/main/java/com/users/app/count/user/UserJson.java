package com.users.app.count.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserJson {
    @JsonProperty("id")
    private String id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("avatarUrl")
    private String avatarUrl;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("followers")
    private int followers;
    @JsonProperty("publicRepos")
    private int publicRepos;
}
