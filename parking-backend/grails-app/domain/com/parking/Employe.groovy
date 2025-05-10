package com.parking

class Employe {

    String nom
    String prenom
    String email
    String telephone
    String role
    Parking parking


    static constraints = {
        nom blank: false
        prenom blank: false
        email email: true, unique: true
        telephone matches:/^\+?[\d\s-]{10,}$/
        role inList: ['ADMIN', 'GESTIONNAIRE','CAISSIER']
        parking nullable: false
    }
}
