package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Artwork;
import persistence.ArtworkSale;
import persistence.StatusOfSale;
import persistence.User;
import services.ArtworkSaleServiceRemote;
import services.ArtworkServiceRemote;
import services.BasicOpsRemote;

public class TestFindArtworkSale {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/BasicOps!services.BasicOpsRemote");
		ArtworkSaleServiceRemote artworkSaleServiceRemote = (ArtworkSaleServiceRemote) context.lookup(
				"ArtisticShowroom-ear/ArtisticShowroom-ejb/ArtworkSaleService!services.ArtworkSaleServiceRemote");
		ArtworkServiceRemote artworkServiceRemote = (ArtworkServiceRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/ArtworkService!services.ArtworkServiceRemote");

		User user = basicOpsRemote.findUserById("123");
		List<ArtworkSale> artworks = artworkSaleServiceRemote.FindArtworkSaleByStatus(user, StatusOfSale.ONHOLD);
		for (ArtworkSale artworkSale : artworks) {
			System.out.println(artworkSale.getOrderAddress());
		}
	}

}
