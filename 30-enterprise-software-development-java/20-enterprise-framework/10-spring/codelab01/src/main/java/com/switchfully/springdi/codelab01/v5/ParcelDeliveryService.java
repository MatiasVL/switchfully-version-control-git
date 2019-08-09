package com.switchfully.springdi.codelab01.v5;

import com.switchfully.springdi.codelab01.v5.configuration.AppConfig;
import com.switchfully.springdi.codelab01.v5.entities.DeliveryVan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ParcelDeliveryService {
    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        DeliveryVan deliveryVan = applicationContext.getBean(DeliveryVan.class);
        String myProduct = (String) applicationContext.getBean("ContentOfParcel");
        String driverName = applicationContext.getBean("DriverName", String.class);

        if (deliveryVan.canDeliveryParcels()){
            System.out.println("Hooray! My " + myProduct + " will arrive soon by " + driverName + "! (better be home!)");
        } else {
            System.err.println("Something went wrong, your parcel cannot be delivered today \uD83D\uDE20");
        }
    }
}
