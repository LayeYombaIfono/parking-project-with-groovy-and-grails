package com.parking

import grails.gorm.services.Service

@Service(Parking)
interface ParkingService {

    Parking get(Serializable id)

    List<Parking> list(Map args)

    Long count()

    Parking delete(Serializable id)

    Parking save(Parking parking)

}
