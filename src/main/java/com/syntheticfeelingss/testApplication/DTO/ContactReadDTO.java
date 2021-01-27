package com.syntheticfeelingss.testApplication.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactReadDTO {
    private UUID id;
    private String name;
}
