/**
 * Copyright 2012 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.thuattq1.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.example.thuattq1.constants.Constants;
import com.example.thuattq1.global.GlobalInfo;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Chua cac ham util ve xu ly chuoi
 *
 * @author:
 * @version: 1.0
 * @since: 1.0
 */
public class StringUtil {
	// public static final String TAG_PATERN =
	public static final String EMPTY_STRING = "";
	public static final String SPACE_STRING = " ";
//	private static final char CHAR_SPLIT = '�';
	static final String[] arrSpecialChar = { "‘", "’", "“", "”", "„", "†", "‡", "‰", "‹", "›", "♠", "♣", "♥", "♦",
			"‾", "←", "↑", "→", "↓", "™", "!", "“", "#", "$", "%", "&", "‘", "(", ")", "*", "+", ",", "-", ".", "/",
			":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "_", "`", "{", "|", "}", "~", "–", "—", "¡", "¢", "£",
			"¤", "¥", "¦", "§", "¨", "©", "ª", "«", "¬", "¬", "®", "¯", "°", "±", "²", "³", "´", "µ", "¶", "•", "¸",
			"¹", "º", "¿", "Ä", "Å", "Æ", "Ç", "Ë", "Î", "Ï", "Ñ", "Ö", "×", "Ø", "Û", "Ü", "Þ", "ß", "ã", "ä", "å",
			"æ", "ç", "ë", "î", "ï", "ð", "ñ", "õ", "ö", "÷", "ø", "û", "ü", "þ", "ÿ" };

	/** The codau. */
	static char codau[] = { 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ', 'À',
			'Á', 'Ả', 'Ã', 'Ạ', 'Ă', 'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ', 'Â', 'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ', 'è', 'é', 'ẻ', 'ẽ', 'ẹ',
			'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ', 'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ', 'ì', 'í', 'ỉ', 'ĩ',
			'ị', 'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ', 'ờ', 'ớ', 'ở',
			'ỡ', 'ợ', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ', 'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ', 'Ơ', 'Ờ', 'Ớ', 'Ở', 'Ỡ', 'Ợ', 'ù', 'ú',
			'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ', 'Ỳ', 'Ý',
			'Ỷ', 'Ỹ', 'Ỵ', 'đ', 'Đ', 'Ư', 'Ừ', 'Ử', 'Ữ', 'Ứ', 'Ự' };
	/** The khongdau. */
	static char khongdau[] = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
			'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'e', 'e', 'e', 'e',
			'e', 'e', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'i', 'i', 'i',
			'i', 'i', 'I', 'I', 'I', 'I', 'I', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
			'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'u',
			'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'U', 'U', 'U', 'U', 'U', 'y', 'y', 'y', 'y', 'y', 'Y',
			'Y', 'Y', 'Y', 'Y', 'd', 'D', 'U', 'U', 'U', 'U', 'U', 'U' };

	static char charsInName[] = { 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
			'À', 'Á', 'Ả', 'Ã', 'Ạ', 'Ă', 'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ', 'Â', 'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ', 'è', 'é', 'ẻ', 'ẽ',
			'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ', 'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ', 'ì', 'í', 'ỉ',
			'ĩ', 'ị', 'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ', 'ờ', 'ớ',
			'ở', 'ỡ', 'ợ', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ', 'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ', 'Ơ', 'Ờ', 'Ớ', 'Ở', 'Ỡ', 'Ợ', 'ù',
			'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ', 'Ư', 'Ừ', 'Ứ', 'Ử', 'Ữ', 'Ự',
			'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ', 'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ', 'đ', 'Đ', 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e',
			'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O',
			'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z',
			'Z', '(', ')', ' ' };
	
	static final int VN_SYMBOLS[] = {768, 769, 771, 777, 803};

	/** STRING_SEARCH_LIKE_ALL. */
	public static final String STRING_SEARCH_LIKE_ALL = "%%";

	private static final String[] oracleTextKeywords = new String[] { "ACCUM", "ABOUT", "NOT", "OR", "AND", "BT",
			"BTG", "BTP", "BTI", "NT", "NTG", "NTP", "NTI", "PT", "RT", "RT", "SQE", "SYN", "TR", "TRSYN", "TT",
			"FUZZY", "HASPATH", "INPATH", "MINUS", "NEAR", "WITHIN", "84%", "8%", "MDATA" };

	public static final String STRING_SPECIAL_CHAR = "<>./!@#$%^*'\"-_():|[]~+{}?\\\n";

	private static final byte[] HEX_CHAR_TABLE = { (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4',
			(byte) '5', (byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd',
			(byte) 'e', (byte) 'f' };
	static char charsInNumber[] = { '0','1', '2','3','4','5','6','7','8','9' };
	static char charsInStreet[] = { '-', ',', '/', '0','1', '2','3','4','5','6','7','8','9' };
	static char charsInHouseNumber[] = { '-', ',', '/', '0','1', '2','3','4','5','6','7','8','9'};

	/* PATTERN PASSWORD POLICY
	^                 # start-of-string
	(?=.*[0-9])       # a digit must occur at least once
	(?=.*[a-z])       # a lower case letter must occur at least once
	(?=.*[A-Z])       # an upper case letter must occur at least once
	(?=.*[@#$%^&+=])  # a special character must occur at least once
	(?=\S+$)          # no whitespace allowed in the entire string
	.{8,}             # anything, at least eight places though
	$                 # end-of-string
	*/
	//static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&()+=]).{8,}$";

	/**
	 * kiem tra ten co chua cac ki tu hop le
	 * @author: 
	 * @param name
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static boolean isNameContainValidChars(String name) {
		boolean isContain = false;
		for (int j = 0, m = name.length(); j < m; j++) {
			isContain = false;
			for (int i = 0, n = charsInName.length; i < n; i++) {
				if (name.charAt(j) == charsInName[i]) {
					isContain = true;
					break;
				}
			}
		}
		return isContain;
	}

	/**
	 *
	 * bo dau tieng viet
	 *
	 * @author: 
	 * @param input
	 * @return: String
	 * @throws:
	 */
	public static String getEngStringFromUnicodeString(String input) {
		if (isNullOrEmpty(input)) {
			return "";
		}
		
		StringBuilder str = new StringBuilder(input.trim());
		
		//Loai bo cac dau tieng viet dac biet
		for (int j = 0, m = str.length(); j < m; j++) {
			for(int k = 0, n = VN_SYMBOLS.length; k < n; k++) {
				if(Integer.valueOf(str.charAt(j)) == VN_SYMBOLS[k]) {
					str.deleteCharAt(j);
					j--;
					m--;
					break;
				}
			}
		}
		
		input = str.toString();
		for (int i = 0; i < codau.length; i++) {
			input = input.replace(codau[i], khongdau[i]);
		}
		return input;
	}

	public static String replace(String _text, String _searchStr, String _replacementStr) {
		// String buffer to store str
		StringBuffer sb = new StringBuffer();

		// Search for search
		int searchStringPos = _text.indexOf(_searchStr);
		int startPos = 0;
		int searchStringLength = _searchStr.length();

		// Iterate to add string
		while (searchStringPos != -1) {
			sb.append(_text.substring(startPos, searchStringPos)).append(_replacementStr);
			startPos = searchStringPos + searchStringLength;
			searchStringPos = _text.indexOf(_searchStr, startPos);
		}

		// Create string
		sb.append(_text.substring(startPos, _text.length()));

		return sb.toString();
	}

	/**
	 * Kiem tra nick name hop le
	 *
	 * @author: 
	 * @param userName
	 * @return: boolean
	 * @throws:
	 */
	public static boolean isValidateUserName(String userName) {
		// UserName khong the toan so
		// UserName chi chua cac ky tu a-z, A-Z, 0-9
		Boolean isValid = false;
		int length = userName.length();
		for (int i = 0; i < length; i++) {
			char ch = userName.charAt(i);
			if (((ch >= 0x30 && ch <= 0x39) || (ch >= 0x41 && ch <= 0x5a) || (ch >= 0x61 && ch <= 0x7a))) {
				isValid = true;
			} else {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	/**
	 * Kiem tra noi dung hop le
	 *
	 * @author: 
	 * @param name
	 * @return: boolean
	 * @throws:
	 */
	public static boolean isValidatePaymentContent(String name) {
		// Noi dung chi chua cac ky tu a-z, A-Z, 0-9, khoang trang
		Boolean isValid = false;
		int length = name.length();
		for (int i = 0; i < length; i++) {
			char ch = name.charAt(i);
			if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || (ch == ' '))) {
				isValid = true;
			} else {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	/**
	 * Kiem tra noi dung hop le
	 *
	 * @author: 
	 * @param name
	 * @return: boolean
	 * @throws:
	 */
	public static boolean isValidatePaymentContentWithoutSpace(String name) {
		// Noi dung chi chua cac ky tu a-z, A-Z, 0 - 9
		Boolean isValid = false;
		int length = name.length();
		for (int i = 0; i < length; i++) {
			char ch = name.charAt(i);
			if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))) {
				isValid = true;
			} else {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	/**
	 *
	 * validate num product input to order
	 *
	 * @author: 
	 * @param inputData
	 * @return
	 * @return: boolean
	 * @throws:
	 */
	public static boolean isValidateNumProductInput(String inputData) {
		for (int i = 0, size = inputData.length(); i < size; i++) {
			if ((inputData.charAt(i) < '0' || inputData.charAt(i) > '9') && inputData.charAt(i) != '/') {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * validate vote number input for product
	 *
	 * @author: 
	 * @param inputData
	 * @return
	 * @return: boolean
	 * @throws:
	 */
	public static boolean isValidateIntergeNonNegativeInput(String inputData) {
		for (int i = 0, size = inputData.length(); i < size; i++) {
			if (inputData.charAt(i) < '0' || inputData.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * validate phone
	 *
	 * @param phone
	 * @return
	 * @Author :  Since Dec 9, 2010
	 */
	public static boolean isValidPhone(String phone) {
		int length = phone.length();
		for (int i = 0; i < length; i++) {
			if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * validate email
	 *
	 * @param email
	 * @return
	 * @Author :  Since Dec 9, 2010
	 */
	public static boolean isValidateEmail(String email) {
		if (email == null || email.length() == 0 || email.indexOf("@") == -1 || email.indexOf(" ") != -1) {
			return false;
		}
		int emailLenght = email.length();
		int atPosition = email.indexOf("@");

		String beforeAt = email.substring(0, atPosition);
		String afterAt = email.substring(atPosition + 1, emailLenght);

		if (beforeAt.length() == 0 || afterAt.length() == 0) {
			// #ifdef DEBUG
			// # //System.out.println("only @ is");
			// #endif
			return false;
		}

		// CHECK for .(dot) before @(at) = aaa.@domain.com
		if (email.charAt(atPosition - 1) == '.') {
			// #ifdef DEBUG
			// # //System.out.println(".(dot) before @(at)");
			// #endif
			return false;
		}

		// CHECK for .(dot) before @(at) = aaa@.domain.com
		if (email.charAt(atPosition + 1) == '.') {
			// #ifdef DEBUG
			// # //System.out.println("@.");
			// #endif
			return false;
		}

		// CHECK for .(dot) = email@domaincom
		if (afterAt.indexOf(".") == -1) {
			// #ifdef DEBUG
			// # //System.out.println("no dot(.)");
			// #endif
			return false;
		}

		// CHECK for ..(2 dots) = email@domain..com
		char dotCh = 0;
		for (int i = 0; i < afterAt.length(); i++) {
			char ch = afterAt.charAt(i);
			// soan validate
			if (!((ch >= 0x30 && ch <= 0x39) || (ch >= 0x41 && ch <= 0x5a) || (ch >= 0x61 && ch <= 0x7a)
					|| (ch == 0x2e) || (ch == 0x2d) || (ch == 0x5f))) {
				// #ifdef DEBUG
				// # //System.out.println("not valid chars");
				// #endif
				return false;
			}
			// end soan
			if ((ch == 0x2e) && (ch == dotCh)) {
				// #ifdef DEBUG
				// # // System.out.println("find .. (2 dots) in @>");
				// #endif
				return false;
			}
			dotCh = ch;
		}

		// CHECK for double '@' = example@@domain.com
		if (afterAt.indexOf("@") != -1) {
			// #ifdef DEBUG
			// # //System.out.println("find 2 @");
			// #endif
			return false;
		}
		// check domain name 2-5 chars
		int ind = 0;
		do {
			int newInd = afterAt.indexOf(".", ind + 1);

			if (newInd == ind || newInd == -1) {
				String prefix = afterAt.substring(ind + 1);
				if (prefix.length() > 1 && prefix.length() < 6) {
					break;
				} else {
					// #ifdef DEBUG
					// # //System.out.println("prefix not 2-5 chars");
					// #endif
					return false;
				}
			} else {
				ind = newInd;
			}
		} while (true);

		// CHECK for valid chars[a-z][A-Z][0-9][. - _]
		// CHECK for ..(2 dots)
		dotCh = 0;
		for (int i = 0; i < beforeAt.length(); i++) {
			char ch = beforeAt.charAt(i);
			if (!((ch >= 0x30 && ch <= 0x39) || (ch >= 0x41 && ch <= 0x5a) || (ch >= 0x61 && ch <= 0x7a)
					|| (ch == 0x2e) || (ch == 0x2d) || (ch == 0x5f))) {
				// #ifdef DEBUG
				// # //System.out.println("not valid chars");
				// #endif
				return false;
			}
			if ((ch == 0x2e) && (ch == dotCh)) {
				// #ifdef DEBUG
				// # //System.out.println("find .. (2 dots)");
				// #endif
				return false;
			}
			dotCh = ch;
		}
		return true;
	}

	public final static void supplementCodePointToSurrogatePair(int codePoint, int[] surrogatePair) {
		int high4 = ((codePoint >> 16) & 0x1F) - 1;
		int mid6 = ((codePoint >> 10) & 0x3F);
		int low10 = codePoint & 0x3FF;

		surrogatePair[0] = (0xD800 | (high4 << 6) | (mid6));
		surrogatePair[1] = (0xDC00 | (low10));
	}

	public static boolean isNullOrEmpty(String aString) {
		return (aString == null) || ("".equals(aString.trim()));
	}

	public static boolean isNullOrEmpty(Object object) {
		boolean isNull = (object == null);
		if (!isNull) {
			if (object instanceof String) {
				isNull = isNullOrEmpty((String)object);
			}
		}
		return isNull;
	}

	/*public static String getString(int id) {
		return GlobalInfo.getInstance().getAppContext().getResources().getString(id);
	}*/

	/**
	 * lay string co dang "... xxx..." tu string.xml va thay the chuoi xxx
	 *
	 * @author: 
	 * @param
	 * @return: String
	 * @throws:
	 */
	public static String getStringAndReplace(int id, String replace) {
		String str = getString(id);
		if (str.contains(Constants.REPLACED_STRING))
			str = str.replace(Constants.REPLACED_STRING, replace);
		return str;
	}

	/**
	 * chuyen phone ve dang 01, 09
	 *
	 * @author: 
	 * @param phoneString
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String converPhoneStringToHeader0109(String phoneString) {
		if (!isNullOrEmpty(phoneString)) {
			if (phoneString.startsWith("84")) {
				phoneString = phoneString.substring(2);
				phoneString = "0" + phoneString;
			} else if (phoneString.startsWith("+84")) {
				phoneString = phoneString.substring(3);
				phoneString = "0" + phoneString;
			}
		} else {
			phoneString = "";
		}
		return phoneString;
	}

	/**
	 *
	 * Thay the khoang trang thanh %20
	 *
	 * @author: 
	 * @return: void
	 * @throws:
	 */
	public static String replaceSpaceByHtmlCode(String ori) {
		if (isNullOrEmpty(ori))
			return "";
		return ori.replace(" ", "%20");
	}

	/**
	 * validate va chuyen phone ve dang 01, 09
	 *
	 * @author: 
	 * @param phoneString
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String validateAndConverPhoneStringToHeader0109(String phoneString) {
		String res = phoneString;
		if (validateMobileNumber(phoneString)) {
			res = converPhoneStringToHeader0109(phoneString);
		}
		return res;
	}

	/**
	 * Co the la so dien thoai hay khong
	 *
	 * @author: 
	 * @param phonenumber
	 * @return: boolean
	 */
	public static boolean canBePhoneNumber(String phonenumber) {
		if (StringUtil.isNullOrEmpty(phonenumber)) {
			return false;
		}
		Pattern p = Pattern.compile("^[09|01|849|841|+849|+841][0-9]+$");
		Matcher m = p.matcher(phonenumber);

		boolean matchFound = m.matches();
		return matchFound;
	}

	/**
	 * Kiem tra mot chuoi co phai la so dien thoai hop le hay khong
	 *
	 * @author: 
	 * @param mobileNumber
	 * @return: boolean
	 */
	public static boolean validateMobileNumber(String mobileNumber) {
		mobileNumber = mobileNumber.trim();
		final String prefix849 = "849";
		final String prefix849plus = "+849";
		final String prefix841 = "841";
		final String prefix841plus = "+841";
		final String prefix09 = "09";
		final String prefix01 = "01";
		boolean result = false;

		if (!StringUtil.isNullOrEmpty(mobileNumber) && canBePhoneNumber(mobileNumber)) {
			int length = mobileNumber.length();
			switch (length) {
			case 10:
				if (mobileNumber.startsWith(prefix09)) {
					result = true;
				}
				break;
			case 11:
				if (mobileNumber.startsWith(prefix01) || mobileNumber.startsWith(prefix849)) {
					result = true;
				}
				break;
			case 12:
				if (mobileNumber.startsWith(prefix841) || mobileNumber.startsWith(prefix849plus)) {
					result = true;
				}
				break;
			case 13:
				if (mobileNumber.startsWith(prefix841plus)) {
					result = true;
				}
				break;
			}
		}

		return result;
	}

	/**
	 * Them ma code quoc gia vietnam vao so dien thoai
	 *
	 * @author: 
	 * @param mobileNumber
	 * @return: String
	 */
	public static String parseMobileNumber(String mobileNumber) {
		final String countryCode = "84";
		final String countryCodePlus = "+84";
		final String _9x = "9";
		final String _09x = "09";
		final String _1x = "1";
		final String _01x = "01";

		if (mobileNumber == null) {
			return null;
		}
		mobileNumber = mobileNumber.trim();

		if (mobileNumber.startsWith(countryCodePlus)) {
			mobileNumber = mobileNumber.substring(1);
		}

		String validatePhone = null;

		// phone start with "84" or "+84"
		if (mobileNumber.startsWith(countryCode)) {
			boolean isMobileNumber = (mobileNumber.length() == 11 && mobileNumber.substring(2).startsWith(_9x))
					|| (mobileNumber.length() == 12 && mobileNumber.substring(2).startsWith(_1x));
			if (isMobileNumber) {
				validatePhone = mobileNumber;
			}
		}
		// phone = "09xxxxxxxx" (like: 0987868686)
		else if (mobileNumber.length() == 10 && mobileNumber.startsWith(_09x)) {
			validatePhone = countryCode + mobileNumber.substring(1);
		}
		// phone = "1xxxxxxxx" (like: 01696999999)
		else if (mobileNumber.length() == 11 && mobileNumber.startsWith(_01x)) {
			validatePhone = countryCode + mobileNumber.substring(1);
		}

		return validatePhone;
	}

	public static String md5(String s) {
		StringBuffer hexString = new StringBuffer();
		try {
			byte[] defaultBytes = s.getBytes("UTF-8");
			MessageDigest algorithm;
			algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();

			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
		} catch (NoSuchAlgorithmException e) {
			Log.w("" + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			Log.w("" + e.getMessage(), e);
		}
		return hexString.toString();
	}

	/**
	 * Sinh hash voi thuat toan SHA-256 (code mobile server)
	 * @author :  Input: mat khau. Salt: ten dang nhap da lower. since : 1.0
	 */
	public static String generateHashSHA256(String input, String salt) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		// SHA or MD5
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String hash = "";

		if (null == salt || "".equals(salt)) {
			salt = "";
		}
		
		if (input == null) {
			input = "";
		}

		input += salt;
		byte[] data = input.getBytes("US-ASCII");

		md.update(data);
		byte[] digest = md.digest();
		for (int i = 0; i < digest.length; i++) {
			String hex = Integer.toHexString(digest[i]);
			if (hex.length() == 1)
				hex = "0" + hex;
			hex = hex.substring(hex.length() - 2);
			hash += hex;
		}

		return hash;
	}

	/**
	 * Sinh hash voi thuat toan MD5 (code mobile server)
	 * @author :  Input: mat khau. Salt: ten dang nhap da lower. since : 1.0
	 */
	public static String generateHashMD5(String input, String salt) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		// SHA or MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		String hash = "";

		if (null == salt || "".equals(salt)) {
			salt = "";
		}

		if (input == null) {
			input = "";
		}

		input += salt;
		byte[] data = input.getBytes("US-ASCII");

		md.update(data);
		byte[] digest = md.digest();
		for (int i = 0; i < digest.length; i++) {
			String hex = Integer.toHexString(digest[i]);
			if (hex.length() == 1)
				hex = "0" + hex;
			hex = hex.substring(hex.length() - 2);
			hash += hex;
		}

		return hash;
	}

	/**
	 * Tao mot string tien duoc ngan cach boi dau cham vi du :1.600.000
	 *
	 * @author: 6
	 * @modified:  -  chuyen '.' -> ','
	 * @param money
	 * @return: String
	 */
	public static String parseAmountMoney(String money) {
		String result = "";
		if (!isNullOrEmpty(money)) {
			for (int i = money.length() - 1; i >= 0; i--) {
				int offsetLast = money.length() - 1 - i;
				if ((offsetLast > 0) && (offsetLast % 3) == 0 && (money.charAt(i) != '+') && (money.charAt(i) != '-'))
					result = "," + result;
				result = money.charAt(i) + result;
			}

			if (result.substring(0, 1).equals(",")) {
				result = result.substring(1, result.length() - 1);
			}
		}
		return result;
	}

	/**
	 *
	 * Mo ta chuc nang cua ham
	 *
	 * @author: 
	 * @param money
	 *            - string tien can chuyen fomat
	 * @param unit
	 *            - chuoi cac so 0 cua don vi format tuong ung, vi du 1000VND
	 *            thi unit = "000"
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String parseAmountMoney(String money, String unit) {
		String result = "";
		int lengthUnit = unit.length();
		boolean checkNumberNotIsZero = false;
		if (!isNullOrEmpty(money)) {
			for (int i = money.length() - 1; i >= 0; i--) {
				int offsetLast = money.length() - 1 - i;
				if (offsetLast < lengthUnit) {// check truong hop co unit
					if (money.charAt(i) != '0') {
						checkNumberNotIsZero = true;
					}
				}
				if (offsetLast < lengthUnit + 1) {
					if ((offsetLast > 0) && (offsetLast % lengthUnit) == 0 && (money.charAt(i) != '+')
							&& (money.charAt(i) != '-')) {
						if (checkNumberNotIsZero == true) {
							result = "." + result;
							checkNumberNotIsZero = false;
						} else {
							result = "";
						}
					}
				} else {
					if ((offsetLast > 0) && (offsetLast % 3) == 0 && (money.charAt(i) != '+')
							&& (money.charAt(i) != '-')) {
						result = "," + result;
					}
				}
				result = money.charAt(i) + result;
			}
		}
		return result;
	}

	public static String parseAmountMoney(double money) {
		String amount = decimalFormatSymbols("#.##", money);
		return parseAmountMoney(amount);
	}

	public static String parseAmountMoney(float money) {

		String amount = decimalFormatSymbols("#.##", money);
		return parseAmountMoney(amount);
	}

	public static String parseAmountMoney(long money) {
		String amount = decimalFormatSymbols("#.##", money);
		return parseAmountMoney(amount);
	}

	/**
	 *
	 * hien thi 2 chu so sau ki tu thap phan su dung DecimalFormat("#.##")
	 *
	 * @author: 
	 * @param percent
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String parseTwoDigitsDecimalCharacter(float percent) {
		String strPercent = decimalFormatSymbols("#.##", percent);
		return strPercent;
	}

	/**
	 *
	 * hien thi 2 chu so sau ki tu thap phan su dung DecimalFormat("#.##")
	 *
	 * @author: 
	 * @param percent
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String parseTwoDigitsDecimalCharacter(double percent) {
		String strPercent = decimalFormatSymbols("#.##", percent);
		return strPercent;
	}

	/**
	 * Cat khoang trang o giua String, giua 2 ky tu chi co duy nhat 1 khoang
	 * trang
	 *
	 * @author: 
	 * @param source
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String itrim(String source) {
		if (!isNullOrEmpty(source)) {
			return source.replaceAll("\\b\\s{2,}\\b", " ");
		}
		return source;
	}

	/**
	 * Checks if is viettel phone number.
	 *
	 * @author: 
	 * @param phoneNumber
	 *            the phone number
	 * @return true, if is viettel phone number
	 */
	public static boolean isViettelPhoneNumber(String phoneNumber) {
		boolean match = false;
		if (canBePhoneNumber(phoneNumber)) {
			String formatedPhone = parseMobileNumber(phoneNumber);
			if (formatedPhone != null) {
				Pattern p = Pattern.compile("^84(98|97|163|164|165|166|167|168|169)[0-9]*$");
				Matcher m = p.matcher(formatedPhone);
				match = m.matches();
			}
		}
		return match;
	}

	public static String dateToString(Date input, String format) throws Exception {
		try {
			String expectedPattern = "".equals(format) ? "dd/MM/yyyy" : format;
			SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

			return formatter.format(input);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public static String stringDateToString(String input, String format) throws Exception {
		try {
			String expectedPattern = "".equals(format) ? "dd/MM/yyyy" : format;
			SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
			return formatter.format(stringToDate(input, format));

		} catch (Exception ex) {
			throw ex;
		}
	}

	public static Date stringToDate(String input, String format) throws Exception {
		try {
			String expectedPattern = "".equals(format) ? "dd/MM/yyyy" : format;
			SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

			return formatter.parse(input);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public static Date addDate(Date input, int number) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(input);

		cal.add(Calendar.DATE, number);

		return cal.getTime();
	}

	public static String changeString(String src, String change, String replace) {
		String result = "";
		result = src.replaceAll(change, replace);
		return result;
	}

	/**
	 * Lay 2 chu so thap phan, khong lam tron, VD: 56.556 => 56.55
	 *
	 * @author: 
	 * @param number
	 * @return
	 * @return: String
	 * @throws:
	*/
	public static String parsePercentWith2Digit(String number) {
		String result = "";
		if (!isNullOrEmpty(number)) {
			// check co dau "." hay khong
			int indexDot = 0;
			String tempMoney = number;
			for (int j = number.length() - 1; j >= 0; j--) {
				Character c = number.charAt(j);
				if (c.equals('.')) {
					indexDot = j;
					break;
				}
			}
			if (indexDot > 0) {
				tempMoney = number.substring(0, indexDot);
				tempMoney = StringUtil.parseAmountMoney(tempMoney);
				if (number.length() - 1 - indexDot > 2) {
					result = tempMoney
							+ number.substring(indexDot, indexDot + 3);
				} else {
					result = tempMoney
							+ number.substring(indexDot, number.length());
				}
			} else {
				result = StringUtil.parseAmountMoney(tempMoney);
			}
		}
		result = formatDoubleString(result);
		return result;
	}

	/**
	 *
	 * Remove cac ky tu dat biet cua sql
	 *
	 * @author: 
	 * @param searchText
	 * @param isAutocomplete
	 * @return
	 * @return: String
	 * @throws:
	 */
	public static String toOracleSearchText(String searchText, boolean isAutocomplete) {
		String[] splitString;
		StringBuilder text = new StringBuilder();
		String OpPat = ",;&"; // search operator pattern
		// String SpPat = "<>./!@#$%^*'\"-_():|[]~+{}?\\\n"; // special char
		// pattern
		char[] searchTextArr;
		boolean preCheck = true;

		// [ commented on Jan 10 - 2011: remove all special characters
		// later]
		// searchText = clearAllHTMLTags(searchText);
		// [end]

		if (!StringUtil.isNullOrEmpty(searchText)) {
			searchTextArr = searchText.toCharArray();

			// remove special char, keep operator char
			for (int i = 0; i < searchTextArr.length; i++) {
				if (STRING_SPECIAL_CHAR.indexOf(searchTextArr[i]) >= 0) {
					searchTextArr[i] = ' ';
				} else if (OpPat.indexOf(searchTextArr[i]) >= 0) {
					if (preCheck) {
						searchTextArr[i] = ' ';
					}
					preCheck = true;
				} else
					preCheck = false;
			}

			searchText = String.valueOf(searchTextArr).trim();
			if (StringUtil.isNullOrEmpty(searchText)) {
				return STRING_SEARCH_LIKE_ALL;
			}

			if (isAutocomplete)
				// searchText = "%" + text.toString().trim() + "%";
				searchText = searchText.trim() + "%";
			else
				searchText = searchText.trim();

			splitString = searchText.split(" ");
			// if (splitString.length > 1) {
			for (int i = 0; i < splitString.length; i++) {
				if (!"".equals(splitString[i])) {

					// if (!isAutocomplete) {
					for (int j = 0; j < oracleTextKeywords.length; j++) {
						if (oracleTextKeywords[j].equals(splitString[i].toUpperCase())) {
							splitString[i] = "{" + splitString[i] + "}";
							break;
						}
					}
					// }

					text.append(splitString[i] + " ");
				}
			}

			searchText = text.toString();

			// remove last operator if exist
			if (OpPat.indexOf(searchText.charAt(searchText.length() - 1)) >= 0) {
				searchText = searchText.substring(0, searchText.length() - 1);
			}
		} else
			return STRING_SEARCH_LIKE_ALL;

		// System.out.println("searchString:" + searchText);
		return searchText;
	}

	/**
	 * Get chuoi HEXA tu mang byte
	 *
	 * @author 
	 * @param b
	 *            : mang byte
	 * @return
	 * @throws Exception
	 */
	public static String getHexString(byte[] b) throws Exception {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

	/**
	 * Get chuoi HEXA tu mang byte nhanh hon
	 *
	 * @author 
	 * @param raw
	 *            : mang byte
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getHexStringFaster(byte[] raw) throws UnsupportedEncodingException {
		byte[] hex = new byte[2 * raw.length];
		int index = 0;
		for (byte b : raw) {
			int v = b & 0xFF;
			hex[index++] = HEX_CHAR_TABLE[v >>> 4];
			hex[index++] = HEX_CHAR_TABLE[v & 0xF];
		}
		return new String(hex, "ASCII");
	}

	/**
	 * Get so serial number SIM
	 *
	 * @author 
	 * @return: serial number SIM
	 */
	public static String getSimSerialNumber() {
		TelephonyManager tm = (TelephonyManager) GlobalInfo.getInstance().getAppContext()
				.getSystemService(Context.TELEPHONY_SERVICE);
		String number = tm.getSimSerialNumber();
		return number;
	}

	/**
	 * tinh % lam tron len
	 *
	 * @author: 
	 * @param temp2
	 * @param temp3
	 * @return
	 * @return: intvoid
	 * @throws:
	 */
	public static int calcularPercent(double temp2, double temp3) {
		if (temp2 >= temp3) {
			return 100;
		} else {
			return (int) ((temp2 / temp3) * 100);
		}
	}

	/**
	 * escape special character of sql
	 *
	 * @author: 
	 * @param sqlValue
	 * @return
	 * @return: String
	 * @throws:
	 */

	public static String escapeSqlString(String sqlValue) {
		sqlValue = sqlValue.replace("^", "^^");// escape char
		sqlValue = sqlValue.replace("_", "^_");// search 1 character
		sqlValue = sqlValue.replace("%", "^%");// search all

		return sqlValue;
	}

	/**
	 * Lay ten file tu chuoi duong dan URL Vi du:
	 * https://www.192.168.1.171/data/file.zip tra ve chuoi: "file"
	 *
	 * @author: 
	 * @param url
	 *            Duong dan URL co chua file name
	 * @return
	 */
	public static String getFileNameRromURLString(String url) {
		String fileNameWithoutExtn = null;
		if (!isNullOrEmpty(url)) {
			String fileName = url.substring(url.lastIndexOf('/') + 1, url.length());
			fileNameWithoutExtn = fileName.substring(0, fileName.lastIndexOf('.'));
		}
		return fileNameWithoutExtn;
	}

	/**
	 * tao chuoi username tu nhung ky tu ban dau
	 *
	 * @author: 
	 * @param userName
	 * @return
	 * @return: String
	 * @throws: Ngoai le do ham dua ra (neu co)
	 */
	public static String generateFullUserName(String userName) {
		StringBuilder fullName = new StringBuilder();
		if (StringUtil.isNullOrEmpty(userName)) {
		} else if (userName.length() == 10) {
			fullName.append(userName);
		} else {
			String zero = "0000000000";
			int lengh = userName.length();
			if (lengh > 2 && userName.substring(0, 2).toUpperCase().equals("GS")) {
				fullName.append("GS" + zero.substring(0, 10 - lengh) + userName.substring(2));
			} else if (lengh > 4 && userName.substring(0, 4).toUpperCase().equals("TBHV")) {
				fullName.append("TBHV" + zero.substring(0, 10 - lengh) + userName.substring(4));
			} else if (userName.charAt(0) <= '9' && userName.charAt(0) >= '0') {
				fullName.append(zero.substring(0, 10 - lengh) + userName);
			}
			else if (lengh >= 1 && userName.substring(0, 1).toUpperCase().equals("N")) {
				fullName.append("NVBH100000");
			}else if (lengh >= 1 && userName.substring(0, 1).toUpperCase().equals("G")) {
				fullName.append("GSNPP10000");
			}
			else if (lengh >= 1 && userName.substring(0, 1).toUpperCase().equals("T")) {
				fullName.append("TBHV100000");
			}
			else {
				fullName.append(userName);
			}
		}
		return fullName.toString();
	}

	/**
	 * count Char In String
	 *
	 * @author: 
	 * @param action
	 * @return
	 * @return: intvoid
	 * @throws:
	 */
	public static int countCharInString(Character ch, String action) {
		int counter = 0;
		for (int i = 0; i < action.length(); i++) {
			if (action.charAt(i) == ch) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * chuyen format string kieu double neu .0 thi bo di
	 *
	 * @author 
	 * @param doubleString
	 * @return
	 */
	public static String formatDoubleString(String doubleString) {
		String result = "";
		if (doubleString.length() > 2) {
			// check cho truong hop ".00"
			String subString2 = doubleString.substring(doubleString.length() - 3, doubleString.length());
			if (subString2.equals(".00")) {
				result = doubleString.substring(0, doubleString.length() - 3);
				return result;
			} else {
				result = doubleString;
			}
			String subString = doubleString.substring(doubleString.length() - 2, doubleString.length());
			if (subString.equals(".0")) {
				result = doubleString.substring(0, doubleString.length() - 2);
				return result;
			} else {
				result = doubleString;
			}
		} else {
			result = doubleString;
		}

		return result;
	}

	/**
	 * Tao mot string tien duoc ngan cach boi dau cham phay voi dang double vi
	 * du :1,600,000.05
	 *
	 * @author 
	 * @param money
	 * @return
	 */
	public static String parseAmountMoneyWithDoubleString(String money) {
		String result = "";
		if (!isNullOrEmpty(money)) {
			// check co dau "." hay khong
			int indexDot = 0;
			String tempMoney = money;
			for (int j = money.length() - 1; j >= 0; j--) {
				Character c = money.charAt(j);
				if (c.equals('.')) {
					indexDot = j;
					break;
				}
			}
			if (indexDot > 0) {
				tempMoney = money.substring(0, indexDot);
				tempMoney = StringUtil.parseAmountMoney(tempMoney);
				result = tempMoney + money.substring(indexDot, money.length());
			} else {
				result = StringUtil.parseAmountMoney(tempMoney);
			}
		}
		return result;
	}

	/**
	 * parse dau thap phan va dau gom nhom du :1,600,000.05
	 *
	 * @author 
	 * @param
	 * @return
	 */
	public static String decimalFormatSymbols(String formatString, Object str) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat(formatString, otherSymbols);
		return df.format(str);
	}

	public static double roundDoubleUp(String formatString, Object str) {
		return roundDouble(formatString, str, RoundingMode.UP);
	}

	public static double roundDoubleDown(String formatString, Object str) {
		return roundDouble(formatString, str, RoundingMode.DOWN);
	}

	public static double roundDouble(String formatString, Object str, RoundingMode roundingMode) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(',');
		DecimalFormat df = new DecimalFormat(formatString, otherSymbols);
		df.setRoundingMode(roundingMode);
		return Double.parseDouble(df.format(str));
	}

	/**
	 * get Double Using Sys Config
	 * @author:
	 * @since: 11:22:03 12 Apr 2015
	 * @return: double
	 * @throws:
	 * @param number
	 * @return
	 */
	/*public static double getDoubleUsingSysConfig(double number){
		return StringUtil.getDouble(number, GlobalInfo.getInstance().getSysCurrencyDivide(),
				GlobalInfo.getInstance().getSysNumRounding());
	}*/

	/**
	 * generate sql count item
	 *
	 * @author: 
	 * @since: 10:34:52 AM Sep 16, 2014
	 * @return: String
	 * @param:
	 * @throws:
	 */
	public static String getCountSql(String sql) {
		String result =  getCountSql(sql, "NUM_ROW");
		return result;
	}

	public static String getCountSql(String sql, String nameCol) {
		String result =  "SELECT count(*) as " + nameCol + " FROM ( " + sql + " )";
		return result;
	}

	/**
	 * Get sql paging from itemOnPage & page
	 *
	 * @author:
	 * @since: 21:12:26 6 Nov 2013
	 * @return: String
	 * @throws:
	 * @param itemOnPage
	 * @param page
	 * @return
	 */
	public static String getPagingSql(int itemOnPage, int page){
		int offset = (page - 1) * itemOnPage;
		int limit = itemOnPage;
		String result =  " limit " + limit + " offset " + offset ;

		return result;
	}

	/**
	 * chuoi html
	 *
	 * @author: 
	 * @since: 9:47:33 AM Sep 17, 2014
	 * @return: CharSequence
	 * @throws:
	 * @param text
	 * @return:
	 */
	public static CharSequence getHTMLText(String text) {
		return Html.fromHtml(text);
	}

	/**
	 * Lay STT
	 *
	 * @author: 
	 * @since: 10:38:42 AM Sep 16, 2014
	 * @return: int
	 * @param:
	 * @throws:
	 */
	public static int getSTT(int currentPage, int numItemPerPage) {
		// TODO Auto-generated method stub
		int firstStt = ((currentPage - 1) * numItemPerPage) + 1;
		return firstStt;
	}

	/**
	 * ten KH co chua ky tu dac biet ko?
	 *
	 * @author: 
	 * @since: 9:20:02 AM Sep 17, 2014
	 * @return: boolean
	 * @throws:
	 * @param
	 * @return:
	 */
	public static boolean isCustomerNameContainValidChars(String name) {
		return isStringContainValidChars(name, charsInNumber, charsInName);
	}

	/**
	 * ky tu dac biet
	 *
	 * @author: 
	 * @since: 9:21:48 AM Sep 17, 2014
	 * @return: boolean
	 * @throws:
	 * @param
	 * @param
	 * @param
	 * @return:
	 */
	private static boolean isStringContainValidChars(String text, char[]  arChar1, char[]  arChar2) {
		boolean isContain = false;
		for (int j = 0, m = text.length(); j < m; j++) {
			isContain = false;
			//check mang 1
			for (int i = 0, n = arChar1.length; i < n; i++) {
				if (text.charAt(j) == arChar1[i]) {
					isContain = true;
					break;
				}
			}
			if (isContain == true) {
				continue;
			}
			 
			for (int i = 0, n = arChar2.length; i < n; i++) {
				if (text.charAt(j) == arChar2[i]) {
					isContain = true;
					break;
				}
			}
			
			for(int k = 0, n = VN_SYMBOLS.length; k < n; k++) {
				if(Integer.valueOf(text.charAt(j)) == VN_SYMBOLS[k]) {
					isContain = true;
					break;
				}
			}
			
			if (isContain == false) {
				break;
			}
		}

		return isContain;
	}

	/**
	 * Dia chi chua ky tu dac biet
	 *
	 * @author: 
	 * @since: 9:29:25 AM Sep 17, 2014
	 * @return: boolean
	 * @throws:
	 * @param
	 * @return:
	 */
	public static boolean isHouseNumberContainValidChars(String street) {
		return isStringContainValidChars(street, charsInHouseNumber, charsInName);
	}

	/**
	 * ten duong chua ky tu dac biet
	 *
	 * @author: 
	 * @since: 9:30:02 AM Sep 17, 2014
	 * @return: boolean
	 * @throws:
	 * @param
	 * @return:
	 */
	public static boolean isStreetContainValidChars(String street) {
		return isStringContainValidChars(street, charsInStreet, charsInName);
	}

	/**
	 * mau chu
	 *
	 * @author: 
	 * @since: 9:46:03 AM Sep 17, 2014
	 * @return: String
	 * @throws:
	 * @param
	 * @param color
	 * @return:
	 */
	public static String getColorText(String text, int color) {
		if (isNullOrEmpty(text)) {
			text = "";
		}
		String colorString = String.format("%X", color).substring(2); // !!strip alpha value!!
		String result = String.format("<font color=\"#%s\">%s</font>", colorString, text);
		return result;
	}

	public static String getStringOrder(String order, boolean orderAscOrDesc) {
		StringBuilder sb = new StringBuilder();
		if(!StringUtil.isNullOrEmpty(order)) {
			sb.append(" order by ");
			sb.append(order);
			if(orderAscOrDesc) {
				// sap tang
				sb.append(" asc ");
			} else {
				// sap giam
				sb.append(" desc ");
			}
		}
		return sb.toString();
	}

	public static final int ROUND_UP = 1;
	public static final int ROUND_DOWN = 2;
	public static final int ROUND_NATURAL = 3;

	/**
	 * format double number with format  #,##0.00 (cau hinh dau , . + so luong so sau thap phan)
	 * @author:
	 * @since: 10:53:22 31 Mar 2015
	 * @return: String
	 * @throws:
	 * @param number
	 * @return
	 */
	public static String formatNumber(double number) {
		String result;
		if(number % 1 == 0){
			result = formatNumber(number, false);
		}else{
			result = formatNumber(number, true);
		}
		return result;
	}

	/**
	 * format long number with format  #,##0
	 * @author:
	 * @since: 11:03:10 31 Mar 2015
	 * @return: String
	 * @throws:
	 * @param number
	 * @return
	 */
	public static String formatNumber(long number) {
		String result = formatNumber(number, false);
		return result;
	}

	/**
	 * format int number with format  #,##0
	 * @author:
	 * @since: 15:15:16 2 Apr 2015
	 * @return: String
	 * @throws:
	 * @param number
	 * @return
	 */
	public static String formatNumber(int number) {
		String result = formatNumber(number, false);
		return result;
	}

	/**
	 * format object number with format pattern
	 * @author:
	 * @since: 11:03:23 31 Mar 2015
	 * @return: String
	 * @throws:
	 * @param number
	 * @param format
	 * @param numberSeparator
	 * @param groupingSeparator
	 * @return
	 */
	private static String formatNumber(Object number, String format, char numberSeparator, char groupingSeparator) {
		String result = EMPTY_STRING;
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		otherSymbols.setDecimalSeparator(numberSeparator);
		otherSymbols.setGroupingSeparator(groupingSeparator);
		DecimalFormat df = new DecimalFormat(format, otherSymbols);
		result = df.format(number);
		return result;
	}

	/**
	 * parse number from string (1,0909.090)
	 * @author:
	 * @since: 09:54:02 9 Apr 2015
	 * @return: String
	 * @throws:
	 * @param
	 * @param format
	 * @param numberSeparator
	 * @param groupingSeparator
	 * @return
	 */
	private static Number parseNumberStr(String numberStr, String format, char numberSeparator, char groupingSeparator) {
		Number result = 0;
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		otherSymbols.setDecimalSeparator(numberSeparator);
		otherSymbols.setGroupingSeparator(groupingSeparator);
		DecimalFormat df = new DecimalFormat(format, otherSymbols);
		try {
			if (!StringUtil.isNullOrEmpty(numberStr)) {
				result = df.parse(numberStr);
			}
		} catch (ParseException e) {
			Log.i("parseNumberStr: " + e.getMessage(), "parse fail", e);
		}
		return result;
	}

	/**
	 * parse string to double
	 * @author:
	 * @since: 10:01:26 9 Apr 2015
	 * @return: double
	 * @throws:
	 * @param numberStr
	 * @return
	 */
	public static double parseDoubleStr(String numberStr) {
		return parseNumberStr(numberStr).doubleValue();
	}

	/**
	 * parse string to long
	 * @author:
	 * @since: 10:01:46 9 Apr 2015
	 * @return: long
	 * @throws:
	 * @param numberStr
	 * @return
	 */
	public static long parseLongStr(String numberStr) {
		return parseNumberStr(numberStr).longValue();
	}

	/**
	 * parse string to int
	 * @author:
	 * @since: 10:01:53 9 Apr 2015
	 * @return: int
	 * @throws:
	 * @param numberStr
	 * @return
	 */
	public static int parseIntStr(String numberStr) {
		return parseNumberStr(numberStr).intValue();
	}

	/**
	 * parse number string using sys config format
	 * @author:
	 * @since: 10:00:34 9 Apr 2015
	 * @return: Number
	 * @throws:
	 * @param
	 * @return
	 */
	private static Number parseNumberStr(String numberStr) {
		int sysDecimalPoint = GlobalInfo.getInstance().getSysDecimalPoint();
		//2 la dung dau cham ngan cach phan thap phan
		char numberSeparator = (sysDecimalPoint == 2) ? '.' : ',';
		//se dung dau con lai ngan cach nhom 3 chu so
		char groupingSeparator = (sysDecimalPoint == 2) ? ',' : '.';
		String format = "#,##0";
		//so luong chu so phan thap phan
		int numDot = GlobalInfo.getInstance().getSysDigitDecimal();
		if (numDot > 0) {
			format += numberSeparator;
			for (int i = 0; i < numDot; i++) {
				format += "0";
			}
		}
		return parseNumberStr(numberStr, format, numberSeparator, groupingSeparator);
	}

	private static String formatNumber(Object number, boolean isUsingDigitDecimal) {
		int sysDecimalPoint = GlobalInfo.getInstance().getSysDecimalPoint();
		//2 la dung dau cham ngan cach phan thap phan
		char numberSeparator = (sysDecimalPoint == 2) ? '.' : ',';
		//se dung dau con lai ngan cach nhom 3 chu so
		char groupingSeparator = (sysDecimalPoint == 2) ? ',' : '.';
		String format = "#,##0";
		if (isUsingDigitDecimal) {
			//so luong chu so phan thap phan
			int numDot = GlobalInfo.getInstance().getSysDigitDecimal();
			if (numDot > 0) {
				format += ".";
				for (int i = 0; i < numDot; i++) {
					format += "0";
				}
			}
		}

		return formatNumber(number, format, numberSeparator, groupingSeparator);
	}

	/**
	 * Remove cac ky tu hang thap phan, hang ngan
	 * @param numberStr
	 * @return
     */
	public static String removeSysDecimalConfigOfNumberStr(String numberStr) {
		//2 la dung dau cham ngan cach phan thap phan
		String charOne = ".";
		String charTwo = ",";
		if (!isNullOrEmpty(numberStr)) {
			numberStr = numberStr.replace(charOne, "").replace(charTwo, "");
		}
		return numberStr;
	}

	/**
	 * get amount with sys Currency Divide
	 * @author:
	 * @since: 13:50:23 2 Apr 2015
	 * @return: double
	 * @throws:
	 * @param amount
	 * @param sysCurrencyDivide
	 * @return
	 */
	public static double getAmountWithCurDivide(double amount, int sysCurrencyDivide){
		if (sysCurrencyDivide <= 0) {
			sysCurrencyDivide = 1;
		}

		double result = amount / sysCurrencyDivide;
		return result;
	}

	public static String formatStringNumber(double d)
	{
		if(d == (long) d)
			return String.format("%d",(long)d);
		else
			return String.format("%s",d);
	}

	/**
	 * get number with sys round config
	 * @author:
	 * @since: 16:52:46 5 Apr 2015
	 * @return: double
	 * @throws:
	 * @param number 1. Lam tron len: 2.345 = 2.35, 2.678 = 2.68, 2. Lam tron xuong: 2.865 = 2.86, 2.841 = 2.84, 3. Lam tron tu nhien: 2.355 = 2.36, 2.344 = 2.34, 2.567 = 2.57
	 * @param typeRound
	 * @return
	 */
	public static double round(double number, int typeRound){
		//so luong chu so phan thap phan
		int numDot = GlobalInfo.getInstance().getSysDigitDecimal();
		double result = 0;
		switch (typeRound) {
		case 1:
			result = roundUp(number, numDot);
			break;
		case 2:
			result = roundDown(number, numDot);
			break;
		case 3:
			result = roundNatural(number, numDot);
			break;

		default:
			result = number;
			break;
		}
		return result;
	}

	/**
	 * round number using round config
	 * @author:
	 * @since: 08:53:32 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param number
	 * @return
	 */
	public static double round(double number){
		return round(number, GlobalInfo.getInstance().getSysNumRounding());
	}

	/**
	 * round up
	 * @author:
	 * @since: 09:09:49 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param x
	 * @param scale
	 * @return
	 */
	public static double roundUp(double x, int scale) {
	      return round(x, scale, BigDecimal.ROUND_CEILING);
	}

	/**
	 * round down
	 * @author:
	 * @since: 09:09:57 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param x
	 * @param scale
	 * @return
	 */
	public static double roundDown(double x, int scale) {
		return round(x, scale, BigDecimal.ROUND_FLOOR);
	}

	/**
	 * round natural
	 * @author:
	 * @since: 09:10:03 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param x
	 * @param scale
	 * @return
	 */
	public static double roundNatural(double x, int scale) {
		return round(x, scale, BigDecimal.ROUND_HALF_EVEN);
	}

	/**
	 * round using param config
	 * @author:
	 * @since: 09:10:11 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param x
	 * @param scale so chu so sau dau thap phan
	 * @param roundingMethod 1 tron len, 2 tron xuong, 3 tron tu nhien
	 * @return
	 */
	public static double round(double x, int scale, int roundingMethod) {
		try {
			return (new BigDecimal(Double.toString(x)).setScale(scale, roundingMethod)).doubleValue();
		} catch (NumberFormatException ex) {
			if (Double.isInfinite(x)) {
				return x;
			} else {
				return Double.NaN;
			}
		}
	}

	/**
	 * display double data in TextView
	 * @author:
	 * @since: 14:39:50 2 Apr 2015
	 * @return: void
	 * @throws:
	 * @param tv
	 * @param number
	 */
	public static void display(TextView tv, double number){
		display(tv, StringUtil.formatNumber(number));
	}

	/**
	 * display percent
	 * @author:
	 * @since: 11:10:40 3 Apr 2015
	 * @return: void
	 * @throws:
	 * @param tv
	 * @param
	 */
	public static void displayPercent(TextView tv, double percent){
		display(tv, StringUtil.formatNumber(percent) + "%");
	}

	/**
	 * display long data in TextView
	 * @author:
	 * @since: 14:40:09 2 Apr 2015
	 * @return: void
	 * @throws:
	 * @param tv
	 * @param number
	 */
	public static void display(TextView tv, long number){
		display(tv, StringUtil.formatNumber(number));
	}

	/**
	 * display int data in TextView
	 * @author:
	 * @since: 14:40:29 2 Apr 2015
	 * @return: void
	 * @throws:
	 * @param tv
	 * @param number
	 */
	public static void display(TextView tv, int number){
		display(tv, StringUtil.formatNumber(number));
	}

	/**
	 * display CharSequence data in TextView
	 * @author:
	 * @since: 14:40:37 2 Apr 2015
	 * @return: void
	 * @throws:
	 * @param tv
	 * @param str
	 */
	public static void display(TextView tv, CharSequence str){
		if (tv != null) {
			tv.setText(str);
		} else{
			Log.e("display TextView", "TextView null with data: " + str);
		}
	}
	
	/**
	 * display string data with format in TextView
	 * @author:
	 * @since: 14:40:37 2 Apr 2015
	 * @return: void
	 * @throws:
	 * @param
	 * @param
	 */
	public static void displayWithFormat(TextView tv, String format, Object... params){
		if (tv != null) {
			tv.setText(String.format(format, params));
		} else{
			Log.e("display TextView", "TextView null with data: format: " + format + " params: " + Arrays.toString(params));
		}
	}

	/**
	 * cal percent
	 * @author:
	 * @since: 09:03:34 3 Apr 2015
	 * @return: double
	 * @throws:
	 * @param planNumber
	 * @param workNumber
	 * @return
	 */
	public static double calPercent(double planNumber, double workNumber) {
		double result = 0;
//		if (planNumber == 0) {
//			if (workNumber == 0) {		
		if (BigDecimal.valueOf(planNumber).compareTo(BigDecimal.ZERO) == 0) {
			if (BigDecimal.valueOf(workNumber).compareTo(BigDecimal.ZERO) == 0) {
				result = 0;
			} else{
				result = 100;
			}
		} else {
			return (workNumber / planNumber) * 100;
		}
		return result;
	}

	/**
	 * cal percent using round config
	 * @author:
	 * @since: 09:11:43 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param planNumber
	 * @param workNumber
	 * @return
	 */
	public static double calPercentUsingRound(double planNumber, double workNumber) {
		double result = calPercent(planNumber, workNumber);
		result = round(result);
		return result;
	}

	/**
	 * cal remain
	 * @author:
	 * @since: 09:05:04 3 Apr 2015
	 * @return: double
	 * @throws:
	 * @param planNumber
	 * @param workNumber
	 * @return
	 */
	public static double calRemain(double planNumber, double workNumber) {
		double result = 0;
		if (workNumber > planNumber) {
			result = 0;
		} else {
			return planNumber - workNumber;
		}
		return result;
	}

	/**
	 * cal remain uisng sys round
	 * @author:
	 * @since: 08:54:19 6 Apr 2015
	 * @return: double
	 * @throws:
	 * @param planNumber
	 * @param workNumber
	 * @return
	 */
	public static double calRemainUsingRound(double planNumber, double workNumber) {
		double result = calRemain(planNumber, workNumber);
		result = round(result);
		return result;
	}

	/**
	 * cal remain with long number
	 * @author:
	 * @since: 09:05:08 3 Apr 2015
	 * @return: long
	 * @throws:
	 * @param planNumber
	 * @param workNumber
	 * @return
	 */
	public static long calRemain(long planNumber, long workNumber) {
		long result = 0;
		if (workNumber > planNumber) {
			result = 0;
		} else {
			return planNumber - workNumber;
		}
		return result;
	}

	/**
	 * get string from array
	 * @author:
	 * @since: 09:32:35 3 Apr 2015
	 * @return: String
	 * @throws:
	 * @param array
	 * @return
	 */
	public static <T> String getArrayString(T[] array){
		StringBuilder result = new StringBuilder();
		if (array != null) {
			for (T item : array) {
				result.append(String.valueOf(item) + ",");
			}
		}
		return result.toString();
	}

	/**
	 * return super script
	 *
	 * @author: 
	 * @since: 11:15:04 AM Apr 20, 2015
	 * @return: SpannableStringBuilder
	 * @param superScript
	 * @param color
	 */
	public static SpannableStringBuilder superScript(CharSequence superScript, int color) {
		SpannableStringBuilder builder = new SpannableStringBuilder();

		String text = Constants.STR_BLANK;
		text = text + "<sup><small>" + superScript + "</small></sup>";
		CharSequence script =  getHTMLText(text);

		SpannableString redSpannable= new SpannableString(script);
		redSpannable.setSpan(new ForegroundColorSpan(color), 0, script.length(), 0);
		builder.append(redSpannable);
		return builder;
	}

	/**
	 * setcolor cho percent
	 * @author: hoanpd1
	 * @since: 14:55:02 07-04-2015
	 * @return: void
	 * @throws:
	 * @param
	 * @param
	 * @param
	 * @param
	 */
	/*public static void setTextColorPercent(TextView tv, double progress, double standarPercentAlow, int color) {
		tv.setTextColor(ImageUtil.getColor(R.color.BLACK));
		if (progress < standarPercentAlow) {
			tv.setTextColor(color);
		}
	}*/

	/**
	 * get double with config
	 * @author:
	 * @since: 11:21:18 12 Apr 2015
	 * @return: double
	 * @throws:
	 * @param number
	 * @param sysCurrencyDivide
	 * @param sysTypeRound
	 * @return
	 */
	public static double getDouble(double number, int sysCurrencyDivide, int sysTypeRound){
		if (sysCurrencyDivide > 1) {
			number = getAmountWithCurDivide(number, sysCurrencyDivide);
		}
		if (sysTypeRound >= 1) {
			number = round(number, sysTypeRound);
		}
		return number;
	}

	/**
	 * get string from
	 * @author:
	 * @since: 17:37:53 13 Apr 2015
	 * @return: String
	 * @throws:
	 * @param resId
	 * @param formatArgs
	 * @return
	 */
	public static String getString(int resId, Object... formatArgs) {
		return GlobalInfo.getInstance().getAppContext().getResources().getString(resId, formatArgs);
	}

	 /**
	 * Tinh % va lam tron
	 * @author: Tuanlt11
	 * @param planNumber
	 * @param workNumber
	 * @return
	 * @return: double
	 * @throws:
	*/
	public static double calPercentUsingRound(long planNumber, long workNumber) {
		double result = calPercent(planNumber, workNumber);
		result = round(result);
		return result;
	}
	
	/**
	 * numReport
	 * @author: 
	 * @since: 14:20:17 21-07-2015
	 * @return: int
	 * @throws:  
	 * @param num
	 * @param convfact
	 * @return
	 */
	public static String numReport(long num, int convfact) {
		String result = Constants.STR_BLANK;
		long numC = 0;
		long numL = 0;
		if (num == 0) {
			result = "0" + "/" + "0";
		} else {
			numC = (int) (num / convfact);
			if((numC*convfact) == num){
				numL = 0;
			}else{
				numL = num - (numC*convfact);
			}
			result = numC + "/" + numL;
		}
		return result;
	}

	public static String removeUnicodeChar(String src){
		String des = src;
		
		try {
			if (!StringUtil.isNullOrEmpty(src)) {
				String input = String.valueOf(src);
				input = getEngStringFromUnicodeString(input);
				des = Normalizer.normalize(input, Normalizer.Form.NFD)
						.replaceAll("[^\\p{ASCII}]", "");
			}
			Log.d("removeUnicodeChar", src + " -> " + des);
		} catch (Exception e) {
			Log.d("removeUnicodeChar", e.getMessage(), e);
		}

		return des;
	}
	
	/**
	 * check policy password
	 * @author:
	 * @time: 6:27:48 AM Nov 3, 2015
	 * @param pass
	 * @return
	*/
	public static boolean checkPolicyPassword(String pass) {
		//return pass.length() > 6 && pass.matches(".*[A-Z].*") && pass.matches(".*[a-z].*") && pass.matches(".*[0-9].*");
		//return pass.length() > 8 && pass.matches(".*[a-z].*") && pass.matches(".*[0-9].*");
		return pass.matches(PASSWORD_PATTERN);
	}

	/**
	 * DungNX3
	 * @param number
	 * @param typeRound
	 * @return
	 */
	public static double roundMarkTraining(double number, int numDot, int typeRound){
		double result = 0;
		switch (typeRound) {
			case 1:
				result = roundUp(number, numDot);
				break;
			case 2:
				result = roundDown(number, numDot);
				break;
			case 3:
				result = roundNatural(number, numDot);
				break;

			default:
				result = number;
				break;
		}
		return result;
	}

	/**
	 * DungNX3
	 * @param number
	 * @return
	 */
	public static String formatTrainingScore(double number) {
		int sysDecimalPoint = GlobalInfo.getInstance().getSysDecimalPoint();
		//2 la dung dau cham ngan cach phan thap phan
		char numberSeparator = (sysDecimalPoint == 2) ? '.' : ',';
		//se dung dau con lai ngan cach nhom 3 chu so
		char groupingSeparator = (sysDecimalPoint == 2) ? ',' : '.';
		String format = "#,##0";
		//so luong chu so phan thap phan
		int numDot = 2;
		if (numDot > 0) {
			format += ".";
			for (int i = 0; i < numDot; i++) {
				format += "0";
			}
		}
		return formatNumber(number, format, numberSeparator, groupingSeparator);
	}
}
