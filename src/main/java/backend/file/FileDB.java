package backend.file;

import backend.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class FileDB {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String fileDownloadUri;

    @NotBlank
    @Column(nullable = false)
    private String type;
    @NotBlank
    @Column(nullable = false)
    private String likes;


    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User fileOwner;

    @Lob
    private byte[] data;

    //constructors

    public FileDB() {
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public FileDB(@NotBlank String name, @NotBlank String  fileDownloadUri, @NotBlank String type, byte[] data, String like) {
        this.name = name;
        this.fileDownloadUri=fileDownloadUri;
        this.type = type;
        this.data = data;
        this.likes = like;
    }

    //getters and setters

    public User getFileOwner() {
        return fileOwner;
    }

    public void setFileOwner(User fileOwner) {
        this.fileOwner = fileOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}



