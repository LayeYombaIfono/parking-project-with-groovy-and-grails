package com.parking

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class ClientServiceSpec extends Specification {

    ClientService clientService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Client(...).save(flush: true, failOnError: true)
        //new Client(...).save(flush: true, failOnError: true)
        //Client client = new Client(...).save(flush: true, failOnError: true)
        //new Client(...).save(flush: true, failOnError: true)
        //new Client(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //client.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        clientService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Client> clientList = clientService.list(max: 2, offset: 2)

        then:
        clientList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        clientService.count() == 5
    }

    void "test delete"() {
        Long clientId = setupData()

        expect:
        clientService.count() == 5

        when:
        clientService.delete(clientId)
        datastore.currentSession.flush()

        then:
        clientService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Client client = new Client()
        clientService.save(client)

        then:
        client.id != null
    }
}
