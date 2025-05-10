package com.parking

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*



import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class ParkingController {

    ParkingService parkingService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        Integer offset = params.offset ? params.offset.toInteger() : 0
        respond parkingService.list([max: params.max, offset: offset]), model:[parkingCount: parkingService.count()]
    }

    def show(Long id) {
        def parking = parkingService.get(id)

        if (!parking){
            respond ([message:"Parking introuvable avec ID: $id" ], status: NOT_FOUND)
            return
        }

        respond parking
    }

    @Transactional
    def save(Parking parking) {
      try {
          respond parkingService.save(parking),[status: CREATED]
      }catch (ValidationException e){
          respond e.errors, status: BAD_REQUEST
      }catch (IllegalArgumentException e){
          render e.getMessage()
      }
    }

    @Transactional
    def update(Parking parking) {
        try {
            respond parkingService.save(parking), [status: OK, view: "show"]
        }catch (ValidationException e){
            respond e.errors, status: BAD_REQUEST
        }catch (IllegalArgumentException e){
            respond ([message: e.getMessage()], status: NOT_FOUND)
        }
    }

    @Transactional
    def delete(Long id) {
        try {
            parkingService.delete(id)

            render status: NO_CONTENT

        }catch (IllegalArgumentException e){
            render e.getMessage()
        }
    }
}
