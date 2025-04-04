package com.scm.eis.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SocialMediaCommunication {

    FACEBOOK("Facebook"),INSTAGRAM("Instagram"),WHATSAPP("Whatsapp"),TWITEER_X("Twitter-X"),OTHERS("Others");

    private final String socialCommunication;
}
