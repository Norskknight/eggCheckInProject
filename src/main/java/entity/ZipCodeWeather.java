package entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


@Getter
@Setter
@Entity(name = "zipCodeWeather")
@Table(name = "zipCodeWeather")
public class ZipCodeWeather implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "zip")
    private int zip;

    @Column(name = "tempInKelvin")
    private double tempInKelvin;

    @Column(name = "weather")
    private String weather;

    @Column(name = "timeStamp")
    private String timeStamp;

    @OneToMany(mappedBy = "zipCodeWeather", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> user = new HashSet<>();

    public void addUser(User user){
        getUser().add(user);
    }

    private String getApiKey() throws Exception {
        Logger $logger = LogManager.getLogger(this.getClass());
        InputStream inputStream = null;
        Properties prop;
        String key = null;
        try {
            prop = new Properties();
            String propFileName = "weatherAPI.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            key = prop.getProperty("key");
        } catch (Exception e) {
            $logger.debug("Exception: " + e);
        } finally {
            inputStream.close();

            return key;
        }
    }

    public void setWeather() {
        Logger $logger = LogManager.getLogger(this.getClass());
        String key = null;
        try {
            key = getApiKey();
            $logger.info(key);
        } catch (Exception e) {
            $logger.debug("Exception: " + e);
        }
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=" + getZip() + "&APPID=" + key);
            $logger.info(url);
            URLConnection req = url.openConnection();
            req.connect();
            Date time = new Date();
            setTimeStamp(Long.toString(time.getTime()));
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) req.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            $logger.debug(rootobj);
            JsonElement weatherList = rootobj.get("list").getAsJsonArray();
            JsonElement firstTime = ((JsonArray) weatherList).get(0).getAsJsonObject();
            JsonElement main = ((JsonObject) firstTime).get("main").getAsJsonObject();
            JsonElement weatherAtTime = ((JsonObject) firstTime).get("weather");
            JsonObject weatherJsonObject = weatherAtTime.getAsJsonArray().get(0).getAsJsonObject();
            $logger.debug(weatherJsonObject.get("description"));
            String temp = ((JsonObject) main).get("temp").getAsString();
            String weather = weatherJsonObject.get("description").getAsString();
            $logger.info("set weather " + weather);
            this.weather = weather;
            $logger.debug(temp);
            $logger.info("set Kelvin " + temp);
            setTempInKelvin(Double.parseDouble(temp));
            setTimeStamp(new Date().toString());
        } catch (Exception e) {
            $logger.debug("Exception: " + e);
        }
    }

    public String getWeather() {
        //if time stamp older than 12 m set weather else return
        if (weather.isEmpty()) {
            setWeather();
            return weather;
        } else if (true) {
            //if time stamp older than 12 m set weather
            return weather;
        } else {
            return weather;
        }
    }
    public double tempToFahrenheit(){
        double fahrenheit = (getTempInKelvin() - 273.15) * 9/5 + 32;

        return Math.round(fahrenheit);
    }
    public double tempToCelsius(){
        double celsius = (getTempInKelvin() - 273.15);

        return Math.round(celsius);
    }

    @Override
    public String toString() {
        return "ZipCodeWeather{" +
                "id=" + id +
                ", zip=" + zip +
                ", tempInKelvin=" + tempInKelvin +
                ", weather='" + weather + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
