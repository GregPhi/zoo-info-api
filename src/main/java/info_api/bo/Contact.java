package info_api.bo;

import java.util.Objects;

public class Contact {
    private String mail;
    private String number;

    public Contact() {
    }

    public Contact(String mail, String number) {
        this.mail = mail;
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(mail, contact.mail) &&
                Objects.equals(number, contact.number);
    }
}
