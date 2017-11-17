package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.ArtworkSale;
import persistence.User;
import services.ArtworkSaleServiceRemote;
import services.BasicOpsRemote;

public class TestFindArtworksInBasket {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/BasicOps!services.BasicOpsRemote");
		ArtworkSaleServiceRemote artworkSaleServiceRemote = (ArtworkSaleServiceRemote) context.lookup(
				"ArtisticShowroom-ear/ArtisticShowroom-ejb/ArtworkSaleService!services.ArtworkSaleServiceRemote");

		User user = basicOpsRemote.findUserById("456");
		List<ArtworkSale> artworks = artworkSaleServiceRemote.FindArtworkInBasket(user);

		for (ArtworkSale artworkSale : artworks) {
			System.out.println(artworkSale.getId().getArtworkId());
		}
	}

}
