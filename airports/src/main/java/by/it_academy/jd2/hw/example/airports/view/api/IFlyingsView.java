package by.it_academy.jd2.hw.example.airports.view.api;

import by.it_academy.jd2.hw.example.airports.model.Flying;

import java.util.List;

public interface IFlyingsView {
    long count(FlyingFilter filter);
    List<Flying> getList(FlyingFilter filter);
    Flying get(Integer key);

    public static class FlyingFilter{
        private String airportOut;
        private String airportIn;
        private int page;

        public FlyingFilter(String airportOut, String airportIn, int page) {
            this.airportOut = airportOut;
            this.airportIn = airportIn;
            this.page = page;
        }

        public String getAirportOut() {
            return airportOut;
        }

        public void setAirportOut(String airportOut) {
            this.airportOut = airportOut;
        }

        public String getAirportIn() {
            return airportIn;
        }

        public void setAirportIn(String airportIn) {
            this.airportIn = airportIn;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }
    }
}
