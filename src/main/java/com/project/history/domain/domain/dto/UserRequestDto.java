package com.project.history.domain.domain.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {

    @NotNull
    private String name;

    private Long point;

    @Builder
    public UserRequestDto(String name, Long point) {
        this.name = name;
        this.point = point;
    }
}
