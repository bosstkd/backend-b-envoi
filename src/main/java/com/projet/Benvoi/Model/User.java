package com.projet.Benvoi.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.persistence.UniqueConstraint;
	  

@Entity
@Table(name = "Utilisateur",
uniqueConstraints = {
@UniqueConstraint(columnNames = "username"
+ ""),
@UniqueConstraint(columnNames = "email")
})
public class User {
@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 @NotBlank
@Size(max = 20)
 private String username;
 @NotBlank
 @Size(max = 20)
 @Email
 private String email;
 private String password;
 private String role;
 private boolean isActive;
public long getId() {
return id;
}
public void setId(long id) {
this.id = id;
}
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getRole() {
return role;
}
public void setRole(String role) {
this.role = role;
}
public boolean isActive() {
return isActive;
}
public void setActive(boolean isActive) {
this.isActive = isActive;
}
public User() {
super();
// TODO Auto-generated constructor stub
}
public User(long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 20) @Email String email,
String password, String role, boolean isActive) {
super();
this.id = id;
this.username = username;
this.email = email;
this.password = password;
this.role = role;
this.isActive = isActive;
}
@Override
public String toString() {
return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
+ role + ", isActive=" + isActive + "]";
}


}

