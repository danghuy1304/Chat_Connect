package com.project.chatconnect.applications.services.mail;

import java.util.Map;

public interface IMailService {
    void sendEmail(String to, String subject, String content);

    void sendTemplateMail(String to, String subject, String templateName, Map<String, Object> variables);
}
