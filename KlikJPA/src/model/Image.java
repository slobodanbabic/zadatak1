package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String url;

	//bi-directional many-to-one association to UsersHasImage
	@OneToMany(mappedBy="image")
	private List<UsersHasImage> usersHasImages;

	public Image() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<UsersHasImage> getUsersHasImages() {
		return this.usersHasImages;
	}

	public void setUsersHasImages(List<UsersHasImage> usersHasImages) {
		this.usersHasImages = usersHasImages;
	}

	public UsersHasImage addUsersHasImage(UsersHasImage usersHasImage) {
		getUsersHasImages().add(usersHasImage);
		usersHasImage.setImage(this);

		return usersHasImage;
	}

	public UsersHasImage removeUsersHasImage(UsersHasImage usersHasImage) {
		getUsersHasImages().remove(usersHasImage);
		usersHasImage.setImage(null);

		return usersHasImage;
	}

}