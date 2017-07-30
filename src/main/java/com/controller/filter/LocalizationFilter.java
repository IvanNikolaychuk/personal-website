package com.controller.filter;

import com.entity.article.Language;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class LocalizationFilter implements Filter {
    public static final String LANGUAGE_ATTRIBUTE = "lang";

    private static final String DEFAULT_LANGUAGE = Language.EN.name();
    private static final List<String> KNOWN_LANGUAGES = Arrays.asList(Language.EN.name(), Language.RU.name());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String language = pickLanguage(servletRequest.getLocale());
        servletRequest.setAttribute(LANGUAGE_ATTRIBUTE, language);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String pickLanguage(Locale locale) {
        if (locale == null) return DEFAULT_LANGUAGE;

        final String language = locale.getLanguage().toUpperCase();
        return KNOWN_LANGUAGES.contains(language) ? language : DEFAULT_LANGUAGE;
    }

    @Override
    public void destroy() {
    }
}
