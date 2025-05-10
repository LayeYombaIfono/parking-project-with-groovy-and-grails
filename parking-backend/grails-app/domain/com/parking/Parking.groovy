package com.parking

class Parking {

    String nom
    String adresse
    Integer capaciteTotale
    String telephone

    static hasMany = [zones: Zone, employes: Employe]

    static constraints = {
        nom blank: false
        adresse blank: false
        capaciteTotale min: 1
        telephone matches: /^(\+?\d[\d\s-]{9,})$/
    }
}
