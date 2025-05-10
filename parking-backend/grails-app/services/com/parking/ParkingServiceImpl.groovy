
package com.parking
import grails.gorm.transactions.Transactional


@Transactional
class ParkingServiceImpl implements ParkingService{
    @Override
    Parking get(Serializable id) {
      if (!id){
          throw new IllegalArgumentException("L'ID du parking ne peut pas être null ou vide.")

      }
      def parking = Parking.get(id)

      if (!parking){
          throw new IllegalArgumentException("Parking introuvable avec ID: $id")
      }
        return parking
    }

    @Override
    List<Parking> list(Map args) {
        int max = args.max ? args.max.toInteger() : 10
        int offset = args.offset ? args.offset.toInteger() : 0
        String searchName = args.name ? args.name.toString().trim() : null
        String searchLocation = args.location ? args.location.toString().trim() : null

        return  Parking.createCriteria().list {

            if (searchName){
                ilike("name", "%${searchName}%")
            }

            if (searchLocation){
                ilike("location", "%${searchLocation}%")
            }

            maxResults(max)
            firstResult(offset)
        }as List<Parking>
    }

    @Override
    Long count() {
        return Parking.count()
    }

    @Override
    Parking delete(Serializable id) {
        def parking = Parking.get(id)

        if (!parking){
            throw new IllegalArgumentException("Parking introuvable avec ID: $id")
        }
        parking.delete(flush:true)
        return parking
    }

    @Override
    Parking save(Parking parking) {

        if (!parking || parking.hasErrors()){
            throw new IllegalArgumentException("Parking invalide $parking.errors")
        }

        parking.save(flush:true)

        return parking
    }


}
