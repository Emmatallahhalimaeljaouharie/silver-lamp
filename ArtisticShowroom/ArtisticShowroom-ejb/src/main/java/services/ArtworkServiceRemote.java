package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Artwork;
import persistence.User;

@Remote
public interface ArtworkServiceRemote {

	void updateArtwork(Artwork artwork);

	Artwork findArtworkById(int artworkId);

	List<Artwork> findAllArtworks(User user);

	List<Artwork> findArtworksByTheme(String theme, User user);

	List<Artwork> findAllArtworksByArtist(String userName, User user);

	Artwork findMostWantedArtwork();

	List<Artwork> FindArtworkCommandsByUser(User user);

	List<Artwork> FindArtworkCommandsByUser();

	List<Artwork> findAllArtworksNotCommanded(User user);

	List<Artwork> findAllArtworksNotCommandedByArtist(User user, String ArtistName);

	List<Artwork> findAllArtworksNotCommandedByTitle(User user, String title);

	List<Artwork> findArtworkByThemeAndArtist(User user, String title, String artistName);

	List<Artwork> findArtwork(User user, String title, String artistName);
}
