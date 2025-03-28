/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Employer extends DomainObject implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private String adress;
    private Long phoneNumber;
    private String sss;
    private OptionalProgram optionalProgram;

    public Employer() {
    }

    public Employer(Long id, String firstname, String lastname, String adress, Long phoneNumber, String sss, OptionalProgram optionalProgram) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.sss = sss;
        this.optionalProgram = optionalProgram;
    }

    public OptionalProgram getOptionalProgram() {
        return optionalProgram;
    }

    public void setOptionalProgram(OptionalProgram optionalProgram) {
        this.optionalProgram = optionalProgram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSss() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss = sss;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public String getTableName() {
        return "employer";
    }

    @Override
    public String getColumnsForAdd() {
        return "firstname,lastname,adress,phone_number,sss,optional_program_id";
    }

    @Override
    public String getParamsForAdd() {
        return "?,?,?,?,?,?";
    }

    @Override
    public void setParamsForAdd(PreparedStatement ps, DomainObject domainObject) throws SQLException {
        Employer employer = (Employer) domainObject;
        ps.setString(1, employer.getFirstname());
        ps.setString(2, employer.getLastname());
        ps.setString(3, employer.getAdress());
        ps.setLong(4, employer.getPhoneNumber());
        ps.setString(5, employer.getSss());

        ps.setLong(6, employer.getOptionalProgram().getId());

        int result = ps.executeUpdate();
    }

    @Override
    public void setAutogeneratedKey(long key) {
        setId(key);
        System.out.println("Vrednost primarnog kljuca je: " + key);
    }

    @Override
    public String getSelectValues() {
        if(lastname==null){
        return " e.*,op.* FROM employer e INNER JOIN optional_program op ON(e.optional_program_id=op.id)";
        }else{
            return " e.*,op.* FROM employer e INNER JOIN optional_program op ON(e.optional_program_id=op.id) WHERE e.lastname=\""+lastname+"\"";
        }
    }

    @Override
    public DomainObject setValuesForGet(ResultSet rs) {
        Employer employer = new Employer();
        try {
            OptionalProgram optionalProgram = new OptionalProgram();
            employer.setId(rs.getLong("e.id"));
            employer.setFirstname(rs.getString("e.firstname"));
            employer.setLastname(rs.getString("e.lastname"));
            employer.setAdress(rs.getString("e.adress"));
            employer.setPhoneNumber(rs.getLong("e.phone_number"));
            employer.setSss(rs.getString("e.sss"));
            optionalProgram.setId(rs.getLong("op.id"));
            optionalProgram.setName(rs.getString("op.name"));
            optionalProgram.setDifficultyLevel(rs.getInt("op.difficulty_level"));
            optionalProgram.setAge(rs.getString("op.age"));
            employer.setOptionalProgram(optionalProgram);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employer;
    }

    @Override
    public String getUpdateValues() {
        return "employer SET firstname=?, lastname=?, adress=?, phone_number=?, sss=?, optional_program_id=? WHERE id=?";
    }

    @Override
    public void setValuesForEdit(PreparedStatement ps) {
        try {
            ps.setString(1, getFirstname());
            ps.setString(2, getLastname());
            ps.setString(3, getAdress());
            ps.setLong(4, getPhoneNumber());
            ps.setString(5, getSss());
            ps.setLong(6, getOptionalProgram().getId());
            ps.setLong(7, getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getDeleteValues() {
        return "FROM employer WHERE id=?";
    }

    @Override
    public void setValuesForDelete(PreparedStatement ps) {
        try {
            ps.setLong(1, getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
