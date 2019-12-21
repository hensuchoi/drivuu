package com.example.drivuu;

public class Plate {
    private String plateID;
    private String image;
    private String[] comments;

    public Plate() {
    }

    public Plate(String plateID, String[] comments) {
        this.plateID = plateID;
        this.comments = comments;
    }

    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        this.plateID = plateID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
