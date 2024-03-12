package com.eva.springdemo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Task {
    private final String taskName;
    private final String serviceName;
}
