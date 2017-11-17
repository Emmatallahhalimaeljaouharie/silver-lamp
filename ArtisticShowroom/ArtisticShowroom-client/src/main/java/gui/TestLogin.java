package gui;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.BasicOpsRemote;

public class TestLogin {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/BasicOps!services.BasicOpsRemote");

		 User member = basicOpsRemote.login("safa.baatout@esprit.tn","123AZErty@");
		//List<User> clients = basicOpsRemote.findAllUsers();

		System.out.println(member.getUserName());

	}

}
