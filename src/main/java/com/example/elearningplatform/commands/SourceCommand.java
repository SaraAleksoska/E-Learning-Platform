package com.example.elearningplatform.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SourceCommand {
    private Long id;
    private String source;
    private String url;
}
