package weatherapp;

public class WeatherCurrent {
    private String description;
    private Integer dt;
    private String time;
    private String date;
    private String weekday;
    private String city;
    private String icon;
    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Double humidity;
    private Double wind_speed;
    private Double wind_deg;

    public WeatherCurrent(String description,Integer dt, String time, String date, String weekday, String city, String icon, Double temp, Double temp_min, Double temp_max, Double pressure, Double humidity, Double wind_speed, Double wind_deg) {
        this.description = description;
        this.dt = dt;
        this.time = time;
        this.date = date;
        this.weekday = weekday;
        this.city = city;
        this.icon = icon;
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.wind_deg = wind_deg;
    }
    public WeatherCurrent(){
        super(); //Calling constructor to initialize fields
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Double getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Double wind_deg) {
        this.wind_deg = wind_deg;
    }

    @Override
    public String toString() {
        return "WeatherCurrent{" +
                "description='" + description + '\'' +
                ", time=" + time +
                ", date='" + date + '\'' +
                ", weekday='" + weekday + '\'' +
                ", city='" + city + '\'' +
                ", icon='" + icon + '\'' +
                ", temp=" + temp +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", wind_speed=" + wind_speed +
                ", wind_deg=" + wind_deg +
                '}';
    }
}
