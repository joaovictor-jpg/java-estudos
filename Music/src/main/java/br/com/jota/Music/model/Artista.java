package br.com.jota.Music.model;

import br.com.jota.Music.model.enums.TipoArtista;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> music = new ArrayList<>();

    public Artista() {
    }

    public Artista(String nome, TipoArtista tipoArtista) {
        this.name = nome;
        this.tipo = tipoArtista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "Artista {" +
                "music=" + music +
                ", tipo=" + tipo +
                ", name='" + name + '\'' +
                '}';
    }
}
