package com.mjc813.login_cookie.models.member;

import java.time.LocalDateTime;

public interface IMember {
    Long getId();
    void setId(Long id);

    String getSignId();
    void setSignId(String signId);

    String getPassword();
    void setPassword(String password);

    String getEmail();
    void setEmail(String email);

    Boolean getIsValidEmail();
    void setIsValidEmail(Boolean isValidEmail);

    LocalDateTime getCreateDt();
    void setCreateDt(LocalDateTime createDt);

    LocalDateTime getUpdateDt();
    void setUpdateDt(LocalDateTime updateDt);

    LocalDateTime getDeleteDt();
    void setDeleteDt(LocalDateTime deleteDt);

    default IMember clone(IMember src, boolean forced) {
        if (src == null) {
            return this;
        }
        if (forced || src.getId() == null) {
            src.setId(this.getId());
        }
        if (forced || src.getSignId() == null) {
            src.setSignId(this.getSignId());
        }
        if (forced || src.getPassword() == null) {
            src.setPassword(this.getPassword());
        }
        if (forced || src.getEmail() == null) {
            src.setEmail(this.getEmail());
        }
        if (forced || src.getIsValidEmail() == null) {
            src.setIsValidEmail(this.getIsValidEmail());
        }
        if (forced || src.getCreateDt() == null) {
            src.setCreateDt(this.getCreateDt());
        }
        if (forced || src.getUpdateDt() == null) {
            src.setUpdateDt(this.getUpdateDt());
        }
        if (forced || src.getDeleteDt() == null) {
            src.setDeleteDt(this.getDeleteDt());
        }
        return src;
    }
}
