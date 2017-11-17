package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Artwork;
import persistence.ArtworkSale;
import persistence.User;

@Stateless
public class ArtworkService implements ArtworkServiceLocal, ArtworkServiceRemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Artwork> findAllArtworks(User user) {
		String jpql = "SELECT a FROM Artwork a WHERE a.bought=FALSE AND a.user!=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}

	@Override
	public List<Artwork> findArtworksByTheme(String theme, User user) {
		String jpql = "SELECT a FROM Artwork a WHERE a.artworkTitle LIKE :param1 AND a.bought=FALSE AND a.user!=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", '%' + theme + '%');
		query.setParameter("param2", user);
		return query.getResultList();
	}

	@Override
	public List<Artwork> findAllArtworksByArtist(String userName, User user) {
		String jpql = "SELECT a FROM Artwork a WHERE a.user.userName LIKE :param1 AND a.bought=FALSE AND a.user!=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", '%' + userName + '%');
		query.setParameter("param2", user);
		return query.getResultList();
	}

	@Override
	public Artwork findArtworkById(int artworkId) {

		return entityManager.find(Artwork.class, artworkId);
	}

	@Override
	public void updateArtwork(Artwork artwork) {
		entityManager.merge(artwork);

	}

	@Override
	public List<Artwork> FindArtworkCommandsByUser(User user) {
		String jpql = "SELECT a FROM Artwork a INNER JOIN a.artworkSales s WHERE s.user=:param";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}

	@Override
	public Artwork findMostWantedArtwork() {
		String jpql = "SELECT as from ArtworkSale as GROUP BY as.artwork.artworkId ORDER BY COUNT(as.artwork.artworkId) desc ";
		Query query = entityManager.createQuery(jpql);
		return findArtworkById(query.getFirstResult());
	}

	@Override
	public List<Artwork> FindArtworkCommandsByUser() {
		String jpql = "SELECT a FROM Artwork";

		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

	@Override
	public List<Artwork> findAllArtworksNotCommanded(User user) {
		List<Artwork> list = findAllArtworks(user);
		for (Artwork artwork : list) {
			for (ArtworkSale artSale : artwork.getArtworkSales()) {
				if (artSale.getUser().getId().equals(user.getId())) {
					list.remove(artwork);
				}
			}
		}

		return list;
	}

	@Override
	public List<Artwork> findAllArtworksNotCommandedByArtist(User user, String ArtistName) {
		List<Artwork> list = findAllArtworksByArtist(ArtistName, user);
		for (Artwork artwork : list) {
			for (ArtworkSale artSale : artwork.getArtworkSales()) {
				if (artSale.getUser().getId().equals(user.getId())) {
					list.remove(artwork);
				}
			}
		}

		return list;
	}

	@Override
	public List<Artwork> findAllArtworksNotCommandedByTitle(User user, String title) {
		List<Artwork> list = findArtworksByTheme(title, user);
		for (Artwork artwork : list) {
			for (ArtworkSale artSale : artwork.getArtworkSales()) {
				if (artSale.getUser().getId().equals(user.getId())) {
					list.remove(artwork);
				}
			}
		}

		return list;

	}

	@Override
	public List<Artwork> findArtworkByThemeAndArtist(User user, String title, String artistName) {
		String jpql = "SELECT a FROM Artwork a WHERE a.user.userName LIKE :param1 AND a.artworkTitle LIKE :param2 AND a.bought=FALSE AND a.user!=:param3";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", '%' + artistName + '%');
		query.setParameter("param2", '%' + title + '%');
		query.setParameter("param3", user);

		return query.getResultList();
	}

	@Override
	public List<Artwork> findArtwork(User user, String title, String artistName) {
		List<Artwork> myList = new ArrayList<Artwork>();
		if ((artistName != null) && (title == null)) {
			myList = findAllArtworksByArtist(artistName, user);

		} else if ((artistName == null) && (title != null)) {
			myList = findArtworksByTheme(title, user);
		} else if ((artistName != null) && (title != null)) {
			myList = findArtworkByThemeAndArtist(user, title, artistName);
		}

		else{
			
			myList = findAllArtworksNotCommanded(user);
		}

		return myList;
	}

}
