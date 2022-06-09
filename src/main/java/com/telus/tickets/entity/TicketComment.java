package com.telus.tickets.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_comment")
public class TicketComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ticket_comment", nullable = false)
    private Integer idTicketComment;
    @Column(name = "comment", length = 350)
    private String comment;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket")
    @ManyToOne
    private Ticket idTicket;

    public TicketComment() {
    }

    public TicketComment(Integer idTicketComment) {
        this.idTicketComment = idTicketComment;
    }

    public Integer getIdTicketComment() {
        return idTicketComment;
    }

    public void setIdTicketComment(Integer idTicketComment) {
        this.idTicketComment = idTicketComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Ticket getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Ticket idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicketComment != null ? idTicketComment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TicketComment)) {
            return false;
        }
        TicketComment other = (TicketComment) object;
        if ((this.idTicketComment == null && other.idTicketComment != null) || (this.idTicketComment != null && !this.idTicketComment.equals(other.idTicketComment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.entitys.TicketComment[ idTicketComment=" + idTicketComment + " ]";
    }
    
}

