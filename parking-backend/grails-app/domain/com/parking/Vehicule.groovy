package com.parking

class Vehicule {

    String immatriculation
    String marque
    String modele
    String type
    Client client

    static constraints = {

        immatriculation blank: false, unique: true
        marque blank: false
        modele blank: false
        type inList: ['VOITURE', 'MOTO', 'CAMION']
        client nullable: false

    }
}
