package com.parking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class PaiementServiceSpec extends Specification {

    PaiementService paiementService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Paiement(...).save(flush: true, failOnError: true)
        //new Paiement(...).save(flush: true, failOnError: true)
        //Paiement paiement = new Paiement(...).save(flush: true, failOnError: true)
        //new Paiement(...).save(flush: true, failOnError: true)
        //new Paiement(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //paiement.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        paiementService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Paiement> paiementList = paiementService.list(max: 2, offset: 2)

        then:
        paiementList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        paiementService.count() == 5
    }

    void "test delete"() {
        Long paiementId = setupData()

        expect:
        paiementService.count() == 5

        when:
        paiementService.delete(paiementId)
        datastore.currentSession.flush()

        then:
        paiementService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Paiement paiement = new Paiement()
        paiementService.save(paiement)

        then:
        paiement.id != null
    }
}
