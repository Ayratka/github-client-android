package github.maxat.com.githubclient.data.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoryEntity extends RealmObject {


    public final static String FIELD_LOCAL_IS_OWNER = "local_is_owner";


    @PrimaryKey
    long id;

    String name;

    String full_name;

    String html_url;

    String description;

    String language;


    boolean local_is_owner;



    public void setOwner(boolean owner) {
        local_is_owner = owner;
    }

    public boolean isOwner() {
        return local_is_owner;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }


}
