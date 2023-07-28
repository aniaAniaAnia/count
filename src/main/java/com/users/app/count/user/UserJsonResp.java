package com.users.app.count.user;

public class UserJsonResp {
    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private double calculations;

    public UserJsonResp(UserJson userJson){
        this.id = userJson.getId();
        this.login = userJson.getLogin();
        this.name =  userJson.getName();
        this.type =  userJson.getType();
        this.avatarUrl =  getEmptyWhenNull(userJson.getAvatarUrl());
        this.createdAt =  getEmptyWhenNull(userJson.getCreatedAt());
        this.calculations = getCalculations(userJson);
    }

    private double getCalculations(UserJson userJson){
        if(userJson.getFollowers() != 0){
            return  6.0d / userJson.getFollowers() * (2.0d + userJson.getPublicRepos());
        }
        return 0;
    }

    private String getEmptyWhenNull(String string){
        if(string == null){
            return "";
        }
        return string;
    }
}
