package com.example.thuattq1.constants;

/**
 *  Define hang so trong chuong trinh
 *  @author:
 *  @version: 1.0
 *  @since: 1.0
 */
public final class Constants {
	//kich thuoc cua hinh anh dinh kem
	//kich thuoc anh toi da upload
	public static final int MAX_FULL_IMAGE_WIDTH = 600;
	public static final int MAX_FULL_IMAGE_HEIGHT = 600;

	//kich thuoc anh toi da upload
	public static final int MAX_THUMB_IMAGE_WIDTH = 250;
	public static final int MAX_THUMB_IMAGE_HEIGHT = 200;
	public static final int MAX_UPLOAD_IMAGE_WIDTH = 740;
	public static final int MAX_UPLOAD_IMAGE_HEIGHT = 740;
	public static final int MAX_LENGHT_QUANTITY = 7;
	public static final int MAX_LENGHT_LOT = 10;
	public static final int MAX_LENGHT_PRICE = 20;
	public static final int MAX_LENGHT_PRICE_HAS_GROUP = 25;
	public static final int MAX_LENGTH_TRANSACTION_ID = 14;
	public static final int MAX_LENGTH_RANDOM_ID = 18;

    public static final String TEMP_IMG = "temp_image";

	// kich thuoc left menu
	public static final int LEFT_MARGIN_TABLE_DIP = 10;
	public static final int RIGHT_MARGIN_TABLE_DIP = 10;
	public static final int LEFT_MARGIN_TABLE_DIP_SMALL = 5;

    //
	public static final String STR_BLANK = "";
	public static final String STR_SPACE = " ";
	public static final String STR_SUBTRACTION = " - ";
	public static final String STR_CROSS = " / ";
	public static final String LOG_LBS = "LOG_LBS";
	public static final String REPLACED_STRING = "xxx";
	public static final int COLUMN = 2;
	public static final int ROW = 1;
	public static final int IN_USE = 1;
	public static final int NO_USE = 0;
	public static final int ZERO = 0;

	// chuoi dung de ghep vao ds doi tuong bao cao lay ra
	public static final String GROUP_STRING = "___";
	public static final String STR_BRACKET_LEFT  = " (";
	public static final String STR_BRACKET_RIGHT  = ") ";
	public static final String STR_TOKEN  = ", ";

    // config report
	public static final String[] LEVEL_CODE_ARRAY = new String[] {
        "A", "B", "C", "D", "E", "F",
        "G", "H", "I", "J", "K", "L",
        "M", "N", "O", "P", "Q", "W",
        "V", "Y", "Z" };

	public static final int NUM_ITEM_PER_PAGE = 10;

    /*public static final String DAY_LINE[] = {
        StringUtil.getString(R.string.TEXT_MONDAY_),
		StringUtil.getString(R.string.TEXT_TUESDAY_),
		StringUtil.getString(R.string.TEXT_WEDNESDAY_),
		StringUtil.getString(R.string.TEXT_THUSDAY_),
		StringUtil.getString(R.string.TEXT_FRIDAY_),
		StringUtil.getString(R.string.TEXT_SATURDAY_),
		StringUtil.getString(R.string.TEXT_SUNDAY_)
    };

    public static final String ARRAY_LINE_CHOOSE[] = {
            StringUtil.getString(R.string.TEXT_MONDAY),
            StringUtil.getString(R.string.TEXT_TUESDAY),
            StringUtil.getString(R.string.TEXT_WEDNESDAY),
            StringUtil.getString(R.string.TEXT_THURSDAY),
            StringUtil.getString(R.string.TEXT_FRIDAY),
            StringUtil.getString(R.string.TEXT_SATURDAY),
            StringUtil.getString(R.string.TEXT_SUNDAY),
            StringUtil.getString(R.string.TEXT_ALL)
    };*/

    public static final String TODAY[] = {
            "Monday","Tuesday","Wednesday",
            "Thursday","Friday","Saturday",
            "Sunday"
    };

    // connect to server
	public static final int CONNECTION_ONLINE  = 1;
	public static final int CONNECTION_OFFLINE  = -1;
	/*public static final String MESSAGE_ERROR_COMMON = StringUtil.getString(R.string.TEXT_MESSAGE_ERROR_COMMON);
    public static final String HAS_ERROR_HAPPEN = StringUtil.getString(R.string.TEXT_HAS_ERROR_HAPPEN);*/

	// ten file db ma hoa
    public static final String DATABASE_NAME = "TodoDatabase";
    public static final String TEMP_SYNDATA_FILE = "Tmp" + DATABASE_NAME;
	public static final String DATABASE_NAME_CIPHER = "Plaint" + DATABASE_NAME;

	public static final int NUM_LOAD_MORE_IMAGE = 10;
	public static final int NUM_LOAD_MORE = 20;

	public static final int NEED_VALIDATE_CLICK = 1;
	public static final int NO_NEED_VALIDATE_CLICK = 0;
	public static final int TIME_CHECK_DOUBLE_CLICK = 1000;
}
