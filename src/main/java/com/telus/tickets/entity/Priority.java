package com.telus.tickets.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;


public class Priority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_priority", nullable = false)
    private Integer idPriority;
    @Column(name = "name_priority", length = 75)
    private String namePriority;
    @OneToMany(mappedBy = "idPriority")
    private List<Ticket> ticketList;

    public Priority() {
    }

    public Priority(Integer idPriority) {
        this.idPriority = idPriority;
    }

    public Integer getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(Integer idPriority) {
        this.idPriority = idPriority;
    }

    public String getNamePriority() {
        return namePriority;
    }

    public void setNamePriority(String namePriority) {
        this.namePriority = namePriority;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPriority != null ? idPriority.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Priority)) {
            return false;
        }
        Priority other = (Priority) object;
        if ((this.idPriority == null && other.idPriority != null) || (this.idPriority != null && !this.idPriority.equals(other.idPriority))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.entitys.Priority[ idPriority=" + idPriority + " ]";
    }
    
}
