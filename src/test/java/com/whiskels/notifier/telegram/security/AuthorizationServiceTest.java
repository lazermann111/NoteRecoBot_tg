package com.whiskels.notifier.telegram.security;

import com.whiskels.notifier.App;
import com.whiskels.notifier.telegram.handler.impl.HelpHandler;
import com.whiskels.notifier.telegram.handler.impl.TokenHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.whiskels.notifier.telegram.UserTestData.USER_1;
import static com.whiskels.notifier.telegram.UserTestData.USER_2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = AuthorizationService.class)
class AuthorizationServiceTest {
    @Autowired
    private AuthorizationService service;

    @Test
    void testAuthorizationService() {

        assertTrue(service.authorize(TokenHandler.class, USER_2));
        assertTrue(service.authorize(HelpHandler.class, USER_2));
    }

    @Test
    void testAuthorizationService_withException() {
        assertTrue(service.authorize(App.class, USER_1));
    }
}
