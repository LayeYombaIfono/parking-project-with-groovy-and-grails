package com.parking

class Zone {

    String code
    String typeVehicule
    Parking parking

    static hasMany = [places: Place]

    static constraints = {

        code blank: false, unique: ['parking']
        typeVehicule inList: ['VOITURE', 'MOTO', 'HANDICAPE']
        parking nullable: false
    }

    static mapping = {
        parking fetch: 'join'
    }
}
