package com.HotelShare.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping()
    public String getWebURL() {
        return "<html>" +
                    "<body>" +
                        "<u> <h1> Mappings </h1> </u>" +
                        "<br/>" +
                        "<h3> Users </h3>" +
                        "<ul>" +
                            "<li> <i><b> @GET (/api/users) </i></b> : <a href=\"api/users\"> Get All Users </a> </li>" +
                            "<li> <i><b> @GET (/api/users/{userId})  </i></b> : <a href=\"api/users/33\"> Get One User </a> </li>" +
                            "<li> <i><b> @GET (/api/users/{userId}/hotels)  </i></b> : <a href=\"api/users/33/hotels\"> Get All Hotels For One User </a> </li>" +
                            "<li> <i><b> @POST (/api/users/)  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/users/{userId})  </i></b> </li>" +
                            "<li> <i><b> @DELETE (/api/users/{userId})  </i></b> </li>" +
                        "</ul> <br/>" +
                        "<h3> UserProfiles </h3>" +
                        "<ul>" +
                            "<li> <i><b> @GET (/api/userprofiles) </i></b> : <a href=\"api/userprofiles\"> Get All UserProfiles </a> </li>" +
                            "<li> <i><b> @GET (/api/userprofiles/{userProfileId})  </i></b> : <a href=\"api/userprofiles/34\"> Get One UserProfile </a> </li>" +
                            "<li> <i><b> @POST (/api/userprofiles/)  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/userprofiles/{userProfileId})  </i></b> </li>" +
                            "<li> <i><b> @DELETE (/api/userprofiles/{userProfileId})  </i></b> </li>" +
                        "</ul> <br/>" +
                        "<h3> Hotels </h3>" +
                        "<ul>" +
                            "<li> <i><b> @GET (/api/hotels) </i></b> : <a href=\"api/hotels\"> Get All Hotels </a> </li>" +
                            "<li> <i><b> @GET (/api/hotels/city/{city}) </i></b> <a href=\"api/hotels/city/Gournay\"> Research Hotels By City </a> </li>" +
                            "<li> <i><b> @GET (/api/hotels/postalCode/{postalCode}) </i></b> <a href=\"api/hotels/postalCode/93\"> Research Hotels By Postal Code </a> </li>" +
                            "<li> <i><b> @GET (/api/hotels/{hotelId})  </i></b> : <a href=\"api/hotels/1\"> Get One Hotel </a> </li>" +
                            "<li> <i><b> @GET (/api/hotels/{hotelId}/equipments)  </i></b> : <a href=\"api/hotels/1/equipments\"> Get All Equipments For One Hotel </a> </li>" +
                            "<li> <i><b> @POST (/api/hotels/)  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/hotels/{hotelId})  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/hotels/{hotelId}/equipments)  </i></b> </li>" +
                            "<li> <i><b> @DELETE (/api/hotels/{hotelId})  </i></b> </li>" +
                        "</ul> <br/>" +
                        "<h3> Countries </h3>" +
                        "<ul>" +
                            "<li> <i><b> @GET (/api/countries) </i></b> : <a href=\"api/countries\"> Get All Countries </a> </li>" +
                            "<li> <i><b> @GET (/api/countries/{countryId})  </i></b> : <a href=\"api/countries/75\"> Get One Country </a> </li>" +
                            "<li> <i><b> @POST (/api/countries/)  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/countries/{countryId})  </i></b> </li>" +
                            "<li> <i><b> @DELETE (/api/countries/{countryId})  </i></b> </li>" +
                        "</ul> <br/>" +
                        "<h3> Address </h3>" +
                        "<ul>" +
                            "<li> <i><b> @GET (/api/addresses) </i></b> : <a href=\"api/addresses\"> Get All Addresses </a> </li>" +
                            "<li> <i><b> @GET (/api/addresses/{addressId})  </i></b> : <a href=\"api/addresses/1\"> Get One Address </a> </li>" +
                            "<li> <i><b> @POST (/api/addresses/)  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/addresses/{addressId})  </i></b> </li>" +
                            "<li> <i><b> @DELETE (/api/addresses/{addressId})  </i></b> </li>" +
                        "</ul> <br/>" +
                        "<h3> Equipments </h3>" +
                        "<ul>" +
                            "<li> <i><b> @GET (/api/equipments) </i></b> : <a href=\"api/equipments\"> Get All Equipments </a> </li>" +
                            "<li> <i><b> @GET (/api/equipments/{equipmentId})  </i></b> : <a href=\"api/equipments/1\"> Get One Equipment </a> </li>" +
                            "<li> <i><b> @POST (/api/equipments/)  </i></b> </li>" +
                            "<li> <i><b> @PUT (/api/equipments/{equipmentId})  </i></b> </li>" +
                            "<li> <i><b> @DELETE (/api/equipments/{equipmentId})  </i></b> </li>" +
                        "</ul> <br/>" +
                    "</body>" +
                "</html>";
    }
}
