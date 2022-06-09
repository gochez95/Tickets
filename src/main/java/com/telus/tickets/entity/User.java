package com.telus.tickets.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Basic(optional = false)
    @Column(name = "name_user", nullable = false, length = 150)
    private String nameUser;
    @Basic(optional = false)
    @Column(name = "lastname_user", nullable = false, length = 150)
    private String lastnameUser;
    @Basic(optional = false)
    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @Basic(optional = false)
    @Column(name = "email_user", nullable = false, length = 150)
    private String emailUser;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany(mappedBy = "userList")
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "idUser")
    private List<Ticket> ticketList1;
    @JoinColumn(name = "id_role", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol idRole;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String nameUser, String lastnameUser, String userName, String password, String emailUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.lastnameUser = lastnameUser;
        this.userName = userName;
        this.password = password;
        this.emailUser = emailUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<Ticket> getTicketList1() {
        return ticketList1;
    }

    public void setTicketList1(List<Ticket> ticketList1) {
        this.ticketList1 = ticketList1;
    }

    public Rol getIdRole() {
        return idRole;
    }

    public void setIdRole(Rol idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.entitys.User[ idUser=" + idUser + " ]";
    }
    
}
