package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Artwork;
import persistence.ArtworkSale;
import persistence.StatusOfSale;
import persistence.User;

@Local
public interface ArtworkSaleLocal {

	void CommandArtwork(User user, Artwork artwork);

	ArtworkSale FindArtworkSale(User user, Artwork artwork);

	List<ArtworkSale> AllArtworkSale(User user);

	List<ArtworkSale> FindArtworkInBasket(User user);

	void OrderArtwork(User user, Artwork artwork, int codePost, String orderAddress);

	String DeleteCommand(User user, Artwork artwork);

	List<ArtworkSale> FindArtworkSaleByStatus(User user,StatusOfSale statusOfSale);
	
	String DeleteOrderBeforeSevenDays(User user, Artwork artwork);
	String DeleteOrder(User user, Artwork artwork);
	

}
