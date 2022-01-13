package common;

import java.util.regex.Pattern;

public class Constants {
    public static final String BILL_FILE = "Bill.DAT";
    public static final String CLOTHES_STORE_FILE= "ClothersStore.DAT";
    public static final String TYPE_OF_CLOTHES_FILE = "TypesOfCloth.DAT";
    public static final String USER_CUR_FILE ="User_Cur.DAT";
    public static final String USER_FILE= "Users.DAT";
    public static final double DISCOUNT_BIRTHDAY =0.25;
    public static Pattern regexPassword = Pattern.compile("^(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9@$!%*?&]{8,}$");
    public static Pattern regexEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    public static Pattern regexUsername = Pattern.compile("^[a-zA-Z0-9]{6,}$");
    public static Pattern regexPhone = Pattern.compile("^[0-9\\-\\+]{9,15}$");
}
