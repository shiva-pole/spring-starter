
package com.analytics.scatterfit.common.util;

import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

	public static int getRandomNumber(int min, int max) {

		Random rand = new Random();
		return rand.nextInt(max) + min;
	}

	public static String hashHmacMD5(String data, String key) {

		String hash = null;
		try {
			Mac hmacMD5 = Mac.getInstance("HmacMD5");
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacMD5");
			hmacMD5.init(secretKey);
			hash = byteArrayToHex(hmacMD5.doFinal(data.getBytes()));
		} catch (Exception e) {
			LOGGER.error("Error while creating md5 hash", e);
		}
		return hash;
	}

	protected static String byteArrayToHex(byte[] a) {

		int hn, ln, cx;
		String hexDigitChars = "0123456789abcdef";
		StringBuilder buf = new StringBuilder(a.length * 2);
		for (cx = 0; cx < a.length; cx++) {
			hn = ((int) (a[cx]) & 0x00ff) / 16;
			ln = ((int) (a[cx]) & 0x000f);
			buf.append(hexDigitChars.charAt(hn));
			buf.append(hexDigitChars.charAt(ln));
		}
		return buf.toString();
	}
}