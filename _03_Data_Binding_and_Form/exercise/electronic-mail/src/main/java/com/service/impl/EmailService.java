package com.service.impl;

import com.model.Email;
import com.service.IEmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {
    private static List<Email> emailList = new ArrayList<>();

    static {
        emailList.add(new Email("English", "25", "enable", "Thor"));
    }

    @Override
    public void create(Email email) {
        emailList.add(email);
    }
}
