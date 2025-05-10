package parking.backend

class UrlMappings {

    static mappings = {
        // Parking
        "/parking"(controller: "parking", action: "index", method: "GET")
        "/parking/$id"(controller: "parking", action: "show", method: "GET")
        "/parking"(controller: "parking", action: "save", method: "POST")
        "/parking/$id"(controller: "parking", action: "update", method: "PUT")
        "/parking/$id"(controller: "parking", action: "delete", method: "DELETE")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
