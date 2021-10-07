package com.delivair.common.payload.request;

import lombok.Data;

@Data
public class AuditRequest {
    private Integer isDeleted = 0;
}
