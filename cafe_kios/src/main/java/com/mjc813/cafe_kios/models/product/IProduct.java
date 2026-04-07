package com.mjc813.cafe_kios.models.product;

public interface IProduct {
    Integer getPrice();
    void setPrice(Integer id);

//    Integer getCategoryId();
//    void setCategoryId(Integer categoryId);

    String getPicture();
    void setPicture(String picture);

    default IProduct copyMembers(IProduct src) {
        if (src != null) {
            if (src.getPrice() != null) this.setPrice(src.getPrice());
//            if (src.getCategoryId() != null) this.setCategoryId(src.getCategoryId());
            if (src.getPicture() != null) this.setPicture(src.getPicture());
        }
        return this;
    }
}
