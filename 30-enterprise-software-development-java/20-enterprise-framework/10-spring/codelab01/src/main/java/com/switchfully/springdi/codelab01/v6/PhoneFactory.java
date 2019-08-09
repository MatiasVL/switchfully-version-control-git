package com.switchfully.springdi.codelab01.v6;

public class PhoneFactory {
    public static void main(String... args) {
        PackageDealSmartPhoneWithSubscription funkyPhoneWithSubscription
                = new PackageDealSmartPhoneWithSubscription(new Smartphone(), new PhoneSubscription());

        System.out.println("You have bought the following package: \n" +
                funkyPhoneWithSubscription.getDealInfo());
    }
}
