package com.parking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class PlaceServiceSpec extends Specification {

    PlaceService placeService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Place(...).save(flush: true, failOnError: true)
        //new Place(...).save(flush: true, failOnError: true)
        //Place place = new Place(...).save(flush: true, failOnError: true)
        //new Place(...).save(flush: true, failOnError: true)
        //new Place(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //place.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        placeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Place> placeList = placeService.list(max: 2, offset: 2)

        then:
        placeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        placeService.count() == 5
    }

    void "test delete"() {
        Long placeId = setupData()

        expect:
        placeService.count() == 5

        when:
        placeService.delete(placeId)
        datastore.currentSession.flush()

        then:
        placeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Place place = new Place()
        placeService.save(place)

        then:
        place.id != null
    }
}
