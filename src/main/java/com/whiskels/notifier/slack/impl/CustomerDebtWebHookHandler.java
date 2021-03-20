package com.whiskels.notifier.slack.impl;

import com.whiskels.notifier.external.debt.service.CustomerDebtService;
import com.whiskels.notifier.slack.SlackWebHookHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("slack-common")
@Slf4j
public class CustomerDebtWebHookHandler implements SlackWebHookHandler {
    @Value("${slack.customer.debt.webhook}")
    private String webHook;

    private final CustomerDebtService service;

    @Scheduled(cron = "${slack.customer.debt.cron}")
    public void dailyPayload() {
        final String result = sendDailyReport(webHook, service);
        log.info(result);
    }
}