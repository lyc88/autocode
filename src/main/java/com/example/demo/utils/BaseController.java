package com.example.demo.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by nob.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected boolean checkSign(Map<String, String> paramsMap) {
        logger.debug("request params: {}", paramsMap);
        String appId = paramsMap.get("app_id");
        String paramSign = paramsMap.get("sign");
        paramsMap.remove("sign");

        String secret = "11111111111";//Config.getSecret(appId);
        logger.debug("secret :" + secret);

        if (secret == null) {
            logger.debug("secret is not exist");
            return false;
        }

        String newSign = SignUtil.sign(paramsMap, secret);
        logger.debug("new sign: " + newSign);
        return paramSign.equals(newSign);
    }

}
