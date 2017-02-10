package com.trekking.tatvaevents.model;

/**
 * @class Event
 * @desc Model class to store events.
 */
public class Event {

    /**
     * Private global data members.
     */

    private int sno = 0;                    // Event Sno.
    private String title = null;            // Event Title.
    private String description = null;      // Event Description.
    private String startplace = null;       // Starting Place (Depart from place/point of meeting).
    private String place = null;            // Place to be visited.
    private String phone = null;            // Contact number for information.
    private String price = null;            // Price of event.
    private String mapplot = null;          // Map position of place for event.
    private String booking = null;          // Booking or Payment url to web.
    private String imgurl = null;           // Image URL.
    private String startdt = null;          // Event Date, time start.

    /**
     * Getter Setter for Sno.
     */
    public int getSno() {
        return sno;
    }

    public void setSno(int nSno) {
        this.sno = nSno;
    }

    /**
     * Getter Setter for Title.
     */
    public String getTitle() {
        if (this.title == null) {
            return "";
        }
        return title;
    }

    public void setTitle(String sTitle) {
        this.title = sTitle;
    }

    /**
     * Getter Setter for Description.
     */
    public String getDescription() {
        if (this.description == null) {
            return "";
        }
        return description;
    }

    public void setDescription(String sDescription) {
        this.description = sDescription;
    }

    /**
     * Getter Setter for Start Place.
     */
    public String getStartPlace() {
        if (this.startplace == null) {
            return "";
        }
        return startplace;
    }

    public void setStartPlace(String sStartPlace) {
        this.startplace = sStartPlace;
    }

    /**
     * Getter Setter for Place.
     */
    public String getPlace() {
        if (this.place == null) {
            return "";
        }
        return place;
    }

    public void setPlace(String sPlace) {
        this.place = sPlace;
    }

    /**
     * Getter Setter for Phone.
     */
    public String getPhone() {
        if (this.phone == null) {
            return "";
        }
        return phone;
    }

    public void setPhone(String sPhone) {
        this.phone = sPhone;
    }

    /**
     * Getter Setter for Price.
     */
    public String getPrice() {
        if (this.price == null) {
            return "";
        }
        return price;
    }

    public void setPrice(String sPrice) {
        this.price = sPrice;
    }

    /**
     * Getter Setter for Map plot.
     */
    public String getMapPlot() {
        if (this.mapplot == null) {
            return "";
        }
        return mapplot;
    }

    public void setMapPlot(String sMapPlot) {
        this.mapplot = sMapPlot;
    }

    /**
     * Getter Setter for Booking url.
     */
    public String getBooking() {
        if (this.booking == null) {
            return "";
        }
        return booking;
    }

    public void setBooking(String sBooking) {
        this.booking = sBooking;
    }

    /**
     * Getter Setter for Image URL.
     */
    public String getImgurl() {
        if (this.imgurl == null) {
            return "";
        }
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * Getter Setter for Start Date Time.
     */
    public String getStartdt() {
        return startdt;
    }

    public void setStartdt(String startdt) {
        this.startdt = startdt;
    }
}
