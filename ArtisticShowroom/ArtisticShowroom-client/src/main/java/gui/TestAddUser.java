package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.User;
import services.BasicOpsRemote;

public class TestAddUser {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		BasicOpsRemote basicOpsRemote = (BasicOpsRemote) context
				.lookup("ArtisticShowroom-ear/ArtisticShowroom-ejb/BasicOps!services.BasicOpsRemote");

		/*
		 * Member member = new Member(); member.setId(2);
		 * member.setName("faycel"); member.setLogin("feel");
		 * member.setPassword("753357"); member.setGender(Gender.MALE);
		 */

		User a = new User();

		a.setUserName("safa");
		a.setPasswordHash("123456");
		a.setAge(23);
		a.setEmailConfirmed(true);
		a.setPhoneNumberConfirmed(true);
		a.setTwoFactorEnabled(true);
		a.setLockoutEnabled(true);
		a.setAccessFailedCount(1);

		//basicOpsRemote.addUser(a);
	}
}
