package com.priscilla.web.parameter;

public class UserQueryParameter {

    private Boolean isDeleted;
    private String nameKeyword;
    private String emailKeyword;
    private String role;
    private String orderBy;
    private String sortRule;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getNameKeyword() {
        return nameKeyword;
    }

    public void setNameKeyword(String nameKeyword) {
        this.nameKeyword = nameKeyword;
    }

    public String getEmailKeyword() {
        return emailKeyword;
    }

    public void setEmailKeyword(String emailKeyword) {
        this.emailKeyword = emailKeyword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSortRule() {
        return sortRule;
    }

    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
    }
}
