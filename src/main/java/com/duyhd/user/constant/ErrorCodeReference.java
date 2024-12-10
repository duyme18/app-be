package com.duyhd.user.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorCodeReference {
    //Account does not have permission
    public static final String FORBIDDEN = "403";
    //Common message code for Validation
    public static final String VALIDATOR_EXCEPTION = "VALIDATOR_ERROR";
    //Validate message code notnull or empty
    public static final String NOT_NULL_OR_EMPTY = "MSG0001";
    //Validate message code max length 255
    public static final String MAX_LENGTH_255 = "MSG0002";
    //Validate update account - regis account
    public static final String EMAIL_EXISTED = "MSG001";
    //Validate email when generate OTP for change password
    public static final String EMAIL_NOT_EXISTED = "MSG002";

    //Validate email format
    public static final String EMAIL_FORMAT_INVALID = "MSG0011";
    //Validate phone update account - regis account
    public static final String PHONE_NUMBER_INVALID = "MSG003";
    //Validate OTP failed
    public static final String OTP_INVALID = "MSG006";
    public static final String BAD_REQUEST = "MSG007";
    //Login failed
    public static final String INVALID_USER_CREDENTIALS = "MSG008";
    //Read file failed
    public static final String FILE_UNREADABLE = "MSG009";
    public static final String ACCOUNT_HAS_NOT_CHANGED_PASSWORD_FIRST_TIME = "MSG010";
    //Changed password: New password and confirm password does not match
    public static final String PASSWORD_NOT_MATCH = "MSG011";
    //OTP timeout
    public static final String OTP_TIMEOUT = "MSG016";
    public static final String EMPTY_RESULT = "MSG101";
    public static final String OBJECT_NOT_FOUND = "MSG004";
    public static final String STATUS_INVALID = "MSG005";
    public static final String PROJECT_TYPE_INVALID = "MSG012";
    public static final String FILE_EXCEED_MAXIMUM_ALLOWED_SIZE = "MSG013";
    public static final String BUDGET_INVALID = "MSG014";
    public static final String DATE_INVALID = "MSG015";
    public static final String FIELD_INVALID_DATA_TYPE = "MSG017";
    public static final String PROJECT_HAS_A_PROPOSAL = "MSG018";
    public static final String UNCONFIRMED_PROJECT = "MSG019";
    public static final String PMO_NOT_ASSIGNED_PROJECT = "MSG020";
    public static final String ENUM_INVALID = "MSG021";
    public static final String REJECT_REASON_CAN_NOT_BE_EMPTY = "MSG022";
    public static final String PROJECT_NOT_EDITABLE = "MSG023";
    public static final String KEYCLOAK_ERROR = "MSG024";
    public static final String PROJECT_PLANNING_NOT_FOUND = "MSG025";
    public static final String CUSTOMER_PLANNING_NOT_VIEWABLE = "MSG026";
    public static final String FILE_NOT_FOUND = "MSG027";
    public static final String FILE_EXTENSION_NOT_ALLOWED = "MSG028";
    public static final String INVALID_AUTHENTICATION_CODE = "MSG029";
}
