package com.example.thomas.resttemplateexample1;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by thomas on 20.03.18.
 */

@Root(strict=false)
public class WeatherData {
    @Element
    Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
