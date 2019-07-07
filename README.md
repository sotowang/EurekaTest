# Spring Boot Jar包精简流程

* 修改spring-boot-maven-plugin的参数, 使其将内置的jar包exclude掉

  ```xml
  <plugin>  
     <groupId>org.springframework.boot</groupId>  
     <artifactId>spring-boot-maven-plugin</artifactId>  
     <version>1.5.1.RELEASE</version>  
     <configuration>  
        <layout>ZIP</layout>  
         <excludes>  
             <exclude>  
                 <groupId>ch.qos.logback</groupId>  
                 <artifactId>logback-classic</artifactId>  
             </exclude>  
             <exclude>  
                 <groupId>com.google.guava</groupId>  
                 <artifactId>guava</artifactId>  
             </exclude>  
         </excludes>  
         
     </configuration>  
  </plugin>  
  ```

  可以在公司的parent pom.xml的pluginManagement部分添加spring-boot-maven-plugin的配置, 这样每个web项目就可以继承一套全公司统一的配置.

* 将上一步exclude掉的jar放到一个外置的目录中

  `mvn dependency:copy-dependencies`命令将jar包copy到这个外置目录.

* `java -Dloader.path="lib/" -jar xxxx.jar  `

# Spring Cloud服务启动通知

```java

@Component
public class EurekaStateChangeListener {
    
    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println(appName);
        System.out.println(serverId);
    }
 
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo);
    }
 
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getAppName();
        event.getServerId();
    }
 
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
 
    }
 
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
    }
}

```

