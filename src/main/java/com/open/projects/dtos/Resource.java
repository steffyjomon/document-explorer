package com.open.projects.dtos;

import com.open.projects.components.FileType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    String name;
    FileType fileType;
    String relativePath;
}
