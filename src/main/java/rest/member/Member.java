package rest.member;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String province;
    private String email;
    private String phone;
    private LocalDate startDate;
    private int membershipDuration;

    public Member() {
    }

    public Member(String firstName, String lastName, String streetAddress, String city, String province, String email,
                  String phone, LocalDate startDate, int membershipDuration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.membershipDuration = membershipDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(int membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    @Override
    public String toString() {
        return "Member( id = " + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", streetAddress = " + streetAddress +
                ", city = " + city +
                ", province = " + province +
                ", email = " + email +
                ", phone = " + phone +
                ", startDate = " + startDate +
                ", membershipDuration = " + membershipDuration +" )";
    }
}
