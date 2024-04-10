package com.logistica.commonacl.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 32)
    @Column(name = "login", length = 32)
    private String login;

    @Size(max = 128)
    @Column(name = "clave", length = 128)
    private String clave;

    @Size(max = 1)
    @Column(name = "activo", length = 1)
    private String activo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="usuario_rol", joinColumns= @JoinColumn(name="id_usuario"),
            inverseJoinColumns=@JoinColumn(name="id_rol"),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"id_usuario", "id_rol"})})
    private List<Rol> roles;
    
       
    private Integer idGrupo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    
}