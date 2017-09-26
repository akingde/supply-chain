package com.bs.service.core.utils;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringUtil {
	/** 编码 **/
	public static final String ENCODING = "UTF-8";
	/** 编码 **/
	public static final String ISO_ENCODING = "ISO8859-1";

	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String formatData(Object money) {
		DecimalFormat a = new DecimalFormat("##.##");
		String formatStr = a.format(money);
		return formatStr;
	}

	/**
	 * 验证手机号
	 * @param mobilePhone
	 * @return
	 */
	public static boolean isMobileNO(String mobilePhone) {
		String exp = "^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$";
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(mobilePhone);
		return m.matches();

	}

	/**
	 * 浮点和整数验证
	 * @param data
	 * @return
	 */
	public static boolean isFooatOrInt(String data) {
		String exp = "[0-9]{1,14}(\\.{0,1}[0-9]{1,2})?";
		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(data);
		return matcher.matches();
	}

	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String exp = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * 随机数生成
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String getRandomCode(int begin, int length) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		StringBuilder result = new StringBuilder();
		for (int i = begin; i < length; i++) {
			result.append(array[i]);
		}
		return result.toString();
	}

	/**
	 * 这是典型的随机洗牌算法。 流程是从备选数组中选择一个放入目标数组中， 将选取的数组从备选数组移除（放至最后，并缩小选择区域） 算法时间复杂度O(n)
	 *
	 * @return 随机8为不重复数组
	 */
	public static String generateRandom(int len) {
		String no = "";
		// 初始化备选数组
		int[] defaultNums = new int[10];
		for (int i = 0; i < defaultNums.length; i++) {
			defaultNums[i] = i;
		}
		Random random = new Random();
		int[] nums = new int[len];
		// 默认数组中可以选择的部分长度
		int canBeUsed = 10;
		// 填充目标数组
		for (int i = 0; i < nums.length; i++) {
			// 将随机选取的数字存入目标数组
			int index = random.nextInt(canBeUsed);
			nums[i] = defaultNums[index];
			// 将已用过的数字扔到备选数组最后，并减小可选区域
			swap(index, canBeUsed - 1, defaultNums);
			canBeUsed--;
		}
		if (nums.length > 0) {
			for (int i = 0; i < nums.length; i++) {
				no += nums[i];
			}
		}

		return no;
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static boolean pwd(String pwd) {
		String exp = "^[a-zA-Z0-9`~!@#$%^&*()+=|{}':;',\\[\\].<>/?]{6,20}$";
		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(pwd);
		return matcher.matches();
	}

	public static String encoding(String value) {
		try {
			if (value.equals(new String(value.getBytes(ISO_ENCODING), ISO_ENCODING))) {
				return value = new String(value.getBytes(ISO_ENCODING), ENCODING);
			}
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 生成流水号:业务代码_yyyyMMddHHmmssSSS
	 * @param
	 */
	public static synchronized String genertFlowNumber(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		StringBuffer buffer = new StringBuffer(str);
		String dateStr = formatter.format(new Date());
		buffer.append("_").append(dateStr);
		return buffer.toString();
	}

	public static String subCardNum(String idCard) {
		String cardNumber = "";
		if (!StringUtils.isEmpty(idCard)) {
			cardNumber = idCard.substring(idCard.length() - 4, idCard.length());
		}
		return cardNumber;
	}

	/**
	 * 格式化金额
	 * @param money
	 */
	public static String formatMoney(Object money) {
		DecimalFormat a = new DecimalFormat(".##");
		String pattern = "###,###.##";
		a.applyPattern(pattern);
		String formatStr = a.format(money);
		return formatStr;
	}

	public static String escapeSpecialWord(String keyword) {
		if (!StringUtils.isEmpty(keyword)) {
			String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" };
			for (String key : fbsArr) {
				if (keyword.contains(key)) {
					keyword = keyword.replace(key, "\\" + key);
				}
			}
		}
		return keyword;
	}

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static String trim(Object obj) {
		if (obj == null)
			return "";
		return obj.toString().trim();
	}

	public static boolean isEmpty(String str) {
		return ((str == null) || ("".equals(str.trim())));
	}

	public static boolean isNotEmpty(String str) {
		return (!(isEmpty(str)));
	}

	// public static void main(String[] args) {
	// // System.out.println(generateRandom(6));
	// // System.out.println(String.format("%05d", 2));
	// // System.out.println(pwd("1234567*~@？890") + "--1234567890");
	// // System.out.println(pwd("qwertyuiop") + "--qwertyuiop");
	// // System.out.println(pwd("1234q56") + "--1234q56");
	// // System.out.println(pwd("123qw456") + "--123qw456");
	// // System.out.println(pwd("12qw3!@456") + "--12qw3!@456");
	// // System.out.println(pwd("1&*23456") + "--1&*23456");
	// // System.out.println(pwd("!@#$%^&*()") + "--!@#$%^&*()");
	// System.out.println(genertFlowNumber("cle"));
	//
	// }
}
