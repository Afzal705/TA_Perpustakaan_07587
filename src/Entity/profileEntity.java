package Entity;

import javax.swing.*;

public class profileEntity {
    private String Username;
    private String ttl;
    private JLabel fotoProfile;
    private String Jabatan ;


    //SET----------------------------------
    public void setFotoProfile(JLabel fotoProfile) {
        this.fotoProfile = fotoProfile;
    }

    public void setJabatan(String jabatan) {
        Jabatan = jabatan;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public void setUsername(String username) {
        Username = username;
    }
    //GET----------------------------------

    public String getUsername() {
        return Username;
    }

    public JLabel getFotoProfile() {
        return fotoProfile;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public String getTtl() {
        return ttl;
    }

}
