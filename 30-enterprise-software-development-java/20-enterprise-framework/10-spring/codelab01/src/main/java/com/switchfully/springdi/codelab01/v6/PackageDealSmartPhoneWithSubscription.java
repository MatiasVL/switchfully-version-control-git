package com.switchfully.springdi.codelab01.v6;

public class PackageDealSmartPhoneWithSubscription {
    private Smartphone phone;
    private PhoneSubscription subscription;

    public PackageDealSmartPhoneWithSubscription(Smartphone phone, PhoneSubscription subscription){
        this.phone = phone;
        this.subscription = subscription;
    }

    public String getDealInfo() {
        return "--------------------\n" +
                phone.toString() + "\n" +
                subscription.toString() + "\n" +
                "--------------------";
    }
}
