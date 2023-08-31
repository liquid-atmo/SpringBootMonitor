package com.monitor.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherUnit {

        private Coord coord;
        private Weather[] weather;
        private String base;
        private Main main;
        private long visibility;
        private Wind wind;
        private Rain rain;
        private Clouds clouds;
        private long dt;
        private Sys sys;
        private long timezone;
        private long id;
        private String name;
        private long cod;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Clouds {
        private long all;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Coord {
        private double lon;
        private double lat;


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Main {
        private double temp;
        private double feelsLike;
        private double tempMin;
        private double tempMax;
        private long pressure;
        private long humidity;
        private long seaLevel;
        private long grndLevel;

    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Rain {
        private double the1H;

    }



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Sys {
        private long type;
        private long id;
        private String country;
        private long sunrise;
        private long sunset;

    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Weather {
        private long id;
        private String main;
        private String description;
        private String icon;

    }
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Wind {
            private double speed;
            private long deg;
            private double gust;


        }


}



