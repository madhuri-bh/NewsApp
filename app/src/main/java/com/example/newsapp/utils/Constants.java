package com.example.newsapp.utils;

import retrofit2.http.GET;

public class Constants {

    static final int READ_TIMEOUT = 10000; /*Milliseconds*/
    static final int CONNECT_TIMEOUT = 15000; /*Milliseconds*/
    public static final int RESPONSE_CODE = 200;
    public static final String REQUEST_METHOD = "GET";
    public static final String NEWS_REQUEST_URL = "https://content.guardianapis.com/search";

public static final int TECHNOLOGY = 0;
public static final int SCIENCE = 1;
public static final int BUSINESS = 2;
public static final int HEALTH = 3;
public static final int ENTERTAINMENT = 4;
public static final int GENERAL = 5;
public static final int SPORTS = 6;

}

