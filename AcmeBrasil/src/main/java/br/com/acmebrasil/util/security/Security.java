package br.com.acmebrasil.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class Security {

	public String geraMD5(String pass) {
		MessageDigest md = null;
		String retorno = "";
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			System.out.println(ex);
		}
		md.update(pass.getBytes());
		byte[] hashMd5 = md.digest();
		for (int i = 0; i < hashMd5.length; i++) {
			retorno += hashMd5[i];
		}
		retorno = retorno.replaceAll("-", "");
		return retorno;
	}

	public String encode(String valor) {
		return Base64.encodeBase64String(valor.getBytes());
	}

	public String decode(String valor) {
		byte[] decode = Base64.decodeBase64(valor.getBytes());
		valor = new String(decode);
		return valor;
	}

}
