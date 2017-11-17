package mBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import persistence.ArtworkSale;
import services.ArtworkSaleLocal;

@ManagedBean
@ViewScoped
public class OrderManagementBean {

	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;
	@EJB
	private ArtworkSaleLocal artworkSaleLocal;
	
	public ArtworkSaleLocal getArtworkSaleLocal() {
		return artworkSaleLocal;
	}

	public void setArtworkSaleLocal(ArtworkSaleLocal artworkSaleLocal) {
		this.artworkSaleLocal = artworkSaleLocal;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}
	
	@ManagedProperty(value = "#{basketManagementBean}")
	private BasketManagementBean basketManagementBean;

	public BasketManagementBean getBasketManagementBean() {
		return basketManagementBean;
	}

	public void setBasketManagementBean(BasketManagementBean basketManagementBean) {
		this.basketManagementBean = basketManagementBean;
	}
	
	public String doValidateOrder(ArtworkSale artworkSale,String orderAddress,int codePost){
		artworkSaleLocal.OrderArtwork(getIdentityBean().getUser(), artworkSale.getArtwork(), codePost, orderAddress);
		return"";
	}
	
	 public void buttonAction(ActionEvent actionEvent) {
	        addMessage("Artwork Ordred");
	    }
	     
	    public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	
	
}
