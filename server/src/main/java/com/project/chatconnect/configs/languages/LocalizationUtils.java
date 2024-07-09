package com.project.chatconnect.configs.languages;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.Objects;

/**
 * The type Localization utils.
 *
 * @author Huy Dang
 */
@Component
@RequiredArgsConstructor
public class LocalizationUtils {
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    /**
     * Gets localize message.
     *
     * @param message the message
     * @param params  the params
     * @return the localize message
     */
    public String getLocalizeMessage(String message, Objects... params) {
        HttpServletRequest request = ServletRequest.getCurrentRequest();
        Locale locale = localeResolver.resolveLocale(request);
        return messageSource.getMessage(message, params, locale);
    }
}
