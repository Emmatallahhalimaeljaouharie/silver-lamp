package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Artwork;
import persistence.ArtworkSale;
import persistence.ArtworkSalePK;
import persistence.StatusOfSale;
import persistence.User;

@Stateless
public class ArtworkSaleService implements ArtworkSaleServiceRemote, ArtworkSaleLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private BasicOpsLocal basicOpsLocal;
	@EJB
	private ArtworkServiceLocal artworkServiceLocal;

	@Override
	public void CommandArtwork(User user, Artwork artwork) {
		ArtworkSale artworkSale = new ArtworkSale(user, artwork);
		entityManager.persist(artworkSale);
		entityManager.flush();
	}

	@Override
	public ArtworkSale FindArtworkSale(User user, Artwork artwork) {
		ArtworkSalePK artworkSalePK = new ArtworkSalePK(user.getId(), artwork.getArtworkId());
		return basicOpsLocal.FindArtworkSaleById(artworkSalePK);

	}

	@Override
	public List<ArtworkSale> AllArtworkSale(User user) {
		String jpql = "SELECT a FROM ArtworkSale a WHERE a.user=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}

	@Override
	public List<ArtworkSale> FindArtworkInBasket(User user) {
		List<ArtworkSale> myList = new ArrayList<ArtworkSale>();
		List<ArtworkSale> allArtworkSale = AllArtworkSale(user);
		for (ArtworkSale artworkSale : allArtworkSale) {
			if (artworkSale.getSaleStatus() == StatusOfSale.ONHOLD) {
				myList.add(artworkSale);
			}
		}
		return myList;

	}

	@Override
	public String DeleteCommand(User user, Artwork artwork) {
		ArtworkSale artworkSale = FindArtworkSale(user, artwork);
		if (artworkSale.getSaleStatus() == StatusOfSale.ONHOLD) {
			entityManager.remove(artworkSale);
			return "Command deleted";
		} else
			return "Command confirmed cannot be deleted";
	}

	@Override
	public void OrderArtwork(User user, Artwork artwork, int codePost, String orderAddress) {
		ArtworkSale artworkSale = FindArtworkSale(user, artwork);
		artworkSale.setSaleStatus(StatusOfSale.CONFIRMED);
		artworkSale.setOrderAddress(orderAddress);
		artworkSale.setPostalCode(codePost);
		Date d = new Date();
		artworkSale.setArtworkOrderDate(d);
		artworkSale.setTotalPrice(artwork.getPrice());
		entityManager.merge(artworkSale);
		artwork.setBought(true);
		artworkServiceLocal.updateArtwork(artwork);

	}

	@Override
	public List<ArtworkSale> FindArtworkSaleByStatus(User user, StatusOfSale statusOfSale) {
		List<ArtworkSale> myList = new ArrayList<ArtworkSale>();
		List<ArtworkSale> allArtworkSale = AllArtworkSale(user);
		for (ArtworkSale artworkSale : allArtworkSale) {
			if (artworkSale.getSaleStatus().equals(statusOfSale)) {
				myList.add(artworkSale);
			}
		}
		return myList;
	}

	@Override
	public String DeleteOrderBeforeSevenDays(User user, Artwork artwork) {

		return null;
	}

	@Override
	public String DeleteOrder(User user, Artwork artwork) {
		ArtworkSale artworkSale = FindArtworkSale(user, artwork);
		if (artworkSale.getSaleStatus() == StatusOfSale.CONFIRMED) {
			entityManager.remove(artworkSale);
			Artwork art = entityManager.find(Artwork.class, artworkSale.getArtwork().getArtworkId());
			art.setBought(true);
			entityManager.merge(art);
			return "Order deleted";
		} else
			return "Order cannot be deleted";
	}

}
