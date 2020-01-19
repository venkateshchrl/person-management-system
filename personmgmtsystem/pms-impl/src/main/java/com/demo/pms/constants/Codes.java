package com.demo.pms.constants;

public class Codes {
    private Codes(){
        throw new IllegalStateException("Utility class to handle error messages and codes");
    }
    public static final String PERSON_ADDITION_SUCCESS_CODE = "API-2100";
    public static final String PERSON_ADDITION_SUCCESS_MSG = "Person Added Successfully";

    public static final String PERSON_ADDITION_FAILURE_CODE = "API-1100";
    public static final String PERSON_ADDITION_FAILURE_MSG = "Person Addition Failed";

    public static final String PERSONS_LIST_FETCH_SUCCESS_CODE = "API-2101";
    public static final String PERSONS_LIST_FETCH_SUCCESS_MSG = "Person List Retrieval Successful";

    public static final String PERSONS_LIST_FETCH_FAILURE_CODE = "API-1101";
    public static final String PERSONS_LIST_FETCH_FAILURE_MSG = "Person List Retrieval Failed";

    public static final String PERSON_DETAILS_RETRIEVAL_SUCCESS_CODE = "API-2102";
    public static final String PERSON_DETAILS_RETRIEVAL_SUCCESS_MSG = "Person Details Retrieval Successful";

    public static final String PERSON_DETAILS_RETRIEVAL_FAILURE_CODE = "API-1102";
    public static final String PERSON_DETAILS_RETRIEVAL_FAILURE_MSG = "Person Details Retrieval Failed";

    public static final String PERSON_DETAILS_UPDATE_SUCCESS_CODE = "API-2103";
    public static final String PERSON_DETAILS_UPDATE_SUCCESS_MSG = "Person Details Update Successful";

    public static final String PERSON_DETAILS_UPDATE_FAILURE_CODE = "API-1103";
    public static final String PERSON_DETAILS_UPDATE_FAILURE_MSG = "Person Details Update Failed";

    public static final String PERSON_DETAILS_DELETE_SUCCESS_CODE = "API-2104";
    public static final String PERSON_DETAILS_DELETE_SUCCESS_MSG = "Person Details Delete Successful";

    public static final String PERSON_DETAILS_DELETE_FAILURE_CODE = "API-1104";
    public static final String PERSON_DETAILS_DELETE_FAILURE_MSG = "Person Details Delete Failed";

    public static final String PERSON_NOT_FOUND_CODE = "API-3200";
    public static final String PERSON_NOT_FOUND_MSG = "Person Not Found";

    public static final String PERSON_CREATION_UPDATION_FAILED_DUPLICATE_RECORD_CODE = "API-3201";
    public static final String PERSON_CREATION_UPDATION_FAILED_DUPLICATE_RECORD_MSG = "Person addition/update failed as person with similar FirstName/LastName already exists";
}
