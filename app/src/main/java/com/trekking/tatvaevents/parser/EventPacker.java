package com.trekking.tatvaevents.parser;

import com.trekking.tatvaevents.model.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @class EventPacker
 * @desc Packer class to parse event data into {@link Event} model class.
 */
public class EventPacker {

    /**
     * @param eventData
     * @return event
     * @method packEvents
     * @desc Method to parse json String data and pack into {@link Event} model class.
     */
    public ArrayList<Event> packEvents(String eventData) {

        JSONArray eventJSONArray;
        ArrayList<Event> eventList;
        try {
            eventJSONArray = new JSONArray(eventData.trim());
            eventList = new ArrayList<>();
            Event event;
            int eventJSONArraySize = eventJSONArray.length();
            for (int arrPos = 0; arrPos < eventJSONArraySize; arrPos++) {

                JSONObject eventJSONJsonObject = eventJSONArray.getJSONObject(arrPos);
                event = new Event();

                int sno = eventJSONJsonObject.getInt("sno");
                String title = eventJSONJsonObject.getString("title");
                String description = eventJSONJsonObject.getString("description");
                String place = eventJSONJsonObject.getString("place");
                String startPlace = eventJSONJsonObject.getString("startplace");
                String phone = eventJSONJsonObject.getString("phone");
                String price = eventJSONJsonObject.getString("price");
                String mapPlot = eventJSONJsonObject.getString("mapplot");
                String booking = eventJSONJsonObject.getString("booking");
                String imageUrl = eventJSONJsonObject.getString("imageurl");
                String startDateTime = eventJSONJsonObject.getString("startdatetime");

                event.setSno(sno);
                event.setTitle(title.trim());
                event.setDescription(description.trim());
                event.setPlace(place.trim());
                event.setStartPlace(startPlace.trim());
                event.setPhone(phone.trim());
                event.setPrice(price.trim());
                event.setMapPlot(mapPlot.trim());
                event.setBooking(booking.trim());
                event.setImage(imageUrl.trim());
                event.setDateTime(startDateTime.trim());

                eventList.add(event);
            }

            return eventList;
        } catch (JSONException jsonException) {

            jsonException.printStackTrace();
            return null;
        } catch (Exception exception) {

            exception.printStackTrace();
            return null;
        }
    }
}
