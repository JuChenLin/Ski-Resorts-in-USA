package com.priscilla.web.entity.user;

import com.priscilla.web.entity.enumerate.UserRole;
import com.priscilla.web.entity.skiresort.SkiResort;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//public abstract class User {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private final String id;
//
//    @Email
//    @Column
//    private String email;
//
//    @Column
//    private String username;
//
//    protected User(String id) {
//        this.id = id;
//    }
//
//    public User(String id, @Email String email, String username) {
//        this(id);
//        this.email = email;
//        this.username = username == null ? email : username;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//}

@RedisHash("user")
public class User implements Serializable {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "int(10) ZEROFILL", updatable = false, nullable = false)
    @Id
    private String id;

//    @Indexed
    private String externalID;
    private Boolean isActive = true;
    private Boolean isDeleted = false;

    @Email
    private String email;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private List<Integer> favorites = new ArrayList<>();
//    private String favoritesID;

    private static Integer defaultIdNum = 0;

    public User () {}

    private User(String id) {
        this.id = id;
    }

    public User(String id, @Email String email, String name, String idPrefix) {
        this(id,email, name, UserRole.USER, idPrefix);
    }

    public User(String id, @Email String email, String name, UserRole role, String idPrefix) {
        this(id);
        System.out.println("Creating User with ID => id = " + id + ", role = " + role.name());

        this.email = email;
        this.name = name == null ? email : name;
        this.role = role;
        this.externalID = idPrefix + String.format("%020d", defaultIdNum++);
    }

    // Copy Constructor
    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.name = user.name;
    }

    public String getId() {
        return id;
    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole userRole) {
        this.role = userRole;
    }

//    public String getFavoritesID() {
//        return favoritesID;
//    }
//
//    public void setFavoritesID(String favoritesID) {
//        this.favoritesID = favoritesID;
//    }

    public List<Integer> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Integer> favorites) {
        this.favorites = favorites;
    }

    public void addFavorites(Integer skiResortID) {
        this.favorites.add(skiResortID);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", externalID='" + externalID + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", favorites='" + favorites + '\'' +
                '}';
    }

    public void setAll(User request) {
        this.setName(request.getName());
        this.setEmail(request.getEmail());
        this.setRole(request.getRole());
        this.setFavorites(request.getFavorites());
    }
}