package com.priscilla.web.SocialLoginUserInfo;

import java.util.Map;

public class FacebookUserInfo {

    private Map<String, Object> attributes;

    public FacebookUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return (String) attributes.get("sub");
    }

    public String getName() {
        return (String) attributes.get("name");
    }

    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String toString() {
        return "FacebookUserInfo{" +
                "attributes=" + attributes +
                '}';
    }
}
