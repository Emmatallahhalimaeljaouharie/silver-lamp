package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the Artwork database table.
 * 
 */
@Entity
@NamedQuery(name = "Artwork.findAll", query = "SELECT a FROM Artwork a")
public class Artwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ArtworkId")
	private int artworkId;

	@Column(name = "ArtworkImagePath")
	private String artworkImagePath;

	@Column(name = "ArtworkTitle")
	private String artworkTitle;

	@Column(name = "Description")
	private String description;

	@Column(name = "Price")
	private double price;

	@Column(name = "Size")
	private String size;

	@Column(name = "Test")
	private int test;

	@Column(name = "Year")
	private int year;

	@Column(name = "Bought")
	private boolean bought;

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	// bi-directional many-to-one association to ArtworkSale
	@OneToMany(mappedBy = "artwork")
	private List<ArtworkSale> artworkSales;

	// bi-directional many-to-one association to ComplaintArtwork
	@OneToMany(mappedBy = "artwork")
	private List<ComplaintArtwork> complaintArtworks;

	// bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy = "artwork")
	private List<Evaluation> evaluations;

	public Artwork() {
	}

	public int getArtworkId() {
		return this.artworkId;
	}

	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public Object getArtworkImagePath() {
		return this.artworkImagePath;
	}

	public void setArtworkImagePath(Object artworkImagePath) {
		this.artworkImagePath = (String) artworkImagePath;
	}

	public Object getArtworkTitle() {
		return this.artworkTitle;
	}

	public void setArtworkTitle(Object artworkTitle) {
		this.artworkTitle = (String) artworkTitle;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = (String) description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Object getSize() {
		return this.size;
	}

	public void setSize(Object size) {
		this.size = (String) size;
	}

	public int getTest() {
		return this.test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ArtworkSale> getArtworkSales() {
		return this.artworkSales;
	}

	public void setArtworkSales(List<ArtworkSale> artworkSales) {
		this.artworkSales = artworkSales;
	}

	public ArtworkSale addArtworkSale(ArtworkSale artworkSale) {
		getArtworkSales().add(artworkSale);
		artworkSale.setArtwork(this);

		return artworkSale;
	}

	public ArtworkSale removeArtworkSale(ArtworkSale artworkSale) {
		getArtworkSales().remove(artworkSale);
		artworkSale.setArtwork(null);

		return artworkSale;
	}

	public List<ComplaintArtwork> getComplaintArtworks() {
		return this.complaintArtworks;
	}

	public void setComplaintArtworks(List<ComplaintArtwork> complaintArtworks) {
		this.complaintArtworks = complaintArtworks;
	}

	public ComplaintArtwork addComplaintArtwork(ComplaintArtwork complaintArtwork) {
		getComplaintArtworks().add(complaintArtwork);
		complaintArtwork.setArtwork(this);

		return complaintArtwork;
	}

	public ComplaintArtwork removeComplaintArtwork(ComplaintArtwork complaintArtwork) {
		getComplaintArtworks().remove(complaintArtwork);
		complaintArtwork.setArtwork(null);

		return complaintArtwork;
	}

	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setArtwork(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setArtwork(null);

		return evaluation;
	}

}