package com.project.history.global.sort;

import com.project.history.domain.domain.entity.User;

import java.util.Comparator;

public class PointComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if(o1.getPoint() > o2.getPoint()) {
            return 1;
        } else if(o1.getPoint() < o2.getPoint()) {
            return -1;
        }
        return 0;
    }
}

