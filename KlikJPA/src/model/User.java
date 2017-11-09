package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private String username;	
		
	@Column(name="full_name")	
	private String fullName;

	private String password;

	//bi-directional many-to-one association to UsersHasImage
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<UsersHasImage> usersHasImages;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UsersHasImage> getUsersHasImages() {
		return this.usersHasImages;
	}

	public void setUsersHasImages(List<UsersHasImage> usersHasImages) {
		this.usersHasImages = usersHasImages;
	}

	public UsersHasImage addUsersHasImage(UsersHasImage usersHasImage) {
		getUsersHasImages().add(usersHasImage);
		usersHasImage.setUser(this);

		return usersHasImage;
	}

	public UsersHasImage removeUsersHasImage(UsersHasImage usersHasImage) {
		getUsersHasImages().remove(usersHasImage);
		usersHasImage.setUser(null);

		return usersHasImage;
	}

}