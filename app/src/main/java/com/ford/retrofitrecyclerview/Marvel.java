package com.ford.retrofitrecyclerview;

public class Marvel {

    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String bio;

    public Marvel(String name, String realname, String team, String firstappearance, String createdby, String publisher, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "RealName: " + realname + "\n"+
                "Team: " + team + "\n"+
                "FirstAppearance: " + firstappearance + "\n"+
                "CreatedBy: " + createdby + "\n"+
                "Publisher: " + publisher + "\n"+
                "Bio: " + bio +  "\n";

    }
}
