package com.cucumber.junit.util;

import java.util.Arrays;

public enum Pages {

    HOME_PAGE("https://ecsc00a08ec4:9002/yacceleratorstorefront/?site=electronics"),
    SEARCH_RESULTS_PAGE("https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/search/?text={searchText}"),
    CART_PAGE("https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/cart"),
    SIGN_IN_REGISTER_PAGE("https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/login/checkout"),
    CHECKOUT_SHIPMENT_PAGE("https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/checkout/multi/delivery-address/add");

    private final String page;

    private String getPage() {
        return page;
    }

    Pages(String page) {
        this.page = page;
    }

    public static Pages getEnum(String pageName) {
        return Arrays.stream(values())
                .filter(pages -> pageName.equalsIgnoreCase(pages.getPage()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong page name provided"));
    }
}
