package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Artwork;
import services.ArtworkSaleLocal;
import services.ArtworkServiceLocal;
import services.BasicOpsLocal;

@ManagedBean
@ViewScoped
public class FindArtworkBean {

	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;

	@ManagedProperty(value = "#{artworkManagementBean}")
	private ArtworkManagementBean artworkManagementBean;

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	private List<Artwork> artworks = new ArrayList<>();

	public ArtworkManagementBean getArtworkManagementBean() {
		return artworkManagementBean;
	}

	public void setArtworkManagementBean(ArtworkManagementBean artworkManagementBean) {
		this.artworkManagementBean = artworkManagementBean;
	}

	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

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

	public ArtworkServiceLocal getArtworkServiceLocal() {
		return artworkServiceLocal;
	}

	public void setArtworkServiceLocal(ArtworkServiceLocal artworkServiceLocal) {
		this.artworkServiceLocal = artworkServiceLocal;
	}

	public BasicOpsLocal getBasicOpsLocal() {
		return basicOpsLocal;
	}

	public void setBasicOpsLocal(BasicOpsLocal basicOpsLocal) {
		this.basicOpsLocal = basicOpsLocal;
	}

	public ArtworkSaleLocal getArtworkSaleLocal() {
		return artworkSaleLocal;
	}

	public void setArtworkSaleLocal(ArtworkSaleLocal artworkSaleLocal) {
		this.artworkSaleLocal = artworkSaleLocal;
	}

	private String title;
	private String artistName;
	@EJB
	private ArtworkServiceLocal artworkServiceLocal;
	@EJB
	private BasicOpsLocal basicOpsLocal;
	@EJB
	private ArtworkSaleLocal artworkSaleLocal;

	@PostConstruct

	public void init() {
		artworks = artworkServiceLocal.findArtwork(getIdentityBean().getUser(), artworkManagementBean.getTitle(),
				artworkManagementBean.getArtistName());

	}
}
