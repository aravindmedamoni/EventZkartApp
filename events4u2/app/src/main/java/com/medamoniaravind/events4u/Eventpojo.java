package com.medamoniaravind.events4u;

public class Eventpojo {
    String ep_title,ep_price,ep_date,ep_image,ep_venue;

    public Eventpojo(String title, String price, String date, String venue, String image) {
        this.ep_title=title;
        this.ep_price=price;
        this.ep_date=date;
        this.ep_venue=venue;
        this.ep_image=image;
    }

    public String getEp_title() {
        return ep_title;
    }

    public void setEp_title(String ep_title) {
        this.ep_title = ep_title;
    }

    public String getEp_price() {
        return ep_price;
    }

    public void setEp_price(String ep_price) {
        this.ep_price = ep_price;
    }

    public String getEp_date() {
        return ep_date;
    }

    public void setEp_date(String ep_date) {
        this.ep_date = ep_date;
    }

    public String getEp_image() {
        return ep_image;
    }

    public void setEp_image(String ep_image) {
        this.ep_image = ep_image;
    }

    public String getEp_venue() {
        return ep_venue;
    }

    public void setEp_venue(String ep_venue) {
        this.ep_venue = ep_venue;
    }
}
