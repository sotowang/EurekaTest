package com.soto.listener;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class EurekaStateChangeListener {

    private static final Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);

    private static HashSet<String> registryCountMap = new HashSet<String>();

    @Value("${app-name.count}")
    private int registryCount;

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String appName = instanceInfo.getAppName();
        registryCountMap.add(appName);
        if (registryCountMap.size() == registryCount) {
            logger.info("============>组件启动成功!<============");
        }

        logger.info("=AppName==>" + appName + "===registryCount: ======"+registryCountMap.size()+"============");
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        String appName = eurekaInstanceCanceledEvent.getAppName();
        registryCountMap.remove(appName);
        logger.info("=AppName==>" + appName + "===registryCount: ======"+registryCountMap.size()+"============");
    }




}
