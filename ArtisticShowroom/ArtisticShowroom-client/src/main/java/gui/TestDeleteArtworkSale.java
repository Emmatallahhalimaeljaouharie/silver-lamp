package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Artwork;
import persistence.User;
import services.ArtworkSaleServiceRemote;
import services.ArtworkServiceRemote;
import services.BasicOpsRemote;

public class TestDeleteArtworkSale {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/BasicOps!services.BasicOpsRemote");
		ArtworkServiceRemote artworkServiceRemote = (ArtworkServiceRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/ArtworkService!services.ArtworkServiceRemote");
		ArtworkSaleServiceRemote artworkSaleServiceRemote = (ArtworkSaleServiceRemote) context.lookup(
				"ArtisticShowroom-ear/ArtisticShowroom-ejb/ArtworkSaleService!services.ArtworkSaleServiceRemote");

		User user = basicOpsRemote.findUserById("123");
		Artwork artwork = artworkServiceRemote.findArtworkById(1);
		System.out.println(artworkSaleServiceRemote.DeleteCommand(user, artwork));

	}

}
