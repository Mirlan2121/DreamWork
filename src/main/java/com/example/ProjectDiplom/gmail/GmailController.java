package com.example.ProjectDiplom.gmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gmail")
public class GmailController {
    @Autowired
    private GmailService gmailService;

    @PostMapping("/save")
    public Boolean send(@RequestBody GmailModel gmailModel){
        return gmailService.send(gmailModel.getToGmail(), gmailModel.getSubject(), gmailModel.getText());
    }
}
