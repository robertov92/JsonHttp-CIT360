package jsonHttp;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {
    int id;
    String name;
    @SerializedName("main")
    Map<String, Float> measures;

    public WeatherConditions(int id, String name) {
        this.id = id;
        this.name = name;
        this.measures = new HashMap<>();
    }

    @Override
    public String toString() {
        return "\nCurrent Weather Conditions for " + name + ":" +
                "\nTemperature: " + measures.get("temp") + "°" +
                "\nFeels like: " + measures.get("feels_like") + "°" +
                "\nMin Temperature: " + measures.get("temp_min") + "°" +
                "\nMax Temperature: " + measures.get("temp_max") + "°" +
                "\nCity ID: " + id;
    }
}
