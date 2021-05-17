package com.pkiks1.passwordmanager.dto;

import java.util.Objects;

public final class CredentialDto {

    private final String id;
    private final String userId;
    private final String title;
    private final String email;
    private final char[] password;

    private CredentialDto(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.title = builder.title;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class Builder {
        private String id;
        private String userId;
        private String title;
        private String email;
        private char[] password;

        public Builder() {}

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(char[] password) {
            this.password = password;
            return this;
        }

        public CredentialDto build() {
            return new CredentialDto(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public char[] getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialDto that = (CredentialDto) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(title, that.title) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, email);
    }

    @Override
    public String toString() {
        return "CredentialDto{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
