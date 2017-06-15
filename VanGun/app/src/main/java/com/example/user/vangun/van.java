package com.example.user.vangun;

/**
 * Created by user on 22/2/2560.
 */
public class van {
    private String datavanname;
    private String datavan;
    private int photo;    //ใส่ตัวเเปรรูปด้วยนะ...//

    van(int photo, String datavanname, String datavan) {
        this.photo = photo;
        this.datavanname = datavanname;
        this.datavan = datavan;
    }

    public String getDatavanname() {
        return datavanname;
    }

    public String getDatavan() {
        return datavan;
    }

    public int getPhoto() {
        return photo;
    }

}







