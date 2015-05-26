package se.cromigon.beepsend.api.Pricelist;

import se.cromigon.beepsend.api.network.Network;

public class PriceList {

    private Integer id;
    private Network[] networks;
    private Integer timestamp;
    private Boolean active;
    private Integer first_viewed;
    private Integer parent_revision_id;

    public PriceList() {
    }

    public PriceList(Integer id, Network[] networks, Integer timestamp, Boolean active, Integer first_viewed, Integer parent_revision_id) {
        this.id = id;
        this.networks = networks;
        this.timestamp = timestamp;
        this.active = active;
        this.first_viewed = first_viewed;
        this.parent_revision_id = parent_revision_id;
    }

    public Integer getId() {
        return id;
    }

    public Network[] getNetworks() {
        return networks;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public Boolean getActive() {
        return active;
    }

    public Integer getFirst_viewed() {
        return first_viewed;
    }

    public Integer getParent_revision_id() {
        return parent_revision_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNetworks(Network[] networks) {
        this.networks = networks;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setFirst_viewed(Integer first_viewed) {
        this.first_viewed = first_viewed;
    }

    public void setParent_revision_id(Integer parent_revision_id) {
        this.parent_revision_id = parent_revision_id;
    }
}
