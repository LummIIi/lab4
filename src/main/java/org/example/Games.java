package org.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Games {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String genre;
    private String releasedate;
    private int cost;
    private String company;

    public Games() {
    }

    public Games(String firstname, String genre, String releasedate, int cost, String company) {
        this.firstname = firstname;
        this.genre = genre;
        this.releasedate = releasedate;
        this.cost = cost;
        this.company = company;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Games{" +
                "firstname='" + firstname + '\'' +
                ", genre='" + genre + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", cost=" + cost +
                ", company='" + company + '\'' +
                '}';
    }
}