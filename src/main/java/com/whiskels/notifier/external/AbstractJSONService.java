package com.whiskels.notifier.external;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractJSONService {
    @Value("${heroku.server.hour.offset:3}")
    protected int serverHourOffset;

    protected abstract void update();
}