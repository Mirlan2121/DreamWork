package com.example.ProjectDiplom.gmail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GmailModel {
    private String toGmail;
    private String subject;
    private String text;
}
