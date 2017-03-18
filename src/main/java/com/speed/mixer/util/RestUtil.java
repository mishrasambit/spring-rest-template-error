package com.speed.mixer.util;

import org.springframework.http.HttpStatus;

/**
 * Created by sambit on 3/18/2017.
 */
public class RestUtil {
    public static boolean isError(HttpStatus status) {
        HttpStatus.Series series = status.series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
    }
}
