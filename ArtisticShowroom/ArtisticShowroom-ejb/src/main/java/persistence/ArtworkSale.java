package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ArtworkSale database table.
 * 
 */
@Entity
@NamedQuery(name = "ArtworkSale.findAll", query = "SELECT a FROM ArtworkSale a")
public class ArtworkSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArtworkSalePK id;

	@Column(name = "ArtworkCommandDate")
	@Temporal(TemporalType.DATE)
	private Date artworkCommandDate;

	@Column(name = "ArtworkOrderDate")
	@Temporal(TemporalType.DATE)
	private Date artworkOrderDate;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	@Column(name = "OrderAddress")
	private String orderAddress;

	@Column(name = "PostalCode")
	private int postalCode;

	@Column(name = "SaleStatus")
	private StatusOfSale saleStatus;

	@Column(name = "TotalPrice")
	private double totalPrice;

	// bi-directional many-to-one association to Artwork
	@ManyToOne
	@JoinColumn(name = "ArtworkId", referencedColumnName = "ArtworkId", insertable = false, updatable = false)
	private Artwork artwork;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "ClientId", referencedColumnName = "Id", insertable = false, updatable = false)
	private User user;

	public ArtworkSale() {
	}

	public ArtworkSale(User user, Artwork artwork) {
		super();
		this.id = new ArtworkSalePK(user.getId(), artwork.getArtworkId());
		this.saleStatus = StatusOfSale.ONHOLD;
		this.artworkCommandDate = new Date();
	    //this.artworkOrderDate=null;
		this.orderAddress = null;
		this.postalCode = 0;
		this.totalPrice = 0;
		this.artwork = artwork;
		this.user = user;
	}

	public ArtworkSalePK getId() {
		return this.id;
	}

	public void setId(ArtworkSalePK id) {
		this.id = id;
	}

	public Object getOrderAddress() {
		return this.orderAddress;
	}

	public void setOrderAddress(Object orderAddress) {
		this.orderAddress = (String) orderAddress;
	}

	public int getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public StatusOfSale getSaleStatus() {
		return this.saleStatus;
	}

	public void setSaleStatus(StatusOfSale saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Artwork getArtwork() {
		return this.artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getArtworkCommandDate() {
		return artworkCommandDate;
	}

	public void setArtworkCommandDate(Date artworkCommandDate) {
		this.artworkCommandDate = artworkCommandDate;
	}

	public Date getArtworkOrderDate() {
		return artworkOrderDate;
	}

	public void setArtworkOrderDate(Date artworkOrderDate) {
		this.artworkOrderDate = artworkOrderDate;
	}

}