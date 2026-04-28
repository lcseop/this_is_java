package com.mjc813.swimpool.models.swimpool;

public interface SwimPoolInterface {
    Integer getId();
    void setId(Integer id);

    String getName();
    void setName(String name);

    String getTel();
    void setTel(String tel);

    String getAddr1();
    void setAddr1(String addr1);

    String getAddr2();
    void setAddr2(String addr2);

    String getLanes();
    void setLanes(String lanes);

    Integer getSize();
    void setSize(Integer size);

    default SwimPoolInterface copyMembers(SwimPoolInterface src, boolean forced) {
        if (src == null) {
            return this;
        }
        if (forced || src.getId() != null) {
            this.setId(src.getId());
        }
        if (forced || src.getName() != null) {
            this.setName(src.getName());
        }
        if (forced || src.getTel() != null) {
            this.setTel(src.getTel());
        }
        if (forced || src.getAddr1() != null) {
            this.setAddr1(src.getAddr1());
        }
        if (forced || src.getAddr2() != null) {
            this.setAddr2(src.getAddr2());
        }
        if (forced || src.getLanes() != null) {
            this.setLanes(src.getLanes());
        }
        if (forced || src.getSize() != null) {
            this.setSize(src.getSize());
        }
        return this;
    }

}
