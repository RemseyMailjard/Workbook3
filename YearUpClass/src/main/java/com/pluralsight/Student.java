package com.pluralsight;

public class Student extends Person {
    private int id;
    private String github;
    private String linkedin;
    private String codingNickname;
    private String codewarsXPoints;
    private String imageUrl;
    private String deviceType; //Mac or Windows
    private int pageNumberWorkbook;//
    private String currentlyWorkingOn;

    public Student() {
    }

    public Student(int id, String firstname, String lastname, String email, String gender,
                   String github, String linkedin, String codingNickname, String codewarsXPoints,
                   String imageUrl, String deviceType, int pageNumberWorkbook, String currentlyWorkingOn) {
        super(firstname, lastname, email, gender);
        this.id = id;
        this.github = github;
        this.linkedin = linkedin;
        this.codingNickname = codingNickname;
        this.codewarsXPoints = codewarsXPoints;
        this.imageUrl = imageUrl;
        this.deviceType = deviceType;
        this.pageNumberWorkbook = pageNumberWorkbook;
        this.currentlyWorkingOn = currentlyWorkingOn;
    }
        // Getters & Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getGithub() { return github; }
        public void setGithub(String github) { this.github = github; }

        public String getLinkedin() { return linkedin; }
        public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

        public String getCodingNickname() { return codingNickname; }
        public void setCodingNickname(String codingNickname) { this.codingNickname = codingNickname; }

        public String getCodewarsXPoints() { return codewarsXPoints; }
        public void setCodewarsXPoints(String codewarsXPoints) { this.codewarsXPoints = codewarsXPoints; }

        public String getImageUrl() { return imageUrl; }
        public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

        public String getDeviceType() { return deviceType; }
        public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

        public int getPageNumberWorkbook() { return pageNumberWorkbook; }
        public void setPageNumberWorkbook(int pageNumberWorkbook) { this.pageNumberWorkbook = pageNumberWorkbook; }

        public String getCurrentlyWorkingOn() { return currentlyWorkingOn; }
        public void setCurrentlyWorkingOn(String currentlyWorkingOn) { this.currentlyWorkingOn = currentlyWorkingOn; }

    }

