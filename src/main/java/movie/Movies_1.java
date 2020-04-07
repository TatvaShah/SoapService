/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tatva
 */
@Entity
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movies_1.findAll", query = "SELECT m FROM Movies_1 m"),
    @NamedQuery(name = "Movies_1.findByMoiveid", query = "SELECT m FROM Movies_1 m WHERE m.moiveid = :moiveid"),
    @NamedQuery(name = "Movies_1.findByMovietitle", query = "SELECT m FROM Movies_1 m WHERE m.movietitle = :movietitle"),
    @NamedQuery(name = "Movies_1.findByMoviegenre", query = "SELECT m FROM Movies_1 m WHERE m.moviegenre = :moviegenre"),
    @NamedQuery(name = "Movies_1.findByMovierating", query = "SELECT m FROM Movies_1 m WHERE m.movierating = :movierating"),
    @NamedQuery(name = "Movies_1.findByMoviereleasedate", query = "SELECT m FROM Movies_1 m WHERE m.moviereleasedate = :moviereleasedate")})
public class Movies_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOIVEID")
    private BigDecimal moiveid;
    @Size(max = 50)
    @Column(name = "MOVIETITLE")
    private String movietitle;
    @Size(max = 50)
    @Column(name = "MOVIEGENRE")
    private String moviegenre;
    @Column(name = "MOVIERATING")
    private Double movierating;
    @Size(max = 50)
    @Column(name = "MOVIERELEASEDATE")
    private String moviereleasedate;

    public Movies_1() {
    }

    public Movies_1(BigDecimal moiveid) {
        this.moiveid = moiveid;
    }

    public BigDecimal getMoiveid() {
        return moiveid;
    }

    public void setMoiveid(BigDecimal moiveid) {
        this.moiveid = moiveid;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getMoviegenre() {
        return moviegenre;
    }

    public void setMoviegenre(String moviegenre) {
        this.moviegenre = moviegenre;
    }

    public Double getMovierating() {
        return movierating;
    }

    public void setMovierating(Double movierating) {
        this.movierating = movierating;
    }

    public String getMoviereleasedate() {
        return moviereleasedate;
    }

    public void setMoviereleasedate(String moviereleasedate) {
        this.moviereleasedate = moviereleasedate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moiveid != null ? moiveid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies_1)) {
            return false;
        }
        Movies_1 other = (Movies_1) object;
        if ((this.moiveid == null && other.moiveid != null) || (this.moiveid != null && !this.moiveid.equals(other.moiveid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "movie.Movies_1[ moiveid=" + moiveid + " ]";
    }
    
}
