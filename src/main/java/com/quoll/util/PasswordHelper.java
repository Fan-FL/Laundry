package com.quoll.util;


import com.quoll.model.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(User user) {
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUsername()), hashIterations).toHex();
		user.setPassword(newPassword);

	}
}
