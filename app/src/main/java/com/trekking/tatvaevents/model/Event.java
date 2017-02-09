package com.trekking.tatvaevents.model;

/**
 * @class Event
 * @desc Model class to store events.
 */
public class Event {

    /**
     * Private global data members.
     */
    private int nSno = 0;                   // Event Sno.
    private String sTitle = null;           // Event Title.
    private String sDescription = null;     // Event Description.
    private String sStartPlace = null;      // Starting Place (Depart from place/point of meeting).
    private String sPlace = null;           // Place to be visited.
    private String sPhone = null;           // Contact number for information.
    private String sPrice = null;           // Price of event.
    private String sMapPlot = null;         // Map position of place for event.
    private String sBooking = null;         // Booking or Payment url to web.
    private String sImage = null;           // Image URL.
    private String sDateTime = null;        // Event Date, time start.

    /**
     * Getter Setter for Sno.
     */
    public int getSno() {
        return nSno;
    }

    public void setSno(int nSno) {
        this.nSno = nSno;
    }

    /**
     * Getter Setter for Title.
     */
    public String getTitle() {
        if (this.sTitle == null) {
            return "";
        }
        return sTitle;
    }

    public void setTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    /**
     * Getter Setter for Description.
     */
    public String getDescription() {
        if (this.sDescription == null) {
            return "";
        }
        return sDescription;
    }

    public void setDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    /**
     * Getter Setter for Start Place.
     */
    public String getStartPlace() {
        if (this.sStartPlace == null) {
            return "";
        }
        return sStartPlace;
    }

    public void setStartPlace(String sStartPlace) {
        this.sStartPlace = sStartPlace;
    }

    /**
     * Getter Setter for Place.
     */
    public String getPlace() {
        if (this.sPlace == null) {
            return "";
        }
        return sPlace;
    }

    public void setPlace(String sPlace) {
        this.sPlace = sPlace;
    }

    /**
     * Getter Setter for Phone.
     */
    public String getPhone() {
        if (this.sPhone == null) {
            return "";
        }
        return sPhone;
    }

    public void setPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    /**
     * Getter Setter for Price.
     */
    public String getPrice() {
        if (this.sPrice == null) {
            return "";
        }
        return sPrice;
    }

    public void setPrice(String sPrice) {
        this.sPrice = sPrice;
    }

    /**
     * Getter Setter for Map plot.
     */
    public String getMapPlot() {
        if (this.sMapPlot == null) {
            return "";
        }
        return sMapPlot;
    }

    public void setMapPlot(String sMapPlot) {
        this.sMapPlot = sMapPlot;
    }

    /**
     * Getter Setter for Booking url.
     */
    public String getBooking() {
        if (this.sBooking == null) {
            return "";
        }
        return sBooking;
    }

    public void setBooking(String sBooking) {
        this.sBooking = sBooking;
    }

    /**
     * Getter Setter for Image URL.
     */
    public String getImage() {
        if (this.sImage == null) {
            return "";
        }
        return sImage;
    }

    public void setImage(String sImage) {
        this.sImage = sImage;
    }

    /**
     * Getter Setter for DateTime.
     */
    public String getDateTime() {
        return sDateTime;
    }

    public void setDateTime(String sDateTime) {
        this.sDateTime = sDateTime;
    }
}
