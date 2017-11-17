package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import persistence.Artwork;
import persistence.User;
import services.ArtworkSaleLocal;
import services.ArtworkServiceLocal;
import services.BasicOpsLocal;

@ManagedBean
@SessionScoped
public class ArtworkManagementBean {

	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	private List<Artwork> artworks = new ArrayList<>();
	private String title;
	private String artistName;
	@EJB
	private ArtworkServiceLocal artworkServiceLocal;
	@EJB
	private BasicOpsLocal basicOpsLocal;
	@EJB
	private ArtworkSaleLocal artworkSaleLocal;

	// public User u = identityBean.getUser();

	User u = new User();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	@PostConstruct

	public void init() {

		// u = basicOpsLocal.findUserById("456");
		// System.out.println(identityBean.user);
		// System.out.println(basicOpsLocal.findUserById("456").getEmail());
		// List<Artwork> a = new ArrayList<>();
	
			//artworks = artworkServiceLocal.findArtwork(getIdentityBean().getUser(), getTitle(), getArtistName());
		
		/*
		 * for (Artwork artwork : artworks) { for (ArtworkSale artSale :
		 * artwork.getArtworkSales()) { if
		 * (artSale.getUser().getId().equals(u.getId())) {
		 * artworks.remove(artwork); } } }
		 */

	}

	public String doAddToBasket(User user, Artwork artwork) {
		artworkSaleLocal.CommandArtwork(user, artwork);
		return "MyBasket.jsf?faces-redirect=true";

	}

	public String doOrderCommand() {
		return "OrderForm.jsf?faces-redirect=true";

	}

	public String doRedirect( String title, String artist) {
	
		this.title=title ;
		this.artistName = artist ;
		
		return "/pages/Artwork/ArtworkList?faces-redirect=true";

	}
	
	public List<Artwork> doFindArtwork(){
		
		System.out.println(title);
		System.out.println(artistName);
		return artworks;
	}
	
public String doRefresh(){
		
		setTitle(null);
		setArtistName(null);
		return "/pages/Artwork/ArtworkList?faces-redirect=true";
	}
	

	/*
	 * public void doFindArtwork(String artistName, String title) {
	 * 
	 * if ((artistName != "") && (title == "")) { artworks =
	 * artworkServiceLocal.findAllArtworksByArtist(artistName,
	 * getIdentityBean().getUser());
	 * 
	 * } else if ((artistName == "") && (title != "")) { artworks =
	 * artworkServiceLocal.findArtworksByTheme(title,
	 * getIdentityBean().getUser()); } else { artworks =
	 * artworkServiceLocal.findAllArtworksNotCommanded(getIdentityBean().getUser
	 * ()); } }
	 */

}
