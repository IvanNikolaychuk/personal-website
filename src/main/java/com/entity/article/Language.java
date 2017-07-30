package com.entity.article;

import java.util.Arrays;

public enum Language {
    EN("EN"), RU("RU");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public static Language find(String langString) {
        return Arrays.stream(Language.values())
                .filter(language -> language.language.equalsIgnoreCase(langString))
                .findFirst()
                .orElse(EN);
    }
}
