package com.parking

class Paiement {

    String methode
    BigDecimal montant
    Date datePaiement = new Date()
    String reference
    Reservation reservation

    static constraints = {
        methode inList: ['ESPECES','ORANGE_MONEY','KULU','SOUTRA','MOBILE_MONEY','VIREMENT','CARTE']
        montant min: 0.0
        reference blank: false, unique: true
        reservation nullable: false

    }
}
