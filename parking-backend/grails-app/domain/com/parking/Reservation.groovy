package com.parking

import java.time.LocalDateTime

class Reservation {

    LocalDateTime dateCreation = LocalDateTime.now()
    LocalDateTime dateDebut
    LocalDateTime dateFin
    BigDecimal montant
    String status
    Client client
    Place place
    Vehicule vehicule
    Paiement paiement


    static constraints = {
        dateDebut nullable: false
        dateFin nullable: true
        montant min: 0.0
        status inList: ['CONFIRME', 'ANNULEE', 'TERMINE']
        client nullable: false
        place nullable: false
        vehicule nullable: false
        paiement nullable: true
    }

    static mapping = {
        client fetch: 'join'
        place fetch: 'join'
        vehicule fetch: 'join'
    }
}
