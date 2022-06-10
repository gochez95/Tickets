package com.telus.tickets.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ticket", nullable = false)
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "name_ticket", nullable = false, length = 150)
    private String nameTicket;
    @Basic(optional = false)
    @Column(name = "description_ticket", nullable = false, length = 350)
    private String descriptionTicket;
    @Column(name = "create_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    @Column(name = "finish_at")
    @Temporal(TemporalType.DATE)
    private Date finishAt;
    @ManyToMany(mappedBy = "ticketList")
    private List<Status> statusList;
    @JoinTable(name = "user_tickets", joinColumns = {
        @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)})
    @ManyToMany
    private List<User> userList;
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    @ManyToOne
    private Category idCategory;
    @JoinColumn(name = "id_priority", referencedColumnName = "id_priority")
    @ManyToOne
    private Priority idPriority;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private User idUser;
    @JoinColumn(name = "assign", referencedColumnName = "id_user")
    @ManyToOne
    private User assign;
    @OneToMany(mappedBy = "idTicket")
    private List<TicketComment> ticketCommentList;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, String nameTicket, String descriptionTicket) {
        this.idTicket = idTicket;
        this.nameTicket = nameTicket;
        this.descriptionTicket = descriptionTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getNameTicket() {
        return nameTicket;
    }

    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    public String getDescriptionTicket() {
        return descriptionTicket;
    }

    public void setDescriptionTicket(String descriptionTicket) {
        this.descriptionTicket = descriptionTicket;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    @XmlTransient
    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Priority getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(Priority idPriority) {
        this.idPriority = idPriority;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<TicketComment> getTicketCommentList() {
        return ticketCommentList;
    }

    public void setTicketCommentList(List<TicketComment> ticketCommentList) {
        this.ticketCommentList = ticketCommentList;
    }
    
    

    public User getAssign() {
		return assign;
	}

	public void setAssign(User assign) {
		this.assign = assign;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telus.entitys.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
