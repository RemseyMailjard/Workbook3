package com.pluralsight;

public class Person {

        private String firstname;
        private String lastname;
        private String email;
        private String gender;

        public Person() {

        }
        // Constructor
        public Person(String firstname, String lastname, String email, String gender) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.gender = gender;
        }

        // Getters en Setters
        public String getName() { return firstname +  " " + lastname; }
        public String getEmail() { return email; }
        public String getGender() { return gender; }

        public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public void setEmail(String email) { this.email = email; }
        public void setGender(String gender) { this.gender = gender; }


}
