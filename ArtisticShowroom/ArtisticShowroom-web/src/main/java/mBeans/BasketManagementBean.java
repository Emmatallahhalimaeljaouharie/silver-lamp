package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.Artwork;
import persistence.ArtworkSale;
import persistence.User;
import services.ArtworkSaleLocal;
import services.BasicOpsLocal;

@ManagedBean
@ViewScoped
public class BasketManagementBean {

	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	@EJB
	private ArtworkSaleLocal artworkSaleLocal;
	@EJB
	private BasicOpsLocal basicOpsLocal;
	private List<ArtworkSale> arts;

	private List<ArtworkSale> droppedArts;

	private ArtworkSale selectedArtworkSale;

	@PostConstruct
	public void init() {
		// User user = basicOpsLocal.findUserById("456");
		
		arts = artworkSaleLocal.FindArtworkInBasket(getIdentityBean().getUser());
		
		droppedArts = new ArrayList<ArtworkSale>();
	}



	public ArtworkSaleLocal getArtworkSaleLocal() {
		return artworkSaleLocal;
	}

	public void setArtworkSaleLocal(ArtworkSaleLocal artworkSaleLocal) {
		this.artworkSaleLocal = artworkSaleLocal;
	}

	public List<ArtworkSale> getArts() {
		return arts;
	}

	public void setArts(List<ArtworkSale> arts) {
		this.arts = arts;
	}

	public List<ArtworkSale> getDroppedArts() {
		return droppedArts;
	}

	public void setDroppedArts(List<ArtworkSale> droppedArts) {
		this.droppedArts = droppedArts;
	}

	public ArtworkSale getSelectedArtworkSale() {
		return selectedArtworkSale;
	}

	public void setSelectedArtworkSale(ArtworkSale selectedArtworkSale) {
		this.selectedArtworkSale = selectedArtworkSale;
	}

	public String doDeleteCommandFromBasket(User user, Artwork artwork) {
		artworkSaleLocal.DeleteCommand(user, artwork);
		return "/pages/Artwork/MyBasket?faces-redirect=true";
	}
	
	
	public String doOrderCommand(ArtworkSale artworkSale){
		setSelectedArtworkSale(artworkSale);
		return "/pages/Artwork/OrderForm?faces-redirect=true";
	}

	public void buttonAction(ActionEvent actionEvent) {
		addMessage("Command deleted");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String doRefresh(){
		
		
		return "/pages/Artwork/ArtworkList?faces-redirect=true";
	}
}
