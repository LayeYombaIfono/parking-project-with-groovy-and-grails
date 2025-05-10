package com.parking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class ParkingServiceSpec extends Specification {

    ParkingService parkingService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Parking(...).save(flush: true, failOnError: true)
        //new Parking(...).save(flush: true, failOnError: true)
        //Parking parking = new Parking(...).save(flush: true, failOnError: true)
        //new Parking(...).save(flush: true, failOnError: true)
        //new Parking(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //parking.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        parkingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Parking> parkingList = parkingService.list(max: 2, offset: 2)

        then:
        parkingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        parkingService.count() == 5
    }

    void "test delete"() {
        Long parkingId = setupData()

        expect:
        parkingService.count() == 5

        when:
        parkingService.delete(parkingId)
        datastore.currentSession.flush()

        then:
        parkingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Parking parking = new Parking()
        parkingService.save(parking)

        then:
        parking.id != null
    }
}
