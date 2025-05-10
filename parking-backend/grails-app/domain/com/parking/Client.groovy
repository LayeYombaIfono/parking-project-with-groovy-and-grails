package com.parking

class Client {

    String nom
    String prenom
    String email
    String telephone
    String numeroPermis

    static hasMany = [reservations: Reservation, vehicules: Vehicule]

    static constraints = {
        nom blank: false
        prenom blank: false
        email email: true, unique: true
        telephone matches: /^\+?[\d\s-]{10,}$/
        numeroPermis blank: false, unique: true
    }
}
