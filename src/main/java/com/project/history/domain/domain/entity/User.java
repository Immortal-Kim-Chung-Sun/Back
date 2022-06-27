package com.project.history.domain.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_rank")
    private int rank;

    @Column(name = "user_point")
    private Long point;

    @Builder
    public User(int rank, String name, Long point) {
        this.rank = rank;
        this.name = name;
        this.point = point;
    }
}
