package by.dziomin.trade.controller;

import by.dziomin.trade.entity.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.dziomin.trade.command.AppUrls.PRODUCTS_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_EDIT_PAGE;
import static by.dziomin.trade.command.AppUrls.PRODUCT_INFO_PAGE;
import static by.dziomin.trade.command.AppUrls.RECEIPT_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNIN_PAGE;
import static by.dziomin.trade.command.AppUrls.SIGNUP_PAGE;
import static by.dziomin.trade.command.AppUrls.USERS_PAGE;
import static by.dziomin.trade.command.AppUrls.USER_INFO_PAGE;

final class SecurityConfig {

    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    private static final List<String> freeAccess = Arrays.asList(SIGNIN_PAGE,
            SIGNUP_PAGE, "/app");

    static final List<String> authorizedAccess = Arrays.asList(
            "/locale", "/home");

    static {
        init();
    }

    private SecurityConfig() {
    }

    private static void init() {

        // USER
        List<String> userUrls = new ArrayList<>();
        userUrls.add(USER_INFO_PAGE);
        userUrls.add(PRODUCTS_PAGE);
        userUrls.add(PRODUCT_INFO_PAGE);
        userUrls.add(RECEIPT_PAGE);

        //MANAGER
        List<String> managerUrls = new ArrayList<>(userUrls);
        managerUrls.add(PRODUCT_EDIT_PAGE);

        //ADMIN
        List<String> adminUrls = new ArrayList<>(managerUrls);
        managerUrls.add(USERS_PAGE);

        mapConfig.put(Role.USER.name(), userUrls);
        mapConfig.put(Role.MANAGER.name(), managerUrls);
        mapConfig.put(Role.ADMIN.name(), adminUrls);
    }

    static boolean checkAccess(String role, String url) {
        return mapConfig.containsKey(role) && mapConfig.get(role).contains(url);
    }

    static boolean isFreeAccess(final String path) {
        return freeAccess.contains(path) || path.startsWith("/css/") || path.startsWith("/img/") || path.startsWith("/js/");
    }
}
