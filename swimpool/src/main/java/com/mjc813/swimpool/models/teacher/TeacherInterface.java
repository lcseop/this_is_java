package com.mjc813.swimpool.models.teacher;

import com.mjc813.swimpool.models.swimpool.SwimPoolInterface;

public interface TeacherInterface {
    Integer getId();
    void setId(Integer id);

    String getName();
    void setName(String name);

    String getMain();
    void setMain(String main);

    Integer getBirthYear();
    void setBirthYear(Integer birthYear);

    Integer getSwimPoolId();
    void setSwimPoolId(Integer swimPoolId);

    SwimPoolInterface getSwimPool();
    void setSwimPool(SwimPoolInterface swimPool);

    default TeacherInterface copyMembers(TeacherInterface src, boolean forced) {
        if (src == null) {
            return this;
        }
        if (forced || src.getId() != null) {
            this.setId(src.getId());
        }
        if (forced || src.getName() != null) {
            this.setName(src.getName());
        }
        if (forced || src.getMain() != null) {
            this.setMain(src.getMain());
        }
        if (forced || src.getBirthYear() != null) {
            this.setBirthYear(src.getBirthYear());
        }
        if (forced || src.getSwimPoolId() != null) {
            this.setSwimPoolId(src.getSwimPoolId());
            this.getSwimPool().copyMembers(src.getSwimPool(), forced);
        }
        return this;
    }

}
