package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_has_images database table.
 * 
 */
@Entity
@Table(name="users_has_images")
@NamedQuery(name="UsersHasImage.findAll", query="SELECT u FROM UsersHasImage u")
public class UsersHasImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="img_ordinal")
	private Integer imgOrdinal;

	@Column(name="results_path")
	private String resultsPath;

	//bi-directional many-to-one association to Image
	@ManyToOne
	@JoinColumn(name="images_id")
	private Image image;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="users_username")
	private User user;

	public UsersHasImage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getImgOrdinal() {
		return this.imgOrdinal;
	}

	public void setImgOrdinal(Integer imgOrdinal) {
		this.imgOrdinal = imgOrdinal;
	}

	public String getResultsPath() {
		return this.resultsPath;
	}

	public void setResultsPath(String resultsPath) {
		this.resultsPath = resultsPath;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}