package weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherForecast {
        private Integer time;
        private String date;
        private String weekday;
        private Double temp;
        private Double temp_max;
        private Double temp_min;
        private Double pressure;
        private Double sea_level;
        private Double grnd_level;
        private Integer Humidity;
        private Double temp_kf;
        private Double wind_speed;
        private Double wind_deg;
        private String description;

        public WeatherForecast(Integer time, String date, String weekday, Double temp, Double temp_max, Double temp_min, Double pressure, Double sea_level, Double grnd_level, Integer humidity, Double temp_kf, Double wind_speed, Double wind_deg, String description) {
                this.time = time;
                this.date = date;
                this.weekday = weekday;
                this.temp = temp;
                this.temp_max = temp_max;
                this.temp_min = temp_min;
                this.pressure = pressure;
                this.sea_level = sea_level;
                this.grnd_level = grnd_level;
                Humidity = humidity;
                this.temp_kf = temp_kf;
                this.wind_speed = wind_speed;
                this.wind_deg = wind_deg;
                this.description = description;
        }

        public WeatherForecast() {
                super();
        }

        public Integer getTime() {
                return time;
        }

        public void setTime(Integer time) {
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

        public Double getTemp() {
                return temp;
        }

        public void setTemp(Double temp) {
                this.temp = temp;
        }

        public Double getTemp_max() {
                return temp_max;
        }

        public void setTemp_max(Double temp_max) {
                this.temp_max = temp_max;
        }

        public Double getTemp_min() {
                return temp_min;
        }

        public void setTemp_min(Double temp_min) {
                this.temp_min = temp_min;
        }

        public Double getPressure() {
                return pressure;
        }

        public void setPressure(Double pressure) {
                this.pressure = pressure;
        }

        public Double getSea_level() {
                return sea_level;
        }

        public void setSea_level(Double sea_level) {
                this.sea_level = sea_level;
        }

        public Double getGrnd_level() {
                return grnd_level;
        }

        public void setGrnd_level(Double grnd_level) {
                this.grnd_level = grnd_level;
        }

        public Integer getHumidity() {
                return Humidity;
        }

        public void setHumidity(Integer humidity) {
                Humidity = humidity;
        }

        public Double getTemp_kf() {
                return temp_kf;
        }

        public void setTemp_kf(Double temp_kf) {
                this.temp_kf = temp_kf;
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

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        @Override
        public String toString() {
                return "WeatherForecast{" +
                        "date='" + date + '\'' +
                        ", time=" + time +
                        ", weekday='" + weekday + '\'' +
                        ", temp=" + temp +
                        ", temp_max=" + temp_max +
                        ", temp_min=" + temp_min +
                        ", pressure=" + pressure +
                        ", sea_level=" + sea_level +
                        ", grnd_level=" + grnd_level +
                        ", Humidity=" + Humidity +
                        ", temp_kf=" + temp_kf +
                        ", wind_speed=" + wind_speed +
                        ", wind_deg=" + wind_deg +
                        ", description='" + description + '\'' +
                        '}';
        }
}
