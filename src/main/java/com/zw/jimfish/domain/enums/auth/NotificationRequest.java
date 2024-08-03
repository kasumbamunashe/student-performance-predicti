package com.zw.jimfish.domain.enums.auth;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest {
    private String content;
    private String subject;
    @Embedded
    private Recipient recipient;
    private boolean isEmail;
    private boolean isSMS;
    private boolean isPush;
}
