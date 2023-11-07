package com.example.crud.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ValidTestDto {
    @NotNull
    private String notNullString;
    @NotEmpty
    private String notEmptyString;
    @NotBlank
    private String notBlankString;
    @NotEmpty
    private List<String> notEmptyStringList;

    public ValidTestDto(){

    }
    public ValidTestDto(String notNullString, String notEmptyString, String notBlankString, List<String> notEmptyStringList) {
        this.notNullString = notNullString;
        this.notEmptyString = notEmptyString;
        this.notBlankString = notBlankString;
        this.notEmptyStringList = notEmptyStringList;
    }

    public String getNotNullString() {
        return notNullString;
    }

    public String getNotEmptyString() {
        return notEmptyString;
    }

    public String getNotBlankString() {
        return notBlankString;
    }

    public List<String> getNotEmptyStringList() {
        return notEmptyStringList;
    }

    public void setNotNullString(String notNullString) {
        this.notNullString = notNullString;
    }

    public void setNotEmptyString(String notEmptyString) {
        this.notEmptyString = notEmptyString;
    }

    public void setNotBlankString(String notBlankString) {
        this.notBlankString = notBlankString;
    }

    public void setNotEmptyStringList(List<String> notEmptyStringList) {
        this.notEmptyStringList = notEmptyStringList;
    }
}
