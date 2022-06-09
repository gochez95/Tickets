package com.telus.tickets.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_status", nullable = false)
    private Integer idStatus;
    @Basic(optional = false)
    @Column(name = "status_name", nullable = false, length = 75)
    private String statusName;
    @JoinTable(name = "ticket_status", joinColumns = {
        @JoinColumn(name = "id_status", referencedColumnName = "id_status", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket", nullable = false)})
    @ManyToMany
    private List<Ticket> ticketList;

    public Status() {
    }

    public Status(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Status(Integer idStatus, String statusName) {
        this.idStatus = idStatus;
        this.statusName = statusName;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.idStatus == null && other.idStatus != null) || (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.entitys.Status[ idStatus=" + idStatus + " ]";
    }
    
}
