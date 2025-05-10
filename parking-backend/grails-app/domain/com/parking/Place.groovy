package com.parking

class Place {

    String numero
    Zone zone
    boolean occupe = false
    boolean reserve = false

    static hasMany = [reservations: Reservation]

    static constraints = {
        numero blank: false, unique: ['zone']
        zone nullable: false
    }

    static mapping = {
        zone fetch: 'join'
    }
}
