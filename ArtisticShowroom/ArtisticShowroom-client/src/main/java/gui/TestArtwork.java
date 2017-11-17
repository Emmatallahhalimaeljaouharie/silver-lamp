package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Artwork;
import persistence.User;
import services.ArtworkServiceRemote;
import services.BasicOpsRemote;

public class TestArtwork {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/BasicOps!services.BasicOpsRemote");
		ArtworkServiceRemote artworkServiceRemote = (ArtworkServiceRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/ArtworkService!services.ArtworkServiceRemote");

		User user = basicOpsRemote.findUserById("456");
		List<Artwork> artworks = artworkServiceRemote.findArtworksByTheme("view", user);
        if(artworks.size()!=0){
		for (Artwork artwork : artworks) {
			System.out.println(artwork.getArtworkTitle());
		}}else System.out.println("No List");

	}

}
