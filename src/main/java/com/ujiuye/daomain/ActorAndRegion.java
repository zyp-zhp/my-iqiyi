package com.ujiuye.daomain;


public class ActorAndRegion {
    private int actorId;
    private int regionId;

    public ActorAndRegion() {
    }

    public ActorAndRegion(int actorId, int regionId) {
        this.actorId = actorId;
        this.regionId = regionId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "ActorAndRegion{" +
                "actorId=" + actorId +
                ", regionId=" + regionId +
                '}';
    }
}
